package com.icure.sdk.crypto

import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService = object : CryptoService {
    init { Security.addProvider(BouncyCastleProvider()) }

    override val aes: AesCryptoService = JavaAesCryptoService
    override val rsa: RsaCryptoService get() = TODO("Not yet implemented")
}
