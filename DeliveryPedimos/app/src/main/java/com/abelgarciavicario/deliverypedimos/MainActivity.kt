package com.abelgarciavicario.deliverypedimos


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.abelgarciavicario.deliverypedimos.dish.ui.DishViewModel
import com.abelgarciavicario.deliverypedimos.home.ui.HomeViewModel
import com.abelgarciavicario.deliverypedimos.navigations.NavigationsHost
import com.abelgarciavicario.deliverypedimos.registro.ui.components.RegistroViewModel
import com.abelgarciavicario.deliverypedimos.restaurante.ui.FoodViewModel
import com.abelgarciavicario.deliverypedimos.signin.ui.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private val registroViewModel: RegistroViewModel by viewModels()
    private val foodViewModel: FoodViewModel by viewModels()
    private val dishViewModel: DishViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationsHost(signUpViewModel,homeViewModel,registroViewModel,
                dishViewModel,foodViewModel)
        }
    }
}

