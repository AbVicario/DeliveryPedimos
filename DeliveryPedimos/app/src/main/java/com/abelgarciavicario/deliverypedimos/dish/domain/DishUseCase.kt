package com.abelgarciavicario.deliverypedimos.dish.domain

import com.abelgarciavicario.deliverypedimos.dish.network.DishRepository
import com.abelgarciavicario.deliverypedimos.dish.network.response.DishResponse
import javax.inject.Inject

class DishUseCase @Inject constructor(private val networkRepository: DishRepository) {
    suspend operator fun invoke(url: String): List<DishResponse>{
        return   networkRepository.getDish(url)
    }
}