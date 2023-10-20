package com.project.beertracker.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class ProductDto {
    @Serializable
    data class ProductDto(
        @SerialName("productid")
        val productId: String,
        @SerialName("name")
        val name: String,
        @SerialName("description")
        val description: String,
        @SerialName("image")
        val image: String,
        @SerialName("category")
        val category: String,
        @SerialName("owner_id")
        val ownerId: String,
    )
}