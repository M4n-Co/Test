package com.example.test.productList.data

import com.example.test.productList.data.network.ProductsService
import com.example.test.productList.data.network.model.ProductsModel
import com.example.test.productList.domian.ProductsRepository
import retrofit2.Response
import javax.inject.Inject

class ProductsListRepositoryImpl @Inject constructor(
    private val productsService: ProductsService
) : ProductsRepository {
    override suspend fun getProducts() : Response<ProductsModel> {
        return productsService.getProducts()
    }
}