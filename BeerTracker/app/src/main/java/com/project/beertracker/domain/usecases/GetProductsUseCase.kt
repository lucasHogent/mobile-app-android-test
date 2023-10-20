package com.project.beertracker.domain.usecases

import com.project.beertracker.data.repository.IProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: IProductRepository) :
    IGetProductsUseCase {
    override fun execute(input: IGetProductsUseCase.Input): IGetProductsUseCase.Output {
        val result = productRepository.getAllProducts()
        return IGetProductsUseCase.Output(result)
    }

}
