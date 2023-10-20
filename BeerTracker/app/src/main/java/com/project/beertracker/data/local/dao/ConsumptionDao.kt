package com.project.beertracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.project.beertracker.domain.model.Consumption

@Dao
interface ConsumptionDao {
    @Upsert
    suspend fun upsertConsumption(consumption: Consumption)
    @Query("SELECT * FROM user_consumption WHERE user_id = :userId")
    suspend fun getConsumptionsByUserId(userId: Long): List<Consumption>

}