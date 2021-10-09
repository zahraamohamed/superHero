package com.example.superhero.model.repository

import com.example.superhero.model.Status
import com.example.superhero.model.network.Client
import com.example.superhero.model.responce.SuperheroResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {
    abstract fun getHeroData(query: String):Flow<Status<SuperheroResponce>>
}