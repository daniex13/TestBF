package com.example.testbf.data.remote

import com.example.testbf.data.model.Character
import com.example.testbf.util.AppConstans
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("character")
    suspend fun getCharacters(): Character

}

object RetrofitClient{
    val webservice: WebService by lazy{

        Retrofit.Builder()
            .baseUrl(AppConstans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}