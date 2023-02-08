package com.example.apicalls.data.remote

import com.example.apicalls.data.model.GotCharacter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://thronesapi.com/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface GotApiService {

    @GET("Characters")
    suspend fun getCharacters(): List<GotCharacter>

}

object GotApi{
    val retrofitService: GotApiService by lazy { retrofit.create(GotApiService::class.java) }
}
