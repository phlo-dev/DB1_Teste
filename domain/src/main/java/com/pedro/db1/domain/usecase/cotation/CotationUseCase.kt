package com.pedro.db1.domain.usecase.cotation

import com.pedro.db1.domain.model.CotationValue
import com.pedro.db1.domain.repository.cotation.CotationRepository
import com.pedro.db1.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope

class CotationUseCase(
    scope: CoroutineScope,
    private val repository: CotationRepository
) : UseCase<String, List<CotationValue>>(scope) {
    override suspend fun call(params: String) =
        repository.getCotationValues(params)
}