package com.pedro.db1.dependencies

import com.pedro.db1.domain.usecase.login.SignInUseCase
import com.pedro.db1.domain.utils.ThreadContextProvider
import org.koin.dsl.module.module

val domainModule = module {

    factory { SignInUseCase(authRepository = get()) }

    factory { ThreadContextProvider() }
}