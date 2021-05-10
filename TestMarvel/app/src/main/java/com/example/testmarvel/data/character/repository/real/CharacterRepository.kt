package com.example.testmarvel.data.character.repository.real

import com.example.testmarvel.data.common.SafeApiRequest
import com.example.testmarvel.data.common.extensions.toCharacter
import com.example.testmarvel.data.common.extensions.toCharacters
import com.example.testmarvel.data.common.model.ResultRequest
import com.example.testmarvel.domain.character.gateways.CharacterGateway
import com.example.testmarvel.domain.character.model.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val remoteCharacterDataSource: RemoteCharacterDataSource) : SafeApiRequest(), CharacterGateway {

    override suspend fun getCharacters(): ResultRequest<List<Character>> {
        return when (val result = safeApiCall {remoteCharacterDataSource.getCharacters()}) {
            is ResultRequest.Success -> {
                ResultRequest.Success(result.data?.data?.results?.toCharacters())
            }
            is ResultRequest.Failure -> result
        }
    }

    override suspend fun getCharacterById(idCharacter: Int): ResultRequest<Character> {
        return when (val result = safeApiCall {remoteCharacterDataSource.getCharacterById(idCharacter)}) {
            is ResultRequest.Success -> {
                ResultRequest.Success(result.data?.data?.results?.get(0)?.toCharacter())
            }
            is ResultRequest.Failure -> result
        }
    }
}
