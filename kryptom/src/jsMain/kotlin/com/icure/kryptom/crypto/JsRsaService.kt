package com.icure.kryptom.crypto

import com.icure.kryptom.js.jsCrypto
import com.icure.kryptom.js.toArrayBuffer
import com.icure.kryptom.js.toByteArray
import kotlinx.coroutines.await
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import kotlin.js.json

object JsRsaService : RsaService {
	private val publicExponentData = Uint8Array(byteArrayOf(0x01, 0x00, 0x01).toTypedArray())

	override suspend fun <A : RsaAlgorithm> generateKeyPair(
		algorithm: A,
		keySize: RsaService.KeySize
	): RsaKeypair<A> {
		val pair = jsCrypto.subtle.generateKey(
			keyGenParams(keySize, algorithm),
			true,
			keyPairUses(algorithm)
		).await()
		val privateKey = PrivateRsaKey(
			checkNotNull(pair["privateKey"]) { "Pair returned by generator should have private key" },
			algorithm
		)
		val publicKey = PublicRsaKey(
			checkNotNull(pair["publicKey"]) { "Pair returned by generator should have public key" },
			algorithm
		)
		return RsaKeypair(privateKey, publicKey)
	}

	override suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray {
		return (jsCrypto.subtle.exportKey("pkcs8", key.key).await() as ArrayBuffer).toByteArray()
	}

	override suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray {
		return (jsCrypto.subtle.exportKey("spki", key.key).await() as ArrayBuffer).toByteArray()
	}

	override suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A> {
		val params = importAlgorithmParams(algorithm)
		val rawPrivateKey = jsCrypto.subtle.importKey(
			"pkcs8",
			privateKeyPkcs8.toArrayBuffer(),
			params,
			true,
			privateKeyUses(algorithm)
		).await()
		// https://stackoverflow.com/questions/56807959/generate-public-key-from-private-key-using-webcrypto-api
		val jwkPrivateKey = jsCrypto.subtle.exportKey("jwk", rawPrivateKey).await()
		jwkPrivateKey.d = undefined
		jwkPrivateKey.dp = undefined
		jwkPrivateKey.dq = undefined
		jwkPrivateKey.q = undefined
		jwkPrivateKey.qi = undefined
		jwkPrivateKey.key_ops = publicKeyUses(algorithm)
		val rawPublicKey = jsCrypto.subtle.importKey(
			"jwk",
			jwkPrivateKey,
			params,
			true,
			publicKeyUses(algorithm)
		).await()
		return RsaKeypair(
			PrivateRsaKey(rawPrivateKey, algorithm),
			PublicRsaKey(rawPublicKey, algorithm)
		)
	}

	override suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A> {
		val rawPublicKey = jsCrypto.subtle.importKey(
			"spki",
			publicKeySpki,
			importAlgorithmParams(algorithm),
			true,
			publicKeyUses(algorithm)
		).await()
		return PublicRsaKey(rawPublicKey, algorithm)
	}

	override suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> encrypt(
		algorithm: A,
		data: ByteArray,
		publicKey: PublicRsaKey<A>
	): ByteArray =
		jsCrypto.subtle.encrypt(
			algorithmParams(algorithm),
			publicKey.key,
			data.toArrayBuffer()
		).await().toByteArray()

	override suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> decrypt(
		algorithm: A,
		data: ByteArray,
		privateKey: PrivateRsaKey<A>
	): ByteArray =
		jsCrypto.subtle.decrypt(
			algorithmParams(algorithm),
			privateKey.key,
			data.toArrayBuffer()
		).await().toByteArray()

	override suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> sign(
		algorithm: A,
		data: ByteArray,
		privateKey: PrivateRsaKey<A>
	): ByteArray =
		jsCrypto.subtle.sign(
			algorithmParams(algorithm),
			privateKey.key,
			data.toArrayBuffer()
		).await().toByteArray()

	override suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> verifySignature(
		algorithm: A,
		signature: ByteArray,
		data: ByteArray,
		publicKey: PublicRsaKey<A>
	): Boolean =
		jsCrypto.subtle.verify(
			algorithmParams(algorithm),
			publicKey.key,
			signature.toArrayBuffer(),
			data.toArrayBuffer()
		).await()

	private fun keyGenParams(keySize: RsaService.KeySize, algorithm: RsaAlgorithm) = json(
		"name" to algorithmName(algorithm),
		"modulusLength" to keySize.bitSize,
		"publicExponent" to publicExponentData,
		"hash" to json("name" to hashName(algorithm))
	)

	private fun importAlgorithmParams(algorithm: RsaAlgorithm) = json(
		"name" to algorithmName(algorithm),
		"hash" to json("name" to hashName(algorithm))
	)

	private fun algorithmParams(algorithm: RsaAlgorithm) = when (algorithm) {
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> json(
			"name" to algorithmName(algorithm)
		)

		RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256 -> json(
			"name" to algorithmName(algorithm),
			"saltLength" to 32
		)
	}

	private fun algorithmName(algorithm: RsaAlgorithm) = when (algorithm) {
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 ->
			"RSA-OAEP"

		RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256 ->
			"RSA-PSS"
	}

	private fun hashName(algorithm: RsaAlgorithm) = when (algorithm) {
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 ->
			"SHA-1"

		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256 ->
			"SHA-256"
	}

	private fun keyPairUses(algorithm: RsaAlgorithm) = when (algorithm) {
		is RsaAlgorithm.RsaEncryptionAlgorithm ->
			arrayOf("encrypt", "decrypt")

		is RsaAlgorithm.RsaSignatureAlgorithm ->
			arrayOf("sign", "verify")
	}

	private fun privateKeyUses(algorithm: RsaAlgorithm) = when (algorithm) {
		is RsaAlgorithm.RsaEncryptionAlgorithm ->
			arrayOf("decrypt")

		is RsaAlgorithm.RsaSignatureAlgorithm ->
			arrayOf("sign")
	}

	private fun publicKeyUses(algorithm: RsaAlgorithm) = when (algorithm) {
		is RsaAlgorithm.RsaEncryptionAlgorithm ->
			arrayOf("encrypt")

		is RsaAlgorithm.RsaSignatureAlgorithm ->
			arrayOf("verify")
	}
}
