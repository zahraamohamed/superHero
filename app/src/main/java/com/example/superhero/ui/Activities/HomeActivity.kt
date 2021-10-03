package com.example.superhero.ui.Activities

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding

class HomeActivity() :BaseActivity<ActivityHomeBinding>() {


    override val LOG_TAG: String = "Main_Activity"
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
            = ActivityHomeBinding::inflate

    override fun setUp() {

    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit()
    }


}