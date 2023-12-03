
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.abelgarciavicario.deliverypedimos.R
import com.abelgarciavicario.deliverypedimos.domain.Restaurant
import com.abelgarciavicario.deliverypedimos.home.data.network.response.RestaurantResponse
import com.abelgarciavicario.deliverypedimos.home.ui.HomeViewModel
import com.abelgarciavicario.deliverypedimos.navigations.Destinations
import com.abelgarciavicario.deliverypedimos.ui.theme.color1


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Home(
    navController: NavController,
    homeViewModel: HomeViewModel

) {
    val listaRestaurant = homeViewModel.restaurants.observeAsState(emptyList())
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Body4(navController,homeViewModel,listaRestaurant)
    }
}

@Composable
fun Body4(
    navController: NavController,
    homeViewModel: HomeViewModel,
    listaRestaurant: State<List<RestaurantResponse>>
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(65.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "¿Pedimos?", fontSize = 40, color = color1)
                IconPerfil {

                }
            }
            OutButton()
            Text(text = "Categorias", fontSize = 30, color = Color.Black)
            CardRest()

            LazyColumn {
                item {
                    Promo()
                    Restaurants(navController,homeViewModel,listaRestaurant)
                }
            }
        }
    }
}

@Composable
fun CardRest() {
    LazyRow(
        modifier = Modifier.padding(top = 16.dp),
        contentPadding = PaddingValues(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            ImageCard(
                image = R.drawable.hamburguesa,
                "Burguers",
                "Restaurantes de hamburguesas"
            )

            ImageCard(
                image = R.drawable.sushi,
                "Japones",
                "Restaurantes Japoneses"
            )
            ImageCard(
                image = R.drawable.tacos,
                "Mexicanos",
                "Restaurantes de mexicanos"
            )
            ImageCard(
                image = R.drawable.cafe,
                "Cafes",
                "Cafeterias"
            )
            ImageCard(
                image = R.drawable.pizza,
                "Pizzas",
                "Pizzerias"
            )
        }
    }
}

@Composable
fun Restaurants(
    navController: NavController,
    homeViewModel: HomeViewModel,
    listaRestaurant: State<List<RestaurantResponse>>

) {
    Column( verticalArrangement = Arrangement.spacedBy(25.dp)) {
        for(element in listaRestaurant.value.orEmpty()) {
            Column {
                BoxRestaurants(
                    image = element.cover_url,
                    name = element.name ?: "",
                    description = element.description ?: "",
                    Destinations.Restaurante.route,
                    navController,
                    homeViewModel,
                    element
                )
            }
        }
    }
}


@Composable
fun PriceTime(price: Int, time: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            Icons.Default.ShoppingCart, "Precio",
            tint = color1,
            modifier = Modifier
                .size(25.dp)
        )
        Text(text = "$price EUR", fontSize = 15, color = Color.Black)
        Spacer(modifier = Modifier.width(26.dp))
        Image(
            modifier = Modifier.size(25.dp),
            painter = painterResource(id = R.drawable.iconreloj),
            contentDescription = null
        )
        Text(text = "$time min", fontSize = 15, color = Color.Black)

    }

}

@Composable
fun BoxRestaurants(
     image: String,
    name: String, description: String,
    destino: String, navController: NavController,
     homeViewModel: HomeViewModel, restaurant: RestaurantResponse) {
    Text(text = name, fontSize = 25, color = Color.Black)
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable
                {
                    homeViewModel.restaurantSelected(navController = navController, restaurant)
                }){
            AsyncImage(contentScale = ContentScale.Crop,
                model = image, contentDescription = null)
        }

}

@Composable
fun Promo() {
    Box(modifier = Modifier.fillMaxWidth()
        .padding(bottom = 25.dp)) {
        Image(painter = painterResource(id = R.drawable.promo),
            contentDescription = "Promo del dia",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(shape = RoundedCornerShape(35.dp))
                .clickable { }
        )
    }
}

@Composable
fun OutButton() {
    OutlinedButton(
        onClick = { /*TODO*/ }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(35.dp)
        ) {
            Icon(
                Icons.Default.Place, "Ubicacion",
                tint = color1,
                modifier = Modifier
                    .size(30.dp)
            )
            Text(text = "Calle Ubicación n6", fontSize = 20, color1)
        }
    }
}

@Composable
fun ImageCard(image: Int, text: String, description: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(120.dp)
            .clickable { }) {
        Image(
            modifier = Modifier
                .height(80.dp)
                .width(80.dp),
            painter = painterResource(id = image),
            contentDescription = description
        )
        Text(text = text, fontSize = 14, color = Color.Black)
    }
}

@Composable
fun IconPerfil(content: () -> Unit) {
    Icon(
        Icons.Default.AccountCircle, "Atras",
        tint = color1,
        modifier = Modifier
            .size(50.dp)
            .clickable { /*onClick()*/ }
    )
}

@Composable
fun Text(text: String, fontSize: Int, color: Color) {
    androidx.compose.material3.Text(text = text, fontSize = fontSize.sp, color = color)
}




