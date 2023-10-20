package com.project.beertracker.ui.productlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.beertracker.domain.model.Product
import com.project.beertracker.domain.usecases.IGetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
@HiltViewModel
class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getProductsListUseCase: IGetProductsUseCase,
   // private val getProductsByNameUseCase: GetProductsByCategoryUseCase,
) : ViewModel() {

    private val _productList: Flow<List<Product>> = getProductLists()

    val state = _productList.map {
        ProductListViewState(it.toImmutableList())
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ProductListViewState.Empty
    )

    private fun getProductLists(): Flow<List<Product>> {
        return getProductsListUseCase.execute(IGetProductsUseCase.Input()).result
    }

}
