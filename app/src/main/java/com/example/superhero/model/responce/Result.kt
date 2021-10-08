package com.example.superhero.model.responce


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
class Result(
    @SerializedName("appearance")
    val appearance: Appearance?,
    @SerializedName("biography")
    val biography: Biography?,
    @SerializedName("connections")
    val connections: Connections?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: Image?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("powerstats")
    val powerstats: Powerstats?,
    @SerializedName("work")
    val work: Work?
):Parcelable {
    override fun describeContents(): Int = 0

    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}