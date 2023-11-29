package com.abelgarciavicario.delivery.home.data.network

import com.abelgarciavicario.delivery.domain.Restaurant
import com.abelgarciavicario.delivery.home.data.network.response.RestaurantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class HomeService @Inject constructor(private val homeClient: HomeClient){

   suspend fun getRestaurants():List<RestaurantResponse> {
        return withContext(Dispatchers.IO){
            val response = homeClient.getRestaurants()
            response
        }
    }
}