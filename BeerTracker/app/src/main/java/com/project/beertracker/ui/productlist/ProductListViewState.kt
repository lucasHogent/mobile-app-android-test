package com.project.beertracker.ui.productlist

import androidx.compose.runtime.Immutable
import com.project.beertracker.domain.model.Product
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
class ProductListViewState(
    val productList: ImmutableList<Product> = persistentListOf()
) {
    companion object {
        val Empty = ProductListViewState()
    }
}