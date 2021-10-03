package com.example.superhero.ui.homeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superhero.R
import com.example.superhero.model.responce.*
import com.example.superhero.ui.IMainView

class MainActivity : AppCompatActivity() , IMainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSuperheroResponseSuccess(superheroResponse: SuperHeroResponce) {
        TODO("Not yet implemented")
    }

    override fun bindData(data: SuperHeroResponce) {
        TODO("Not yet implemented")
    }

    override fun hideAllViews() {
        TODO("Not yet implemented")
    }


}