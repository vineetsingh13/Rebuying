package com.example.rebuying.ProductPage

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserRetrofit {

    @GET("users/id/")
    fun getUserData(@Query("UserId") UserId:Int): Call<UserData>
}