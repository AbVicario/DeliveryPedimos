package com.abelgarciavicario.delivery.recuperarcontraseña.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecuperarContraseña(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White).padding(end = 15.dp, start = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        IconButton(modifier = Modifier
            .padding(top = 45.dp)
            .padding(end = 370.dp),
            onClick = { }

        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft, "Atras",
                tint = Color(0xFFfb813a),
            )
        }
        Text(
            text = "¿Has olvidado la contraseña? \n \n",
            fontSize = 20.sp
        )
        Text(
            text = "¡No te preocues! eso ocurre. Ingrese la dirección de correo electronico" +
                    "vinculada con su cuenta",
            fontSize = 20.sp
        )
        var email by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .width(400.dp)
                .padding(top = 60.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Ingresa tu email") },
            placeholder = { Text(text = "ejemplo@gmail.com") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.AccountCircle, null) }
        )
        Button(modifier = Modifier
            .width(250.dp)
            .padding(top=80.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFfb813a)),
            onClick = {
            }) {
            Text(text = "Enviar código")
        }
        Column(modifier = Modifier.padding(top =80.dp),
            Arrangement.Center) {
            Text(text = "    ¿Recuerdas la contraseña?",
                fontSize = 20.sp)
            TextButton(modifier = Modifier
                .width(250.dp)
                .padding(10.dp),
                onClick = { /* Acción al hacer clic en el botón */ }) {
                Text(
                    text = "Ingresar",
                    color = Color(0xFFfb813a),
                    fontSize = 18.sp
                )
            }
        }
    }
}