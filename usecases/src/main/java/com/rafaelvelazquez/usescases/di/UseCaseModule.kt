package com.rafaelvelazquez.usescases.di

import com.rafaelvelazquez.data.SearchProductsRepository
import com.rafaelvelazquez.usescases.GetAllProductsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun userLoginUseCaseProvider(searchProductsRepository: SearchProductsRepository) =
        GetAllProductsUseCase(searchProductsRepository)

}
