package com.abelgarciavicario.delivery.restaurante.data.network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestauranteService  @Inject constructor(private val restauranteClient: RestauranteClient){
    //=  RetrofitHelper.getRetrofit()

    suspend fun doRestaurante(name: String){
        return withContext(Dispatchers.IO){
            val response = restauranteClient.doRestaurante()

            //response.body()?.name == name
        }
    }
}