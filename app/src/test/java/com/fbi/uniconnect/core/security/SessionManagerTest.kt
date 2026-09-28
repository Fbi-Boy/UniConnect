package com.fbi.uniconnect.core.security

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SessionManagerTest {
    @Test
    fun establishAndReadToken() = runTest {
        val manager = SessionManager(InMemorySessionStore())
        manager.establish("token-123", 200)
        assertEquals("token-123", manager.getValidToken(100))
    }

    @Test
    fun expiredTokenIsCleared() = runTest {
        val manager = SessionManager(InMemorySessionStore())
        manager.establish("token-123", 200)
        assertNull(manager.getValidToken(200))
        assertNull(manager.getValidToken(201))
    }

    @Test(expected = IllegalArgumentException::class)
    fun blankTokenIsRejected() = runTest {
        SessionManager(InMemorySessionStore()).establish("")
    }
}
