package com.abelgarciavicario.delivery.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.abelgarciavicario.delivery.domain.Restaurant
import com.abelgarciavicario.delivery.home.data.network.response.RestaurantResponse
import com.abelgarciavicario.delivery.home.domain.HomeUseCase
import com.abelgarciavicario.delivery.navigations.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase):ViewModel() {
    private val _restaurants = MutableLiveData<List<RestaurantResponse>>()
    val restaurants : LiveData<List<RestaurantResponse>> = _restaurants

    init {
        loadRestaurant()
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

    fun bkSelected(navController: NavController){
        //val result = homeUseCase(nombre.value!!)
        navController.navigate(Destinations.Restaurante.route)

    }

}


