package com.example.testmarvel.domain.character.usecases

import com.example.testmarvel.data.common.model.ResultRequest
import com.example.testmarvel.domain.character.gateways.CharacterGateway
import com.example.testmarvel.domain.character.model.Character
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(private val gateway: CharacterGateway) {
    suspend fun execute(idCharacter: Int): ResultRequest<Character> {
        return gateway.getCharacterById(idCharacter)
    }
}