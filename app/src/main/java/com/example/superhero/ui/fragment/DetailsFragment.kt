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
        initShowView()
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
    }
}