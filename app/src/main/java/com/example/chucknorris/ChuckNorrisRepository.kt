package com.example.chucknorris

import com.example.chucknorris.model.Joke

interface ChuckNorrisRepository {

    suspend fun getCategory(): List<String>

    suspend fun random(category: String? = null): Joke
}

class ChuckNorrisRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi) :
    ChuckNorrisRepository {
    override suspend fun getCategory(): List<String> {
        return chuckNorrisApi.getCategories()
    }

    override suspend fun random(category: String?): Joke {
        return chuckNorrisApi.random(category)
    }

}