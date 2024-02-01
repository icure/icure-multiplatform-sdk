package com.icure.kryptom.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val defaultCryptoService = object : CryptoService {
	init {
		initCryptoProvider()
	}

	override val aes: AesService = JvmAesService

	override val rsa: RsaService = JvmRsaService

	override val strongRandom: StrongRandom = JvmStrongRandom

	override val digest: DigestService = JvmDigestService

	override val hmac: HmacService = JvmHmacService
}

expect fun initCryptoProvider()