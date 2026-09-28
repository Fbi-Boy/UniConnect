package com.fbi.uniconnect.data.remote

import retrofit2.http.GET

interface UniConnectApi {
    @GET("health")
    suspend fun health(): HealthResponse
}

@kotlinx.serialization.Serializable
data class HealthResponse(
    val status: String,
)
