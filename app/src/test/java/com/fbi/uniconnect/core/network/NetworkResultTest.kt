package com.fbi.uniconnect.core.network

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkResultTest {
    @Test
    fun safeApiCall_returns_success() = runTest {
        val result = safeApiCall { "ok" }
        assertEquals(NetworkResult.Success("ok"), result)
    }

    @Test
    fun safeApiCall_maps_network_exception() = runTest {
        val result = safeApiCall<String> { throw java.io.IOException("offline") }
        assertEquals("offline", (result as NetworkResult.NetworkError).exception.message)
    }
}
