package com.icure.kryptom.crypto

/**
 * Represents an RSA algorithm. Only encryption and signature algorithms defined here are supported.
 */
sealed interface RsaAlgorithm {
	/**
	 * Unique identifier for the algorithm
	 */
	val identifier: String

	/**
	 * Identifier for the algorithm in JWK format
	 */
	val jwkIdentifier: String

	/**
	 * Represents an RSA encryption algorithm.
	 */
	sealed interface RsaEncryptionAlgorithm : RsaAlgorithm {

		companion object {
			/**
			 * Get an encryption algorithm from its identifier.
			 * @param identifier the identifier of the algorithm.
			 * @return the algorithm.
			 * @throws IllegalArgumentException if the identifier is unknown.
			 */
			@Throws(IllegalArgumentException::class)
			fun fromIdentifier(identifier: String): RsaEncryptionAlgorithm = when (identifier) {
				Identifiers.Encryption.RSA_OAEP_SHA1 -> OaepWithSha1
				Identifiers.Encryption.RSA_OAEP_SHA256 -> OaepWithSha256
				else -> throw IllegalArgumentException("Unknown rsa encryption algorithm $identifier")
			}
		}

		/**
		 * RSA-OAEP public-key as specified in RFC 3447, using sha-1 for the padding
		 */
		data object OaepWithSha1 : RsaEncryptionAlgorithm {
			override val identifier: String = Identifiers.Encryption.RSA_OAEP_SHA1
			override val jwkIdentifier: String = Identifiers.Jwk.Encryption.RSA_OAEP_SHA1
		}
		data object OaepWithSha256 : RsaEncryptionAlgorithm {
			override val identifier: String = Identifiers.Encryption.RSA_OAEP_SHA256
			override val jwkIdentifier: String = Identifiers.Jwk.Encryption.RSA_OAEP_SHA256
		}
	}

	/**
	 * Represents an RSA signature algorithm.
	 */
	sealed interface RsaSignatureAlgorithm : RsaAlgorithm {
		companion object {
			/**
			 * Get a signature algorithm from its identifier.
			 * @param identifier the identifier of the algorithm.
			 * @return the algorithm.
			 * @throws IllegalArgumentException if the identifier is unknown.
			 */
			@Throws(IllegalArgumentException::class)
			fun fromIdentifier(identifier: String): RsaSignatureAlgorithm = when (identifier) {
				Identifiers.Signature.RSA_PSS_SHA256 -> PssWithSha256
				else -> throw IllegalArgumentException("Unknown rsa signature algorithm $identifier")
			}
		}
		data object PssWithSha256 : RsaSignatureAlgorithm {
			override val identifier: String = Identifiers.Signature.RSA_PSS_SHA256
			override val jwkIdentifier: String = Identifiers.Jwk.Decryption.RSA_PSS_SHA256
		}
	}

	companion object {
		private object Identifiers {
			object Encryption {
				const val RSA_OAEP_SHA1 = "OaepWithSha1"
				const val RSA_OAEP_SHA256 = "OaepWithSha256"
			}
			object Signature {
				const val RSA_PSS_SHA256 = "PssWithSha256"
			}
			object Jwk {
				object Encryption {
					const val RSA_OAEP_SHA1 = "RSA-OAEP"
					const val RSA_OAEP_SHA256 = "RSA-OAEP-256"
				}
				object Decryption {
					const val RSA_PSS_SHA256 = "PS256"
				}
			}
		}

		/**
		 * Get an algorithm from its identifier.
		 * @param identifier the identifier of the algorithm.
		 * @return the algorithm.
		 * @throws IllegalArgumentException if the identifier is unknown.
		 */
		@Throws(IllegalArgumentException::class)
		fun fromIdentifier(identifier: String): RsaAlgorithm = when (identifier) {
			Identifiers.Encryption.RSA_OAEP_SHA1 -> RsaEncryptionAlgorithm.OaepWithSha1
			Identifiers.Encryption.RSA_OAEP_SHA256 -> RsaEncryptionAlgorithm.OaepWithSha256
			Identifiers.Signature.RSA_PSS_SHA256 -> RsaSignatureAlgorithm.PssWithSha256
			else -> throw IllegalArgumentException("Unknown rsa algorithm $identifier")
		}

		/**
		 * Get an algorithm from its JWK identifier.
		 * @param jwkIdentifier the JWK identifier of the algorithm (from [PublicRsaKeyJwk.alg] or
		 * [PrivateRsaKeyJwk.alg]).
		 * @return the algorithm.
		 */
		@Throws(IllegalArgumentException::class)
		fun fromJwkIdentifier(jwkIdentifier: String): RsaAlgorithm = when (jwkIdentifier) {
			Identifiers.Jwk.Encryption.RSA_OAEP_SHA1 -> RsaEncryptionAlgorithm.OaepWithSha1
			Identifiers.Jwk.Encryption.RSA_OAEP_SHA256 -> RsaEncryptionAlgorithm.OaepWithSha256
			Identifiers.Jwk.Decryption.RSA_PSS_SHA256 -> RsaSignatureAlgorithm.PssWithSha256
			else -> throw IllegalArgumentException("Unknown/unsupported rsa jwk algorithm $jwkIdentifier")
		}
	}
}

