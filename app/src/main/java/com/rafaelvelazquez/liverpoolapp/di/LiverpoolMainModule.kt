package com.rafaelvelazquez.liverpoolapp.di

import android.app.Application
import android.content.Context
import com.rafaelvelazquez.liverpoolapp.LiverpoolMainApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LiverpoolMainModule {

    @Provides
    @Singleton
    fun providesContext(context: LiverpoolMainApp): Context = context.applicationContext

    @Provides
    @Singleton
    fun providesApplication(application: LiverpoolMainApp): Application = application
}