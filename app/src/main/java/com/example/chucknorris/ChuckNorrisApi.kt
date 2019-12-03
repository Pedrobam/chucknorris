package com.example.chucknorris

import retrofit2.http.GET

interface ChuckNorrisApi {

    @GET("/jokes/categories")
    suspend fun getCategories(): List<String>
}