package com.abelgarciavicario.delivery.restaurante.data.network

import javax.inject.Inject

class RestauranteRepository@Inject constructor(private val api: RestauranteService){

    suspend fun  doRestaurante(name: String) = api.doRestaurante(name)
}