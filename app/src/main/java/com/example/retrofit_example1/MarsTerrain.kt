package com.example.retrofit_example1

import com.google.gson.annotations.SerializedName
//(POJO) son clases que solo representan datos
data class MarsTerrain(@SerializedName("id")
                       val id: String,
                       @SerializedName("price")
                       val price: Long,
                       @SerializedName("type")
                       val type: String,
                       @SerializedName("img_src")
                       val srcImg: String)