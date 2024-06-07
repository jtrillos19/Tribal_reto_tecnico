package com.jt.infraestructure.api

import retrofit2.http.GET

interface CategoryEndpoint {


    @GET("categories")
    suspend fun getCategory(): List<String>
}