package com.example.chucknorris

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

//	single<OkHttpClient> { provideDefaultOkhttpClient() }
	single { provideRetrofit(get()) }
	single { provideApiService(get()) }
	single<ChuckNorrisRepository> { ChuckNorrisRepositoryImpl(get()) }
}
//
//fun provideDefaultOkhttpClient(): OkHttpClient {
//	return OkHttpClient.Builder()
//		.addInterceptor(ApiKeyInterceptor())
//		.build()
//}

fun provideRetrofit(client: OkHttpClient): Retrofit {
	return Retrofit.Builder()
		.baseUrl("https://api.chucknorris.io/")
		.client(client)
		.addConverterFactory(GsonConverterFactory.create())
//		.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
		.build()
}

fun provideApiService(retrofit: Retrofit): ChuckNorrisApi = retrofit.create(ChuckNorrisApi::class.java)