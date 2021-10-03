package com.example.superhero.ui.homeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superhero.R
import com.example.superhero.model.responce.*
import com.example.superhero.ui.homeActivity.InfoSuccess.IMainView

class MainActivity : AppCompatActivity() , IMainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSuperheroResponceInfoSuccess(superheroResponce: SuperheroResponce) {
        TODO("Not yet implemented")
    }

    override fun onAppearanceInfoSuccess(appearance: Appearance) {
        TODO("Not yet implemented")
    }

    override fun onBiographyInfoSuccess(biography: Biography) {
        TODO("Not yet implemented")
    }

    override fun onConnectionsInfoSuccess(connections: Connections) {
        TODO("Not yet implemented")
    }

    override fun onImageInfoSuccess(image: Image) {
        TODO("Not yet implemented")
    }

    override fun onPowerStatsInfoSuccess(powerStats: PowerStats) {
        TODO("Not yet implemented")
    }

    override fun onWorkInfoSuccess(work: Work) {
        TODO("Not yet implemented")
    }
}