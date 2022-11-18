package com.task.currency.data.remote

import com.currency.banktask.data.CurrencyConvResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyRemoteDS {
    @GET("symbols")
    suspend fun getSymbols(): SymbolsResponse

    @GET("convert")
    suspend fun convertCurrency(
        @Query("to") to: String,
        @Query("from") from: String,
        @Query("amount") amount: String
    ): CurrencyConvResponse
}