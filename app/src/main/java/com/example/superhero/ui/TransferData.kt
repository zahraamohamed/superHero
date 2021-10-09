package com.example.superhero.ui

import com.example.superhero.model.responce.Result
import com.example.superhero.model.responce.SuperheroResponce

interface IHomeListener {

  fun onClickItem(data: Result)
}