package com.pedro.db1.data_local.database

import android.app.Application
import androidx.room.Room

class DatabaseFactory(private val app: Application) {
    val cotationDb = createCotationDb()
    val cotationDao = cotationDb.getCotationFilterDao()

    private fun createCotationDb() =
        Room.databaseBuilder(app, CotationFilterDb::class.java, DATABASE_COTATION).build()

    companion object {
        private const val DATABASE_COTATION = "cotation-db"
    }
}