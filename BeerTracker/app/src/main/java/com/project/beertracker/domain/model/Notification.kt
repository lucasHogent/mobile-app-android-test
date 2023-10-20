package com.project.beertracker.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_notification")

data class Notification(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "actor_user_id")
    val actor: Long?,
    @ColumnInfo(name = "notifier_user_id")
    val notifier: Long?,
    @ColumnInfo(name = "product_id")
    //@TypeConverter enum REQUEST,REVIEW
    val type: String,
    val text: String,
    val createTimeStamp: Long?,
    val status: Int,
) {
}