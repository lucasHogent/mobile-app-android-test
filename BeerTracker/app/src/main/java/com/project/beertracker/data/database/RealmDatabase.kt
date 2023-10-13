package com.project.beertracker.data.database

import Product
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RealmDatabase {

    val realm: Realm by lazy {
        val configuration = RealmConfiguration.create(schema = setOf(Product::class))
        Realm.open(configuration)
    }

    fun getAllProducts(): List<Product> {
        return realm.query<Product>().find()
    }

    fun getAllProductsAsFlow(): Flow<List<Product>> {
        return realm.query<Product>().asFlow().map { it.list }
    }

    fun getAllProductsAsCommonFlow(): CFlow<List<Product>> {
        return getAllProductsAsFlow().wrap()
    }

    fun getProductsByName(name: String): List<Product> {
        return realm.query<Product>("name = $0", name).find()
    }

    fun getProductsByNameAsFlow(name: String): Flow<List<Product>> {
        return realm.query<Product>("name = $0", name).asFlow().map { it.list }
    }

    fun getProductsByNameAsCommonFlow(name: String): CFlow<List<Product>> {
        return getProductsByNameAsFlow(name).wrap()
    }

    fun addProduct(product: Product) {
        realm.writeBlocking {
            copyToRealm(product)
        }
    }

    fun deleteProduct(title: String) {
        realm.writeBlocking {
            query<Product>("name = $0", title)
                .first()
                .find()
                ?.let { delete(it) }
                ?: throw IllegalStateException("Product not found.")
        }
    }

}