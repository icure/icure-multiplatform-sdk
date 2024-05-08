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

	override suspend fun sign(data: ByteArray, key: HmacKey<*>): ByteArray =
		memScoped {
			val out = allocArray<UByteVar>(key.algorithm.digestSize)
			CCHmac(
				key.algorithm.coreCryptoAlgorithm,
				key.rawKey.refTo(0),
				key.rawKey.size.toULong(),
				data.refTo(0),
				data.size.toULong(),
				out
			)
			out.readBytes(key.algorithm.digestSize)
		}

	override suspend fun verify(
		signature: ByteArray,
		data: ByteArray,
		key: HmacKey<*>
	): Boolean {
		return sign(data, key).contentEquals(signature)
	}

	private val HmacAlgorithm.coreCryptoAlgorithm: UInt get() = when (this) {
		HmacAlgorithm.HmacSha512 -> kCCHmacAlgSHA512
	}
}