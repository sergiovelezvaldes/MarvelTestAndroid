package com.example.testmarvel.data.common.model

enum class ErrorCode {
    UNAUTHORIZED,
    NOT_FOUND,
    NO_NETWORK,
    BAD_RESPONSE,
    NOT_CONTENT,
    UNKNOWN
}

data class ErrorResponse(
    val code: ErrorCode = ErrorCode.UNKNOWN,
    val error: String = "",
    val message: String = ""
) {
    override fun toString(): String {
        return code.name + " - " + error + ": " + message
    }
}