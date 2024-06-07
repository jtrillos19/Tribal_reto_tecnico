package com.jt.infraestructure.repository

import com.jt.domain.repository.CategoryRepository
import com.jt.infraestructure.api.ApiManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CategoryRepositoryImpl(private val apiManager: ApiManager): CategoryRepository {

    override suspend fun getCategory(): Flow<List<String>> =
        flow {
            emit(apiManager.getCategory())
        }.catch {
            throw Exception("Hubo un error al obtener las categorias")
        }
}