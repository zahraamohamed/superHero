package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import okhttp3.HttpUrl

interface IClient {

    fun getRequest(queryHeroName: String): Status<SuperheroResponce>
}