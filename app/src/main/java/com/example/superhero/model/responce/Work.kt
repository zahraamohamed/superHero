package com.example.superhero.model.responce


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("base")
    val base: String?,
    @SerializedName("occupation")
    val occupation: String?
)