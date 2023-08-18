package com.example.rebuying.ProductPage

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductRetrofit {

    @GET("Products/id/")
    fun getProduct(@Query("product_id") product_id:Int): Call<ProductResponseData>
}