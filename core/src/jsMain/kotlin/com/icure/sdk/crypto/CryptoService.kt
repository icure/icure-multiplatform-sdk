package com.icure.sdk.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService: CryptoService = object : CryptoService {
    override val aes: AesCryptoService = JsAesCryptoService

    override val rsa: RsaCryptoService get() = TODO("Not yet implemented")
}

