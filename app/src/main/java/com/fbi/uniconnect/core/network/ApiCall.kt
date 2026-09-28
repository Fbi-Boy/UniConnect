package com.fbi.uniconnect.core.network

import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    retryPolicy: RetryPolicy = RetryPolicy(),
    block: suspend () -> T,
): NetworkResult<T> = withRetry(retryPolicy) {
    try {
        NetworkResult.Success(block())
    } catch (exception: HttpException) {
        NetworkResult.HttpError(exception.code(), exception.message())
    } catch (exception: IOException) {
        NetworkResult.NetworkError(exception)
    }
}
