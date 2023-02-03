package com.rafaelvelazquez.liverpoolapp.di

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.rafaelvelazquez.data.di.RepositoryModule
import com.rafaelvelazquez.liverpoolapp.InjectableApplication
import com.rafaelvelazquez.liverpoolapp.LiverpoolMainApp
import com.rafaelvelazquez.requestmanager.di.ApiServiceModule
import com.rafaelvelazquez.usescases.di.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        LiverpoolMainModule::class,
        ApiServiceModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)

interface LiverpoolAppComponent:
    ViewModelProvider {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application
        ): LiverpoolAppComponent
    }

    fun androidInjector(): DispatchingAndroidInjector<Any>
}

val FragmentActivity.injector
    get() = DaggerLiverpoolAppComponent.factory().create(
        application
    )
