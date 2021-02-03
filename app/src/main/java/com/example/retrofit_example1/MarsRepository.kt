package com.example.retrofit_example1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRepository() {
    private val services= RetrofitClient.retrofitInstance()
    private val liveDataMarsTerrain = MutableLiveData<List<MarsTerrain>>()

    fun fetchMarsTerrainEnqueue(): LiveData<List<MarsTerrain>>{
        services.fetchMarsTerrainEnqueue().enqueue(object : Callback<List<MarsTerrain>> {
            override fun onFailure(call: Call<List<MarsTerrain>>, t: Throwable) {
                Log.e("Error",t.message.toString())
            }
            override fun onResponse(call: Call<List<MarsTerrain>>, response: Response<List<MarsTerrain>>) {
                when(response.code()){
                   in 200..299 -> liveDataMarsTerrain.value = response.body()
                   in 300..399 -> Log.d("Error",response.errorBody().toString())
                   else -> Log.d("ERROR", "ERROR DEL SERVER ${response.code()}")
               }
            }
        })
        return liveDataMarsTerrain
    }
    /*//funcion que utiliza las corrutinas para la conexion al servicio
    suspend fun getTerrainWithCourrutines(): LiveData<List<MarsViewModel>>{
        Log.d("REPOSITORY","Utilizando corrutinas")
        val response = RetrofitClient.retrofitInstance().fetchMarsTerrainCorroutines()
        when(response.isSuccessful){
            true->response.body()?.let {
                liveDataMarsTerrain.value = it
            }
            false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()} ")
        }
        return liveDataMarsTerrain
    }*/
}