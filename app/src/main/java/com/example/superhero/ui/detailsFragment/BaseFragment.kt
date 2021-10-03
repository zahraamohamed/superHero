package com.example.superhero.ui.detailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

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
        setup()
        callBack()
        _binding = inflate(inflater, container, false)
        return _binding.root
    }
}