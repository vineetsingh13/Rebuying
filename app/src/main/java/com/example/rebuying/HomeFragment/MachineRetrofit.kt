package com.example.rebuying.HomeFragment

import retrofit2.Call
import retrofit2.http.GET

interface MachineRetrofit {

    @GET(value= "Products/")
    fun getProducts(): Call<MutableList<MachineResponseData>>
}