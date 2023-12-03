package com.abelgarciavicario.deliverypedimos.dish.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.abelgarciavicario.deliverypedimos.dish.domain.DishUseCase
import com.abelgarciavicario.deliverypedimos.dish.network.response.DishResponse
import com.abelgarciavicario.deliverypedimos.navigations.Destinations
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.response.FoodResponse
import com.abelgarciavicario.deliverypedimos.restaurante.domain.FoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(private val dishUseCase:DishUseCase,
    private val foodUseCase: FoodUseCase):ViewModel(){


}