package com.icure.kryptom.crypto

import com.icure.kryptom.crypto.AesService.Companion.IV_BYTE_LENGTH
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object JvmAesService : AesService {
	private fun newCipherAES(): Cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")

	override suspend fun generateKey(size: AesService.KeySize): AesKey {
		val keyGen: KeyGenerator = KeyGenerator.getInstance("AES")
		keyGen.init(size.bitSize)
		return AesKey(keyGen.generateKey())
	}

	override suspend fun exportKey(key: AesKey): ByteArray =
		key.encoded

	override suspend fun loadKey(bytes: ByteArray): AesKey {
		require(bytes.size in AesService.validKeySizes) { "Invalid key length: ${bytes.size}" }
		return AesKey(SecretKeySpec(bytes, "AES"))
	}

	override suspend fun encrypt(data: ByteArray, key: AesKey, iv: ByteArray?): ByteArray {
		val generatedIv = iv ?: JvmStrongRandom.randomBytes(IV_BYTE_LENGTH)
		val cipher = newCipherAES().apply { init(Cipher.ENCRYPT_MODE, key.key, IvParameterSpec(generatedIv)) }
		return generatedIv + cipher.doFinal(data)
	}

	override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey): ByteArray {
		val iv = ivAndEncryptedData.sliceArray(0 until IV_BYTE_LENGTH)
		val data = ivAndEncryptedData.sliceArray(IV_BYTE_LENGTH until ivAndEncryptedData.size)
		return newCipherAES().apply { init(Cipher.DECRYPT_MODE, key.key, IvParameterSpec(iv)) }.doFinal(data)
	}
}