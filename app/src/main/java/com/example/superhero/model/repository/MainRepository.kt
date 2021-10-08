package com.example.superhero.model.repository

import com.example.superhero.model.Status
import com.example.superhero.model.network.Client
import com.example.superhero.model.network.Response
import com.example.superhero.model.responce.SuperheroResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepository: BaseRepository() {
    override fun  getInfoSuperHero(query: String): Flow<Status<SuperheroResponce>> =
        flow<Status<SuperheroResponce>>{
            emit(Status.Loading)
            emit(Client.getRequest(query))
        }.flowOn(Dispatchers.IO)
    }
    /*override fun getInfoSuperHero(searchSuperHeroName: String) =
        flow<Status<SuperheroResponce>>{
        emit(Status.Loading)
        emit(Client.getRequest(searchSuperHeroName))
    }.flowOn(Dispatchers.IO)*/