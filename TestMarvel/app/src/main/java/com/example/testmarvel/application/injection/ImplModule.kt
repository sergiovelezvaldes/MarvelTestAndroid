package com.example.testmarvel.application.injection

import com.example.testmarvel.application.common.DefaultDispatcherProvider
import com.example.testmarvel.application.common.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImplModule {

    @Binds
    @Singleton
    abstract fun bindDispatchers(dispatchers: DefaultDispatcherProvider): DispatcherProvider
}