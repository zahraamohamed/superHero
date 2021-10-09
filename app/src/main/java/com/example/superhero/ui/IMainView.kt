package com.example.superhero.ui

import com.example.superhero.model.responce.SuperheroResponce

interface IMainView {

    fun onSuccess(data: SuperheroResponce)
    fun setVisibility(visible: Boolean, isLoading: Boolean = true)
    fun onLoading()
    fun onError()
}