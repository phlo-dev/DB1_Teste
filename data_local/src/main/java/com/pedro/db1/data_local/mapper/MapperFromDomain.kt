package com.pedro.db1.data_local.mapper

import com.pedro.db1.data_local.entities.CotationValuesFilteredEntity
import com.pedro.db1.domain.model.CotationValue

fun List<CotationValue>.fromDomain(timeSpan: String) = map {
    CotationValuesFilteredEntity(
        timeSpan = timeSpan,
        amount = it.amountInDollar,
        date = it.date.time
    )
}
