package com.example.superhero.ui.activities

import android.util.Log
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.fragment.HomeFragment
import com.iammert.library.ui.multisearchviewlib.MultiSearchView

class HomeActivity : BaseActivity<ActivityHomeBinding>(), IMainView {
 private val presenter= MainPresenter(this)

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override val theme = R.style.Theme_SuperHero

    override fun onLoading() {
        setVisibility(false)
    }

    override fun onError() {
        setVisibility(visible = false, isLoading = false)
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


       }

        binding.apply {
            search.isVisible=!visible
            loading.isVisible = !visible

            if (isLoading){
                search.isVisible=visible
               loading. setAnimation(R.raw.load)


            } else {
               loading. setAnimation(R.raw.error)
                search.isVisible=visible

            }
            loading.playAnimation()
        }
    }

    override fun setup() {
        presenter.getResult(" ")
        searchHeroName()

    }

    override fun callBack() {
    }
    private fun searchHeroName(){

        binding.search.setSearchViewListener(object : MultiSearchView.MultiSearchViewListener{
            override fun onItemSelected(index: Int, s: CharSequence) {
                presenter.getResult(s.toString())
                Log.v("TEST", "onItemSelected: index: $index, query: $s")

            }

            override fun onTextChanged(index: Int, text: CharSequence) {

                Log.v("TEST", "TEXT CHANGED: index: $index, query: $text")

            }

            override fun onSearchComplete(index: Int, s: CharSequence) {
                presenter.getResult(s.toString())

                Log.v("TEST", "complete: index: $index, query: $s")

            }

            override fun onSearchItemRemoved(index: Int) {
                Log.v("TEST", "remove: index: $index")

            }

        })
    }






}