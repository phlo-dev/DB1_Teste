package com.pedro.db1.data.repository

import com.pedro.db1.data.mapper.toDomain
import com.pedro.db1.data.remote.CotationRemoteRepository
import com.pedro.db1.domain.repository.cotation.CotationRepository

class CotationRepositoryImpl(
    private val remoteRepository: CotationRemoteRepository
) : CotationRepository {
    override suspend fun getCotationValues(params: String) =
        remoteRepository.getMarketPriceCotation(params).map { it.toDomain() }
}