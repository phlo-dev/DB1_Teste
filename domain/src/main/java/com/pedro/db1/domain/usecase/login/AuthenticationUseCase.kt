package com.pedro.db1.domain.usecase.login

import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.repository.AuthRepository
import com.pedro.db1.domain.utils.UseCase

class AuthenticationUseCase(
    private val authRepository: AuthRepository
) : UseCase<AuthenticationParam, Unit>() {

    override suspend fun call(params: AuthenticationParam) = authRepository.sigIn(params)

}