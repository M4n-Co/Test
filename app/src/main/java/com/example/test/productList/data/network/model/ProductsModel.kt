package com.example.test.productList.data.network.model

data class ProductsModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)