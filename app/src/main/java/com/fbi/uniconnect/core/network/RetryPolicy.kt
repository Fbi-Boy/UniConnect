package com.fbi.uniconnect.core.network

import kotlinx.coroutines.delay

data class RetryPolicy(
    val maxAttempts: Int = 3,
    val initialDelayMillis: Long = 500L,
    val maxDelayMillis: Long = 4_000L,
)

suspend fun <T> withRetry(
    policy: RetryPolicy = RetryPolicy(),
    operation: suspend () -> NetworkResult<T>,
): NetworkResult<T> {
    var attempt = 0
    while (true) {
        val result = operation()
        val retryable = when (result) {
            is NetworkResult.Success -> false
            is NetworkResult.HttpError -> result.code == 408 || result.code == 429 || result.code in 500..599
            is NetworkResult.NetworkError -> true
        }
        if (!retryable || attempt >= policy.maxAttempts - 1) return result
        val multiplier = 1L shl attempt.coerceIn(0, 20)
        delay((policy.initialDelayMillis * multiplier).coerceAtMost(policy.maxDelayMillis))
        attempt++
    }
}
