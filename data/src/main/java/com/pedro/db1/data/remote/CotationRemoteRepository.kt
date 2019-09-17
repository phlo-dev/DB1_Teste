package com.pedro.db1.data.remote

import com.pedro.db1.data.model.CotationValueResponse
import com.pedro.db1.domain.utils.Response

interface CotationRemoteRepository {
    suspend fun getMarketPriceCotation(params: String): Response<List<CotationValueResponse>>
}