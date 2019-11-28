package com.example.chucknorris

import retrofit2.http.GET

interface ChuckNorrisApi {

	@GET("/jokes/categories")
	fun getCategories(): List<String>
}