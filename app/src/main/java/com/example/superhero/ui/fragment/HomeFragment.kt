package com.example.superhero.ui.fragment

import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superhero.R
import com.example.superhero.databinding.FragmentHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.adapter.HeroAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    fun onSuperheroResponseSuccess(data: SuperheroResponce) {
        binding.apply {
            data.results?.let { result ->
                heroRecyclerView.adapter = HeroAdapter(result)
            }
        }
    }

    override fun setup() {
        initRecyclerView()
    }


    private fun initRecyclerView() {
        binding.apply {
            heroRecyclerView.layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun callBack() {
        // just for try
        binding.test.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, DetailsFragment())
                addToBackStack(null)
            }.commit()
        }}
    }

}