package com.example.superhero.ui.fragment


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superhero.databinding.FragmentSearchBinding
import com.iammert.library.ui.multisearchviewlib.MultiSearchView

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding ::inflate

    override fun setup() {
        searchForHero()
    }

    private fun searchForHero() {
        binding.multiSearchView.setSearchViewListener(object : MultiSearchView.MultiSearchViewListener{
            override fun onItemSelected(index: Int, s: CharSequence) {
                Log.v("TEST", "onItemSelected: index: $index, query: $s")

            }

            override fun onTextChanged(index: Int, s: CharSequence) {
                Log.v("TEST", "changed: index: $index, query: $s")

            }

            override fun onSearchComplete(index: Int, s: CharSequence) {
                Log.v("TEST", "complete: index: $index, query: $s")

            }

            override fun onSearchItemRemoved(index: Int) {
                Log.v("TEST", "remove: index: $index")

            }

        })
    }

    override fun callBack() {
        TODO("Not yet implemented")
    }




}