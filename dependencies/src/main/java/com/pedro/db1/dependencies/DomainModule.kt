package com.pedro.db1.dependencies

import com.pedro.db1.domain.usecase.cotation.CotationUseCase
import com.pedro.db1.domain.usecase.login.SignInUseCase
import com.pedro.db1.domain.utils.ThreadContextProvider
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module.module

val domainModule = module {

    factory { (scope: CoroutineScope) -> SignInUseCase(scope, get()) }

    factory { (scope: CoroutineScope) -> CotationUseCase(scope, get()) }

    factory { ThreadContextProvider() }
}