package com.abelgarciavicario.deliverypedimos.restaurante.data.network.data

data class FoodDTO(val name: String, val ingredients: List<String>,
                   val allergens: List<String>, val cover_url: String)
