package com.example.test.productList.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.productList.data.network.model.ProductsModel
import com.example.test.productList.domian.GetProductsUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUC: GetProductsUC
) : ViewModel(){

    val isLoading = MutableLiveData<Boolean>()
    val products = MutableLiveData<ProductsModel>()

    fun getProducts(){

        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)

            val response = getProductsUC()

            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    isLoading.value = false
                    products.value = response.body()
                }else{
                    isLoading.value = false
                }
            }

        }

    }

}