package com.rafaelvelazquez.data.di

import com.rafaelvelazquez.data.SearchProductsRepository
import com.rafaelvelazquez.data.SearchProductsRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun searchProductsRepositoryProvider(
        remoteDataSource: SearchProductsRemoteDataSource
    ) = SearchProductsRepository(
        remoteDataSource
    )

}
