package com.example.superhero.ui.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.ui.ITransferData
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailsFragment(private val data: Result) : BaseFragment<FragmentDetailsBinding>(){

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        initBottomSheet()
        initShowView()
    }

    private fun initShowView() {
        binding.apply {
            superHeroName.text = data.name
            superHeroFullName.text = data.biography?.fullName
            Glide.with(root.context).load(data.image?.url)
                .into(superHeroImage)
        }
    }

    private fun initBottomSheet() {
        BottomSheetBehavior.from(binding.bottomSheetSuperHero).apply {
            peekHeight = 200
            state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun callBack() {
    }
}