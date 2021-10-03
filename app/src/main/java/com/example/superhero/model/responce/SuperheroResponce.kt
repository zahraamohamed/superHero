package com.example.superhero.model.responce


import com.google.gson.annotations.SerializedName

data class SuperheroResponce(
    @SerializedName("response")
    val response: String?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("results-for")
    val resultsFor: String?
)