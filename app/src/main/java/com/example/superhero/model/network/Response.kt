package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import okhttp3.Response

class Response :IResponse{

    override fun responseStatus(response: Response): Status<SuperheroResponce> {
        return if (response.isSuccessful) {
            val parserResponse = Client.gson.fromJson(
                response.body?.string(),
                SuperheroResponce::class.java
            )
            Status.Success(parserResponse)
        } else {
            Status.Error(response.message)
        }
    }

}