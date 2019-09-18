package com.pedro.db1.data_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cotation_filter")
data class CotationValuesFilteredEntity(
    @ColumnInfo var timeSpan: String,
    @ColumnInfo var amount: Double,
    @PrimaryKey var date: Long
)