package com.icure.sdk.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService: CryptoService = object : CryptoService {
    override val aes: AesCryptoService = IosAesCryptoService

    override val rsa: RsaCryptoService = IosRsaCryptoService

    override val strongRandom: StrongRandom = IosStrongRandom
}
