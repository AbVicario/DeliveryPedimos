package com.abelgarciavicario.delivery.home.domain
import com.abelgarciavicario.delivery.domain.Restaurant
import com.abelgarciavicario.delivery.home.data.network.HomeRepository
import com.abelgarciavicario.delivery.home.data.network.response.RestaurantResponse
import retrofit2.Response
import javax.inject.Inject

class HomeUseCase  @Inject constructor(private val networkRepository: HomeRepository){


    suspend operator fun invoke(): List<RestaurantResponse>
    {
        return networkRepository.getRestaurants()
    }

}