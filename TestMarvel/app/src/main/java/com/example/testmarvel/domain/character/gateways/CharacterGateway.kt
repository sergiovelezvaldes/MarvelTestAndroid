package com.example.testmarvel.domain.character.gateways

import com.example.testmarvel.data.common.model.ResultRequest
import com.example.testmarvel.domain.character.model.Character

interface CharacterGateway {
    suspend fun getCharacters(): ResultRequest<List<Character>>
    suspend fun getCharacterById(idCharacter: Int): ResultRequest<Character>
}