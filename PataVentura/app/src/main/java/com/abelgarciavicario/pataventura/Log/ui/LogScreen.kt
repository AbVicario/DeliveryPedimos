package com.abelgarciavicario.pataventura.Log.ui

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abelgarciavicario.pataventura.R
import com.abelgarciavicario.pataventura.ui.theme.verdeClaro


@Composable
fun MyBox() {
    Box( modifier = Modifier
        .fillMaxSize()
        .padding(20.dp), contentAlignment = Alignment.Center){
       Header()
       Body()
       Footer()
    }
}

@Composable
fun Footer() {
    Box{
    }
}

@Composable
fun Body() {
    Box(Modifier.fillMaxWidth().height(600.dp)){
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally){
            LogoImage()
            BotonOutLined(imagen = R.drawable.icono_google, text ="  Registrarse con google")
            BotonOutLined(imagen = R.drawable.icono_facebook, text ="  Registrarse con google")
            BotonApp(text = "Iniciar sesion" )
            BotonApp(text = "Registrarse gratis" )
        }

    }
}

@Composable
fun Header(){
    Box(modifier = Modifier
        .background(color = verdeClaro)){
    }
}

@Composable
fun BotonApp(text:String){
    Button(modifier = Modifier
        .width(250.dp)
        .height(40.dp),
        onClick = { /*TODO*/ }) {
        Text(text = text,
            color = Color.White
        )
    }
}
@Composable
fun LogoImage(){
    Image( modifier = Modifier
        .width(300.dp)
        .height(300.dp),
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo de la aplicación")
}

@Composable
fun BotonOutLined(imagen: Int, text: String){
    OutlinedButton(modifier = Modifier
        .width(250.dp)
        .height(40.dp),
        onClick = { /*TODO*/ }) {
        Row(){
            Image(
                painter = painterResource(id = imagen),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text)
        }
    }
}