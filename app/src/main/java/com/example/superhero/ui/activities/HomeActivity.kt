package com.example.superhero.ui.activities

import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.TransferData
import com.example.superhero.ui.fragment.DetailsFragment
import com.example.superhero.ui.fragment.HomeFragment

class HomeActivity : BaseActivity<ActivityHomeBinding>(), IMainView {
 private val presenter= MainPresenter(this)


    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override val theme = R.style.Theme_SuperHero

    override fun onLoading() {
        setVisibility(false)
    }

    override fun onError() {
        setVisibility(false)
    }


    override fun bindData(data: SuperheroResponce) {
        setVisibility(true)

        supportFragmentManager.findFragmentById(R.id.fragment_container)?.apply {
            this as HomeFragment
            onSuperheroResponseSuccess(data)
        }
    }

    override fun setVisibility(visible: Boolean, isLoading: Boolean) {
      binding.fragmentContainer.isVisible = visible
       binding.loading.apply {
           isVisible = !visible
           if (isLoading){
               setAnimation(R.raw.loading)
           } else {
               setAnimation(R.raw.loading)
           }
           playAnimation()
       }
    }

    override fun setup() {
        presenter.getResult(" ")

    }

    override fun callBack() {
        binding.test.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, DetailsFragment())
                addToBackStack(null)
            }.commit()
        }
    }




}