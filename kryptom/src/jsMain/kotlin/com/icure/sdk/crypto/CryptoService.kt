package com.icure.sdk.crypto

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService: CryptoService = object : CryptoService {
    override val aes: AesService = JsAesService

    override val rsa: RsaService = JsRsaService

    override val strongRandom: StrongRandom  = JsStrongRandom

    override val digest: DigestService = JsDigestService

    override val hmac: HmacService = JsHmacService
}

