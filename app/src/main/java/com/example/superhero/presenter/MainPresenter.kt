package com.example.superhero.presenter

import com.example.superhero.model.Status
import com.example.superhero.model.repository.MainRepository
import com.example.superhero.ui.IMainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainPresenter(private val view: IMainView) {
    var repository = MainRepository()
    fun getResult(searchHeroName:String) {
        CoroutineScope(Dispatchers.Main).launch {
            repository.getInfoSuperHero(searchHeroName).collect { response ->
                when (response) {
                    is Status.Success -> view.onSuperheroResponseSuccess(data = response.responseData)
                    is Status.Loading -> view.onLoading()
                    is Status.Error -> view.onError()
            }
        }
    }
}


}