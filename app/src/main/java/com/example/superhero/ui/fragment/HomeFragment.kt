package com.example.superhero.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.databinding.FragmentHomeBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IHomeListener
import com.example.superhero.ui.adapter.HeroAdapter
import com.example.superhero.ui.adapter.SliderTransformer
import com.iammert.library.ui.multisearchviewlib.MultiSearchView

class HomeFragment : BaseFragment<FragmentHomeBinding>(), IHomeListener {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate


    fun onSuperheroResponseSuccess(data: SuperheroResponce) {
        binding.apply {
            data.results?.let { result ->
                superHeroes.adapter = HeroAdapter(result, this@HomeFragment)
            }
        }
    }

    override fun setup() {
        initRecyclerView()
    }

    @SuppressLint("ResourceType")
    private fun initRecyclerView() {
        binding.apply {
            superHeroes.offscreenPageLimit = 2
            superHeroes.setPageTransformer(SliderTransformer(3))
        }
    }

    override fun callBack() {
    }

    override fun onClickItem(data: Result) {
        val detailsFragment = DetailsFragment()
        detailsFragment.arguments = Bundle().apply {
            putParcelable("keyy",data)
        }
        addFragment(detailsFragment)
    }



}