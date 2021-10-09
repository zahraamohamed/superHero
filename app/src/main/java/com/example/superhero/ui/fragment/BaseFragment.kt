package com.example.superhero.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.superhero.R

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private lateinit var _binding: VB
    protected val binding get() = _binding
    abstract fun setup()
    abstract fun callBack()
    abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        setup()
        callBack()
        return _binding.root
    }

    fun addFragment(fragment: Fragment) {
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

}