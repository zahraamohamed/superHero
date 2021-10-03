package com.example.superhero.ui.homeActivity.InfoSuccess

import com.example.superhero.model.responce.*

interface IMainView {

    fun onSuperheroResponceInfoSuccess(superheroResponce: SuperheroResponce)
    fun onAppearanceInfoSuccess(appearance: Appearance)
    fun onBiographyInfoSuccess(biography: Biography)
    fun onConnectionsInfoSuccess(connections: Connections)
    fun onImageInfoSuccess(image: Image)
    fun onPowerStatsInfoSuccess(powerStats: PowerStats)
    fun onWorkInfoSuccess(work: Work)


}