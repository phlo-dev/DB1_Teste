package com.pedro.db1.data_local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.pedro.db1.data_local.entities.CotationValuesFilteredEntity

@Dao
interface CotationFilterDao {
    @Query("SELECT * FROM cotation_filter WHERE timeSpan == (:timeSpan)")
    fun getCotationList(timeSpan: String): List<CotationValuesFilteredEntity>

    @Insert(onConflict = REPLACE)
    fun insertAllCotationsValues(vararg cotationValueWithFilter: CotationValuesFilteredEntity)
}