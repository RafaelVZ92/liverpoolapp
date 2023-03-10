package com.rafaelvelazquez.requestmanager

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofitBuilder(
    httpClient: OkHttpClient,
    gson: Gson
): Retrofit.Builder = Retrofit.Builder()
    .callFactory { httpClient.newCall(it) }
    .baseUrl(BASE_URL)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create(gson))

fun createOkHttpBuilder(
    interceptors: ArrayList<Interceptor>? = null,
) = OkHttpClient
    .Builder().apply {
        interceptors?.forEach { addInterceptor(it) }
    }

const val BASE_URL = "https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/"