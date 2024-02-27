package com.example.test.productList.data.network

import com.example.test.productList.data.ProductsListRepositoryImpl
import com.example.test.productList.domian.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {

    @Provides
    fun getProductsService(retrofit: Retrofit) : ProductsService{
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    fun provideProductsRepository(service : ProductsService) : ProductsRepository{
        return ProductsListRepositoryImpl(service)
    }
}