package com.currency.banktask.repo

import com.currency.banktask.data.CurrencyConvResponse
import com.task.currency.data.remote.CurrencyRemoteDS
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val currencyRemoteDS: CurrencyRemoteDS) :
    ICurrencyRepository {
    override suspend fun getSymbols(): List<String> {
        var response = currencyRemoteDS.getSymbols().toString()
        val symbolsList = mutableListOf<String>()
        var symbole = ""
        response.forEach {
            if (it.isUpperCase()) {
                symbole += it
            }
            if (symbole.length == 3) {
                symbolsList.add(symbole)
                symbole = ""
            }
        }
        return symbolsList
    }

    override suspend fun convertCurrency(
        from: String,
        to: String,
        amount: String
    ): CurrencyConvResponse {
        return currencyRemoteDS.convertCurrency(from, to, amount)
    }
}