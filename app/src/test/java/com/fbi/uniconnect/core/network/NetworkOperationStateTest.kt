package com.fbi.uniconnect.core.network

import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkOperationStateTest {
    @Test fun idleStateIsStable() { assertEquals(NetworkOperationState.Idle, NetworkOperationState.Idle) }
    @Test fun loadingStateIsStable() { assertEquals(NetworkOperationState.Loading, NetworkOperationState.Loading) }
}
