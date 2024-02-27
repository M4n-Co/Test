package com.example.test.productList.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemToProductsBinding
import com.example.test.productList.data.network.model.Product

class ProductsAdapter (
    private val products : List<Product>,
    private val onItemClick : (Product) -> Unit
) : RecyclerView.Adapter<ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = ItemToProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(products[position], onItemClick)
    }


}