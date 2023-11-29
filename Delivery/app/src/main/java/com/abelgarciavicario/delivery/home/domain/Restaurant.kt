package com.abelgarciavicario.delivery.home.domain

import android.provider.ContactsContract.CommonDataKinds.Email

data class Restaurant(
    val name: String,
    val category: String,
    val phone: String,
    val email: String,
    val direction: String
)
