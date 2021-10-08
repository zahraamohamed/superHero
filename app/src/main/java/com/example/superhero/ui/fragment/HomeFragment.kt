package com.example.superhero.ui.fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.R
import com.example.superhero.databinding.FragmentHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.ui.TransferData
import com.example.superhero.ui.adapter.HeroAdapter
import com.example.superhero.ui.adapter.SliderTransformer

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    fun onSuperheroResponseSuccess(data: SuperheroResponce) {
        binding.apply {
            data.results?.let { result ->
                superHeroes.adapter = HeroAdapter(result)

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
//        binding.test.setOnClickListener {
//            activity?.let {
//                it.supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_container, DetailsFragment())
//                addToBackStack(null)
//            }.commit()
//            }
//        }
        addFragment(DetailsFragment())
    }
}