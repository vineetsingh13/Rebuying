package com.example.rebuying.SignIn

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInRetroft {

    @POST("CreateUser/")
    fun createUser(@Body user: SignInData): Call<SignInResponseData>
}