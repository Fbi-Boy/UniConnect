package com.fbi.uniconnect.core.security

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class SessionManager @Inject constructor(
    private val store: SessionStore,
) {
    val session: Flow<SessionToken?> = store.session

    suspend fun establish(accessToken: String, expiresAtEpochSeconds: Long? = null) {
        require(accessToken.isNotBlank()) { "Access token cannot be blank." }
        store.save(SessionToken(accessToken, expiresAtEpochSeconds))
    }

    suspend fun clear() = store.clear()

    suspend fun getValidToken(nowEpochSeconds: Long): String? {
        var token: SessionToken? = null
        store.session.collect { current ->
            token = current
            return@collect
        }
        val current = token ?: return null
        if (current.expiresAtEpochSeconds != null && current.expiresAtEpochSeconds <= nowEpochSeconds) {
            clear()
            return null
        }
        return current.accessToken
    }
}
