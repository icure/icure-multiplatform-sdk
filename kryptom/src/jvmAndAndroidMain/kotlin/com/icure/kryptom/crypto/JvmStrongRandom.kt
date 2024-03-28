package com.icure.kryptom.crypto

import java.security.SecureRandom
import java.util.UUID

/**
 * Provides access to a cryptographically secure random generator.
 * Thread safe.
 */
object JvmStrongRandom : StrongRandom {
	private val random = SecureRandom()

	override fun fill(array: ByteArray) {
		random.nextBytes(array)
	}

	// UUID.randomUUID is cryptographically strong by contract
	// https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html#randomUUID--
	// https://developer.android.com/reference/java/util/UUID#randomUUID()
	override fun randomUUID(): String =
		UUID.randomUUID().toString()
}