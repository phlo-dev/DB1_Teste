package com.pedro.db1.dependencies

import com.pedro.db1.data.repository.AuthRepositoryImpl
import com.pedro.db1.data.repository.CotationRepositoryImpl
import com.pedro.db1.domain.repository.authentication.AuthRepository
import com.pedro.db1.domain.repository.cotation.CotationRepository
import org.koin.dsl.module.module

val dataModule = module {
    factory {
        AuthRepositoryImpl(remoteRepository = get(), localRepository = get()) as AuthRepository
    }

    factory {
        CotationRepositoryImpl(
            remoteRepository = get(),
            localRepository = get()
        ) as CotationRepository
    }
}