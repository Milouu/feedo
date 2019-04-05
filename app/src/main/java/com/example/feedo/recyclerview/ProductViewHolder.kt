package com.example.feedo.recyclerview

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ViewTarget
import com.example.feedo.R
import com.mikepenz.fastadapter.FastAdapter

class ProductViewHolder(itemView: View) : FastAdapter.ViewHolder<ProductItem>(itemView) {

    val nameView: TextView
    val brandView: TextView
    val imageView: ImageView

    var request: ViewTarget<ImageView, Drawable>? = null

    init {
        nameView = itemView.findViewById(R.id.nameView)
        brandView = itemView.findViewById(R.id.brandView)
        imageView = itemView.findViewById(R.id.imageView)
    }

    override fun bindView(item: ProductItem, payloads: MutableList<Any>) {
        nameView.text = item.productName

        brandView.text = item.brand

        request = Glide.with(imageView)
            .load(item.imageUrl)
            .into(imageView)
    }

    override fun unbindView(item: ProductItem) {
        nameView.text = ""
        brandView.text = ""
        imageView.setImageDrawable(null)
        request?.clearOnDetach()
    }

}