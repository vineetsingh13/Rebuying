package com.example.rebuying

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginRetrofit {

    @GET("AuthenticateUser/")
    fun loginData(@Query("email")email:String, @Query("password")password:String): Call<login_data>
}