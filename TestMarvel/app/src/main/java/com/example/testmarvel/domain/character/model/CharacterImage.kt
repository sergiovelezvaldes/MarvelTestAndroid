package com.example.testmarvel.domain.character.model

data class CharacterImage(val path: String, val extension: String){
    override fun toString(): String {
        return path.plus(".").plus(extension)
    }
}


