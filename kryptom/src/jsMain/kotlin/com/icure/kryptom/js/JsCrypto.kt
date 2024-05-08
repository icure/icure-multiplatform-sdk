package com.icure.kryptom.js

import io.ktor.util.PlatformUtils
import org.khronos.webgl.ArrayBuffer
import kotlin.js.Json
import kotlin.js.Promise

/**
 * Implementation from
 * [ktor](https://github.com/ktorio/ktor/blob/8efb61fcc2/ktor-utils/js/src/io/ktor/util/CryptoJs.kt#L47)
 * Global instance of [Crypto].
 */
internal val jsCrypto: Crypto by lazy {
	if (PlatformUtils.IS_NODE) {
		js("eval('require')('crypto').webcrypto")
	} else {
		js("(window ? (window.crypto ? window.crypto : window.msCrypto) : self.crypto)")
	}
}

/**
 * https://developer.mozilla.org/en-US/docs/Web/API/Crypto
 */
internal external class Crypto {
	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/Crypto/subtle
	 */
	val subtle: SubtleCrypto

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/Crypto/getRandomValues
	 */
	fun getRandomValues(array: ByteArray): ByteArray

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/Crypto/randomUUID
	 */
	fun randomUUID(): String
}

/**
 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto
 */
internal external class SubtleCrypto {
	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/generateKey#syntax
	 */
	fun generateKey(algorithm: Json, extractable: Boolean, keyUsages: Array<String>): Promise<dynamic>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/exportKey
	 */
	fun exportKey(format: String, key: dynamic): Promise<dynamic>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/importKey
	 */
	fun importKey(
		format: String,
		keyData: dynamic,
		algorithm: Json,
		extractable: Boolean,
		keyUsages: Array<String>
	): Promise<dynamic>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/encrypt
	 */
	fun encrypt(algorithm: Json, key: dynamic, data: ArrayBuffer): Promise<ArrayBuffer>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/decrypt
	 */
	fun decrypt(algorithm: Json, key: dynamic, data: ArrayBuffer): Promise<ArrayBuffer>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/sign
	 */
	fun sign(algorithm: Json, key: dynamic, data: ArrayBuffer): Promise<ArrayBuffer>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/verify
	 */
	fun verify(algorithm: Json, key: dynamic, signature: ArrayBuffer, data: ArrayBuffer): Promise<Boolean>

	/**
	 * https://developer.mozilla.org/en-US/docs/Web/API/SubtleCrypto/digest
	 */
	fun digest(algorithm: String, data: ArrayBuffer): Promise<ArrayBuffer>
}
