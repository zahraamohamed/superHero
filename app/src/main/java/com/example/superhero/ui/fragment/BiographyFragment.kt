package com.example.superhero.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.databinding.FragmentBiographyBinding
import com.example.superhero.ui.fragment.BaseFragment


class BiographyFragment  : BaseFragment<FragmentBiographyBinding>() {
    override fun setup() {
    }

    override fun callBack() {
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentBiographyBinding
        get() = TODO("Not yet implemented")


}