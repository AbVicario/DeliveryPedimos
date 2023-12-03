package com.abelgarciavicario.deliverypedimos.registro.ui.components

import com.abelgarciavicario.deliverypedimos.ui.theme.color1
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abelgarciavicario.deliverypedimos.R
import com.abelgarciavicario.deliverypedimos.navigations.Destinations

@Composable
fun Registro(
    navController: NavController,
    registroViewModel: RegistroViewModel
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Body(navController,registroViewModel)
    }

}


@Composable
fun Body(navController: NavController,registroViewModel: RegistroViewModel) {
    val email: String by registroViewModel.email.observeAsState(initial="")
    val password: String by registroViewModel.password.observeAsState(initial="")
    val nombre: String by registroViewModel.nombre.observeAsState(initial="")
    val passwordR: String by registroViewModel.passwordR.observeAsState(initial="")
    val isLogEnable: Boolean by registroViewModel.isLogEnable.observeAsState(initial = false)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconBack {
                    navController.navigate(Destinations.DeliveryLog.route)
                }
                Text("¡Hola! Registrate para comenzar", 16, color1)
            }
            MostrarError(viewModel = registroViewModel)
            TextFieldNombre(nombre){
                registroViewModel.onRegistroChange(it, email, password, passwordR)
            }
            TextFieldMail(email){
                registroViewModel.onRegistroChange(nombre, it, password, passwordR)
            }

            TextFieldPassword(password){
                registroViewModel.onRegistroChange(nombre, email, it, passwordR)
            }
            TextFieldPasswordR(passwordR){
                registroViewModel.onRegistroChange(nombre, email, password, it)
            }
            ButtonReg("Registrarse", color1,isLogEnable,registroViewModel,
                navController, onClick= {})

            Text("Registrate con", 16, color1)
            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                ButtonWhith(image = R.drawable.iconfacebook)
                ButtonWhith(image = R.drawable.icongoogle)
            }
            Row(modifier = Modifier.clickable { }) {
                Text("¿Ya tienes cuenta?", 14, MaterialTheme.colorScheme.primary)
                Text("Inicia sesión aqui", 14, Color.Blue)
            }
        }

    }
}


@Composable
fun IconBack(onClick:() -> Unit) {
    Icon(
        Icons.Default.KeyboardArrowLeft, "Atras",
        tint = color1,
        modifier = Modifier.clickable { onClick() }
    )
}



@Composable
fun ButtonWhith(image: Int) {
    Image(
        modifier = Modifier
            .size(35.dp)
            .clickable { },
        painter = painterResource(id = image),
        contentDescription = "null",
    )

}

@Composable
fun Text(text: String, fontSize: Int, color: Color) {
    Text(text = text, fontSize = fontSize.sp, color = color)
}

@Composable
fun ButtonReg(text: String, color: Color, logEnable: Boolean,registroViewModel: RegistroViewModel,
              navController: NavController,
              onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        onClick = {registroViewModel.onRegistroSelected(navController)},
        enabled= logEnable,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text = text)
    }
}

@Composable
fun TextFieldPassword(password: String,  onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = password,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { Text(text = "Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}
@Composable
fun TextFieldPasswordR(passwordR: String,  onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = passwordR,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { Text(text = "Repetir Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}


@Composable
fun TextFieldNombre(nombre: String,  onTextChange: (String) -> Unit) {

    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(top = 25.dp)
            .padding(start = 10.dp),
        value = nombre,
        onValueChange = {onTextChange(it) },
        placeholder = { Text(text = "Nombre") },
        leadingIcon = { Icon(Icons.Default.AccountCircle, null) }
    )
}

@Composable
fun TextFieldMail(email: String,  onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(top = 25.dp)
            .padding(start = 10.dp),
        value = email,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }
    )
}

@Composable
fun MostrarError(viewModel: RegistroViewModel) {
    val errorMessage = viewModel.errorMessage.observeAsState()

    errorMessage.value?.let { message ->
        AlertDialog(
            onDismissRequest = { viewModel.clearErrorMessage() },
            title = { Text("Error") },
            text = { Text(message) },
            confirmButton = {
                Button(onClick = { viewModel.clearErrorMessage() }) {
                    Text("OK")
                }
            }
        )
    }
}





