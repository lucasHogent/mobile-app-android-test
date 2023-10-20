package com.project.beertracker.data.local.dao


import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.project.beertracker.data.local.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    // Get a product by its unique ID
    @Query("SELECT * FROM product WHERE id = :productId")
    fun getProductById(productId: String): ProductEntity

    // Get all products
    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE name LIKE :name ")
    fun getProductsByName(name: String): Flow<List<ProductEntity>>

    // Upsert a product
    @Upsert
    suspend fun upsertProduct(product: ProductEntity)

    // Delete a product
    @Query("DELETE FROM product WHERE id = :productId")
    suspend fun deleteProduct(productId: String)

    // Delete all products
    @Query("DELETE FROM product")
    suspend  fun deleteAllProducts()

}

