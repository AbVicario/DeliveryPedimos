package com.abelgarciavicario.deliverypedimos.signup.domain

import com.abelgarciavicario.deliverypedimos.signup.data.network.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val networkRepository: SignUpRepository){


    suspend operator fun invoke(email: String, password: String):Boolean
    {
        return networkRepository.doSignUp(email, password)
    }
}