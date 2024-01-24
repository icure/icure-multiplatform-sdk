package com.icure.sdk.crypto

/**
 * Gives access to cryptographic functions.
 * Thread safe.
 */
expect val cryptoService: CryptoService

/**
 * Interface which provides cryptographic functions.
 * Implementations must be thread safe.
 */
interface CryptoService {
    /**
     * Cryptographic functions for AES.
     */
    val aes: AesCryptoService

    /**
     * Cryptographic functions for RSA.
     */
    val rsa: RsaCryptoService

    /**
     * Provides access to a cryptographically strong random generator.
     * Thread safe.
     */
    val strongRandom: StrongRandom
}
