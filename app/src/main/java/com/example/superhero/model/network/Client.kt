package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.util.Constant
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object Client : IClient {

    private var responseState = Response()
    private val okHttpClient = OkHttpClient()

    private fun superHeroUrl(searchSuperHeroName: String) = HttpUrl.Builder()
        .scheme(Constant.SCHEME)
        .host(Constant.HOST)
        .addPathSegment(Constant.API_SEGMENT)
        .addPathSegment(Constant.ACCESS_TOKEN)
        .addPathSegment(Constant.SEARCH_SEGMENT)
        .addPathSegment(searchSuperHeroName)
        .build()

    override fun getRequest(queryHeroName: String): Status<SuperheroResponce> {
        val request = Request.Builder()
            .url(superHeroUrl(queryHeroName))
            .build()
        val response = okHttpClient.newCall(request).execute()
        return responseState.responseStatus(response = response)
    }
}