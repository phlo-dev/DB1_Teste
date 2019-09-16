package com.pedro.db1.data_remote.repository

import com.pedro.db1.data.remote.AuthRemoteRepository
import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.utils.Response

class AuthRemoteRepositoryImpl : AuthRemoteRepository {
    override suspend fun signIn(param: AuthenticationParam) = Response.Success(Unit)
}