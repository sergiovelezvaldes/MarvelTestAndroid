package com.example.testmarvel.data.character.model

import com.example.testmarvel.domain.character.model.CharacterImage

data class CharacterBody(val id: Int, val name: String, val description: String, val thumbnail: CharacterImage? = null)