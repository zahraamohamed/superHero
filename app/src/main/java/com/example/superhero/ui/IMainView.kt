package com.example.superhero.ui

import com.example.superhero.model.responce.SuperheroResponce

interface IMainView {
    fun bindData(data: SuperheroResponce)
    fun setVisibility(visible: Boolean, isLoading: Boolean = true)
    fun onLoading()
    fun onError()
}