package com.example.feedo.offApi

import com.example.feedo.modelApi.OffWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OffApi {
    /*
    @GET("search.pl?search_simple=1&json=1&page_size=20&search_terms={name}")
    fun getProductByCategory(
        @Query("name") name: String
    ): Call<OffWrapper>
    */
    @GET("search.pl?search_simple=1&json=1&page_size=20")
    fun getProductByCategory(
        @Query("search_terms") name: String
    ):Call<OffWrapper>
}