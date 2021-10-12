package com.example.superhero.presenter

import com.example.superhero.model.Status
import com.example.superhero.model.repository.MainRepository
import com.example.superhero.ui.IMainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// TODO: 10/11/2021 we are wrapping our request with a state object to have a single source of truth. then why you
//are unwrap the response state in SuperHeroPresenter and send everything to different functions in UI
//layer. 

// TODO: 10/11/2021 - you need to add base presenter and make all presenters extend it 

class SuperHeroPresenter(private val view: IMainView) {
    private var repository = MainRepository()
    private var coroutineScope = CoroutineScope(Dispatchers.IO)
    fun getHeroResult(query: String) {
        coroutineScope.launch {
            repository.getHeroData(query).catch {
                view.onError()
            }.collect { response ->
                when (response) {
                    is Status.Success -> view.onSuccess(data = response.responseData)
                    is Status.Loading -> view.onLoading()
                }
            }
        }
    }


}