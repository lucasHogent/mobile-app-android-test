package com.project.beertracker.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://tasty.p.rapidapi.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

var rapidApiHost = "tasty.p.rapidapi.com"
var rapidApiKey = "25623d5122mshdf7d5b25fc85d92p16d42bjsn846c1ccf5e93"

interface RecipesApiService {
//    @Headers(
//        "x-rapidapi-host: tasty.p.rapidapi.com",
//        "x-rapidapi-key: 25623d5122mshdf7d5b25fc85d92p16d42bjsn846c1ccf5e93"
//    )
//    @GET("recipes/list")
//    fun getRecipesList(
//        @Query("from") from: Int = 20,
//        @Query("size") size: Int = 30,
//        @Query("tags") tags: String = "under_30_minutes"
//    ): Deferred<RecipeListResponse>
}

object Api {
    val retrofitService: RecipesApiService by lazy {
        retrofit.create(RecipesApiService::class.java)
    }
}