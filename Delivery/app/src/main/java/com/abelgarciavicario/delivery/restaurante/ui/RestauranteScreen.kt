import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abelgarciavicario.delivery.ui.theme.color1

import com.abelgarciavicario.delivery.R
import com.abelgarciavicario.delivery.navigations.Destinations


@Composable
fun Restaurante(
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        BodyBK(navController)
    }

}

@Composable
fun BodyBK(navController: NavController){
    LazyColumn{
        item {
            ImageRes(image = R.drawable.logobk,
                description = "Burguer King", navController)
            MenuRes()
        }

    }

}

@Composable
fun MenuRes() {
    Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
        Text(text = "Menú", fontSize = 35, color = color1 )
        CardDish(image =  R.drawable.cheesebacon, "Cheese Bacon"
            ,"Dos piezas de carne, bacon crujiente y queso chedar", "7" )
        CardDish(R.drawable.whopper, "Whopper",
            "Dos  piezas de carne, tomate, lechuga y queso chedar", "8")
        CardDish(R.drawable.triplewhopper, "Triple Whopper",
            "Tres  piezas de carne, tomate, lechuga y queso chedar", "10")
    }
}

@Composable
fun CardDish(image:Int, name:String, description: String, price: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .clickable { }){
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = image),
            contentDescription = null
        )
        Column {
            Text(
                text = name,
                fontSize = 18,
                color1
            )
            Text(text = description, fontSize = 14, Color.Black)
            Row {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.iconcesta),
                    contentDescription = null
                )
                Text(text = "$price EUR",14, color1)
            }
        }
    }
    }


@Composable
fun ImageRes(image: Int , description: String, navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)){
        Image(
            painter = painterResource(id = image),
            contentDescription = description,
            colorFilter = ColorFilter.tint(Color(0XFF615E58), blendMode = BlendMode.Darken)
        )
        Column(
            horizontalAlignment = Alignment.Start
        ){
            IconButtons(navController)
        }
        Column(
            modifier = Modifier.padding(top = 150.dp),
            horizontalAlignment = Alignment.Start) {
            RestaurantInformation()

        }
    }
}

@Composable
fun IconButtons(navController: NavController){
    Row {
        IconButton(
            onClick = {navController.navigate(Destinations.Home.route) }
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft, "Atras",
                tint = Color.White
            )
        }
        IconButton(modifier = Modifier.padding(start = 250.dp),
            onClick = { }
        ) {
            Icon(
                Icons.Default.Star, "Comentarios",
                tint = Color.White
            )
        }
    }
}

@Composable
fun RestaurantInformation() {
    Text(
        "Burguer King", 22, Color.White
    )
    Row(modifier = Modifier.padding(top = 5.dp)) {
        Icon(
            Icons.Default.Star, "Comentarios",
            tint = Color.White
        )
        Text(
            text = "4.7(+200 calificaciones",
            12,
            color = Color.White

        )
    }
    Row(modifier = Modifier.padding(top = 5.dp)) {
        Icon(
            Icons.Default.ShoppingCart, "Comentarios",
            tint = Color.White
        )
        Text(
            text = "Coste de envio: 4 EUR",
            14,
            color = Color.White
        )
    }
    Text(
        text = "ABIERTO HASTA LAS 12:00 PM",
        14,
        color = Color.White
    )
}









