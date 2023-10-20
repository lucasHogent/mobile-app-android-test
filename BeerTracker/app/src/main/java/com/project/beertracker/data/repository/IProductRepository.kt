package com.project.beertracker.data.repository

import com.project.beertracker.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface IProductRepository {
    fun getAllProducts(): Flow<List<Product>>
    fun getProductById(productId: String): Product?
    fun getProductsByName(name: String): Flow<List<Product>>
    suspend fun upsertProduct(product: Product)
    suspend fun deleteProduct(productId: String)
    suspend fun refreshDatabase()


}