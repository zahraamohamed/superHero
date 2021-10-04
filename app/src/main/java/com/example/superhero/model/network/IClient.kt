package com.example.superhero.model.network

import com.example.superhero.model.Status
import com.example.superhero.model.responce.SuperheroResponce

interface IClient {
    fun getSuperHeroRequest(): Status<SuperheroResponce>
}