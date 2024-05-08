package com.icure.kryptom.crypto.external

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.AesService
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.DigestService
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.kryptom.crypto.HmacService
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.crypto.StrongRandom
import kotlinx.coroutines.await

/**
 * Adapts an external implementation of a crypto service to use the same interface as kryptom. This allows to connect to
 * native implementations of cryptographic operations when using kryptom-ts from react-native.
 */
fun adaptExternalCryptoService(service: XCryptoService): CryptoService =
	ServiceAdapter(service)

@JsExport
external interface XCryptoService {
	val aes: XAesService
	val digest: XDigestService
	val rsa: XRsaService
	val strongRandom: XStrongRandom
	val hmac: XHmacService
}

private class ServiceAdapter(service: XCryptoService) : CryptoService {
	override val aes: AesService = AesServiceAdapter(service.aes)
	override val digest: DigestService = DigestServiceAdapter(service.digest)
	override val rsa: RsaService = RsaServiceAdapter(service.rsa)
	override val strongRandom: StrongRandom = StrongRandomAdapter(service.strongRandom)
	override val hmac: HmacService = HmacServiceAdapter(service.hmac)
}

private class AesServiceAdapter(
	private val service: XAesService
) : AesService {
	override suspend fun <A : AesAlgorithm> generateKey(algorithm: A, size: AesService.KeySize): AesKey<A> =
		service.generateKey(algorithm.identifier, size.bitSize).await().toKryptom(algorithm)

	override suspend fun exportKey(key: AesKey<*>): ByteArray =
		service.exportKey(key.toExternal()).await()

	override suspend fun <A : AesAlgorithm> loadKey(algorithm: A, bytes: ByteArray): AesKey<A> =
		service.loadKey(algorithm.identifier, bytes).await().toKryptom(algorithm)

	override suspend fun encrypt(data: ByteArray, key: AesKey<*>, iv: ByteArray?): ByteArray =
		service.encrypt(data, key.toExternal(), iv).await()

	override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey<*>): ByteArray =
		service.decrypt(ivAndEncryptedData, key.toExternal()).await()
}

private class DigestServiceAdapter(
	private val service: XDigestService
) : DigestService {
	override suspend fun sha256(data: ByteArray): ByteArray =
		service.sha256(data).await()
}

private class HmacServiceAdapter(
	private val service: XHmacService
) : HmacService {
	override suspend fun <A : HmacAlgorithm> generateKey(algorithm: A): HmacKey<A> =
		service.generateKey(algorithm.identifier).await().toKryptom(algorithm)

	override suspend fun exportKey(key: HmacKey<*>): ByteArray =
		service.exportKey(key.toExternal()).await()

	override suspend fun <A : HmacAlgorithm> loadKey(algorithm: A, bytes: ByteArray): HmacKey<A> =
		service.loadKey(algorithm.identifier, bytes).await().toKryptom(algorithm)

	override suspend fun sign(data: ByteArray, key: HmacKey<*>): ByteArray =
		service.sign(data, key.toExternal()).await()

	override suspend fun verify(signature: ByteArray, data: ByteArray, key: HmacKey<*>): Boolean =
		service.verify(signature, data, key.toExternal()).await()
}

private class RsaServiceAdapter(
	private val service: XRsaService
) : RsaService {
	override suspend fun <A : RsaAlgorithm> generateKeyPair(algorithm: A, keySize: RsaService.KeySize): RsaKeypair<A> =
		service.generateKeyPair(algorithm.identifier, keySize.bitSize).await().toKryptom(algorithm)

	override suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray =
		service.exportPrivateKeyPkcs8(key.toExternal()).await()

	override suspend fun <A : RsaAlgorithm> loadPrivateKeyPkcs8(
		algorithm: A,
		privateKeyPkcs8: ByteArray
	): PrivateRsaKey<A> =
		service.loadPrivateKeyPkcs8(algorithm.identifier, privateKeyPkcs8).await().toKryptom(algorithm)

	override suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray =
		service.exportPublicKeySpki(key.toExternal()).await()

	override suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A> =
		service.loadKeyPairPkcs8(algorithm.identifier, privateKeyPkcs8).await().toKryptom(algorithm)

	override suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A> =
		service.loadPublicKeySpki(algorithm.identifier, publicKeySpki).await().toKryptom(algorithm)

	override suspend fun encrypt(
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray =
		service.encrypt(data, publicKey.toExternal()).await()

	override suspend fun decrypt(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray =
		service.decrypt(data, privateKey.toExternal()).await()

	override suspend fun sign(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): ByteArray =
		service.sign(data, privateKey.toExternal()).await()

	override suspend fun verifySignature(
		signature: ByteArray,
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): Boolean =
		service.verifySignature(signature, data, publicKey.toExternal()).await()
}

private class StrongRandomAdapter(
	private val service: XStrongRandom
) : StrongRandom {
	override fun fill(array: ByteArray) {
		val random = service.randomBytes(array.size)
		random.copyInto(array)
	}

	override fun randomBytes(length: Int): ByteArray =
		service.randomBytes(length)

	override fun randomUUID(): String =
		service.randomUUID()
}