package com.example.retrofit_example1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MarsViewModel: ViewModel() {
    private val repository: MarsRepository

    init {
        repository = MarsRepository()
    }
    fun getFetchTerrains(): LiveData<List<MarsTerrain>>{
        return repository.fetchMarsTerrainEnqueue()
    }
    private var selectedMarsTerrain: MutableLiveData<MarsTerrain> = MutableLiveData()
    fun selected(marsTerrain: MarsTerrain?){
        selectedMarsTerrain.value = marsTerrain
    }
    fun selectedItem(): LiveData<MarsTerrain> = selectedMarsTerrain
}