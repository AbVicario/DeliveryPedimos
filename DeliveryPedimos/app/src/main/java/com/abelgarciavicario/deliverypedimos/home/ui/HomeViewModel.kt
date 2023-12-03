package com.abelgarciavicario.deliverypedimos.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.abelgarciavicario.deliverypedimos.dish.domain.DishUseCase
import com.abelgarciavicario.deliverypedimos.dish.network.response.DishResponse
import com.abelgarciavicario.deliverypedimos.domain.Restaurant
import com.abelgarciavicario.deliverypedimos.home.data.network.response.RestaurantResponse
import com.abelgarciavicario.deliverypedimos.home.domain.HomeUseCase
import com.abelgarciavicario.deliverypedimos.navigations.Destinations
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import com.abelgarciavicario.deliverypedimos.restaurante.domain.FoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.http.Url
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase,
                                        private val dishUseCase: DishUseCase,
                                        private val foodUseCase:FoodUseCase):ViewModel() {
    private val _restaurants = MutableLiveData<List<RestaurantResponse>>()
    val restaurants : LiveData<List<RestaurantResponse>> = _restaurants

    private val _listDish = MutableLiveData<List<DishResponse>>()
    val listDish: MutableLiveData<List<DishResponse>> = _listDish

    private val _listFood = MutableLiveData<List<FoodResponse>>()
    val listFood : MutableLiveData<List<FoodResponse>> = _listFood

    private val _restaurant = MutableLiveData<RestaurantResponse> ()
    val restaurant: LiveData<RestaurantResponse> = _restaurant

    init {
        loadRestaurant()
        //getDishes()
    }
    private fun loadRestaurant() {
        viewModelScope.launch {
            try {
                val restaurants = homeUseCase()
                _restaurants.postValue(restaurants.take(4))

            } catch (e: IOException) {

            }

        }

    }


    fun restaurantSelected(navController: NavController, restaurant: RestaurantResponse){
        clearLists()
        _restaurant.value=restaurant
        viewModelScope.launch {
            try {
                val id=restaurant.id
                val urlDish = "rest/v1/dish?id_restaurant=eq.$id&select=*'"
                val dishes = dishUseCase(urlDish)

                _listDish.postValue(dishes)
                val resultList = _listFood.value?.toMutableList() ?: mutableListOf()
                for(elemento in dishes) {
                    val idFood = elemento.id_food
                    val urlDish = "rest/v1/food?id=eq.$idFood&select=*"
                    val foods = foodUseCase(urlDish)
                    resultList.add(foods.get(0))

                }
                _listFood.postValue(resultList)

                withContext(Dispatchers.Main) {
                    navController.navigate(Destinations.Restaurante.route)
                }

            } catch (e: IOException) {

            }
            //_listFood
        }
    }
    fun clearLists() {
        _listDish.postValue(emptyList())
        _listFood.postValue(emptyList())
    }
}








