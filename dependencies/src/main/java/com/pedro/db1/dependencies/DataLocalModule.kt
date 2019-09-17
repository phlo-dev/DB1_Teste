package com.pedro.db1.dependencies

import com.pedro.db1.data.local.CotationLocalRepository
import com.pedro.db1.data.local.SessionLocalRepository
import com.pedro.db1.data_local.repository.CotationLocalRepositoryImpl
import com.pedro.db1.data_local.repository.SessionLocalRepositoryImpl
import com.pedro.db1.data_local.utils.PreferencesUtils
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val dataLocalModule = module {
    factory { SessionLocalRepositoryImpl(preferences = get()) as SessionLocalRepository }

    factory { CotationLocalRepositoryImpl(database = get()) as CotationLocalRepository }

    single { androidApplication()}//TODO create database here

    factory { PreferencesUtils(androidApplication()) }
}