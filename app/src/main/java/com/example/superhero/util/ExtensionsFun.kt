package com.example.superhero.util

import android.view.View
import androidx.core.view.isVisible


fun View.AddHidenProperties(){
    this.isVisible = false
}

fun View.AddDisplayProperties(){
    this.isVisible = true
}
