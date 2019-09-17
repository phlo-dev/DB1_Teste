package com.pedro.db1.data_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pedro.db1.domain.model.CotationValue

@Entity(tableName = "cotation_filter")
data class CotationValuesFilteredEntity (
    @PrimaryKey var timeSpan: String,
    @ColumnInfo var cotationValue: CotationValue
)