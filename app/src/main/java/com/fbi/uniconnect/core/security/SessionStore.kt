package com.fbi.uniconnect.core.security

import kotlinx.coroutines.flow.Flow

interface SessionStore {
    val session: Flow<SessionToken?>
    suspend fun save(token: SessionToken)
    suspend fun clear()
}
