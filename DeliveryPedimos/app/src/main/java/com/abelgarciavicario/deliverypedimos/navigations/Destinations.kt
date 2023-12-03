package com.abelgarciavicario.deliverypedimos.navigations

sealed class Destinations(
    val route: String
){
    object DeliveryLog: Destinations("log")
    object DeliveryIniciarSesion: Destinations("deliverynIciarSesion")
    object Registro: Destinations("registro")
    object RecuperarContraseña: Destinations("recuperarContraseña")
    object VerificarCuenta: Destinations("verificarCuenta")
    object NuevaContraseña: Destinations("nuevaContraseña")
    object ContraseñaModificada: Destinations("contraseñaModificada")
    object EditarPerfil: Destinations("editarPerfil")
    object Restaurante: Destinations("restaurante")
    object Home: Destinations("home")

}
