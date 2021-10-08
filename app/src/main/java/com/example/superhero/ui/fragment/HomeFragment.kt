package com.example.superhero.ui.fragment

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.R
import com.example.superhero.databinding.FragmentHomeBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.ui.ITransferData
import com.example.superhero.ui.adapter.HeroAdapter
import com.example.superhero.ui.adapter.SliderTransformer

class HomeFragment : BaseFragment<FragmentHomeBinding>(), ITransferData {

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
//        binding.test.setOnClickListener {
//            activity?.let {
//                it.supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_container, DetailsFragment())
//                addToBackStack(null)
//            }.commit()
//            }
//        }

    }

    override fun transferData(data: Result) {
//        Log.i("Karrar_j_d", data.toString())
        addFragment(DetailsFragment(data))
    }
}