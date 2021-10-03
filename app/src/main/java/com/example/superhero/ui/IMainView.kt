package com.example.superhero.ui

import com.example.superhero.model.responce.*

interface IMainView {

    fun onSuperheroResponseSuccess(superheroResponse: SuperHeroResponce)
    fun bindData(data: SuperHeroResponce)
    fun hideAllViews()


}