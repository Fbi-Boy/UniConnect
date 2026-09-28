package com.fbi.uniconnect.core.network

sealed interface NetworkError {
    data class Http(val code: Int, val message: String?) : NetworkError
    data class Connectivity(val message: String) : NetworkError
    data class Unknown(val message: String) : NetworkError
}

fun NetworkResult<*>.errorOrNull(): NetworkError? = when (this) {
    is NetworkResult.Success -> null
    is NetworkResult.HttpError -> NetworkError.Http(code, message)
    is NetworkResult.NetworkError -> NetworkError.Connectivity(
        exception.message ?: "Network connection failed.",
    )
}

fun NetworkError.isRetryable(): Boolean = when (this) {
    is NetworkError.Http -> code == 408 || code == 429 || code in 500..599
    is NetworkError.Connectivity -> true
    is NetworkError.Unknown -> false
}
