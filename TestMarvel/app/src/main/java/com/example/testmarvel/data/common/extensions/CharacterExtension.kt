package com.example.testmarvel.data.common.extensions

import com.example.testmarvel.data.character.model.CharacterBody
import com.example.testmarvel.domain.character.model.Character

fun CharacterBody.toCharacter() = Character(
        id = this.id,
        name =  this.name,
        description = this.description,
        thumbnail = this.thumbnail.toString()
)

fun List<CharacterBody>.toCharacters() = this.map { Character(
        id = it.id,
        name =  it.name,
        description = it.description,
        thumbnail = it.thumbnail.toString())}
