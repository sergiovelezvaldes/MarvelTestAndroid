package com.example.testmarvel.application.injection

import android.content.Context
import com.example.testmarvel.data.character.repository.real.CharacterApi
import com.example.testmarvel.data.common.NetworkInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://gateway.marvel.com:443"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(networkInterceptor: NetworkInterceptor) = OkHttpClient.Builder()
            .addInterceptor(networkInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(
                    GsonConverterFactory.create(
                            GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
                    )
            ).build()

    @Provides
    @Singleton
    fun providesNetworkConnectionInterceptor(): NetworkInterceptor = NetworkInterceptor()

    @Provides
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi =
            retrofit.create(CharacterApi::class.java)

}