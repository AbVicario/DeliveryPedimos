package com.abelgarciavicario.delivery.signin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class deliveryLogViewModel: ViewModel() {
    //private val signInUseCase = SignUpUseCase()

    fun onSignInButtonCliked(){
        viewModelScope.launch {
            //val result = signInUseCase()
        }
    }
}