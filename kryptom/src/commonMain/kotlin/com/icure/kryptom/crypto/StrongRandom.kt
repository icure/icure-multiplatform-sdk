package com.icure.kryptom.crypto

import com.icure.kryptom.utils.toHexString

/**
 * Cryptographically strong random generator. The implementation must be thread safe.
 */
interface StrongRandom {
	/**
	 * Generates a sequence of random bytes.
	 * @param length amount of bytes to generate
	 * @return the generated bytes.
	 */
	fun randomBytes(length: Int): ByteArray

	/**
	 * Generates a random UUID.
	 * @return string representation of the uuid.
	 */
	@OptIn(ExperimentalUnsignedTypes::class)
	fun randomUUID(): String {
		val bytes = randomBytes(16).toUByteArray()
		// Set version 4
		bytes[6] = (bytes[6] and 0x0fu) or 0x40u
		// Set IETF variant
		bytes[8] = (bytes[8] and 0x3fu) or 0x80u
		val s = bytes.toHexString()
		return "${s.substring(0, 8)}-${s.substring(8, 12)}-${s.substring(12, 16)}-${s.substring(16, 20)}-${
			s.substring(
				20
			)
		}"
	}
}
