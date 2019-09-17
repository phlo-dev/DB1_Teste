package com.pedro.db1.data.local

import com.pedro.db1.domain.model.CotationValue

interface CotationLocalRepository {
    fun saveCotationsValues(cotationList: List<CotationValue>, timeSpan: String)
    fun getCotationValues(timeSpan: String = "5weeks"): List<CotationValue>
}