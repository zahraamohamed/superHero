package com.example.superhero.util

import android.view.View
import androidx.core.view.isVisible

// TODO: 10/11/2021 In ExtensionFun file your file is related to fun do we have a party?
//- In ExtensionFun file your function start with an upperCase characters ( (خوب كول لعمو بوب موت احسن
//- In ExtensionFun file changing the visibility will not add any thing to the view so why you are
//using add in the name of function

fun View.AddHidenProperties(){
    this.isVisible = false
}

fun View.AddDisplayProperties(){
    this.isVisible = true
}
