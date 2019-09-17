package com.pedro.db1.domain.usecase.cotation

import com.pedro.db1.domain.model.CotationValue
import com.pedro.db1.domain.repository.cotation.CotationRepository
import com.pedro.db1.domain.utils.UseCase

class CotationUseCase(
    private val repository: CotationRepository
) : UseCase<String, List<CotationValue>>() {
    override suspend fun call(params: String) =
        repository.getCotationValues(params)
}