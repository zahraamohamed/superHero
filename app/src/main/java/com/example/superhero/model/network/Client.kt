package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.util.Constant
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

open class Client(searchName: String) : IClient {


    private lateinit var responseState : IResponse
    private val okHttpClient = OkHttpClient()
    val gson = Gson()
    private val superHeroUrl = HttpUrl.Builder()
        .scheme(Constant.SCHEME)
        .host(Constant.HOST)
        .addPathSegment("${Constant.PATH_SEGMENT}${Constant.KEY}/${searchName}")
        .build()

    open fun makeSuperHeroRequest(): Status<SuperheroResponce> {

        val request = Request.Builder().url(superHeroUrl).build()
        val response = okHttpClient.newCall(request).execute()

        responseState = Response()

        return responseState.responseStatus(response)

    }

    override fun getSuperHeroRequest(): Status<SuperheroResponce> {
        return makeSuperHeroRequest()
    }

}