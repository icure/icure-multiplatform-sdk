@file:Suppress("PropertyName")
package com.icure.kryptom.crypto

interface JwkKey {
	val kty: String
	val alg: String
	val ext: Boolean
	val key_ops: Set<String>
}

interface RsaKeyJwk : JwkKey {
	val n: String
	val e: String
}

data class PrivateRsaKeyJwk(
	override val alg: String,
	val d: String,
	val dp: String,
	val dq: String,
	override val e: String,
	override val ext: Boolean,
	override val key_ops: Set<String>,
	override val n: String,
	val p: String,
	val q: String,
	val qi: String
) : RsaKeyJwk {
	override val kty: String = "RSA"

	init {
		require(key_ops.singleOrNull() == "sign" || key_ops.singleOrNull() == "decrypt") {
			"Invalid key_ops for private key - $key_ops"
		}
	}

	/**
	 * Extracts the public key from this private key.
	 */
	fun extractPublic(): PublicRsaKeyJwk = PublicRsaKeyJwk(
		alg = alg,
		e = e,
		ext = ext,
		key_ops = when (key_ops.singleOrNull()) {
			"sign" -> setOf("verify")
			"decrypt" -> setOf("encrypt")
			else -> error("Invalid key_ops for private key - $key_ops")
		},
		n = n
	)
}

data class PublicRsaKeyJwk(
	override val alg: String,
	override val e: String,
	override val ext: Boolean,
	override val key_ops: Set<String>,
	override val n: String
) : RsaKeyJwk  {
	override val kty: String = "RSA"

	init {
		require(key_ops.singleOrNull() == "verify" || key_ops.singleOrNull() == "encrypt") {
			"Invalid key_ops for public key - $key_ops"
		}
	}
}