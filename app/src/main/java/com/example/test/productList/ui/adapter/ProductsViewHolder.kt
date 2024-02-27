package com.example.test.productList.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemToProductsBinding
import com.example.test.productList.data.network.model.Product

class ProductsViewHolder (private val mBinding : ItemToProductsBinding) : RecyclerView.ViewHolder(mBinding.root) {

    fun bind(product: Product, onItemClick: (Product) -> Unit){

        mBinding.tvProductName.text = product.title
        mBinding.tvDescription.text = product.description
        mBinding.tvProductPrice.text = product.price.toString()

        itemView.setOnClickListener {
            onItemClick(product)
        }
    }

}