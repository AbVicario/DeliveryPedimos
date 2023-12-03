package com.abelgarciavicario.deliverypedimos.navigations

import DeliveryIniciarSesion
import DeliveryLog
import Home
import Restaurante
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelgarciavicario.delivery.verificarcuenta.ui.VerificarCuenta
import com.abelgarciavicario.deliverypedimos.dish.ui.DishViewModel
import com.abelgarciavicario.deliverypedimos.editarperfil.ui.EditarPerfil
import com.abelgarciavicario.deliverypedimos.home.ui.HomeViewModel
import com.abelgarciavicario.deliverypedimos.recuperarcontraseña.ui.RecuperarContraseña
import com.abelgarciavicario.deliverypedimos.registro.ui.components.Registro
import com.abelgarciavicario.deliverypedimos.registro.ui.components.RegistroViewModel
import com.abelgarciavicario.deliverypedimos.restaurante.ui.FoodViewModel
import com.abelgarciavicario.deliverypedimos.signin.ui.SignUpViewModel


@Composable
fun NavigationsHost(
    signUpViewModel: SignUpViewModel, homeViewModel: HomeViewModel,
    registroViewModel: RegistroViewModel, dishViewModel: DishViewModel,
    foodViewModel: FoodViewModel
) {
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

            composable(Destinations.EditarPerfil.route) {
                EditarPerfil()
            }
            composable(Destinations.Restaurante.route) {
                Restaurante(navController,foodViewModel, homeViewModel)
            }
            composable(Destinations.DeliveryIniciarSesion.route){
               DeliveryIniciarSesion(navController,signUpViewModel)
            }
        }

}