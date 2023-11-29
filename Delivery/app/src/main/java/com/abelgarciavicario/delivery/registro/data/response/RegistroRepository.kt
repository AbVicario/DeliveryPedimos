package com.abelgarciavicario.delivery.registro.data.response

import javax.inject.Inject

class RegistroRepository @Inject constructor(private val api: RegistroService) {
    suspend fun doRegistro(nombre: String, email: String, password: String):Boolean {
        return api.doRegistro(nombre, email, password)
    }
}