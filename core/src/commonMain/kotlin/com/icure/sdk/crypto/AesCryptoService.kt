package com.icure.sdk.crypto

/**
 * Provides access to AES functions
 */
interface AesCryptoService {
    companion object {
        /**
         * Length of initialization vector for AES in bytes. This is equal to the block size.
         */
        const val IV_BYTE_LENGTH = 16

        /**
         * Valid key sizes for an aes key, in bytes
         */
        internal val validKeySizes = KeySize.values().map { it.byteSize }.toSet()

        /**
         * Specifies how big some data of size [dataSize] will be after encryption, excluding the initialization
         * vector size.
         * @param dataSize size of the input in bytes.
         * @return encrypted size of the input.
         */
        fun aesEncryptedSizeFor(dataSize: Int): Int =
            (dataSize / 16 + 1) * 16
    }

    /**
     * Possible sizes for aes keys.
     */
    enum class KeySize(val byteSize: Int) {
        AES_128(16), AES_192(24), AES_256(32);

        val bitSize: Int get() = byteSize * 8
    }

    /**
     * Generates a new aes key of the specified size (128 bits by default)
     * @param size size of the key.
     * @return the generated key.
     */
    fun generateKey(size: KeySize = KeySize.AES_128): AesKey

    /**
     * Converts an aes key into a byte array. The output can be used with [loadKey]
     * @param key the key to convert
     * @return a representation of the key as a byte array.
     */
    fun exportKey(key: AesKey): ByteArray

    /**
     * Loads an aes keys from a byte array. The byte array must have a size compatible with valid aes keys size.
     * @param bytes the byte representation of the aes key.
     * @return the loaded key.
     */
    fun loadKey(bytes: ByteArray): AesKey

    /**
     * Encrypts data using the provided key. The encryption algorithm is AES cbc with PKCS7 padding.
     * @param data the data to encrypt.
     * @param key the key to use for encryption.
     * @param iv (optional) an initialization vector. If not provided a new one will be generated by the implementation.
     * @return an array consisting of the concatenation of the initialization vector and the encrypted data.
     * @throws IllegalArgumentException if the key is invalid (for example if the size is not good for an aes key) or if
     * the initialization vector is not null and has a length different from [IV_BYTE_LENGTH]
     */
    fun encrypt(data: ByteArray, key: AesKey, iv: ByteArray? = null): ByteArray

    /**
     * Decrypts data which was encrypted with AES cbc with PKCS7 padding.
     * @param ivAndEncryptedData an array consisting of the concatenation of the initialization vector and the encrypted
     * data.
     * @param key the key to use for decryption.
     * @return the decrypted data.
     * @throws IllegalArgumentException if the key is invalid (for example if the size is not good for an aes key).
     * @throws AesDecryptionException if the decryption could not succeed for any reason.
     */
    fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey): ByteArray
}
