package com.example.superhero.ui.fragment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.util.AddDisplayProperties
import com.example.superhero.util.AddHidenProperties


class DetailsFragment() : BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        initShowView()
        checkCardsAndDisplay()
    }

    private fun initShowView() {
        val heroItem: Result?
        arguments?.let { bundle ->
            heroItem = bundle.getParcelable("keyy")
            binding.apply {
                heroItem?.apply {
                    Glide.with(root.context).load(image?.url)
                        .into(heroImage)
                }
            }
        }
    }

    override fun callBack() {
        binding.btnNext.setOnClickListener {
            hidenAllCard()
            checkCardsAndDisplay()
            incrementIfLessThanThree()
        }

    }

    var indexCard = 1
    fun checkCardsAndDisplay(){
        binding.apply {
            when(indexCard){
                1 -> {
                    layoutCardBiography.AddDisplayProperties()
                }
                2 -> {
                    layoutCardAppearance.AddDisplayProperties()

                }
                3 -> {
                    layoutCardPowerstats.AddDisplayProperties()
                }
            }
        }
    }

    fun hidenAllCard(){
       binding.apply {
           layoutCardBiography.AddHidenProperties()
           layoutCardAppearance.AddHidenProperties()
           layoutCardPowerstats.AddHidenProperties()
       }
    }

    fun incrementIfLessThanThree(){
        if(indexCard < 3) indexCard++
        else indexCard = 1
    }

}



