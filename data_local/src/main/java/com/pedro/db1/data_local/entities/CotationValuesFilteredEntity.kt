package com.pedro.db1.data_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cotation_filter")
data class CotationValuesFilteredEntity (
    @PrimaryKey var timeSpan: String,
    @ColumnInfo var amount: Double,
    @ColumnInfo var date: Long
)