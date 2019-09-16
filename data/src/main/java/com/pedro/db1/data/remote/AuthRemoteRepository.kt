package com.pedro.db1.data.remote

import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.utils.Response

interface AuthRemoteRepository {
    suspend fun signIn(param: AuthenticationParam): Response.Success<Unit>
}