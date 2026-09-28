package com.fbi.uniconnect.core.network

import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(block: suspend () -> T): NetworkResult<T> = try {
    NetworkResult.Success(block())
} catch (exception: HttpException) {
    NetworkResult.HttpError(exception.code(), exception.message())
} catch (exception: IOException) {
    NetworkResult.NetworkError(exception)
}
