package com.pedro.db1.data_remote.model

data class MarketPriceResponse(
    val description: String,
    val name: String,
    val period: String,
    val status: String,
    val unit: String,
    val values: List<ValueResponse>
)