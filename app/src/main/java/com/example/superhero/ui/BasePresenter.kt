package com.example.superhero.ui

import com.example.superhero.model.repository.MainRepository

abstract class BasePresenter() {
    abstract fun getHeroResult(query: String)
}