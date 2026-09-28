package com.fbi.uniconnect.core.network

import com.fbi.uniconnect.core.security.InMemorySessionStore
import com.fbi.uniconnect.core.security.SessionManager
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthenticatedApiCallTest {
    @Test
    fun missingSession_returnsUnauthorized() = runTest {
        val call = AuthenticatedApiCall(SessionManager(InMemorySessionStore()))
        val result = call.execute(100) { "unused" }
        assertTrue(result is NetworkResult.HttpError)
        assertEquals(401, (result as NetworkResult.HttpError).code)
    }

    @Test
    fun validSession_passesAccessTokenToRequest() = runTest {
        val manager = SessionManager(InMemorySessionStore())
        manager.establish("token-123", 200)
        val call = AuthenticatedApiCall(manager)
        val result = call.execute(100) { token -> "Bearer $token" }
        assertEquals("Bearer token-123", (result as NetworkResult.Success).data)
    }
}
