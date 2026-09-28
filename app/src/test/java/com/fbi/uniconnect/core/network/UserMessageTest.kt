package com.fbi.uniconnect.core.network

import org.junit.Assert.assertEquals
import org.junit.Test

class UserMessageTest {
    @Test fun unauthorizedMessageRequestsLogin() { assertEquals("Sesi login sudah berakhir. Silakan login kembali.", NetworkError.Http(401, null).userMessage()) }
    @Test fun connectivityMessageExplainsOfflineFallback() { assertEquals("Tidak ada koneksi internet. Data lokal tetap dapat digunakan.", NetworkError.Connectivity("offline").userMessage()) }
}
