package com.example.superhero.ui

import com.example.superhero.model.responce.Result
import com.example.superhero.model.responce.SuperheroResponce

// TODO: 10/11/2021 - Why there is a file called TransferData but inside it we have a IHomeListener interface!! 
interface IHomeListener {

  fun onClickItem(data: Result)
}