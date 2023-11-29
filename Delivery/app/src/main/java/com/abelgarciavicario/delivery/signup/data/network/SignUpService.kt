package com.abelgarciavicario.delivery.signup.data.network

import com.abelgarciavicario.delivery.signup.data.network.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpService @Inject constructor( private val signUpClient: SignUpClient){


    suspend fun doSignUp(email: String, password: String):Boolean{
        return withContext(Dispatchers.IO) {
            val response = signUpClient.doSignUp(UserDTO(email, password))
            response.code()==200


        }
    }
}