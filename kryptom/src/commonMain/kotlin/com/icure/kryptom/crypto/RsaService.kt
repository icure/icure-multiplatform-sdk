package com.icure.kryptom.crypto

/**
 * Provides access to RSA functions.
 */
interface RsaService {
	companion object {
		/**
		 * Most RSA encryption techniques use some padding. This class contains the size of padding for the supported
		 * algorithms.
		 */
		private object EncryptionPaddingSize {
			//Other paddings overhead (from https://crypto.stackexchange.com/questions/32692/what-is-the-typical-block-size-in-rsa)(
			//
			//RSA/ECB/PKCS1Padding, 11
			//RSA/ECB/NoPadding, 0
			//RSA/ECB/OAEPPadding, 42 // Actually it's OAEPWithSHA1AndMGF1Padding
			//RSA/ECB/OAEPWithMD5AndMGF1Padding, 34
			//RSA/ECB/OAEPWithSHA1AndMGF1Padding, 42
			//RSA/ECB/OAEPWithSHA224AndMGF1Padding, 58
			//RSA/ECB/OAEPWithSHA256AndMGF1Padding, 66
			//RSA/ECB/OAEPWithSHA384AndMGF1Padding, 98
			//RSA/ECB/OAEPWithSHA512AndMGF1Padding, 130
			//RSA/ECB/OAEPWithSHA3-224AndMGF1Padding, 58
			//RSA/ECB/OAEPWithSHA3-256AndMGF1Padding, 66
			//RSA/ECB/OAEPWithSHA3-384AndMGF1Padding, 98
			//RSA/ECB/OAEPWithSHA3-512AndMGF1Padding, 130

			/**
			 * Bytes overhead for OAEP padding with SHA1
			 */
			const val OAEP_WITH_SHA1 = 42

			/**
			 * Bytes overhead for OAEP padding with SHA256
			 */
			const val OAEP_WITH_SHA256 = 66
		}
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
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 -> EncryptionPaddingSize.OAEP_WITH_SHA1
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> EncryptionPaddingSize.OAEP_WITH_SHA256
		}
	}

	/**
	 * Generates a new rsa key pair, with default modulus length 2048.
	 * For security reasons the generated key should be used only for the provided algorithm.
	 * There is nothing in the underlying cryptographic algorithms that prevents you from using a
	 * key for various algorithms, but the actual implementations of the service may add metadata
	 * to keep track of the declared intended usage of the key and throw an exception when
	 * attempting to use the key for other purposes.
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
		data: ByteArray,
		publicKey: PublicRsaKey<A>
	): ByteArray

	/**
	 * Decrypts data using the provided key and algorithm.
	 */
	suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> decrypt(
		data: ByteArray,
		privateKey: PrivateRsaKey<A>
	): ByteArray

	/**
	 * Generates a signature for some data using the provided key and algorithm.
	 */
	suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> sign(
		data: ByteArray,
		privateKey: PrivateRsaKey<A>
	): ByteArray

	/**
	 * Verifies that a signature matches the provided data, using the provided key and algorithm.
	 */
	suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> verifySignature(
		signature: ByteArray,
		data: ByteArray,
		publicKey: PublicRsaKey<A>
	): Boolean
}