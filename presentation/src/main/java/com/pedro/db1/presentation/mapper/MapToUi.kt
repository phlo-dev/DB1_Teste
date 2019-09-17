package com.pedro.db1.presentation.mapper

import com.pedro.db1.domain.model.CotationValue
import com.pedro.db1.presentation.model.CotationField

fun List<CotationValue>.toUiModel() = map {
    CotationField(
        date = it.date.toString(),//TODO make the convertion to date format
        amount = it.amountInDollar.toFloat()
    )
}