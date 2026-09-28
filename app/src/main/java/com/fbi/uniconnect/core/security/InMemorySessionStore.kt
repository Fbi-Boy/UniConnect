package com.fbi.uniconnect.core.security

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Singleton
class InMemorySessionStore @Inject constructor() : SessionStore {
    private val state = MutableStateFlow<SessionToken?>(null)

    override val session: Flow<SessionToken?> = state.asStateFlow()

    override suspend fun save(token: SessionToken) {
        state.value = token
    }

    override suspend fun clear() {
        state.value = null
    }
}
