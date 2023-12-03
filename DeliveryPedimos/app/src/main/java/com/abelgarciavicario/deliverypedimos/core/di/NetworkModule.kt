package com.abelgarciavicario.deliverypedimos.core.di

import com.abelgarciavicario.deliverypedimos.dish.network.DishClient
import com.abelgarciavicario.deliverypedimos.home.data.network.HomeClient
import com.abelgarciavicario.deliverypedimos.registro.data.response.RegistroClient
import com.abelgarciavicario.deliverypedimos.signup.data.network.SignUpClient
import com.abelgarciavicario.deliverypedimos.restaurante.data.network.FoodClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://clutrtqceergafdtqjeb.supabase.co/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideSignUpClient(retrofit: Retrofit): SignUpClient {
        return retrofit.create(SignUpClient:: class.java)
    }

    @Singleton
    @Provides
    fun provideRegistroClient(retrofit: Retrofit): RegistroClient {
        return retrofit.create(RegistroClient:: class.java)
    }

    @Singleton
    @Provides
    fun provideHomeClient(retrofit: Retrofit): HomeClient {
        return retrofit.create(HomeClient:: class.java)
    }

    @Singleton
    @Provides
    fun foodClient(retrofit: Retrofit): FoodClient {
        return retrofit.create(FoodClient:: class.java)
    }

    @Singleton
    @Provides
    fun dishClient(retrofit: Retrofit): DishClient {
        return retrofit.create(DishClient:: class.java)
    }

}