package com.icure.kryptom.crypto

import kotlinx.cinterop.UByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.refTo
import platform.CoreCrypto.CCHmac
import platform.CoreCrypto.kCCHmacAlgSHA512

object IosHmacService : HmacService {
	override suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A> =
		HmacKey(IosStrongRandom.randomBytes(algorithm.recommendedKeySize), algorithm)

	override suspend fun exportKey(key: HmacKey<*>): ByteArray =
		key.rawKey.copyOf()

	override suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A> {
		require(bytes.size == algorithm.recommendedKeySize) { "Invalid key size for algorithm $algorithm" }
		return HmacKey(bytes.copyOf(), algorithm)
	}

	override suspend fun <A : HmacAlgorithm> sign(algorithm: A, data: ByteArray, key: HmacKey<A>): ByteArray =
		memScoped {
			require(key.algorithm == algorithm) { "Invalid key: requested algorithm $algorithm, but got key for $algorithm" }
			val out = allocArray<UByteVar>(algorithm.digestSize)
			CCHmac(
				kCCHmacAlgSHA512,
				key.rawKey.refTo(0),
				key.rawKey.size.toULong(),
				data.refTo(0),
				data.size.toULong(),
				out
			)
			out.readBytes(algorithm.digestSize)
		}

	override suspend fun <A : HmacAlgorithm> verify(
		algorithm: A,
		signature: ByteArray,
		data: ByteArray,
		key: HmacKey<A>
	): Boolean {
		return sign(algorithm, data, key).contentEquals(signature)
	}
}