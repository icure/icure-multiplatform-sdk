package com.icure.sdk.crypto

object IosHmacService : HmacCryptoService {
    override suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A> {
        TODO("Not yet implemented")
    }

    override suspend fun exportKey(key: HmacKey<*>): ByteArray {
        TODO("Not yet implemented")
    }

    override suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A> {
        TODO("Not yet implemented")
    }

    override suspend fun <A : HmacAlgorithm> sign(algorithm: A, data: ByteArray, key: HmacKey<A>): ByteArray {
        TODO("Not yet implemented")
    }

    override suspend fun <A : HmacAlgorithm> verify(
        algorithm: A,
        signature: ByteArray,
        data: ByteArray,
        key: HmacKey<A>
    ): Boolean {
        TODO("Not yet implemented")
    }
}