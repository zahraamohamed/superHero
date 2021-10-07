package com.example.superhero.ui.fragment.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superhero.R
import com.example.superhero.databinding.FragmentBiographyBinding
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.ui.fragment.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialog


class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {
        override fun setup() {
            showDetailsBottomSheet()
        }

    private fun showDetailsBottomSheet() {
        binding.showBottomSheetButton.setOnClickListener {

            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        }
    }

    override fun callBack() {
            TODO("Not yet implemented")
        }

        override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
            get() = TODO("Not yet implemented")


    }