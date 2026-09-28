package com.fbi.uniconnect.core.network

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class RetryPolicyTest {
    @Test
    fun transientFailureRetriesUntilSuccess() = runTest {
        var calls = 0
        val result = withRetry(RetryPolicy(maxAttempts = 3, initialDelayMillis = 0)) {
            calls++
            if (calls < 3) NetworkResult.NetworkError(IllegalStateException("offline"))
            else NetworkResult.Success("ok")
        }
        assertEquals(3, calls)
        assertEquals(NetworkResult.Success("ok"), result)
    }

    @Test
    fun clientErrorIsNotRetried() = runTest {
        var calls = 0
        val result = withRetry(RetryPolicy(initialDelayMillis = 0)) {
            calls++
            NetworkResult.HttpError(400, "bad request")
        }
        assertEquals(1, calls)
        assertEquals(NetworkResult.HttpError(400, "bad request"), result)
    }

    @Test
    fun serverErrorStopsAtMaximumAttempts() = runTest {
        var calls = 0
        val result = withRetry(RetryPolicy(maxAttempts = 2, initialDelayMillis = 0)) {
            calls++
            NetworkResult.HttpError(503, "server")
        }
        assertEquals(2, calls)
        assertEquals(NetworkResult.HttpError(503, "server"), result)
    }
}
