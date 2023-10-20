package com.project.beertracker.ui.productlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.beertracker.domain.model.Product
import com.project.beertracker.data.repository.ProductRepository
import kotlinx.coroutines.launch


class ProductViewModel(private val productRepository: ProductRepository): ViewModel() {

    var product: Product? by mutableStateOf(null)

    var openDialog by mutableStateOf(false)

    val products : LiveData<List<Product>> = productRepository.getAllProducts().asLiveData()


    fun getProduct(id: String) = viewModelScope.launch {

        product = productRepository.getProductById(id)
    }

    fun upsertProduct(product: Product) = viewModelScope.launch {
        productRepository.upsertProduct(product)
    }

    fun deleteProduct(id: String) = viewModelScope.launch {
        productRepository.deleteProduct(id)
    }


}
