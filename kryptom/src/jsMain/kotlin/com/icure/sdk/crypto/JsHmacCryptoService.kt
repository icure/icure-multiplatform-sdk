package com.icure.sdk.crypto

import com.icure.sdk.js.jsCrypto
import com.icure.sdk.js.toArrayBuffer
import com.icure.sdk.js.toByteArray
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import kotlin.js.json

object JsHmacCryptoService : HmacCryptoService {
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

    override suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A> = HmacKey(
        jsCrypto.subtle.generateKey(
            paramsForAlgorithm(algorithm),
            true,
            arrayOf("sign", "verify")
        ).await(),
        algorithm
    )

    override suspend fun exportKey(key: HmacKey<*>): ByteArray =
        (jsCrypto.subtle.exportKey(RAW, key.key).await() as ArrayBuffer).toByteArray()

    override suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A> =
        HmacKey(
            jsCrypto.subtle.importKey(
                RAW,
                bytes.toArrayBuffer(),
                paramsForAlgorithm(algorithm),
                true,
                arrayOf("sign", "verify")
            ).await(),
            algorithm
        )

    override suspend fun <A : HmacAlgorithm> sign(algorithm: A, data: ByteArray, key: HmacKey<A>): ByteArray =
        jsCrypto.subtle.sign(
            paramsForAlgorithm(algorithm),
            key.key,
            data.toArrayBuffer()
        ).await().toByteArray()

    override suspend fun <A : HmacAlgorithm> verify(
        algorithm: A,
        signature: ByteArray,
        data: ByteArray,
        key: HmacKey<A>
    ): Boolean = jsCrypto.subtle.verify(
        paramsForAlgorithm(algorithm),
        key.key,
        signature.toArrayBuffer(),
        data.toArrayBuffer()
    ).await()
}