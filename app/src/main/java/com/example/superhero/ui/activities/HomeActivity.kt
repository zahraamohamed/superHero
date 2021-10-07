package com.example.superhero.ui.activities

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.adapter.HeroAdapter

class HomeActivity : BaseActivity<ActivityHomeBinding>(), IMainView {
    private val presenter = MainPresenter(this)


    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override val theme = R.style.Theme_SuperHero

    override fun onLoading() {
        setVisibility(false)


    }

    override fun onError() {
        setVisibility(false)

    }

    override fun onSuperheroResponseSuccess(data: SuperheroResponce) {
        setVisibility(true)
        binding.apply {
            data.results?.let { result ->
                heroRecyclerView.adapter = HeroAdapter(result)
            }
        }
    }

    override fun setVisibility(visible: Boolean, isLoading: Boolean) {
        binding.rootLayout.children.forEach { view ->
            view.isVisible = visible
        }
       binding.loading.apply {
           isVisible = !visible
           if (isLoading){
               setAnimation(R.raw.loading)
           }else {
               setAnimation(R.raw.loading)
           }
           playAnimation()

       }



    }

    override fun setup() {
        initPresenter()
        initRecyclerView()
    }

    private fun initPresenter() {
        presenter.getResult("a")
    }

    private fun initRecyclerView() {
        binding.apply {
            heroRecyclerView.layoutManager = GridLayoutManager(this@HomeActivity, 2)
        }
    }

    override fun callBack() {
    }




}