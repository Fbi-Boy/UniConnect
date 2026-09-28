package com.fbi.uniconnect.core.security

data class SessionToken(
    val accessToken: String,
    val expiresAtEpochSeconds: Long? = null,
)
