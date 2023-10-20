package com.project.beertracker.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.beertracker.domain.model.Product
import java.util.UUID

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "user_id")
    var owner: String?,
    var name: String?,
    var description: String?,
    //@TypeConverter
    // val createTimeStamp: LocalDateTime?,
    var picture: String?,
    var deleted: Boolean?,
    var category: String?,

    )
fun List<ProductEntity>.asDomainModel(): List<Product> {
    return map {
        it.asDomainModel()
    }
}

fun ProductEntity.asDomainModel(): Product {
    return Product(
        id = this.id,
        ownerId = this.owner,
        name = this.name,
        description = this.description,
        picture = this.picture,
        category = this.category,
        deleted =  this.deleted

    )
}