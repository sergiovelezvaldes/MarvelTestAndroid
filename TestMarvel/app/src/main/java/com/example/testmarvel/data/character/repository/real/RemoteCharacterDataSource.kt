package com.example.testmarvel.data.character.repository.real

import com.example.testmarvel.data.character.model.CharacterDataWrapper
import com.example.testmarvel.domain.character.model.Character
import retrofit2.Response
import javax.inject.Inject

class RemoteCharacterDataSource @Inject constructor(private val characterApi: CharacterApi) {
    suspend fun getCharacters(): Response<CharacterDataWrapper> {
        return characterApi.getCharacters()
    }

    suspend fun getCharacterById(characterId: Int): Response<CharacterDataWrapper> {
        return characterApi.getCharacterById(characterId)
    }
}