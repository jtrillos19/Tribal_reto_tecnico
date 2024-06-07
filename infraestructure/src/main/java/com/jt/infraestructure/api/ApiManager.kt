package com.jt.infraestructure.api

import javax.inject.Inject

class ApiManager @Inject constructor(private val categoryEndpoint: CategoryEndpoint) {

    suspend fun getCategory() = categoryEndpoint.getCategory()
}