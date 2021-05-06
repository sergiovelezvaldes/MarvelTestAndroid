package com.example.testmarvel.domain.character.model

data class Character(val id: Int, val name: String, val description: String, val thumbnail: CharacterImage? = null)