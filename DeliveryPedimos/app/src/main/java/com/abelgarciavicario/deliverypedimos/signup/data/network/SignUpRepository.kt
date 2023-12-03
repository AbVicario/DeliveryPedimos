package com.abelgarciavicario.deliverypedimos.signup.data.network

import javax.inject.Inject

class SignUpRepository @Inject constructor(private val api: SignUpService){

    suspend fun doSignUp(email: String, password: String):Boolean {
        return api.doSignUp(email, password)
    }
}