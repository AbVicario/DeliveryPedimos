package com.abelgarciavicario.prueba171023

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abelgarciavicario.prueba171023.ui.theme.Prueba171023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            appDelivery()
        }
    }
}

//@Preview
@Composable
fun appDelivery(){
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        /*Image(modifier= Modifier
            .width(336.dp)
            .height(217.dp),
            painter = painterResource(id = R.mipmap.logodelivery),
            contentDescription = "logo aplicación"
        )*/
        Button(onClick = { /*TODO*/ }) {
            
        }
    }

}

