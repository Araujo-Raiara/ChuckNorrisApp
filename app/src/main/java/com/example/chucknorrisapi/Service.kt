package com.example.chucknorrisapi

import com.example.chucknorrisapi.adapters.AdapterServiceApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.chucknorris.io/"

val moshi = Moshi.Builder().add(AdapterServiceApi()).add(KotlinJsonAdapterFactory()).build()
val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()

interface ChuckNorrisJokesApiService {
    @GET("jokes/random")
    fun getRandomJoke() : Call<Jokes>

    @GET("jokes/categories")
    fun getCategories() : Call<ValueListOfCategories>

    @GET("jokes/random")
    fun getJokeByCategory(@Query("category") category : String) : Call<Jokes>

    @GET("jokes/search")
    fun getSearchJoke(@Query("query") query: String) : Call<SearchResponse>
}