package com.abelgarciavicario.deliverypedimos.registro.domain


import com.abelgarciavicario.deliverypedimos.registro.data.response.RegistroRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val networkRepository: RegistroRepository){


    suspend operator fun invoke(nombre: String, email: String, password: String):Boolean
    {
        return networkRepository.doRegistro(nombre, email, password)
    }
}