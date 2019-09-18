package com.pedro.db1.data_local.mapper

import com.pedro.db1.data_local.entities.CotationValuesFilteredEntity
import com.pedro.db1.domain.model.CotationValue
import java.util.*

fun List<CotationValuesFilteredEntity>.toDomain() = map {
    CotationValue(
        date = Date(it.date),
        amountInDollar = it.amount
    )
}