package com.pedro.db1.data.mapper

import com.pedro.db1.data.model.CotationValueResponse
import com.pedro.db1.domain.model.CotationValue

fun List<CotationValueResponse>.toDomain() = map {
    CotationValue(
        date = it.date,
        amountInDollar = it.amountInDollar
    )
}