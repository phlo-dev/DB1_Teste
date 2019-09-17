package com.pedro.db1.data_remote.mapper

import com.pedro.db1.data.model.CotationValueResponse
import com.pedro.db1.data_remote.model.MarketPriceResponse
import java.util.*

fun MarketPriceResponse.toData() = values.map {
    CotationValueResponse(
        date = Date(it.x),
        amountInDollar = it.y
    )
}