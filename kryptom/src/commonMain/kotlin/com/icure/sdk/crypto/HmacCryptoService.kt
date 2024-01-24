package com.icure.sdk.crypto

interface HmacCryptoService {
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
    suspend fun <A : HmacAlgorithm> sign(algorithm: A, data: ByteArray, key: HmacKey<A>): ByteArray

    /**
     * Verifies that a signature matches the provided data, using the provided key and algorithm.
     */
    suspend fun <A : HmacAlgorithm> verify(algorithm: A, signature: ByteArray, data: ByteArray, key: HmacKey<A>): Boolean
}