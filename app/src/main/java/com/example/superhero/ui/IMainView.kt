package com.example.superhero.ui

import com.example.superhero.model.responce.*

interface IMainView {

    fun onSuperheroResponseSuccess(superheroResponse: SuperheroResponce)
    fun bindData(data: SuperheroResponce)
    fun hideAllViews()


}