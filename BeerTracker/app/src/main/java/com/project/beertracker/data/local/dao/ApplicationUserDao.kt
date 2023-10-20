package com.project.beertracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.project.beertracker.domain.model.ApplicationUser


@Dao
interface ApplicationUserDao {

    @Upsert
    suspend fun upsertApplicationUser(appUser: ApplicationUser)
    @Query("SELECT * FROM app_user WHERE user_name = :username")
    suspend fun getApplicationUserByUserName(username: String): ApplicationUser

}