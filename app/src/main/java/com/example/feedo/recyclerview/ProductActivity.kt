package com.example.feedo.recyclerview

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import com.example.feedo.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val adapter = ItemAdapter<ProductItem>()
        adapter.add(
            ProductItem(
                "Riz complet",
                "Harris",
                "https://rickandmortyapi.com/api/character/avatar/361.jpeg"
            )
        )
        adapter.add(
            ProductItem(
                "Riz again",
                "Bjorg",
                "https://rickandmortyapi.com/api/character/avatar/361.jpeg"
            )
        )

        val fastAdapter: FastAdapter<ProductItem> = FastAdapter.with(adapter)

       // recyclerView.adapter = fastAdapter
        //recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}