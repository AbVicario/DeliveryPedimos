package com.abelgarciavicario.deliverypedimos.dish.network

import com.abelgarciavicario.deliverypedimos.dish.network.response.DishResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DishService @Inject constructor(private val dishClient: DishClient) {
    suspend fun getDish(url: String):List<DishResponse>{
        return withContext(Dispatchers.IO){
            val response = dishClient.getDish(url)
            response
        }
    }
}