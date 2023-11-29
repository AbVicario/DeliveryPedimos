package com.abelgarciavicario.delivery.domain

data class User(
    val userName: String,
    val surname: String,
    val birthdate: String,
    val email: String,
    val phoneNumber: Int,
    val genre: String,
    val password: String,
)
