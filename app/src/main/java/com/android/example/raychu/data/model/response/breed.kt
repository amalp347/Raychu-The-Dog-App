package com.android.example.raychu.data.model.response


import com.google.gson.annotations.SerializedName

data class breed(
    @SerializedName("bred_for")
    val bredFor: String,
    @SerializedName("breed_group")
    val breedGroup: String,
    @SerializedName("country_code")
    val countryCode: String,
    val description: String,
    val height: Height,
    val history: String,
    val id: Int,
    @SerializedName("life_span")
    val lifeSpan: String,
    val name: String,
    val origin: String,
    val temperament: String,
    val weight: Weight
)