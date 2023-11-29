package com.abelgarciavicario.delivery.nuevacontraseña.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaContraseña(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White).padding(end = 15.dp, start = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        IconButton(modifier = Modifier
            .padding(top = 50.dp)
            .padding(end = 370.dp),
            onClick = { }

        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft, "Atras",
                tint = Color(0xFFfb813a),
            )
        }
        Text(
            text = "Crear nueva contraseña",
            fontSize = 20.sp
        )
        var password by remember {
            mutableStateOf("")
        }
        TextField(modifier = Modifier
            .width(400.dp)
            .padding(top = 50.dp)
            .padding(start = 10.dp),
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { password = it },
            label = { Text(text = "Nueva contraseña") },
            singleLine = true,
            placeholder = { Text(text = "*******") },
            leadingIcon = { Icon(Icons.Filled.Lock, null) }
        )
        var confirmPassword by remember {
            mutableStateOf("")
        }
        TextField(modifier = Modifier
            .width(400.dp)
            .padding(top = 50.dp)
            .padding(start = 10.dp),
            value = confirmPassword,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Repite contraseña") },
            placeholder = { Text(text = "*******") },
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Lock, null) }
        )
        Button(modifier = Modifier
            .width(250.dp)
            .padding(50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFfb813a)),
            onClick = {
            }) {
            Text(text = "Cambiar")
        }
    }
}