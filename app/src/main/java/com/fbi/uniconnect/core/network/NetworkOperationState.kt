package com.fbi.uniconnect.core.network

sealed interface NetworkOperationState<out T> {
    data object Idle : NetworkOperationState<Nothing>
    data object Loading : NetworkOperationState<Nothing>
    data class Success<T>(val data: T) : NetworkOperationState<T>
    data class Error(val error: NetworkError) : NetworkOperationState<Nothing>
}
