package com.example.testmarvel.data.common

import com.example.testmarvel.data.common.model.ErrorCode
import com.example.testmarvel.data.common.model.ErrorResponse
import com.example.testmarvel.data.common.model.ResultRequest
import retrofit2.HttpException
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): ResultRequest<T> {
        return try {
            val apiResponse = call.invoke()
            if (apiResponse.isSuccessful && apiResponse.code() == 200) {
                ResultRequest.Success(apiResponse.body())
            } else {
                ResultRequest.Failure(ErrorResponse(ErrorCode.BAD_RESPONSE, apiResponse.code().toString()))
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    ResultRequest.Failure(ErrorResponse(ErrorCode.NO_NETWORK, throwable.cause.toString()))
                }
                else -> {
                    ResultRequest.Failure(
                        ErrorResponse(
                            ErrorCode.UNKNOWN,
                            throwable.cause.toString()
                        )
                    )
                }
            }
        }
    }
}