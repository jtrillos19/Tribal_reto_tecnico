package com.jt.domain.service

import com.jt.domain.repository.CategoryRepository

class CategoryService(private val categoryRepository: CategoryRepository) {

    suspend fun getCategory() = categoryRepository.getCategory()
}