package com.abelgarciavicario.deliverypedimos.home.data.network



import com.abelgarciavicario.deliverypedimos.home.data.network.response.RestaurantResponse
import javax.inject.Inject

class HomeRepository@Inject constructor(private val api: HomeService){

    suspend fun  getRestaurants() : List<RestaurantResponse> {
       return api.getRestaurants();
    }
}