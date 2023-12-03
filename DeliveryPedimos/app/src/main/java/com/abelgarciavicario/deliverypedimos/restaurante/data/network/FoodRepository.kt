package com.abelgarciavicario.deliverypedimos.restaurante.data.network

import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import javax.inject.Inject

class FoodRepository@Inject constructor(private val api: FoodService){

    suspend fun  getFood(url : String): List<FoodResponse> {
        return api.getFood(url)
    }
}