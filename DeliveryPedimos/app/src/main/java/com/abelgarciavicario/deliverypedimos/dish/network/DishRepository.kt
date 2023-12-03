package com.abelgarciavicario.deliverypedimos.dish.network

import com.abelgarciavicario.deliverypedimos.dish.network.response.DishResponse
import javax.inject.Inject

class DishRepository @Inject constructor(private val api: DishService){
    suspend fun getDish(url: String) : List<DishResponse>{
        return  api.getDish(url);
    }
}