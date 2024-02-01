package com.icure.kryptom.crypto

interface HmacService {
	/**
	 * Generates a new hmac key for a specific algorithm. The key size is determined by the algorithm.
	 */
	suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A>

	/**
	 * Exports a key to a byte array.
	 */
	suspend fun exportKey(key: HmacKey<*>): ByteArray

	/**
	 * Imports a key from a byte array. The key size must match the algorithm.
	 */
	suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A>

	/**
	 * Generates a signature for some data using the provided key and algorithm.
	 */
	suspend fun sign(data: ByteArray, key: HmacKey<*>): ByteArray

	/**
	 * Verifies that a signature matches the provided data, using the provided key and algorithm.
	 */
	suspend fun verify(
		signature: ByteArray,
		data: ByteArray,
		key: HmacKey<*>
	): Boolean
}