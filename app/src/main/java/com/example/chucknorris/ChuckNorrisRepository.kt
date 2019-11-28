package com.example.chucknorris

interface ChuckNorrisRepository {

	fun getCategory(): List<String>
}

class ChuckNorrisRepositoryImpl(private val chuckNorrisApi: ChuckNorrisApi): ChuckNorrisRepository {
	override fun getCategory(): List<String> {
		return chuckNorrisApi.getCategories()
	}

}