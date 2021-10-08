package com.example.superhero.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.model.responce.Result
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailsFragment() : BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        initBottomSheet()
        initShowView()
    }

    private fun initShowView() {
        val heroItem: Result?
        arguments?.let { bundle ->
            heroItem = bundle.getParcelable("keyy")

            binding.apply {
                heroItem?.apply {
                    superHeroName.text = name
                    superHeroFullName.text = biography?.fullName
                    Glide.with(root.context).load(image?.url)
                        .into(superHeroImage)
                }

            }

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