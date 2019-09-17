package com.pedro.db1.domain.repository.cotation

import com.pedro.db1.domain.model.CotationValue
import com.pedro.db1.domain.utils.Response

interface CotationRepository {
    suspend fun getCotationValues(params: String): Response<List<CotationValue>>
}