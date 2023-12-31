package com.abelgarciavicario.deliverypedimos.signup.data.network.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
)
