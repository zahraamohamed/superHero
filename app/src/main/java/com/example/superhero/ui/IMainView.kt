package com.example.superhero.ui

import com.example.superhero.model.responce.*

interface IMainView {
    fun onSuperheroResponseSuccess(data: SuperheroResponce)
    fun hideAllViews()
}