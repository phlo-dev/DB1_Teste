package com.pedro.db1.dependencies

import com.pedro.db1.domain.usecase.login.AuthenticationUseCase
import com.pedro.db1.domain.utils.ThreadContextProvider
import org.koin.dsl.module.module

val domainModule = module {

    factory { AuthenticationUseCase(authRepository = get()) }

    factory { ThreadContextProvider() }
}