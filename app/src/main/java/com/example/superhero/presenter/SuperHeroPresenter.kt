package com.example.superhero.presenter

import com.example.superhero.model.repository.MainRepository
import com.example.superhero.ui.BasePresenter
import com.example.superhero.ui.IMainActivityView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class SuperHeroPresenter(private val view: IMainActivityView):BasePresenter() {
    private var repository = MainRepository()
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
   override fun getHeroResult(query: String) {
        coroutineScope.launch {
            repository.getHeroData(query).catch {
                view.onError()
            }.collect { response ->
                view.onDataCollected(response)
            }
        }
    }


}