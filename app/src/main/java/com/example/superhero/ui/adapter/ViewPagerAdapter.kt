package com.example.superhero.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.superhero.ui.fragment.DetailsFragment

class ViewPagerAdapter(container: DetailsFragment, private val fragmentsList: List<Fragment>) :
    FragmentStateAdapter(container) {
    override fun getItemCount() = fragmentsList.size

    override fun createFragment(position: Int) = fragmentsList[position]
}