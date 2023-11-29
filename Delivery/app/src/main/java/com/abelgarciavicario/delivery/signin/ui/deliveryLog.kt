import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abelgarciavicario.delivery.R
import com.abelgarciavicario.delivery.navigations.Destinations
import com.abelgarciavicario.delivery.ui.theme.color1


@Composable
fun DeliveryLog(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Body(navController)
    }
}

@Composable
fun Body(navController: NavController) {
    Box( modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageLogo()
            OutButton(text = "Ingresa con Google", image = R.drawable.icongoogle)
            OutButton(text = "Ingresa con Facebook", image = R.drawable.iconfacebook)
            ButtonReg(text = "Iniciar sesion", color = color1){
                navController.navigate(Destinations.DeliveryIniciarSesion.route)
            }
            ButtonReg(text = "Registrate gratis", color = color1){
                navController.navigate(Destinations.Registro.route)
            }
            Text(text = "Olvidé la contraseña", fontSize = 16, color = color1)


        }
    }
}

@Composable
fun ImageLogo() {
    Image( modifier = Modifier.size(300.dp),
        painter = painterResource(id = R.drawable.logodelivery),
        contentDescription = "logo aplicación",
    )
}
@Composable
fun OutButton(text:String, image:Int){
    OutlinedButton(       
        onClick = { /*TODO*/ }) {
        Row {
            Image(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(20.dp),
                painter = painterResource(id = image),
                contentDescription = "logo aplicación",
            )
            Text(text)
        }
    }
}
@Composable
fun ButtonReg(text: String, color: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, start = 30.dp),
        onClick =  onClick,
        colors = ButtonDefaults.buttonColors(color),
    ) {
        Text(text = text)
    }
}

