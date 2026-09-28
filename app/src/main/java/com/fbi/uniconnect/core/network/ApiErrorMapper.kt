package com.fbi.uniconnect.core.network

import java.io.IOException
import retrofit2.HttpException

fun Throwable.toNetworkError(): NetworkError = when (this) {
    is HttpException -> NetworkError.Http(code(), message())
    is IOException -> NetworkError.Connectivity(message ?: "Network connection failed.")
    else -> NetworkError.Unknown(message ?: "Unexpected error.")
}

fun NetworkError.userMessage(): String = when (this) {
    is NetworkError.Http -> when (code) {
        401 -> "Sesi login sudah berakhir. Silakan login kembali."
        403 -> "Anda tidak memiliki akses ke data ini."
        404 -> "Data yang diminta tidak ditemukan."
        408 -> "Server terlalu lama merespons."
        429 -> "Terlalu banyak permintaan. Coba lagi sebentar."
        in 500..599 -> "Server sedang bermasalah. Coba lagi nanti."
        else -> message ?: "Permintaan gagal."
    }
    is NetworkError.Connectivity -> "Tidak ada koneksi internet. Data lokal tetap dapat digunakan."
    is NetworkError.Unknown -> "Terjadi kesalahan yang tidak terduga."
}
