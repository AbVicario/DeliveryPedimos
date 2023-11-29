import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abelgarciavicario.delivery.signin.ui.SignUpViewModel
import com.abelgarciavicario.delivery.ui.theme.color1


@Composable
fun DeliveryIniciarSesion(
    navController: NavController,
    signUpViewModel: SignUpViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Body1(navController,signUpViewModel)
    }

}

@Composable
fun Body1(navController: NavController,signUpViewModel: SignUpViewModel) {
    val email: String by signUpViewModel.email.observeAsState(initial="")
    val password: String by signUpViewModel.password.observeAsState(initial="")
    val isLogEnable: Boolean by signUpViewModel.isLogEnable.observeAsState(initial = false)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {

            Box(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)){

            }

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, bottom = 120.dp),
                    horizontalArrangement = Arrangement.spacedBy(60.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconBack {

                    }
                    Text(text = "¿Pedimos?", fontSize = 30, color = color1)
                }
                MostrarError(viewModel = signUpViewModel)
                TextFieldNombre(email){
                    signUpViewModel.onLoginChange(email=it,password=password)
                }
                TextFieldPassword(password){
                    signUpViewModel.onLoginChange(email=email,password=it)
                }
                ButtonLog(text = "Iniciar sesión", color = color1, isLogEnable, signUpViewModel,
                    navController, onClick = {})


            }

    }
}

@Composable
fun ButtonLog(text: String, color: Color, logEnable: Boolean,signUpViewModel:SignUpViewModel,
              navController: NavController,
              onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = { signUpViewModel.onLoginSelected(navController) },
        enabled = logEnable,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text = text)
    }
}



@Composable
fun IconBack(onClick: () -> Unit) {
    Icon(
        Icons.Default.KeyboardArrowLeft, "Atras",
        tint = color1,
        modifier = Modifier.clickable { onClick() }
    )
}




@Composable
fun TextFieldNombre( email: String, onTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .width(400.dp)
            .padding(top = 25.dp)
            .padding(start = 10.dp),
        value = email,
        onValueChange = { onTextChange(it) },
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = "Email") },
        leadingIcon = { Icon(Icons.Default.Email, null) }
    )
}

@Composable
fun TextFieldPassword(password: String, onTextChange: (String) -> Unit) {
    TextField(modifier = Modifier
        .width(400.dp)
        .padding(top = 25.dp)
        .padding(start = 10.dp),
        value = password,
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { onTextChange(it) },
        singleLine = true,
        placeholder = { Text(text = "Contraseña") },
        leadingIcon = { Icon(Icons.Filled.Lock, null) }
    )
}

@Composable
fun MostrarError(viewModel: SignUpViewModel) {
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












