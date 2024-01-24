package com.icure.sdk.crypto

import com.icure.sdk.js.jsCrypto
import com.icure.sdk.js.toArrayBuffer
import com.icure.sdk.js.toByteArray
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import kotlin.js.json

object JsAesCryptoService : AesCryptoService {
    private const val RAW = "raw"
    private const val ALGORITHM_NAME = "AES-CBC"
    private val USAGES = arrayOf("encrypt", "decrypt")

    private val sizeToAlgorithmParam = AesCryptoService.KeySize.entries.associateWith {
        json(
            "name" to ALGORITHM_NAME,
            "length" to it.bitSize
        )
    }

    private val algorithmJson = json("name" to ALGORITHM_NAME)

    override suspend fun generateKey(size: AesCryptoService.KeySize): AesKey =
        jsCrypto.subtle.generateKey(
            sizeToAlgorithmParam.getValue(size),
            true,
            USAGES
        ).await() as AesKey


    override suspend fun exportKey(key: AesKey): ByteArray =
        (jsCrypto.subtle.exportKey(RAW, key).await() as ArrayBuffer).toByteArray()

    override suspend fun loadKey(bytes: ByteArray): AesKey =
        jsCrypto.subtle.importKey(RAW, bytes.toArrayBuffer(), algorithmJson, true, USAGES).await() as AesKey

    override suspend fun encrypt(data: ByteArray, key: AesKey, iv: ByteArray?): ByteArray {
        val generatedIv = iv ?: JsStrongRandom.randomBytes(16)
        val encrypted = jsCrypto.subtle.encrypt(
            encryptionParam(generatedIv.toArrayBuffer()),
            key,
            data.toArrayBuffer()
        ).await()
        return generatedIv + encrypted.toByteArray()
    }

    override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey): ByteArray {
        val buffer = ivAndEncryptedData.toArrayBuffer()
        val iv = buffer.slice(0, AesCryptoService.IV_BYTE_LENGTH)
        val data = buffer.slice(AesCryptoService.IV_BYTE_LENGTH)
        return jsCrypto.subtle.decrypt(encryptionParam(iv), key, data).await().toByteArray()
    }

    private fun encryptionParam(iv: ArrayBuffer) = json(
        "name" to ALGORITHM_NAME,
        "iv" to iv
    )
}
