package com.pedro.db1.teste.main.base

import android.app.Application
import com.pedro.db1.dependencies.*
import org.koin.android.ext.android.startKoin

class App : Application() {

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