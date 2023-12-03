package com.abelgarciavicario.deliverypedimos.restaurante.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.abelgarciavicario.deliverypedimos.dish.network.response.DishResponse
import com.abelgarciavicario.deliverypedimos.dish.ui.DishViewModel
import com.abelgarciavicario.deliverypedimos.navigations.Destinations
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import com.abelgarciavicario.deliverypedimos.restaurante.domain.FoodUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class FoodViewModel @Inject constructor(private val foodUseCase: FoodUseCase):ViewModel(){
    private val _food = MutableLiveData<List<FoodResponse>>()
    val food : MutableLiveData<List<FoodResponse>> = _food


    private fun getFood() {


    }

    fun platoSelected(navController: NavController){

        viewModelScope.launch {
            try {
               // val restaurants = foodUseCase.invoke("rest/v1/food?id=eq.1&select=*")
               // _food.postValue(restaurants.take(4))

            } catch (e: IOException) {

            }

        }
        //val result = homeUseCase(nombre.value!!)
        navController.navigate(Destinations.Restaurante.route)

    }
}