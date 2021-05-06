package com.example.testmarvel.application.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface DispatcherProvider {

    fun main(): CoroutineDispatcher = Dispatchers.Main
}

class DefaultDispatcherProvider @Inject constructor() : DispatcherProvider