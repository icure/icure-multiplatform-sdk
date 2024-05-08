package com.icure.kryptom.crypto

import com.icure.kryptom.crypto.AesService.Companion.IV_BYTE_LENGTH
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object JvmAesService : AesService {
	private fun getCipher(
		algorithm: AesAlgorithm
	): Cipher = when (algorithm) {
		AesAlgorithm.CbcWithPkcs7Padding -> Cipher.getInstance("AES/CBC/PKCS7Padding")
	}

	override suspend fun <A : AesAlgorithm> generateKey(algorithm: A, size: AesService.KeySize): AesKey<A> {
		val keyGen: KeyGenerator = KeyGenerator.getInstance("AES")
		keyGen.init(size.bitSize)
		return AesKey(keyGen.generateKey(), algorithm)
	}

	override suspend fun exportKey(key: AesKey<*>): ByteArray =
		key.key.encoded

	override suspend fun <A : AesAlgorithm> loadKey(algorithm: A, bytes: ByteArray): AesKey<A> {
		require(bytes.size in AesService.validKeySizes) { "Invalid key length: ${bytes.size}" }
		return AesKey(SecretKeySpec(bytes, "AES"), algorithm)
	}

	override suspend fun encrypt(data: ByteArray, key: AesKey<*>, iv: ByteArray?): ByteArray {
		val generatedIv = iv ?: JvmStrongRandom.randomBytes(IV_BYTE_LENGTH)
		val cipher = getCipher(key.algorithm).apply { init(Cipher.ENCRYPT_MODE, key.key, IvParameterSpec(generatedIv)) }
		return generatedIv + cipher.doFinal(data)
	}

	override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey<*>): ByteArray {
		val iv = ivAndEncryptedData.sliceArray(0 until IV_BYTE_LENGTH)
		val data = ivAndEncryptedData.sliceArray(IV_BYTE_LENGTH until ivAndEncryptedData.size)
		return getCipher(key.algorithm).apply { init(Cipher.DECRYPT_MODE, key.key, IvParameterSpec(iv)) }.doFinal(data)
	}
}