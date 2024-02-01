package com.icure.kryptom.crypto

/**
 * Provides access to AES functions
 */
interface AesService {
	companion object {
		/**
		 * Length of initialization vector for AES in bytes. This is equal to the block size.
		 */
		const val IV_BYTE_LENGTH = 16

		/**
		 * Valid key sizes for an aes key, in bytes
		 */
		internal val validKeySizes = KeySize.entries.map { it.byteSize }.toSet()

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
	 * @param bitSize Size in bits.
	 */
	enum class KeySize(val bitSize: Int) {
		// Currently not all platforms support AES-192
		AES_128(128), /* AES_192(192), */ AES_256(256);

		/**
		 * Size in bytes.
		 */
		val byteSize: Int get() = bitSize / 8
	}

	/**
	 * Generates a new aes key of the specified size (128 bits by default)
	 * @param size size of the key.
	 * @return the generated key.
	 */
	suspend fun generateKey(size: KeySize = KeySize.AES_256): AesKey

	/**
	 * Converts an aes key into a byte array. The output can be used with [loadKey]
	 * @param key the key to convert
	 * @return a representation of the key as a byte array.
	 */
	suspend fun exportKey(key: AesKey): ByteArray

	/**
	 * Loads an aes keys from a byte array. The byte array must have a size compatible with valid aes keys size.
	 * @param bytes the byte representation of the aes key.
	 * @return the loaded key.
	 */
	suspend fun loadKey(bytes: ByteArray): AesKey

	/**
	 * Encrypts data using the provided key. The encryption algorithm is AES cbc with PKCS7 padding.
	 * @param data the data to encrypt.
	 * @param key the key to use for encryption.
	 * @param iv (optional) an initialization vector. If not provided a new one will be generated by the implementation.
	 * @return an array consisting of the concatenation of the initialization vector and the encrypted data.
	 * @throws IllegalArgumentException if the key is invalid (for example if the size is not good for an aes key) or if
	 * the initialization vector is not null and has a length different from [IV_BYTE_LENGTH]
	 */
	suspend fun encrypt(data: ByteArray, key: AesKey, iv: ByteArray? = null): ByteArray

	/**
	 * Decrypts data which was encrypted with AES cbc with PKCS7 padding.
	 *
	 * ## Decryption with wrong key
	 *
	 * If the provided key is not the correct one the decryption may fail with an exception or may simply return an
	 * array of junk. Some implementations may never throw an error while others may only sometimes throw an error.
	 * There is no way of knowing with 100% accuracy if the provided key was correct, unless the decrypted data is
	 * expected to have a certain structure, in which case the caller may verify the correctness of the result.
	 *
	 * TLDR:
	 * - If the method throws an exception the provided key is wrong
	 * - If the method returns something either the provided key may be the correct key but may also not, in which case
	 * the returned result is just junk.
	 *
	 * @param ivAndEncryptedData an array consisting of the concatenation of the initialization vector and the encrypted
	 * data.
	 * @param key the key to use for decryption.
	 * @return the decrypted data.
	 * @throws IllegalArgumentException if the key is invalid (for example if the size is not good for an aes key).
	 */
	suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey): ByteArray
}
