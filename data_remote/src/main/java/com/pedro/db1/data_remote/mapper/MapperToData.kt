package com.pedro.db1.data_remote.mapper

import com.pedro.db1.data.model.CotationValueResponse
import com.pedro.db1.data_remote.model.MarketPriceResponse

fun MarketPriceResponse.toData() = values.map {
    CotationValueResponse(
        date = it.x,
        amountInDollar = it.y
    )
}