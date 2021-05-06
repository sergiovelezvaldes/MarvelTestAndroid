package com.example.testmarvel.ui.common.model

import com.example.testmarvel.data.common.model.ErrorResponse

sealed class ViewState<T> {
    data class Loading<T>(val data: T?) : ViewState<T>()
    data class Data<T>(val data: T) : ViewState<T>()
    data class Failure<T>(val error: ErrorResponse) : ViewState<T>()
}