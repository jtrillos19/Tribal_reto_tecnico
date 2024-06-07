package com.jt.infraestructure.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    private val URL_BASE = "https://api.chucknorris.io/jokes/"


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val client = OkHttpClient.Builder().connectTimeout(10L,TimeUnit.SECONDS)
        val gsonConverterFactory = GsonConverterFactory.create(GsonBuilder().create())

        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(client.build())
            .addConverterFactory(gsonConverterFactory)
            .build()

    }
}