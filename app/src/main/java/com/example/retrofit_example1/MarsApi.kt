package com.example.retrofit_example1

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {
    //antigua
    @GET("realestate")
    fun fetchMarsTerrainEnqueue(): Call<List<MarsTerrain>>

    //la formanueva recomendable
    @GET("realestate")
    suspend fun fetchMarsTerrainCorroutines(): Response<List<MarsTerrain>>
}