package com.pedro.db1.data.repository

import com.pedro.db1.data.local.CotationLocalRepository
import com.pedro.db1.data.mapper.toDomain
import com.pedro.db1.data.remote.CotationRemoteRepository
import com.pedro.db1.domain.repository.cotation.CotationRepository
import com.pedro.db1.domain.utils.Response

class CotationRepositoryImpl(
    private val remoteRepository: CotationRemoteRepository,
    private val localRepository: CotationLocalRepository
) : CotationRepository {
    override suspend fun getCotationValues(params: String) =
        remoteRepository.getMarketPriceCotation(params).flatMap(
            onFailure = {
                val list = localRepository.getCotationValues(params)
                when (list.isEmpty()) {
                    true -> Response.Failure(it)
                    else -> Response.Success(list)
                }
            },
            onSuccess = {
                val list = it.toDomain()
                localRepository.saveCotationsValues(list, params)
                Response.Success(list)
            }
        )

}