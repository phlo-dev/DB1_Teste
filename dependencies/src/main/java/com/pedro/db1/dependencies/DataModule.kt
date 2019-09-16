package com.pedro.db1.dependencies

import com.pedro.db1.data.repository.AuthRepositoryImpl
import com.pedro.db1.domain.repository.authentication.AuthRepository
import org.koin.dsl.module.module

val dataModule = module {
    factory {
        AuthRepositoryImpl(remoteRepository = get(), localRepository = get()) as AuthRepository
    }
}