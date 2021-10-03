package com.example.superhero.model.network

import android.util.Log
import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.util.Constant
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object Client {


    private val okHttpClient = OkHttpClient()
    private val gson = Gson()
    private val superHeroUrl = HttpUrl.Builder()
        .scheme("https")
        .host("superheroapi.com")
        .addPathSegment("/api/${Constant.KEY}/1")
        .build()

    fun makeSuperHeroRequest(): Status<SuperheroResponce> {

        val request = Request.Builder().url(superHeroUrl).build()
        val response = okHttpClient.newCall(request).execute()

        return if (response.isSuccessful) {
            val parserResponse = gson.fromJson(
                response.body?.string(),
                SuperheroResponce::class.java
            )
            Status.Success(parserResponse)
        } else {
            Status.Error(response.message)
        }
    }

}