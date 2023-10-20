package com.project.beertracker.data.repository

import com.project.beertracker.data.local.dao.ProductDao
import com.project.beertracker.data.local.entities.asDomainModel
import com.project.beertracker.domain.model.Product
import com.project.beertracker.domain.model.asEntityModel
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDao: ProductDao,
    private val supabasePostgrest: Postgrest) : IProductRepository {

   override fun getAllProducts(): Flow<List<Product>> {
       return productDao.getAllProducts().map {
           it.asDomainModel()
       }
    }

    override suspend fun refreshDatabase() {
//        try {
//            val result = supabasePostgrest[CollectionNames.products]
//                .select().decodeList<ProductDto>()
//            val products = result.map { SupabaseMapper.mapToEntity(it) }
//            productDao.insertAll(products)
//        } catch (e: Exception) {
//            Timber.e(e.message)
//        }
    }


    override fun getProductById(productId: String): Product {
        return productDao.getProductById(productId).asDomainModel()
    }

    override fun getProductsByName(name: String): Flow<List<Product>> {
        return return productDao.getProductsByName(name).map {
            it.asDomainModel()
        }
    }

    override suspend fun upsertProduct(product: Product) {
        productDao.upsertProduct(product.asEntityModel())
    }

    override suspend fun deleteProduct(productId: String) {
        productDao.deleteProduct(productId)
    }
}
