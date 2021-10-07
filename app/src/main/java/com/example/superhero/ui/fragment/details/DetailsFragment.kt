package com.example.superhero.ui.fragment.details

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.ui.fragment.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
    override fun setup() {
        initBottomSheet()
    }

    private fun initBottomSheet() {
        BottomSheetBehavior.from(binding.bottomSheetSuperHero).apply {
            peekHeight = 200
            state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    override fun callBack() {
        TODO("Not yet implemented")
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = TODO("Not yet implemented")

}