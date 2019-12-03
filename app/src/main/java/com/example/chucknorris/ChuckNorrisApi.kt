package com.example.chucknorris

import com.example.chucknorris.model.Joke
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("/jokes/categories")
    suspend fun getCategories(): List<String>

    @GET("/jokes/random")
    suspend fun random(@Query("random") random: String? = null): Joke
}