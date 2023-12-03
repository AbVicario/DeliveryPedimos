package com.abelgarciavicario.deliverypedimos.domain

data class Food(val id: Int, val name: String, val ingredients: List<String>,
                val allergens: List<String>, val cover_url: String)
