package com.pedro.db1.presentation.mapper

import com.pedro.db1.domain.model.CotationValue
import com.pedro.db1.presentation.model.CotationField

fun List<CotationValue>.toUiModel() = map {
    CotationField(
        date = it.date,
        amount = it.amountInDollar.toFloat()
    )
}