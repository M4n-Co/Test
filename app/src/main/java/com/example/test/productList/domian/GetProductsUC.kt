package com.example.test.productList.domian

import javax.inject.Inject

class GetProductsUC @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke() = productsRepository.getProducts()
}