package com.example.testmarvel.data.character.repository.real

import com.example.testmarvel.data.character.model.CharacterDataWrapper
import com.example.testmarvel.domain.character.model.Character
import retrofit2.Response
import retrofit2.http.*

interface CharacterApi {

    @Headers("Content-Type: application/json")
    @GET("v1/public/characters")
    suspend fun getCharacters(): Response<CharacterDataWrapper>

    @Headers("Content-Type: application/json")
    @GET("v1/public/characters/{id}")
    suspend fun getCharacterById(@Path("id") idCharacter: Int): Response<CharacterDataWrapper>

}