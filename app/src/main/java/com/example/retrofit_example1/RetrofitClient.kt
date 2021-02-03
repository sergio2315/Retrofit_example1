package com.example.retrofit_example1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val URI_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"

        fun retrofitInstance(): MarsApi{
            val retrofit = Retrofit.Builder().baseUrl(URI_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MarsApi:: class.java)
        }
    }
}