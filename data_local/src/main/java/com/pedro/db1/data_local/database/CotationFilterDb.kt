package com.pedro.db1.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pedro.db1.data_local.dao.CotationFilterDao
import com.pedro.db1.data_local.entities.CotationValuesFilteredEntity

@Database(entities = [CotationValuesFilteredEntity::class], version = 1, exportSchema = false)
abstract class CotationFilterDb : RoomDatabase(){
    abstract fun getCotationFilterDao(): CotationFilterDao
}