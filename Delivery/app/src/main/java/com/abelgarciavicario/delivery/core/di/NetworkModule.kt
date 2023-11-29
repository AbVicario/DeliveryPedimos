package com.abelgarciavicario.delivery.core.di

import com.abelgarciavicario.delivery.home.data.network.HomeClient
import com.abelgarciavicario.delivery.registro.data.response.RegistroClient
import com.abelgarciavicario.delivery.signup.data.network.SignUpClient
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
    fun provideSignUpClient(retrofit: Retrofit):SignUpClient{
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

}