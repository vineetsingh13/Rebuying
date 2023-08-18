package com.example.rebuying

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    //private val url="http://192.168.1.16:8000/"
    //private val url="http://10.0.2.2:8000/"
    private val url ="https://web-production-dae5.up.railway.app/"

    private val retrofit=Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}