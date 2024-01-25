package com.icure.sdk.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService: CryptoService = object : CryptoService {
    override val aes: AesService = IosAesService

    override val rsa: RsaService = IosRsaService

    override val strongRandom: StrongRandom = IosStrongRandom

    override val digest: DigestService = IosDigestService

    override val hmac: HmacService = IosHmacService
}
