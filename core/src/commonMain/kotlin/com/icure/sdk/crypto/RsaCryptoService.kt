package com.icure.sdk.crypto

/**
 * Provides access to RSA functions
 */
interface RsaCryptoService {
    companion object {
        /**
         * Bytes overhead for OAEP padding with SHA1
         */
        private const val SHA1_OAEP_OVERHEAD = 42
    }

    /**
     * Possible sizes for aes keys.
     * @param bitSize Size in bits.
     */
    enum class KeySize(val bitSize: Int) {
        RSA_2048(2048), RSA_4096(4096);

        /**
         * Size in bytes.
         */
        val byteSize get() = bitSize / 8

        /**
         * Maximum size for data which can be encrypted with an RSA key of this size if using RSA-OAEP as specified in
         * RFC 3447.
         */
        val maxOaepEncryptionSizeBytes get() = byteSize - SHA1_OAEP_OVERHEAD
    }

    /**
     * Generates a new rsa key pair, with modulus length 2048.
     */
    fun generateKeyPair(keySize: KeySize = KeySize.RSA_2048): RsaKeypair

    /**
     * Exports the private key in pkcs8 format.
     * @param key the key to export.
     * @return representation of the key in pkcs8 format.
     */
    fun exportPrivateKeyPkcs8(key: PrivateRsaKey): ByteArray

    /**
     * Exports the public key in pkcs8 format.
     * @param key the key to export.
     * @return representation of the key in spki format (java X.509).
     */
    fun exportPublicKeySpki(key: PublicRsaKey): ByteArray

    /**
     * Loads the rsa keypair given the PKCS8 representation of the private key.
     */
    fun loadKeyPairPkcs8(privateKeyPkcs8: ByteArray): RsaKeypair


    /**
     * Loads the rsa public key given the spki representation (java X.509) of the public key.
     */
    fun loadPublicKeySpki(publicKeySpki: ByteArray): PublicRsaKey

    /**
     * Encrypts data using RSA-OAEP public-key encryption as specified in RFC 3447
     */
    fun encrypt(data: ByteArray, publicKey: PublicRsaKey): ByteArray

    /**
     * Decrypts data using RSA-OAEP public-key decryption as specified in RFC 3447
     */
    fun decrypt(data: ByteArray, privateKey: PrivateRsaKey): ByteArray
}