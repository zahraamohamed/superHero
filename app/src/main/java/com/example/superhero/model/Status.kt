package com.example.superhero.model

import com.example.superhero.model.responce.SuperheroResponce

sealed class Status<out T>{
    object Loading : Status<Nothing>()
    data class Error(val errorMessage : String) : Status<Nothing>()
    data class Success<T>(val responseData: T) : Status<T>()
}
