package com.project.beertracker.domain.usecases

import com.project.beertracker.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface IGetProductsUseCase : UseCase<IGetProductsUseCase.Input, IGetProductsUseCase.Output> {
    class Input
    class Output(val result: Flow<List<Product>>)
}