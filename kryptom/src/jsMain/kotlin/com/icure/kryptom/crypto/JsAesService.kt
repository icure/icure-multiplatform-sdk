package com.icure.kryptom.crypto

import com.icure.kryptom.js.jsCrypto
import com.icure.kryptom.js.toArrayBuffer
import com.icure.kryptom.js.toByteArray
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import kotlin.js.json

object JsAesService : AesService {
	private const val RAW = "raw"
	private val USAGES = arrayOf("encrypt", "decrypt")

	private fun subtleAlgorithmNameFor(algorithm: AesAlgorithm) =
		when (algorithm) {
			AesAlgorithm.CbcWithPkcs7Padding -> "AES-CBC"
		}

	private fun generateKeyParams(algorithm: AesAlgorithm, keySize: AesService.KeySize) = json(
		"name" to subtleAlgorithmNameFor(algorithm),
		"length" to keySize.bitSize
	)

	private fun loadKeyParams(algorithm: AesAlgorithm) = json(
		"name" to subtleAlgorithmNameFor(algorithm)
	)

	override suspend fun <A : AesAlgorithm> generateKey(algorithm: A, size: AesService.KeySize): AesKey<A> =
		AesKey(
			jsCrypto.subtle.generateKey(
				generateKeyParams(algorithm, size),
				true,
				USAGES
			).await(),
			algorithm
		)


	override suspend fun exportKey(key: AesKey<*>): ByteArray =
		(jsCrypto.subtle.exportKey(RAW, key.cryptoKey).await() as ArrayBuffer).toByteArray()

	override suspend fun <A : AesAlgorithm> loadKey(algorithm: A, bytes: ByteArray): AesKey<A> =
		AesKey(
			jsCrypto.subtle.importKey(
				RAW,
				bytes.toArrayBuffer(),
				loadKeyParams(algorithm),
				true,
				USAGES
			).await(),
			algorithm
		)

	override suspend fun encrypt(data: ByteArray, key: AesKey<*>, iv: ByteArray?): ByteArray {
		val generatedIv = iv ?: JsStrongRandom.randomBytes(16)
		val encrypted = jsCrypto.subtle.encrypt(
			encryptionParam(key.algorithm, generatedIv.toArrayBuffer()),
			key.cryptoKey,
			data.toArrayBuffer()
		).await()
		return generatedIv + encrypted.toByteArray()
	}

	override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey<*>): ByteArray {
		val buffer = ivAndEncryptedData.toArrayBuffer()
		val iv = buffer.slice(0, AesService.IV_BYTE_LENGTH)
		val data = buffer.slice(AesService.IV_BYTE_LENGTH)
		return jsCrypto.subtle.decrypt(encryptionParam(key.algorithm, iv), key.cryptoKey, data).await().toByteArray()
	}

	private fun encryptionParam(algorithm: AesAlgorithm, iv: ArrayBuffer) = json(
		"name" to subtleAlgorithmNameFor(algorithm),
		"iv" to iv
	)
}
