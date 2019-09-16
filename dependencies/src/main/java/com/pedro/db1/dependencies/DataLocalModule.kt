package com.pedro.db1.dependencies

import com.pedro.db1.data.local.SessionLocalRepository
import com.pedro.db1.data_local.SessionLocalRepositoryImpl
import com.pedro.db1.data_local.utils.PreferencesUtils
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val dataLocalModule = module {
    factory { SessionLocalRepositoryImpl(preferences = get()) as SessionLocalRepository }

    factory { PreferencesUtils(androidApplication()) }
}