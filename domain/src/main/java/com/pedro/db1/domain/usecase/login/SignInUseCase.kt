package com.pedro.db1.domain.usecase.login

import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.repository.authentication.AuthRepository
import com.pedro.db1.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope

class SignInUseCase(
    scope: CoroutineScope,
    private val authRepository: AuthRepository
) : UseCase<AuthenticationParam, Unit>(scope) {

    override suspend fun call(params: AuthenticationParam) = authRepository.sigIn(params)

}