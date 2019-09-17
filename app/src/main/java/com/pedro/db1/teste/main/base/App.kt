package com.pedro.db1.teste.main.base

import androidx.multidex.MultiDexApplication
import com.pedro.db1.dependencies.*
import org.koin.android.ext.android.startKoin

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                presentationModule,
                domainModule,
                dataModule,
                dataLocalModule,
                dataRemoteModule,
                remoteWebServicesModule
            )
        )
    }
}