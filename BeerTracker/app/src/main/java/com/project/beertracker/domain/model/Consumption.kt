package com.project.beertracker.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_consumption")
data class Consumption (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "user_id")
    val userId: Long?,
    @ColumnInfo(name = "product_id")
    val productId: Long,
    //@TypeConverter
    val createTimeStamp: Long?,
    val amount: Int,
    val deleted: Boolean,
)