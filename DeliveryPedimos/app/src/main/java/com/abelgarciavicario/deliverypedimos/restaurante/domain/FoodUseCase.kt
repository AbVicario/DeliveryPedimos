package com.abelgarciavicario.deliverypedimos.restaurante.domain

import com.abelgarciavicario.deliverypedimos.restaurante.data.network.FoodRepository
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import javax.inject.Inject


class FoodUseCase  @Inject
constructor(private val networkRepository: FoodRepository){


    suspend operator fun invoke(url : String): List<FoodResponse> {
        return networkRepository.getFood(url)
    }
}

