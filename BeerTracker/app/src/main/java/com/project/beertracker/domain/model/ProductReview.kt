package com.project.beertracker.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_review")
data class ProductReview(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "product_id")
    val productId: Long,
    @ColumnInfo(name = "user_id")
    val owner: Long,
    val text: String,
    //@TypeConverter
    // val createTimeStamp: LocalDateTime?,


) {

}