/**
 * Marker interface for a rsa key or key pair.
 */
interface RsaKey

/**
 * Represents a private rsa key. Each key should be used only for a specific algorithm, which is represented by [A].
 */
expect class PrivateRsaKey<out A : RsaAlgorithm> : RsaKey {
	val algorithm: A
}

/**
 * Represents a public rsa key. Each key should be used only for a specific algorithm, which is represented by [A].
 */
expect class PublicRsaKey<out A : RsaAlgorithm> : RsaKey {
	val algorithm: A
}

/**
 * Represents an rsa key pair.
 * @param private a private rsa key.
 * @param public the public rsa key corresponding to the private key.
 */
data class RsaKeypair<out A : RsaAlgorithm>(val private: PrivateRsaKey<A>, val public: PublicRsaKey<A>) : RsaKey {
	init {
		require(private.algorithm == public.algorithm) { "Private and public keys must have the same algorithm" }
	}

	val algorithm: A get() = private.algorithm
}

/**
 * Represents an aes algorithm.
 */
sealed interface AesAlgorithm {
	val identifier: String

	/**
	 * Aes cbc encryption algorithm with pkcs7 padding.
	 */
	data object CbcWithPkcs7Padding : AesAlgorithm {
		override val identifier: String = Identifiers.CBC_PKCS7
	}

	companion object {
		private object Identifiers {
			const val CBC_PKCS7 = "AesCbcPkcs7"
		}

		/**
		 * Get an algorithm from its identifier.
		 * @param identifier the identifier of the algorithm.
		 * @return the algorithm.
		 * @throws IllegalArgumentException if the identifier is unknown.
		 */
		@Throws(IllegalArgumentException::class)
		fun fromIdentifier(identifier: String): AesAlgorithm = when (identifier) {
			Identifiers.CBC_PKCS7 -> CbcWithPkcs7Padding
			else -> throw IllegalArgumentException("Unknown aes algorithm $identifier")
		}
	}
}

/**
 * Represents an aes key.
 */
expect class AesKey<out A : AesAlgorithm> {
	val algorithm: A
}

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
	 * Unique identifier for the algorithm
	 */
	val identifier: String

	/**
	 * Hmac with sha 512.
	 */
	data object HmacSha512 : HmacAlgorithm {
		override val recommendedKeySize: Int = 128
		override val digestSize: Int = 64
		override val identifier: String = Identifiers.HMAC_SHA_256
	}

	companion object {
		private object Identifiers {
			const val HMAC_SHA_256 = "HmacSha512"
		}

		/**
		 * Get an algorithm from its identifier.
		 * @param identifier the identifier of the algorithm.
		 * @return the algorithm.
		 * @throws IllegalArgumentException if the identifier is unknown.
		 */
		@Throws(IllegalArgumentException::class)
		fun fromIdentifier(identifier: String): HmacAlgorithm = when (identifier) {
			Identifiers.HMAC_SHA_256 -> HmacSha512
			else -> throw IllegalArgumentException("Unknown hmac algorithm $identifier")
		}
	}
}

expect class HmacKey<out A : HmacAlgorithm> {
	val algorithm: A
}
