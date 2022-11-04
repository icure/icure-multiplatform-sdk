package com.icure.sdk.crypto

/**
 * Provides access to RSA functions
 */
interface RsaCryptoService {
    fun generateKeyPair(): RsaKeypair

    fun exportPkcs8(key: PrivateRsaKey): ByteArray

    /**
     * Loads the rsa keypair given the PKCS8 representation
     */
    fun loadKeyPair(privateKeyPkcs8: ByteArray): RsaKeypair

    fun encrypt(data: ByteArray, key: PublicRsaKey): ByteArray

    fun decrypt(data: ByteArray, key: PrivateRsaKey): ByteArray
}