package com.rafaelvelazquez.liverpoolapp

import com.rafaelvelazquez.liverpoolapp.di.DaggerLiverpoolAppComponent

class LiverpoolMainApp : InjectableApplication() {

    private lateinit var instance: LiverpoolMainApp

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun initializeInjector() {
        DaggerLiverpoolAppComponent
            .factory()
            .create(this)
       /* DaggerLiverpoolAppComponent.builder()
            .application(this)
            .build()
            .androidInjector()
            .apply { inject(this@LiverpoolMainApp) }*/
    }

    override fun androidInjector() = androidInjector

}