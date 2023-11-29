package com.abelgarciavicario.delivery.signin.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.abelgarciavicario.delivery.domain.Restaurant
import com.abelgarciavicario.delivery.home.data.network.HomeClient
import com.abelgarciavicario.delivery.home.domain.HomeUseCase
import com.abelgarciavicario.delivery.navigations.Destinations
import com.abelgarciavicario.delivery.signup.domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase,
    private val homeUseCase: HomeUseCase):ViewModel(){
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password
    private val _isLogEnable = MutableLiveData<Boolean>()
    val isLogEnable: LiveData<Boolean> = _isLogEnable
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLogEnable

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun onLoginChange(email: String, password: String){
        _email.value=email
        _password.value=password
        _isLogEnable.value=enableLog(email,password)

    }
    fun clearErrorMessage() {
        _errorMessage.value = null
    }

    private fun enableLog(user: String, password: String)=
        password.length>6 && user.length>2

    fun onLoginSelected(navController: NavController){

        viewModelScope.launch {
            _isLoading.value=true
            val result = signUpUseCase(email.value!!, password.value!!)

            if(result){
                navController.navigate(Destinations.Home.route)
            }else{
                _errorMessage.value = "Error en el inicio de sesión"
            }


        }
        _isLoading.value=false
    }



}