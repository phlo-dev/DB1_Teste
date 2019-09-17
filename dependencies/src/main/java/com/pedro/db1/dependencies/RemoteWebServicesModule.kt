package com.pedro.db1.dependencies

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pedro.db1.data_remote.BASE_URL
import com.pedro.db1.data_remote.factory.ServiceClientFactory
import com.pedro.db1.data_remote.factory.ServiceClientFactory.createClient
import com.pedro.db1.data_remote.service.CotationService
import org.koin.dsl.module.module

val remoteWebServicesModule = module {

    single { createClient<CotationService>(BASE_URL, get(), get()) }

    single { ServiceClientFactory.createOkHttpClient() }

    factory { CoroutineCallAdapterFactory() }

}