package com.icure.sdk.crypto

import java.security.SecureRandom
import java.util.UUID

/**
 * Provides access to a cryptographically secure random generator.
 * Thread safe.
 */
actual val strongRandom = object : StrongRandom {
    val random = SecureRandom()

    override fun randomBytes(length: Int): ByteArray =
        ByteArray(length).also { random.nextBytes(it) }

    // UUID.randomUUID is cryptographically strong by contract
    // https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html#randomUUID--
    override fun randomUUID(): String =
        UUID.randomUUID().toString()
}