package com.icure.sdk.crypto

import com.icure.sdk.crypto.AesCryptoService.Companion.IV_BYTE_LENGTH
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object JavaAesCryptoService : AesCryptoService {
    private fun newCipherAES() = Cipher.getInstance("AES/CBC/PKCS7Padding")

    override fun generateKey(size: AesCryptoService.KeySize): AesKey {
        val keyGen: KeyGenerator = KeyGenerator.getInstance("AES", "BC")
        keyGen.init(size.bitSize)
        return keyGen.generateKey() as SecretKeySpec
    }

    override fun exportKey(key: AesKey): ByteArray =
        key.encoded

    override fun loadKey(bytes: ByteArray): AesKey {
        require(bytes.size in AesCryptoService.validKeySizes) { "Invalid key length: ${bytes.size}" }
        return SecretKeySpec(bytes, "AES")
    }

    override fun encrypt(data: ByteArray, key: AesKey, iv: ByteArray?): ByteArray {
        val generatedIv = iv ?: strongRandom.randomBytes(IV_BYTE_LENGTH)
        val cipher = newCipherAES().apply { init(Cipher.ENCRYPT_MODE, key, IvParameterSpec(generatedIv)) }
        return generatedIv + cipher.doFinal(data)
    }

    override fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey): ByteArray {
        val iv = ivAndEncryptedData.sliceArray(0 until IV_BYTE_LENGTH)
        val data = ivAndEncryptedData.sliceArray(IV_BYTE_LENGTH until ivAndEncryptedData.size)
        val cipher = newCipherAES().apply { init(Cipher.DECRYPT_MODE, key, IvParameterSpec(iv)) }
        return try {
            cipher.doFinal(data)
        } catch (e: Exception) {
            throw AesDecryptionException("Failed to aes decrypt data", e)
        }
    }
}