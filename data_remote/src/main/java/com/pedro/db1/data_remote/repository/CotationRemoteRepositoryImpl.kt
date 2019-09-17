package com.pedro.db1.data_remote.repository

import com.pedro.db1.data.remote.CotationRemoteRepository
import com.pedro.db1.data_remote.apiCall
import com.pedro.db1.data_remote.mapper.toData
import com.pedro.db1.data_remote.service.CotationService

class CotationRemoteRepositoryImpl(
    private val cotationService: CotationService
) : CotationRemoteRepository {
    override suspend fun getMarketPriceCotation(params: String) = apiCall {
        cotationService.getMarketPriceCharts(params)
    }.map { it.toData() }
}