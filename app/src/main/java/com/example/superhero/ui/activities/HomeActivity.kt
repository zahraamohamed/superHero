package com.example.superhero.ui.activities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.adapter.HeroAdapter
import com.example.superhero.ui.adapter.SliderTransformer


class HomeActivity : BaseActivity<ActivityHomeBinding>(), IMainView {

    private val presenter = MainPresenter(this)

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    override val theme: Int
        get() = R.style.Theme_SuperHero

    override fun setup() {
        initRecyclerView()
        initPresenter()
    }

    override fun callBack() {

    }

    private fun initPresenter() {
        presenter.getResult("a")
    }

    @SuppressLint("ResourceType")
    private fun initRecyclerView() {
        binding.apply {
            superHeroes.offscreenPageLimit = 2
            superHeroes.setPageTransformer(SliderTransformer(3))
        }
    }

    override fun onSuperheroResponseSuccess(data: SuperheroResponce) {
        binding.apply {
            data.results?.let { result ->
                superHeroes.adapter = HeroAdapter(result)
            }
        }
    }

    override fun hideAllViews() {  }

}