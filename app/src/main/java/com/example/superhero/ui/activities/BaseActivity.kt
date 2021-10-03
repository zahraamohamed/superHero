package com.example.superhero.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private lateinit var _binding: VB
    abstract val theme: Int
    abstract fun setup()
    abstract fun callBack()
    abstract val inflate: (LayoutInflater) -> VB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflate(layoutInflater)
        setTheme(theme)
        setContentView(_binding.root)
        setup()
        callBack()
    }
}