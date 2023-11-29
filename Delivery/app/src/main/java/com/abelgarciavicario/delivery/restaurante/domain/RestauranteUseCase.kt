package com.abelgarciavicario.delivery.restaurante.domain


import com.abelgarciavicario.delivery.restaurante.data.network.RestauranteRepository
import javax.inject.Inject

class RestauranteUdseCase  @Inject
constructor(private val networkRepository: RestauranteRepository){


    suspend operator fun invoke(name:String)
    {
        return networkRepository.doRestaurante(name)
    }
}