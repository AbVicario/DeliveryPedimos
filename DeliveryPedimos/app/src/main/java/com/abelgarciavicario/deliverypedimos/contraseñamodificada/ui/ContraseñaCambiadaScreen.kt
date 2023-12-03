package com.abelgarciavicario.deliverypedimos.contraseñamodificada.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abelgarciavicario.deliverypedimos.R


@Composable
fun ContraseñaModificada(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(end = 15.dp, start = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            modifier = Modifier
                .size(300.dp)
                .padding(top=120.dp),
            painter = painterResource(id = R.drawable.tick),
            contentDescription = "Imagen tick",
        )
        Box(modifier = Modifier
            .padding(top = 60.dp, start = 40.dp))
            {
            Text(
                text = "¡Contraseña cambiada!\n" +
                        " Tu contraseña ha sido cambiada exitosamente.",
                fontSize = 20.sp
            )
        }
        Button(modifier = Modifier
            .width(300.dp)
            .padding(top=70.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFfb813a)),
            onClick = {
            }) {
            Text(text = "Regresa al inicio")
        }

    }
}