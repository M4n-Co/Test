package com.example.test.productList.data.network

import com.example.test.productList.data.network.model.ProductsModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {

    @GET("products")
    suspend fun getProducts():Response<ProductsModel>

}