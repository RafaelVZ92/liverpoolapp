package com.rafaelvelazquez.requestmanager.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rafaelvelazquez.data.SearchProductsRemoteDataSource
import com.rafaelvelazquez.requestmanager.*
import com.rafaelvelazquez.requestmanager.data.mappers.ProductsModelMapper
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

@Module
class ApiServiceModule {

    @Provides
    @Reusable
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Reusable
    fun provideAppApiService(retrofit: Retrofit): RestServiceApi =
        retrofit.create(RestServiceApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        createOkHttpBuilder(
            arrayListOf(
                loggingInterceptor
            )
        ).build()

    @Provides
    @Singleton
    fun provideAppRetrofitService(
        httpClient: OkHttpClient,
        gson: Gson,
    ): Retrofit = createRetrofitBuilder(
        httpClient,
        gson
    ).build()


    @Provides
    fun remoteCharacterDataSourceProvider(
        restServiceApi: RestServiceApi,
        productsModelMapper: ProductsModelMapper
    ): SearchProductsRemoteDataSource = SearchProductsRetrofitDataSource(
        restServiceApi,
        productsModelMapper
    )
}