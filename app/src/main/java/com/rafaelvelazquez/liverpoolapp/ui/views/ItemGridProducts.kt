package com.rafaelvelazquez.liverpoolapp.ui.views

import android.view.View
import com.rafaelvelazquez.imagemanager.bindImageUrl
import com.rafaelvelazquez.liverpoolapp.R
import com.rafaelvelazquez.liverpoolapp.databinding.ItemGridProductsBinding
import com.xwray.groupie.viewbinding.BindableItem

class ItemGridProducts(
    private val mImageProduct: String?,
    private val mProductName: String?,
    private val mProductPrice: String,
    private val mProductDiscount:String
): BindableItem<ItemGridProductsBinding>() {

    private lateinit var binding: ItemGridProductsBinding

    override fun bind(viewBinding: ItemGridProductsBinding, position: Int) {
        binding = viewBinding
        binding.apply {
            productName.text = mProductName
            productPrice.text = mProductPrice
            productDiscount.text = mProductDiscount
            imageProduct.bindImageUrl(
                url = mImageProduct,
                placeholder = R.drawable.ic_burst_mode,
                errorPlaceholder = R.drawable.ic_broken_image
            )
        }
    }



    override fun getLayout() = R.layout.item_grid_products


    override fun initializeViewBinding(view: View) =
        ItemGridProductsBinding.bind(view)
}