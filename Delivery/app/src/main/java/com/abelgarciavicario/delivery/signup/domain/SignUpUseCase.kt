package com.abelgarciavicario.delivery.signup.domain
import com.abelgarciavicario.delivery.signup.data.network.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val networkRepository: SignUpRepository){


    suspend operator fun invoke(email: String, password: String):Boolean
    {
        return networkRepository.doSignUp(email, password)
    }
}