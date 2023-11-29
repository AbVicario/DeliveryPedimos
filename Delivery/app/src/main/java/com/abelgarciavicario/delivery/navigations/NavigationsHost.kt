package com.abelgarciavicario.delivery.navigations

import DeliveryIniciarSesion
import DeliveryLog
import Home
import Restaurante
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelgarciavicario.delivery.editarperfil.ui.EditarPerfil
import com.abelgarciavicario.delivery.home.ui.HomeViewModel
import com.abelgarciavicario.delivery.recuperarcontraseña.ui.RecuperarContraseña
import com.abelgarciavicario.delivery.registro.ui.components.Registro
import com.abelgarciavicario.delivery.registro.ui.components.RegistroViewModel
import com.abelgarciavicario.delivery.signin.ui.SignUpViewModel
import com.abelgarciavicario.delivery.verificarcuenta.ui.VerificarCuenta


@Composable
fun NavigationsHost(signUpViewModel:SignUpViewModel,homeViewModel:HomeViewModel,
                    registroViewModel:RegistroViewModel) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Destinations.DeliveryLog.route
        ) {
            composable(Destinations.DeliveryLog.route) {
                DeliveryLog(navController)
            }
            composable(Destinations.Home.route) {
                Home(navController, homeViewModel)
            }
            composable(Destinations.Registro.route) {
                Registro(navController, registroViewModel)
            }
            composable(Destinations.RecuperarContraseña.route) {
                RecuperarContraseña()
            }
            composable(Destinations.VerificarCuenta.route) {
                VerificarCuenta()
            }
            composable(Destinations.VerificarCuenta.route) {
                VerificarCuenta()
            }
            composable(Destinations.EditarPerfil.route) {
                EditarPerfil()
            }
            composable(Destinations.Restaurante.route) {
                Restaurante(navController)
            }
            composable(Destinations.DeliveryIniciarSesion.route){
               DeliveryIniciarSesion(navController,signUpViewModel)
            }
        }

}