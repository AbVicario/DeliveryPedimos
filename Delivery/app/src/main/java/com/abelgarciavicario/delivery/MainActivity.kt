package com.abelgarciavicario.delivery

import Restaurante
import Home
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.abelgarciavicario.delivery.home.ui.HomeViewModel
import com.abelgarciavicario.delivery.navigations.Destinations
import com.abelgarciavicario.delivery.navigations.NavigationsHost
import com.abelgarciavicario.delivery.registro.ui.components.RegistroViewModel
import com.abelgarciavicario.delivery.signin.ui.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signUpViewModel:SignUpViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private val registroViewModel: RegistroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
           NavigationsHost(signUpViewModel,homeViewModel,registroViewModel)
  //         DeliveryLog()
//     DeliveryIniciarSesion()
//       Registro()
//       RecuperarContraseña()
//       VerificarCuenta()
//       NuevaContraseña()
//       ContraseñaModificada()
//       EditarPerfil()
 //      Home()
 //          Restaurante()

       }
    }
}

