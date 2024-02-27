package com.example.test.productList.domian

import com.example.test.productList.data.network.model.ProductsModel
import retrofit2.Response

interface ProductsRepository {

    suspend fun getProducts() : Response<ProductsModel>
}