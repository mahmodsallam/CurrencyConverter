package com.currency.banktask.repo

import com.currency.banktask.data.CurrencyConvResponse

interface ICurrencyRepository {
    suspend fun getSymbols(): List<String>
    suspend fun convertCurrency(from:String,to:String,amount:String): CurrencyConvResponse
}