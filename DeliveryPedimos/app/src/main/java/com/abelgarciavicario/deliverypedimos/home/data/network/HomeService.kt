package com.abelgarciavicario.deliverypedimos.home.data.network


import com.abelgarciavicario.deliverypedimos.home.data.network.response.RestaurantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeService @Inject constructor(private val homeClient: HomeClient){

   suspend fun getRestaurants():List<RestaurantResponse> {
        return withContext(Dispatchers.IO){
            val response = homeClient.getRestaurants()
            response
        }
   }
}