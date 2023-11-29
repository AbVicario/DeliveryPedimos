package com.abelgarciavicario.delivery.restaurante.data.network

import com.abelgarciavicario.delivery.signup.data.network.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestauranteClient {
    @GET("/v3/cd51b18b-1c89-46df-9425-54651f2f364e")
    suspend fun doRestaurante(): Response<UserResponse>
}