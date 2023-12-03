package com.abelgarciavicario.deliverypedimos.restaurante.data.network.response

import com.google.gson.annotations.SerializedName

class FoodResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("allergens") val allergens: List<String>,
    @SerializedName("cover_url") val cover_url: String,
)
