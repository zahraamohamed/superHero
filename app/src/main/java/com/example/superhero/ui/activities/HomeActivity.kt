package com.example.superhero.ui.activities

import android.view.LayoutInflater
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.ui.IMainView

class HomeActivity :BaseActivity<ActivityHomeBinding>() ,IMainView{

    override fun onSuperheroResponseSuccess(superheroResponse: SuperheroResponce) {
        TODO("Not yet implemented")
    }

    override fun bindData(data: SuperheroResponce) {
        TODO("Not yet implemented")
    }

    override fun hideAllViews() {
        TODO("Not yet implemented")
    }

    override val theme: Int
        get() = TODO("Not yet implemented")

    override fun setup() {
        TODO("Not yet implemented")
    }

    override fun callBack() {
        TODO("Not yet implemented")
    }

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = TODO("Not yet implemented")


}