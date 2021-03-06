package com.example.superhero.ui.activities

import android.os.Build
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.example.superhero.R
import com.example.superhero.databinding.ActivityHomeBinding
import com.example.superhero.model.responce.SuperheroResponce
import com.example.superhero.presenter.MainPresenter
import com.example.superhero.ui.IMainView
import com.example.superhero.ui.fragment.HomeFragment
import com.iammert.library.ui.multisearchviewlib.MultiSearchView

class HomeActivity : BaseActivity<ActivityHomeBinding>(), IMainView {

    override val theme = R.style.Theme_SuperHero

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    private val presenter = MainPresenter(this)


    override fun onLoading() {
        setVisibility(false)
    }

    override fun onError() {
        setVisibility(visible = false, isLoading = false)
    }

    override fun onSuccess(data: SuperheroResponce) {
        setVisibility(true)
        supportFragmentManager.findFragmentById(R.id.fragment_container)?.apply {
            this as HomeFragment
            onSuperheroResponseSuccess(data)
        }
    }

    override fun setVisibility(visible: Boolean, isLoading: Boolean) {

        binding.fragmentContainer.isVisible = visible
        binding.search.isVisible=!visible
        binding.apply {
            search.isVisible = !visible
            loading.isVisible = !visible

            if (isLoading) {
                search.isVisible = visible
                loading.setAnimation(R.raw.load)

            } else {
                search.isVisible = visible
                loading.setAnimation(R.raw.error)
            }
            loading.playAnimation()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun setup() {
        presenter.getHeroResult(" ")
        searchHeroName()

        //set status bar color transparent
            window.statusBarColor = getColor(android.R.color.transparent)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.setDecorFitsSystemWindows(false)
            } else {
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )

            }
    }

    override fun callBack() {}

    private fun searchHeroName() {

        binding.search.setSearchViewListener(object : MultiSearchView.MultiSearchViewListener {
            override fun onItemSelected(index: Int, s: CharSequence) {
                presenter.getHeroResult(s.toString())
            }

            override fun onTextChanged(index: Int, text: CharSequence) {

            }

            override fun onSearchComplete(index: Int, s: CharSequence) {
                presenter.getHeroResult(s.toString())
            }
            override fun onSearchItemRemoved(index: Int) {
            }
        })
    }
}