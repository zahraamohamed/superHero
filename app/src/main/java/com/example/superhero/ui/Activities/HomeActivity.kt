package com.example.superhero.ui.Activities

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.ui.IMainView

class HomeActivity() :BaseActivity<ActivityHomeBinding>() ,IMainView{


    override val LOG_TAG: String = "Main_Activity"
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
            = ActivityHomeBinding::inflate

    override fun setUp() {

    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit()
    }

    override fun onSuperheroResponseSuccess(superheroResponse: SuperheroResponce) {
        TODO("Not yet implemented")
    }

    override fun bindData(data: SuperheroResponce) {
        TODO("Not yet implemented")
    }

    override fun hideAllViews() {
        TODO("Not yet implemented")
    }


}