package com.fbi.uniconnect.core.network

import org.junit.Assert.assertTrue
import org.junit.Test

class NetworkErrorTest {
    @Test fun connectivityIsRetryable() { assertTrue(NetworkError.Connectivity("offline").isRetryable()) }
    @Test fun serverHttpErrorIsRetryable() { assertTrue(NetworkError.Http(503, "server").isRetryable()) }
}
