package com.example.chucknorris

interface ChuckNorrisRepository {

    suspend fun getCategory(): List<String>
}

class ChuckNorrisRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi) :
    ChuckNorrisRepository {
    override suspend fun getCategory(): List<String> {
        return chuckNorrisApi.getCategories()
    }

}