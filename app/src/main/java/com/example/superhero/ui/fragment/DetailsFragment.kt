package com.example.superhero.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.util.Constant

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        showHeroInDetailsFragment()
    }

    private fun showHeroInDetailsFragment() {

        val heroItem: Result?
        arguments?.let { bundle ->
            heroItem = bundle.getParcelable(Constant.RECYCLER_DATA_KEY)
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