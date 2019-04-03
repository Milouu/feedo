package com.example.feedo.offApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OffApi {

    @GET("{id}/product")
    fun getProductById(
        @Path("id") id: Long
    ): Call<Product>
}