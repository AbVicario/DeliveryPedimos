package com.abelgarciavicario.deliverypedimos.dish.network.response

import com.google.gson.annotations.SerializedName

class DishResponse (
    @SerializedName("id_restaurant") val id_restaurant: Int,
    @SerializedName("id_food") val id_food: String,
)
