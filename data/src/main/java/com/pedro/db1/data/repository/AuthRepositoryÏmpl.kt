package com.pedro.db1.data.repository

import com.pedro.db1.data.remote.AuthRemoteRepository
import com.pedro.db1.domain.model.AuthenticationParam
import com.pedro.db1.domain.repository.authentication.AuthRepository
import com.pedro.db1.domain.utils.Response

class AuthRepositoryImpl(
    private val remoteRepository: AuthRemoteRepository
//    private val localRepository: AuthRepos
): AuthRepository {

    override suspend fun sigIn(params: AuthenticationParam): Response<Unit> =
        remoteRepository.signIn(params).map {

        }
}