package com.fbi.uniconnect.core.network

import java.io.IOException
import org.junit.Assert.assertEquals
import org.junit.Test

class ApiErrorMapperTest {
    @Test fun ioExceptionMapsToConnectivityError() { assertEquals(NetworkError.Connectivity("offline"), IOException("offline").toNetworkError()) }
    @Test fun unexpectedExceptionMapsToUnknownError() { assertEquals(NetworkError.Unknown("boom"), IllegalStateException("boom").toNetworkError()) }
}
