package com.abelgarciavicario.deliverypedimos.registro.data.response


import com.abelgarciavicario.deliverypedimos.registro.data.dto.UserRDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegistroService @Inject constructor(private val registroClient: RegistroClient){


    suspend fun doRegistro(nombre: String, email: String, password: String):Boolean{
        return withContext(Dispatchers.IO) {
            val response = registroClient.doRegistro(UserRDTO(nombre,email, password))
            response.code()==200

        }
    }
}