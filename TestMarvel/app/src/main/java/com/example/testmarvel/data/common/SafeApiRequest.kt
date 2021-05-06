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
                //Todo: Error Handling
                ResultRequest.Failure(ErrorResponse(ErrorCode.UNKNOWN, ""))
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    //Todo: Error Handling Http
                    ResultRequest.Failure(ErrorResponse(ErrorCode.UNKNOWN, ""))
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