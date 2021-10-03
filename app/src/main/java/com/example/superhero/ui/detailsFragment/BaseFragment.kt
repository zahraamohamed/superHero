package com.example.superhero.ui.detailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.superhero.R
import com.example.superhero.ui.BaseInterface

abstract class BaseFragment<VB: ViewBinding> : Fragment() , BaseInterface<VB> {

        override var _binding: ViewBinding? = null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            setUp()
            addCallbacks()
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle? ): View? {
            _binding = bindingInflater(layoutInflater)
            return _binding?.root
        }

        abstract fun addCallbacks()

        fun addFragment(fragment: Fragment){
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

}