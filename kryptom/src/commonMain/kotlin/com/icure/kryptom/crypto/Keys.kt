package com.icure.kryptom.crypto

/**
 * Represents an RSA algorithm. Only encryption and signature algorithms defined here are supported.
 */
sealed interface RsaAlgorithm {
	/**
	 * Represents an RSA encryption algorithm.
	 */
	sealed interface RsaEncryptionAlgorithm : RsaAlgorithm {
		/**
		 * RSA-OAEP public-key as specified in RFC 3447, using sha-1 for the padding
		 */
		data object OaepWithSha1 : RsaEncryptionAlgorithm
		data object OaepWithSha256 : RsaEncryptionAlgorithm
	}

	/**
	 * Represents an RSA signature algorithm.
	 */
	sealed interface RsaSignatureAlgorithm : RsaAlgorithm {
		data object PssWithSha256 : RsaSignatureAlgorithm
	}
}

/**
 * Represents a private rsa key. Each key should be used only for a specific algorithm, which is represented by [A].
 */
expect class PrivateRsaKey<A : RsaAlgorithm>

/**
 * Represents a public rsa key. Each key should be used only for a specific algorithm, which is represented by [A].
 */
expect class PublicRsaKey<A : RsaAlgorithm>

/**
 * Represents an rsa key pair.
 * @param private a private rsa key.
 * @param public the public rsa key corresponding to the private key.
 */
data class RsaKeypair<A : RsaAlgorithm>(val private: PrivateRsaKey<A>, val public: PublicRsaKey<A>)

/**
 * Represents an aes key.
 */
expect class AesKey

sealed interface HmacAlgorithm {
	/**
	 * The recommended key size for this algorithm in bytes. Since some platform implementations of cryptographic
	 * libraries only allow key of the recommended size this will always be the actual key size used.
	 */
	val recommendedKeySize: Int

	/**
	 * The size of the digest produced by this algorithm in bytes.
	 */
	val digestSize: Int

	/**
	 * Hmac with sha 512.
	 */
	data object HmacSha512 : HmacAlgorithm {
		override val recommendedKeySize: Int = 128
		override val digestSize: Int = 64
	}
}

expect class HmacKey<A : HmacAlgorithm>
