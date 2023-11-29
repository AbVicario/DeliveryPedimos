package com.abelgarciavicario.delivery.restaurante.data.network.response

import com.google.gson.annotations.SerializedName

data class DishResponse(
   @SerializedName("name") val name: String,
   @SerializedName("category") val category: String,
   @SerializedName("ingredients") val ingredients: String,
   @SerializedName("allergens") val allergens: String
)
