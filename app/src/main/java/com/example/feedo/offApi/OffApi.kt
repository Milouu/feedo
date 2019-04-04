package com.example.feedo.offApi

import com.example.feedo.modelApi.OffWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.feedo.modelApi.Product

interface OffApi {

    @GET("{id}")
    fun getProductById(
        @Path("id") id: Long
    ): Call<OffWrapper>
}