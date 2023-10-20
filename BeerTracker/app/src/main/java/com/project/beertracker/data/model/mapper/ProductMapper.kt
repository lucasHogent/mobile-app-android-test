package com.project.beertracker.data.model.mapper

import com.project.beertracker.data.local.entities.ProductEntity
import com.project.beertracker.domain.model.Product

class ProductMapper {

    companion object {
        fun mapToModel(entity: ProductEntity): Product {
            return Product(
                id = entity.id,
                ownerId = entity.owner,
                name = entity.name,
                description = entity.description,
                deleted = entity.deleted,
                category = entity.category
            )
        }

        fun mapToEntity(model: Product): ProductEntity {
            return ProductEntity(
                id = model.id,
                owner = model.ownerId,
                name = model.name,
                description = model.description,
                picture = model.picture,
                deleted = model.deleted,
                category = model.category
            )
        }
    }
}