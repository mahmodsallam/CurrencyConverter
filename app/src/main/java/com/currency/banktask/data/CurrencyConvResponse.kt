package com.currency.banktask.data

data class CurrencyConvResponse(
    val date: String, // 2022-11-18
    val historical: Boolean, // true
    val info: Info,
    val query: Query,
    val result: Double, // 5.182395
    val success: Boolean // true
) {
    data class Info(
        val rate: Double, // 1.036479
        val timestamp: Int // 1668767766
    )

    data class Query(
        val amount: Int, // 5
        val from: String, // EUR
        val to: String // USD
    )
}