package com.example.superhero.ui.detailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superhero.R
import com.example.superhero.databinding.FragmentDetailsBinding


class DetailsFragment  : BaseFragment<FragmentDetailsBinding>() {

    override val LOG_TAG: String = "Details_Fragment"
    override val bindingInflater: (LayoutInflater) ->
    FragmentDetailsBinding = FragmentDetailsBinding::inflate

    override fun addCallbacks() {}
    override fun setUp() {}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }


}