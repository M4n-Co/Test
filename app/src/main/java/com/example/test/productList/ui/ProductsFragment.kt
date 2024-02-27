package com.example.test.productList.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.FragmentProductsBinding
import com.example.test.productDetails.model.ProductParcelable
import com.example.test.productList.data.network.model.Product
import com.example.test.productList.ui.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var mBinding : FragmentProductsBinding
    private lateinit var mAdapter: ProductsAdapter
    private val mViewModel : ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentProductsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        mViewModel.getProducts()
        initObservers()
    }

    private fun initObservers() {
        mViewModel.products.observe(viewLifecycleOwner){
            if (it != null){
                initRecycler(it.products)
            }
        }
    }

    private fun initRecycler(list : List<Product>) {
        mAdapter = ProductsAdapter(list){

            goToDetails(it)

        }

        mBinding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        mBinding.rvProducts.adapter = mAdapter

    }

    private fun goToDetails(product: Product) {
        val productParcelable = ProductParcelable(
            product.description,
            product.images,
            product.price,
            product.title
        )

        findNavController().navigate(
            ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(productParcelable)
        )
    }

}