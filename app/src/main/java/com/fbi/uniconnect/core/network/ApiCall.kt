package com.fbi.uniconnect.core.network

import com.fbi.uniconnect.core.security.SessionManager
import java.io.IOException
import javax.inject.Inject
import retrofit2.HttpException

class AuthenticatedApiCall @Inject constructor(
    private val sessionManager: SessionManager,
) {
    suspend fun <T> execute(
        nowEpochSeconds: Long,
        block: suspend (accessToken: String) -> T,
    ): NetworkResult<T> {
        val token = sessionManager.getValidToken(nowEpochSeconds)
            ?: return NetworkResult.HttpError(401, "Session expired or unavailable.")

        return try {
            NetworkResult.Success(block(token))
        } catch (exception: HttpException) {
            if (exception.code() == 401) {
                sessionManager.clear()
            }
            NetworkResult.HttpError(exception.code(), exception.message())
        } catch (exception: IOException) {
            NetworkResult.NetworkError(exception)
        }
    }
}

suspend fun <T> safeApiCall(block: suspend () -> T): NetworkResult<T> = try {
    NetworkResult.Success(block())
} catch (exception: HttpException) {
    NetworkResult.HttpError(exception.code(), exception.message())
} catch (exception: IOException) {
    NetworkResult.NetworkError(exception)
}
