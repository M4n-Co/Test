package com.example.test.productDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.test.databinding.FragmentProductDetailsBinding
import com.example.test.productDetails.model.ProductParcelable


class ProductDetailsFragment : Fragment() {

    private lateinit var mBinding : FragmentProductDetailsBinding

    private val args : ProductDetailsFragmentArgs by navArgs()
    private val mProduct : ProductParcelable get() = args.product

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInfo()

        mBinding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setInfo() {

        with(mBinding){
            tvTitle.text = mProduct.title

            Glide.with(ivProduct.context)
                .load(mProduct.images[0])
                .into(ivProduct)

            tvDescription.text = mProduct.description

            tvProductPrice.text = mProduct.price.toString()
        }

    }

}