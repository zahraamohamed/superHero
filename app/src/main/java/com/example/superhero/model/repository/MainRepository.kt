package com.example.superhero.model.repository

import com.example.superhero.model.Status
import com.example.superhero.model.network.Client
import com.example.superhero.model.responce.SuperheroResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


// TODO: 10/11/2021 Main Repository class name is not clear what is main do we have a secondary one?, only
//Repository is enough for its name

class MainRepository : BaseRepository() {

    override fun getHeroData(query: String): Flow<Status<SuperheroResponce>> =
        flow<Status<SuperheroResponce>> {
            emit(Status.Loading)
            emit(Client.getRequest(query))
        }.flowOn(Dispatchers.IO)
}