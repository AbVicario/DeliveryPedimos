package com.abelgarciavicario.deliverypedimos.restaurante.data.network
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FoodService  @Inject constructor(private val foodClient: FoodClient){

    suspend fun getFood(url : String): List<FoodResponse>{
        return withContext(Dispatchers.IO){
            val response = foodClient.getFood(url)
            response
        }
    }
}