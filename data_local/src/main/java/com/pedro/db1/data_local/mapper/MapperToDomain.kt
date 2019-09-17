package com.pedro.db1.data_local.mapper

import com.pedro.db1.data_local.entities.CotationValuesFilteredEntity

fun List<CotationValuesFilteredEntity>.toDomain() = map {
    it.cotationValue
}