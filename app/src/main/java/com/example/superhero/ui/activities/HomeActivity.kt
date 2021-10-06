package com.example.superhero.ui.activities

import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.adapter.HeroAdapter

class HomeActivity :BaseActivity<ActivityHomeBinding>() ,IMainView{
    private val presenter = MainPresenter(this)

    override fun onSuperheroResponseSuccess(data: SuperheroResponce) {
        val adapter = HeroAdapter(data)
        binding.apply {
            heroRecyclerView.adapter = adapter
        }
    }



    override fun hideAllViews() {
        TODO("Not yet implemented")
    }

    override val theme: Int
        get() = TODO("Not yet implemented")

    override fun setup() {
        initPresenter()
        initRecyclerView()
    }

    private fun initPresenter() {
        presenter.getResult("a")
    }

    private fun initRecyclerView() {
        binding.apply {
            heroRecyclerView.layoutManager = GridLayoutManager(this@HomeActivity,2)
        }
    }


    override fun callBack() {
        TODO("Not yet implemented")
    }

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = TODO("Not yet implemented")
}