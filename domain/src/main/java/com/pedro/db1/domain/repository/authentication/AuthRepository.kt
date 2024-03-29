package com.pedro.db1.domain.repository.authentication

import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.utils.Response

interface AuthRepository {
    suspend fun sigIn(params: AuthenticationParam): Response<Unit>
}