package com.abelgarciavicario.delivery.signup.data.network

import com.abelgarciavicario.delivery.signup.data.network.dto.UserDTO
import com.abelgarciavicario.delivery.signup.data.network.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignUpClient {
    @Headers(
        "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNsdXRydHFjZWVyZ2FmZHRxamViIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDAwNTI2MDksImV4cCI6MjAxNTYyODYwOX0.M0LOr8aHu4GA8TE9B-7skWZl348m2YF1ACUX_CZQcBw",
        "Content-Type: application/json")
    @POST("auth/v1/token?grant_type=password")
    suspend fun doSignUp(@Body user: UserDTO): Response<UserResponse>
}