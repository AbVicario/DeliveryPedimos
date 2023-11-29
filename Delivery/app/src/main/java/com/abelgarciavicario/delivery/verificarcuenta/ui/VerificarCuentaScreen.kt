package com.abelgarciavicario.delivery.verificarcuenta.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificarCuenta(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        IconButton(modifier = Modifier
            .padding(top = 45.dp)
            .padding(end = 370.dp)
            .size(60.dp),
            onClick = { }

        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                "Atras",
                tint = Color(0xFFfb813a),

            )
        }
        Text(
            text = "Ingrese el código de verificación que acabamos de enviar a su dirección" +
                    " de correo electrónico.",
            fontSize = 20.sp
        )
        Row ( modifier = Modifier.fillMaxWidth()
            .padding(top=80.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            var num1 by remember {
                mutableStateOf("")
            }
            TextField(
                modifier = Modifier
                    .width(80.dp),
                value = num1,
                placeholder = { Text(text = "-",
                    fontSize = 16.sp) },
                onValueChange = { num1 = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,

                )
            )
            var num2 by remember {
                mutableStateOf("")
            }
            TextField(
                modifier = Modifier
                    .width(80.dp),
                value = num2,
                placeholder = { Text(text = "-",
                    fontSize = 16.sp,
                    ) },
                onValueChange = { num2 = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
            var num3 by remember {
                mutableStateOf("")
            }
           TextField(
                modifier = Modifier
                    .width(80.dp),
                value = num3,
                placeholder = { Text(text = "-",
                    fontSize = 16.sp)},
                onValueChange = { num3 = it },
               singleLine = true,
               keyboardOptions = KeyboardOptions.Default.copy(
                   keyboardType = KeyboardType.Number
               )
           )
            var num4 by remember {
                mutableStateOf("")
            }
            TextField(
                modifier = Modifier
                    .width(80.dp),
                value = num4,
                placeholder = { Text(text = "-",
                    fontSize = 16.sp) },
                onValueChange = { num4 = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )
        }
        Button(modifier = Modifier
            .width(250.dp)
            .padding(top = 100.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFfb813a)),
            onClick = {
                //Log.d()
            }) {
            Text(text = "Verificar")
        }
        Column(modifier = Modifier.padding(top =80.dp),
            Arrangement.Center) {
            Text(text = "    ¿No recibiste el código?",
                fontSize = 20.sp)
            TextButton(modifier = Modifier
                .width(250.dp)
                .padding(10.dp),
                onClick = { /* Acción al hacer clic en el botón */ }) {
                Text(
                    text = "Renviar",
                    color = Color(0xFFfb813a),
                    fontSize = 18.sp
                )
            }
        }
    }
}
