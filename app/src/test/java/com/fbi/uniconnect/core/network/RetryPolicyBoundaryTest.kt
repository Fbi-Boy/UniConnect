package com.fbi.uniconnect.core.network

import org.junit.Assert.assertEquals
import org.junit.Test

class RetryPolicyBoundaryTest {
    @Test fun oneAttemptMeansNoRetry() { assertEquals(1, RetryPolicy(maxAttempts = 1).maxAttempts) }
    @Test fun defaultPolicyUsesThreeAttempts() { assertEquals(3, RetryPolicy().maxAttempts) }
}
