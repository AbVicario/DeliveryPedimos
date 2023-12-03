package com.abelgarciavicario.deliverypedimos.home.domain

import com.abelgarciavicario.deliverypedimos.home.data.network.HomeRepository
import com.abelgarciavicario.deliverypedimos.home.data.network.response.RestaurantResponse
import javax.inject.Inject

class HomeUseCase  @Inject constructor(private val networkRepository: HomeRepository){


    suspend operator fun invoke(): List<RestaurantResponse>
    {
        return networkRepository.getRestaurants()
    }

}