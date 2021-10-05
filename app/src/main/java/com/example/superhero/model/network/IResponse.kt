package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import okhttp3.Response

interface IResponse {
    fun responseStatus(response: Response): Status<SuperheroResponce>
}