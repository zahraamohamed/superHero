package com.example.superhero.presenter

import com.example.superhero.model.Status
import com.example.superhero.model.repository.MainRepository
import com.example.superhero.ui.IMainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


// TODO: 10/11/2021 your coroutineScope is used directly without any reference, so if we have another function in
//presenter we couldn’t use same scope, it’s better to declare it inside your presenter.

// TODO: 10/11/2021 custom scope use main dispatcher and that mean all of your request will run on MainThread,
//coroutines is suspend and resume functions so if you make a request on main thread you will
//not notice a UI lag unless there is a big response need to be parsed from json to objects, this
//will drop some frames


// TODO: 10/11/2021 we are wrapping our request with a state object to have a single source of truth. then why you
//are unwrap the response state in SuperHeroPresenter and send everything to different functions in UI
//layer. 

// TODO: 10/11/2021 - you need to add base presenter and make all presenters extend it 

class SuperHeroPresenter(private val view: IMainView) {
    var repository = MainRepository()
    fun getHeroResult(query: String) {
        CoroutineScope(Dispatchers.Main).launch {
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