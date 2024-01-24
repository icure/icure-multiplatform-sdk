package com.icure.sdk.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService = object : CryptoService {
    init { initCryptoProvider() }

    override val aes: AesCryptoService = JvmAesCryptoService

    override val rsa: RsaCryptoService = JvmRsaCryptoService

    override val strongRandom: StrongRandom = JvmStrongRandom
}

expect fun initCryptoProvider()