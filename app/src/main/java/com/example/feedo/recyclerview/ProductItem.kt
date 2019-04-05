package com.example.feedo.recyclerview

import android.view.View
import com.example.feedo.R
import com.mikepenz.fastadapter.items.AbstractItem

data class ProductItem(val productName: String, val brand: String, val imageUrl: String): AbstractItem<ProductItem, ProductViewHolder>() {

    override fun getType() = 0

    override fun getLayoutRes() = R.layout.row_product

    override fun getViewHolder(view: View) = ProductViewHolder(view)

}