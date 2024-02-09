package com.icure.kryptom.crypto

import com.icure.kryptom.js.jsCrypto
import com.icure.kryptom.js.toArrayBuffer
import com.icure.kryptom.js.toByteArray
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import kotlin.js.json

object JsHmacService : HmacService {
	private const val ALGORITHM_NAME = "HMAC"
	private const val RAW = "raw"

	private fun paramsForAlgorithm(algorithm: HmacAlgorithm) =
		json(
			"name" to ALGORITHM_NAME,
			"hash" to when (algorithm) {
				HmacAlgorithm.HmacSha512 -> "SHA-512"
			},
			"length" to algorithm.recommendedKeySize * 8
		)

	override suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A> {
		val generatedKey = jsCrypto.subtle.generateKey(
			paramsForAlgorithm(algorithm),
			true,
			arrayOf("sign", "verify")
		).await()
		val generatedKeySize = exportRawKey(generatedKey).byteLength
		if (generatedKeySize != algorithm.recommendedKeySize) throw AssertionError(
			"Invalid key size for algorithm $algorithm, got $generatedKeySize"
		)
		return HmacKey(generatedKey, algorithm)
	}

	override suspend fun exportKey(key: HmacKey<*>): ByteArray =
		exportRawKey(key.key).toByteArray()

	private suspend fun exportRawKey(rawKey: dynamic) =
		jsCrypto.subtle.exportKey(RAW, rawKey).await() as ArrayBuffer

	override suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A> {
		require(bytes.size == algorithm.recommendedKeySize) { "Invalid key size for algorithm $algorithm" }
		return HmacKey(
			jsCrypto.subtle.importKey(
				RAW,
				bytes.toArrayBuffer(),
				paramsForAlgorithm(algorithm),
				true,
				arrayOf("sign", "verify")
			).await(),
			algorithm
		)
	}

	override suspend fun sign(data: ByteArray, key: HmacKey<*>): ByteArray {
		return jsCrypto.subtle.sign(
			paramsForAlgorithm(key.algorithm),
			key.key,
			data.toArrayBuffer()
		).await().toByteArray()
	}

	override suspend fun verify(
		signature: ByteArray,
		data: ByteArray,
		key: HmacKey<*>
	): Boolean {
		return jsCrypto.subtle.verify(
			paramsForAlgorithm(key.algorithm),
			key.key,
			signature.toArrayBuffer(),
			data.toArrayBuffer()
		).await()
	}
}