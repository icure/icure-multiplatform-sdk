package com.icure.kryptom.crypto.external

import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import kotlin.js.Promise

@JsExport
external interface XHmacService {
	/**
	 * Generates a new hmac key for a specific algorithm. The key size is determined by the algorithm.
	 */
	fun generateKey(algorithm: String): Promise<XHmacKey>

	/**
	 * Exports a key to a byte array.
	 */
	fun exportKey(key: XHmacKey): Promise<ByteArray>

	/**
	 * Imports a key from a byte array. The key size must match the algorithm.
	 */
	fun loadKey(algorithm: String, bytes: ByteArray): Promise<XHmacKey>

	/**
	 * Generates a signature for some data using the provided key and algorithm.
	 */
	fun sign(data: ByteArray, key: XHmacKey): Promise<ByteArray>

	/**
	 * Verifies that a signature matches the provided data, using the provided key and algorithm.
	 */
	fun verify(
		signature: ByteArray,
		data: ByteArray,
		key: XHmacKey
	): Promise<Boolean>
}

@JsExport
data class XHmacKey(
	val key: dynamic,
	val algorithm: String
)

internal fun <A : HmacAlgorithm> XHmacKey.toKryptom(algorithm: A): HmacKey<A> {
	if (this.algorithm != algorithm.identifier) {
		throw AssertionError("Algorithm mismatch: ${this.algorithm} != ${algorithm.identifier}")
	}
	return HmacKey(key, algorithm)
}

internal fun HmacKey<*>.toExternal(): XHmacKey = XHmacKey(key, algorithm.identifier)