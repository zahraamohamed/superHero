package com.example.superhero.presenter

import com.example.superhero.model.Status
import com.example.superhero.model.repository.MainRepository
import com.example.superhero.ui.IMainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainPresenter(private val view: IMainView) {

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