package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce
import okhttp3.Response

/*
 TODO: 10/11/2021 (in IResponse class all the function are not generic and can be used only with
SuperHeroResponse Class, so this is not abstraction and can be used only in one place. so it’s
better to remove it.) */


interface IResponse {
    fun responseStatus(response: Response): Status<SuperheroResponce>
    fun responseSuccessful(response: Response): Status<SuperheroResponce>
    fun responseError(response: Response): Status<SuperheroResponce>
}

