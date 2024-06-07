package com.jt.infraestructure.di

import com.jt.domain.repository.CategoryRepository
import com.jt.domain.service.CategoryService
import com.jt.infraestructure.api.ApiManager
import com.jt.infraestructure.api.CategoryEndpoint
import com.jt.infraestructure.repository.CategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CategoryModule {


    @Provides
    fun provideRepository(apiManager: ApiManager) : CategoryRepository =
        CategoryRepositoryImpl(apiManager)


    @Provides
    fun provideService(categoryRepository: CategoryRepository) : CategoryService =
        CategoryService(categoryRepository)

    @Singleton
    @Provides
    fun provideCategoryEndpoint(retrofit: Retrofit): CategoryEndpoint =
        retrofit.create(CategoryEndpoint::class.java)
}