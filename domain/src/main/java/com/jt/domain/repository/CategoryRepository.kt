package com.jt.domain.repository

import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun getCategory(): Flow<List<String>>
}