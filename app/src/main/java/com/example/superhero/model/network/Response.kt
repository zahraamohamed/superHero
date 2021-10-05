package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import com.google.gson.Gson
import okhttp3.Response

class Response : IResponse {

    val gson = Gson()

    override fun responseStatus(response: Response): Status<SuperheroResponce> {
        return if (response.isSuccessful) {
            responseSuccessful(response)
        } else {
            responseError(response)
        }
    }

    fun responseSuccessful(response: Response) = Status.Success(
        gson.fromJson(
            response.body?.string(),
            SuperheroResponce::class.java
        )
    )

    fun responseError(response: Response) = Status.Error(response.message)

}