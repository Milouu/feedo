package com.example.feedo.offApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OffClient {
    val api: OffApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fr.openfoodfacts.org/api/v0/produit/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(OffApi::class.java)
    }
}