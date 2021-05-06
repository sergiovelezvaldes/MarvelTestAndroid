package com.example.testmarvel.application.injection

import com.example.testmarvel.data.character.repository.real.CharacterRepository
import com.example.testmarvel.domain.character.gateways.CharacterGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharactersRepository(repository: CharacterRepository): CharacterGateway

}