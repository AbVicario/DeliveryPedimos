package com.abelgarciavicario.delivery.registro.domain

import com.abelgarciavicario.delivery.registro.data.response.RegistroRepository
import com.abelgarciavicario.delivery.signup.data.network.SignUpRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val networkRepository: RegistroRepository){


    suspend operator fun invoke(nombre: String, email: String, password: String):Boolean
    {
        return networkRepository.doRegistro(nombre, email, password)
    }
}