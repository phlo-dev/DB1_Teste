package com.pedro.db1.dependencies

import com.pedro.db1.data.remote.AuthRemoteRepository
import com.pedro.db1.data.remote.CotationRemoteRepository
import com.pedro.db1.data_remote.repository.AuthRemoteRepositoryImpl
import com.pedro.db1.data_remote.repository.CotationRemoteRepositoryImpl
import org.koin.dsl.module.module

val dataRemoteModule = module {
    factory { AuthRemoteRepositoryImpl() as AuthRemoteRepository }

    factory { CotationRemoteRepositoryImpl(cotationService = get()) as CotationRemoteRepository }
}