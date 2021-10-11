package com.example.superhero.ui

import com.example.superhero.model.responce.SuperheroResponce

// TODO: 10/11/2021 functions in abstractions (interface should have a readable names with meaning) so in
//IMainView onSuccess is ambiguous name success of what
// TODO: 10/11/2021 - IMainView interface name is not clear!!!!
interface IMainView {

    fun onSuccess(data: SuperheroResponce)
    fun setVisibility(visible: Boolean, isLoading: Boolean = true)
    fun onLoading()
    fun onError()
}