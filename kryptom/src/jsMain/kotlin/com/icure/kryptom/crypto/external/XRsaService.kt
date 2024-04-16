package com.icure.kryptom.crypto.external

import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import kotlin.js.Promise

@JsExport
external interface XRsaService {
	/**
	 * Generates a new rsa key pair, with default modulus length 2048.
	 * For security reasons the generated key should be used only for the provided algorithm.
	 * There is nothing in the underlying cryptographic algorithms that prevents you from using a
	 * key for various algorithms, but the actual implementations of the service may add metadata
	 * to keep track of the declared intended usage of the key and throw an exception when
	 * attempting to use the key for other purposes.
	 * For more info see https://crypto.stackexchange.com/questions/81819/same-private-key-for-signing-and-decryption
	 */
	fun generateKeyPair(algorithm: String, keySize: Int): Promise<XRsaKeypair>

	/**
	 * Exports the private key in pkcs8 format.
	 * @param key the key to export.
	 * @return representation of the key in pkcs8 format.
	 */
	fun exportPrivateKeyPkcs8(key: XPrivateRsaKey): Promise<ByteArray>

	/**
	 * Exports the public key in pkcs8 format.
	 * @param key the key to export.
	 * @return representation of the key in spki format (java X.509).
	 */
	fun exportPublicKeySpki(key: XPublicRsaKey): Promise<ByteArray>

	/**
	 * Loads the rsa keypair given the PKCS8 representation of the private key. Note that there is no way to guarantee
	 * that the provided algorithm matches the algorithm chosen on key generation.
	 */
	fun loadKeyPairPkcs8(algorithm: String, privateKeyPkcs8: ByteArray): Promise<XRsaKeypair>

	/**
	 * Loads the rsa private key given the pkcs8 representation of the private key. Note that there is no way to guarantee
	 * that the provided algorithm matches the algorithm chosen on key generation.
	 */
	fun loadPrivateKeyPkcs8(algorithm: String, privateKeyPkcs8: ByteArray): Promise<XPrivateRsaKey>

	/**
	 * Loads the rsa public key given the spki representation (java X.509) of the public key. Note that there is no way
	 * to guarantee that the provided algorithm matches the algorithm chosen on key generation.
	 */
	fun loadPublicKeySpki(algorithm: String, publicKeySpki: ByteArray): Promise<XPublicRsaKey>

	/**
	 * Encrypts data using the provided key and algorithm. There are limits to the size of data which can be encrypted
	 * depending on the chosen algorithm and key size.
	 */
	fun encrypt(
		data: ByteArray,
		publicKey: XPublicRsaKey
	): Promise<ByteArray>

	/**
	 * Decrypts data using the provided key and algorithm.
	 */
	fun decrypt(
		data: ByteArray,
		privateKey: XPrivateRsaKey
	): Promise<ByteArray>

	/**
	 * Generates a signature for some data using the provided key and algorithm.
	 */
	fun sign(
		data: ByteArray,
		privateKey: XPrivateRsaKey
	): Promise<ByteArray>

	/**
	 * Verifies that a signature matches the provided data, using the provided key and algorithm.
	 */
	fun verifySignature(
		signature: ByteArray,
		data: ByteArray,
		publicKey: XPublicRsaKey
	): Promise<Boolean>
}

@JsExport
data class XRsaKeypair(
	val private: XPrivateRsaKey,
	val public: XPublicRsaKey
) {
	init {
		require(private.algorithm == public.algorithm) { "Private and public key must have the same algorithm." }
	}
}

internal fun <A : RsaAlgorithm> XRsaKeypair.toKryptom(algorithm: A): RsaKeypair<A> {
	return RsaKeypair(private.toKryptom(algorithm), public.toKryptom(algorithm))
}

internal fun RsaKeypair<*>.toExternal(): XRsaKeypair = XRsaKeypair(private.toExternal(), public.toExternal())

@JsExport
data class XPrivateRsaKey(
	val key: dynamic,
	val algorithm: String
)

internal fun <A : RsaAlgorithm> XPrivateRsaKey.toKryptom(algorithm: A): PrivateRsaKey<A> {
	if (this.algorithm != algorithm.identifier) {
		throw AssertionError("Algorithm mismatch: ${this.algorithm} != ${algorithm.identifier}")
	}
	return PrivateRsaKey(key, algorithm)
}

internal fun PrivateRsaKey<*>.toExternal(): XPrivateRsaKey = XPrivateRsaKey(key, algorithm.identifier)

@JsExport
data class XPublicRsaKey(
	val key: dynamic,
	val algorithm: String
)

internal fun <A : RsaAlgorithm> XPublicRsaKey.toKryptom(algorithm: A): PublicRsaKey<A> {
	if (this.algorithm != algorithm.identifier) {
		throw AssertionError("Algorithm mismatch: ${this.algorithm} != ${algorithm.identifier}")
	}
	return PublicRsaKey(key, algorithm)
}

internal fun PublicRsaKey<*>.toExternal(): XPublicRsaKey = XPublicRsaKey(key, algorithm.identifier)