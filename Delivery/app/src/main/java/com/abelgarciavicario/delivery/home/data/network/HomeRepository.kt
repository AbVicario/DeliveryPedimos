package com.abelgarciavicario.delivery.home.data.network

import com.abelgarciavicario.delivery.domain.Restaurant
import com.abelgarciavicario.delivery.home.data.network.response.RestaurantResponse
import retrofit2.Response
import javax.inject.Inject

class HomeRepository@Inject constructor(private val api: HomeService){

    suspend fun  getRestaurants() : List<RestaurantResponse> {
       return api.getRestaurants();
    }
}