package com.example.superhero.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.databinding.FragmentDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        initBottomSheet()
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