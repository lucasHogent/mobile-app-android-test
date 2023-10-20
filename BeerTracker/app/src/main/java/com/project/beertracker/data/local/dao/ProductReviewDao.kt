package com.project.beertracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.project.beertracker.domain.model.ProductReview
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductReviewDao {

    @Upsert
    suspend fun upsertProductReview(product: ProductReview)
    @Query("SELECT * FROM product_review WHERE user_id = :userId")
    fun getProductReviewsByOwner(userId: Int): Flow<ProductReview>

    @Query("SELECT * FROM product_review WHERE product_id = :productId")
    fun getProductReviewsForProduct(productId: Int): Flow<ProductReview>

}