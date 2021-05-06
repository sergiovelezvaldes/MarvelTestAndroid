package com.example.testmarvel.data.common.model

sealed class ResultRequest<out T> {
    data class Success<out T>(val data: T?) : ResultRequest<T>()
    data class Failure(val errorData: ErrorResponse?) : ResultRequest<Nothing>()
}