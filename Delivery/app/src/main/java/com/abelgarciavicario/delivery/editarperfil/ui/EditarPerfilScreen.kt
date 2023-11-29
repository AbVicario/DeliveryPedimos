package com.abelgarciavicario.delivery.editarperfil.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.abelgarciavicario.delivery.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarPerfil() {
    val colors = listOf(Color(0xFFfb813a),Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = colors,
                    startY = 500f,
                    endY = 1000f
                )
            )
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            IconButton(
                modifier = Modifier

                    .padding(end = 10.dp)
                    .background(Color(0xFFfb813a)),

                onClick = { }
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft, "Atras",
                    tint = Color.White
                )
            }
            Text(
                text = "Editar Perfil",
                fontSize = 24.sp,
                color = Color.White
            )
            IconButton(
                modifier = Modifier

                    .padding(end = 10.dp)
                    .background(Color(0xFFfb813a)),

                onClick = {}
            ) {
                Icon(
                    Icons.Default.Check, "Atras",
                    tint = Color.White
                )
            }
        }
        Box(
            modifier = Modifier
                .size(300.dp)
                .padding(40.dp)
                .background(Color(0xFFfb813a), shape = CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.perfilbrayan),
                contentDescription = "Imagen de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
            FloatingActionButton(
                onClick = {
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Editar")
            }

        }
        Text(text = "Tu información",
            color = Color(0xFFfb813a),
            fontSize = 20.sp
        )
        var name by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .width(400.dp)
                .padding(top = 25.dp)
                .padding(start = 10.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nombre") },
            singleLine = true,
            placeholder = { Text(text = "User") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = { Icon(Icons.Filled.AccountCircle, null) }
        )
        var surname by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .width(400.dp)
                .padding(top = 25.dp)
                .padding(start = 10.dp),
            value = surname,
            onValueChange = { surname = it },
            label = { Text(text = "Apellido") },
            singleLine = true,
            placeholder = { Text(text = "Surname") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = { Icon(Icons.Filled.AccountCircle, null) }
        )
        var telefono by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .width(400.dp)
                .padding(top = 25.dp)
                .padding(start = 10.dp),
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text(text = "Teléfono") },
            placeholder = { Text(text = "666666666") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
            leadingIcon = { Icon(Icons.Filled.Phone, null) }
        )
        var email by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .width(400.dp)
                .padding(top = 25.dp)
                .padding(start = 10.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "xxxxxx@gmail.com") },
            leadingIcon = { Icon(Icons.Filled.MailOutline, null) }
        )

    }
}


