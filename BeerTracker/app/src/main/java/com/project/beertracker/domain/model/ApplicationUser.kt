package com.project.beertracker.domain.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_user")
data class ApplicationUser(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "user_name") val userName: String?,
    val password: String?,
    val email: String?,
//    @TypeConverters({TimestampConverter.class})
//    val createTimeStamp: LocalDateTime?
)