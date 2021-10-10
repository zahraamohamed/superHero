package com.example.superhero.ui.fragment

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getColor
import com.bumptech.glide.Glide
import com.example.superhero.R
import com.example.superhero.databinding.FragmentDetailsBinding
import com.example.superhero.model.responce.Result
import com.example.superhero.util.AddDisplayProperties
import com.example.superhero.util.AddHidenProperties
import com.example.superhero.util.Constant

class DetailsFragment: BaseFragment<FragmentDetailsBinding>() {

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    @RequiresApi(Build.VERSION_CODES.M)
    override fun setup() {
        showHeroInDetailsFragment()
        checkCardsAndDisplay()
        }

        private fun showHeroInDetailsFragment() {

        val heroItem: Result?
        arguments?.let { bundle ->
            heroItem = bundle.getParcelable(Constant.RECYCLER_DATA_KEY)
            binding.apply {
                heroItem?.apply {
                    Glide.with(root.context).load(image?.url)
                        .into(heroImage)

                    textValueBirth.text=biography?.placeOfBirth
                    textValueFirstApperance.text=biography?.publisher
                    textValueFullName.text=biography?.fullName
                    textValueName.text=name
                    txtValueWork.text=biography?.alignment

                    height.text= appearance?.height?.get(1).toString()
                    width.text= appearance?.weight?.get(1).toString()
                    textValueGender.text=appearance?.gender

                    progressValuePower.progress= powerstats?.power?.toFloat()!!
                    progressValueSpeed.progress=powerstats?.speed?.toInt()!!
                    progressValueStrength.progress=powerstats?.strength?.toInt()!!

                }
            }
        }
    }

    override fun callBack() {
        binding.btnNext.setOnClickListener {
            hideAllCard()
            checkCardsAndDisplay()
            incrementIfLessThanThree()
        }
    }

    var indexCard = 1
    private fun checkCardsAndDisplay() {
        binding.apply {
            when (indexCard) {
                1 -> {
                    layoutCardBiography.AddDisplayProperties()
                }
                2 -> {
                    layoutCardAppearance.AddDisplayProperties()

                }
                3 -> {
                    layoutCardPowerstats.AddDisplayProperties()
                }
            }
        }
    }

    private fun hideAllCard() {
        binding.apply {
            layoutCardBiography.AddHidenProperties()
            layoutCardAppearance.AddHidenProperties()
            layoutCardPowerstats.AddHidenProperties()
        }
    }

    private fun incrementIfLessThanThree() {
        if (indexCard < 3) indexCard++
        else indexCard = 1
    }

}



