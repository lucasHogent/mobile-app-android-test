package com.project.beertracker.domain.model

import com.project.beertracker.data.local.entities.ProductEntity

data class Product(
    var id: String,
    var ownerId: String? = null,
    var name: String? = null,
    var description: String? = null,
    var picture: String? = null,
    var deleted: Boolean? = null,
    var category: String? = null
)

fun List<Product>.asEntityModel(): List<ProductEntity> {
    return map {
        it.asEntityModel()
    }
}

fun Product.asEntityModel(): ProductEntity {
    return ProductEntity(
        id = this.id,
        owner = this.ownerId,
        name = this.name,
        description = this.description,
        picture = this.picture,
        category = this.category,
        deleted =  this.deleted

    )
}
