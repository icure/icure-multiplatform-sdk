package com.icure.sdk.crypto

/**
 * Provides access to RSA functions
 */
interface RsaCryptoService {
    companion object {
        /**
         * Bytes overhead for OAEP padding with SHA1
         */
        private const val OAEP_WITH_SHA1_OVERHEAD = 42

        /**
         * Bytes overhead for OAEP padding with SHA256
         */
        private const val OAEP_WITH_SHA256_OVERHEAD = 66
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
         * Maximum size for data which can be encrypted with an RSA key of this size for the provided algorithm.
         */
        fun maxEncryptionSizeBytes(algorithm: RsaAlgorithm.RsaEncryptionAlgorithm) = byteSize - when (algorithm) {
            RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 -> OAEP_WITH_SHA1_OVERHEAD
            RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> OAEP_WITH_SHA256_OVERHEAD
        }
    }

    /**
     * Generates a new rsa key pair, with default modulus length 2048.
     * For security reasons the generated key should be used only for the provided algorithm, although there is no
     * characteristic of the key pair itself which prevents from using the keys for other algorithms.
     * For more info see https://crypto.stackexchange.com/questions/81819/same-private-key-for-signing-and-decryption
     */
    suspend fun <A : RsaAlgorithm> generateKeyPair(algorithm: A, keySize: KeySize = KeySize.RSA_2048): RsaKeypair<A>

    /**
     * Exports the private key in pkcs8 format.
     * @param key the key to export.
     * @return representation of the key in pkcs8 format.
     */
    suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray

    /**
     * Exports the public key in pkcs8 format.
     * @param key the key to export.
     * @return representation of the key in spki format (java X.509).
     */
    suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray

    /**
     * Loads the rsa keypair given the PKCS8 representation of the private key. Note that there is no way to guarantee
     * that the provided algorithm matches the algorithm chosen on key generation.
     */
    suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A>


    /**
     * Loads the rsa public key given the spki representation (java X.509) of the public key. Note that there is no way
     * to guarantee that the provided algorithm matches the algorithm chosen on key generation.
     */
    suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A>

    /**
     * Encrypts data using the provided key and algorithm. There are limits to the size of data which can be encrypted
     * depending on the chosen algorithm and key size.
     */
    suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> encrypt(
        algorithm: A,
        data: ByteArray,
        publicKey: PublicRsaKey<A>
    ): ByteArray

    /**
     * Decrypts data using the provided key and algorithm.
     */
    suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> decrypt(
        algorithm: A,
        data: ByteArray,
        privateKey: PrivateRsaKey<A>
    ): ByteArray

    /**
     * Generates a signature for some data using the provided key and algorithm.
     */
    suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> sign(
        algorithm: A,
        data: ByteArray,
        privateKey: PrivateRsaKey<A>
    ): ByteArray

    /**
     * Verifies that a signature matches the provided data, using the provided key and algorithm.
     */
    suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> verifySignature(
        algorithm: A,
        signature: ByteArray,
        data: ByteArray,
        publicKey: PublicRsaKey<A>
    ): Boolean
}