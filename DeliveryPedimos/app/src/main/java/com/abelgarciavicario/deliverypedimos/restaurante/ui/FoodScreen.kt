import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.abelgarciavicario.deliverypedimos.ui.theme.color1
import com.abelgarciavicario.deliverypedimos.R
import com.abelgarciavicario.deliverypedimos.dish.ui.DishViewModel
import com.abelgarciavicario.deliverypedimos.home.data.network.response.RestaurantResponse
import com.abelgarciavicario.deliverypedimos.home.ui.HomeViewModel
import com.abelgarciavicario.deliverypedimos.navigations.Destinations
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import com.abelgarciavicario.deliverypedimos.restaurante.ui.FoodViewModel


@Composable
fun Restaurante(
    navController: NavController,
    foodViewModel: FoodViewModel,
    homeViewModel: HomeViewModel
) {
    val listaPlatos= homeViewModel.listFood.observeAsState(emptyList())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        BodyBK(navController,foodViewModel,listaPlatos,homeViewModel)
    }

}

@Composable
fun BodyBK(navController: NavController,foodViewModel: FoodViewModel,
           listaPlatos: State<List<FoodResponse>>, homeViewModel: HomeViewModel){
    LazyColumn{
        item {
            ImageRes(homeViewModel, navController = navController )
            MenuRes(navController,foodViewModel,listaPlatos,homeViewModel)
        }

    }

}

@Composable
fun MenuRes(navController: NavController,foodViewModel: FoodViewModel,
            listaPlatos: State<List<FoodResponse>>,homeViewModel: HomeViewModel) {
    Column (verticalArrangement = Arrangement.spacedBy(25.dp)){

        Text(text = "Menú", fontSize = 35, color = color1 )
        for(plato in listaPlatos.value.orEmpty()){
            CardDish(navController,foodViewModel,plato, homeViewModel)
        }

    }
}

@Composable
fun CardDish(
    navController: NavController, foodViewModel: FoodViewModel,
    plato: FoodResponse, homeViewModel: HomeViewModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .clickable { /*foodViewModel.platoSelected(navController)*/ }){
        AsyncImage(modifier = Modifier.size(150.dp),
            model = plato.cover_url, contentDescription =null )
        Column (Modifier.padding(start=25.dp)){
            Text(
                text = plato.name,
                fontSize = 18,
                color1
            )
            for(ingredientes in plato.ingredients){
                Text(text = ingredientes, fontSize = 14, Color.Black)
            }

        }
    }
}


@Composable
fun ImageRes(homeViewModel: HomeViewModel, navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp)){
        AsyncImage(homeViewModel.restaurant.value!!.cover_url,
            contentDescription = null)
        IconButton(
            onClick = {navController.navigate(Destinations.Home.route) }
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft, "Atras",
                tint = Color.White
            )
        }
        RestaurantInformation(homeViewModel.restaurant.value!! ,
            Modifier.align(Alignment.BottomStart))
    }
}

@Composable
fun IconButtons(navController: NavController){
    Row {
        IconButton(
            onClick = {navController.navigate(Destinations.Home.route) },
            Modifier.background(Color(0XFF383444).copy(alpha = 0.7f))
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
fun RestaurantInformation(restaurant: RestaurantResponse, modifier: Modifier) {
    Box(modifier = modifier
        .background(Color(0XFF383444).copy(alpha = 0.7f))
    )
    {
        Column {
            Text(
                restaurant.name, 32, Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = restaurant.address,
                20,
                color = Color.White
            )
        }

    }

}









