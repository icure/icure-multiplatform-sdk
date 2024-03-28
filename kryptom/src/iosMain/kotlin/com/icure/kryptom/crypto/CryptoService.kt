package com.icure.kryptom.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val defaultCryptoService: CryptoService = object : CryptoService {
	override val aes: AesService = IosAesService

	override val rsa: RsaService = IosRsaService

	override val strongRandom: StrongRandom = IosStrongRandom

	override val digest: DigestService = IosDigestService

	override val hmac: HmacService = IosHmacService
}
