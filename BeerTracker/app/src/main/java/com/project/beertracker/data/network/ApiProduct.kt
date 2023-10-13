package com.project.beertracker.data.network

import ApplicationUser
import Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ApiProduct(
    val productId: Long = 0,
    val name: String  = "",
    val description: String = "",
    val picture: String = "",
    val owner: ApplicationUser
)

fun ApiProduct.toRealmProduct(): Product {
    return Product().apply {
        name = this@toRealmProduct.name
        description = this@toRealmProduct.description
        picture = this@toRealmProduct.picture
        owner = this@toRealmProduct.owner
        productId = this@toRealmProduct.productId

    }
}