package com.icure.sdk.crypto

import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

/**
 * Gives access to cryptographic functions.
 */
actual val cryptoService = object : CryptoService {
    init { Security.addProvider(BouncyCastleProvider()) }

    override val aes: AesCryptoService = JvmAesCryptoService

    override val rsa: RsaCryptoService = JvmRsaCryptoService
}
