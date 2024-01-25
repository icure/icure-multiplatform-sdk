package com.icure.sdk.crypto

import javax.crypto.KeyGenerator
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object JvmHmacCryptoService : HmacCryptoService {
    private val HmacAlgorithm.name get() = when (this) {
        HmacAlgorithm.HmacSha512 -> "HMac-SHA512"
    }

    override suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A> {
        val keyGen: KeyGenerator = KeyGenerator.getInstance(algorithm.name)
        keyGen.init(algorithm.recommendedKeySize * 8)
        return HmacKey(keyGen.generateKey(), algorithm)
    }
    override suspend fun exportKey(key: HmacKey<*>): ByteArray {
        return key.key.encoded
    }

    override suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A> {
        require(bytes.size == algorithm.recommendedKeySize) { "Invalid key length for algorithm $algorithm: ${bytes.size}" }
        return HmacKey(SecretKeySpec(bytes, algorithm.name), algorithm)
    }

    override suspend fun <A : HmacAlgorithm> sign(algorithm: A, data: ByteArray, key: HmacKey<A>): ByteArray =
        Mac.getInstance(algorithm.name).apply { init(key) }.doFinal(data)

    override suspend fun <A : HmacAlgorithm> verify(
        algorithm: A,
        signature: ByteArray,
        data: ByteArray,
        key: HmacKey<A>
    ): Boolean =
        sign(algorithm, data, key).contentEquals(signature)
}