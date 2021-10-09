package com.example.superhero.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.R
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.ui.adapter.ViewPagerAdapter

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        initBottomSheet()
    }

    override fun callBack() {  }

    private fun initBottomSheet() {
//        BottomSheetBehavior.from(binding.bottomSheetSuperHero).apply {
//            peekHeight = 200
//            state = BottomSheetBehavior.STATE_EXPANDED
//        }
    }

//    private fun initViewPager() {
//        val fragmentsList = listOf(
//            HomeFragment(),
//            TodoFragment(this, this),
//            InProgressFragment(this, this),
//            DoneFragment(this, this)
//        )
//        val adapter = ViewPagerAdapter(this, fragmentsList = fragmentsList)
//        binding.viewPager.adapter = adapter
//    }

}