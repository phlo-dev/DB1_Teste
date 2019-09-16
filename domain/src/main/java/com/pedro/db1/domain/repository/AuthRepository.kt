package com.pedro.db1.domain.repository

import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.utils.Result

interface AuthRepository {
    suspend fun sigIn(params: AuthenticationParam): Result<Unit>
}