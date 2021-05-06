package com.example.testmarvel.domain.character.usecases

import com.example.testmarvel.data.common.model.ResultRequest
import com.example.testmarvel.domain.character.gateways.CharacterGateway
import com.example.testmarvel.domain.character.model.Character
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val gateway: CharacterGateway) {
    suspend fun execute(): ResultRequest<List<Character>>{
        return gateway.getCharacters()
    }
}