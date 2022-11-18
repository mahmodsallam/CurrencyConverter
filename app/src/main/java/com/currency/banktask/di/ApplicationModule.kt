package com.currency.banktask.di

import com.currency.banktask.repo.CurrencyRepository
import com.task.currency.data.remote.CurrencyRemoteDS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideBaseUrl() = "https://api.apilayer.com/fixer/"

    @Provides
    @Singleton
    fun provideOkHttpClient() = run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request: Request =
                    chain.request().newBuilder()
                        .addHeader("apikey", "rYgC4dVrDQ4Sxg3ZKB4BYmCQQ8wKQROK").build()
                chain.proceed(request)
            })
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = run {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }


    @Provides
    fun provideCurrencyRemoteDS(retrofit: Retrofit): CurrencyRemoteDS =
        retrofit.create(CurrencyRemoteDS::class.java)

    @Provides
    fun provideCurrencyRepository(usersRemoteDS: CurrencyRemoteDS) =
        CurrencyRepository(usersRemoteDS)
}