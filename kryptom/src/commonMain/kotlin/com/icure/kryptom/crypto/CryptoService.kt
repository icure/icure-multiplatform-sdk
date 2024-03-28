package com.icure.kryptom.crypto

/**
 * Gives access to cryptographic functions.
 * Thread safe.
 */
expect val defaultCryptoService: CryptoService

/**
 * Interface which provides cryptographic functions.
 * Implementations must be thread safe.
 */
interface CryptoService {
	/**
	 * Cryptographic functions for AES.
	 */
	val aes: AesService

	/**
	 * Cryptographic functions for RSA.
	 */
	val rsa: RsaService

	/**
	 * Provides access to a cryptographically strong random generator.
	 * Thread safe.
	 */
	val strongRandom: StrongRandom

	val digest: DigestService

	val hmac: HmacService
}
