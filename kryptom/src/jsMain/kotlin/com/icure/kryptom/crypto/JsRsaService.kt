package com.icure.kryptom.crypto

import com.icure.kryptom.js.jsCrypto
import com.icure.kryptom.js.parsingDynamic
import com.icure.kryptom.js.toArrayBuffer
import com.icure.kryptom.js.toByteArray
import com.icure.kryptom.utils.PlatformMethodException
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
			pair["privateKey"] ?: throw PlatformMethodException("Pair returned by generator should have private key"),
			algorithm
		)
		val publicKey = PublicRsaKey(
			pair["publicKey"] ?: throw PlatformMethodException("Pair returned by generator should have public key"),
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
		val rawPrivateKey = importRawPrivateKeyPkcs8(algorithm, privateKeyPkcs8)
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
			importAlgorithmParams(algorithm),
			true,
			publicKeyUses(algorithm)
		).await()
		return RsaKeypair(
			PrivateRsaKey(rawPrivateKey, algorithm),
			PublicRsaKey(rawPublicKey, algorithm)
		)
	}

	override suspend fun <A : RsaAlgorithm> loadPrivateKeyPkcs8(
		algorithm: A,
		privateKeyPkcs8: ByteArray
	): PrivateRsaKey<A> =
		PrivateRsaKey(
			importRawPrivateKeyPkcs8(algorithm, privateKeyPkcs8),
			algorithm
		)

	private suspend fun importRawPrivateKeyPkcs8(
		algorithm: RsaAlgorithm,
		privateKeyPkcs8: ByteArray
	): dynamic {
		val params = importAlgorithmParams(algorithm)
		return jsCrypto.subtle.importKey(
			"pkcs8",
			privateKeyPkcs8.toArrayBuffer(),
			params,
			true,
			privateKeyUses(algorithm)
		).await()
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

	override suspend fun encrypt(
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray =
		jsCrypto.subtle.encrypt(
			encryptionAlgorithmParams(publicKey.algorithm),
			publicKey.key,
			data.toArrayBuffer()
		).await().toByteArray()

	override suspend fun decrypt(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray =
		jsCrypto.subtle.decrypt(
			encryptionAlgorithmParams(privateKey.algorithm),
			privateKey.key,
			data.toArrayBuffer()
		).await().toByteArray()

	override suspend fun sign(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): ByteArray =
		jsCrypto.subtle.sign(
			signatureAlgorithmParams(privateKey.algorithm),
			privateKey.key,
			data.toArrayBuffer()
		).await().toByteArray()

	override suspend fun verifySignature(
		signature: ByteArray,
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): Boolean =
		jsCrypto.subtle.verify(
			signatureAlgorithmParams(publicKey.algorithm),
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

	private fun encryptionAlgorithmParams(algorithm: RsaAlgorithm.RsaEncryptionAlgorithm) = when (algorithm) {
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> json(
			"name" to algorithmName(algorithm)
		)
	}

	private fun signatureAlgorithmParams(algorithm: RsaAlgorithm.RsaSignatureAlgorithm) = when (algorithm) {
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

	override suspend fun exportPrivateKeyJwk(key: PrivateRsaKey<*>): PrivateRsaKeyJwk =
		parsingDynamic(jsCrypto.subtle.exportKey("jwk", key.key).await()) {
			PrivateRsaKeyJwk(
				alg = expect<String>("alg"),
				d = expect<String>("d"),
				dp = expect<String>("dp"),
				dq = expect<String>("dq"),
				e = expect<String>("e"),
				n = expect<String>("n"),
				p = expect<String>("p"),
				q = expect<String>("q"),
				qi = expect<String>("qi"),
				key_ops = expectArray<String>("key_ops").toSet(),
				ext = expect<Boolean>("ext")
			).also {
				if (expect<String>("kty") != "RSA") {
					throw PlatformMethodException("Key type should be RSA")
				}
			}
		}

	override suspend fun exportPublicKeyJwk(key: PublicRsaKey<*>): PublicRsaKeyJwk =
		parsingDynamic(jsCrypto.subtle.exportKey("jwk", key.key).await()) {
			PublicRsaKeyJwk(
				alg = expect<String>("alg"),
				e = expect<String>("e"),
				n = expect<String>("n"),
				key_ops = expectArray<String>("key_ops").toSet(),
				ext = expect<Boolean>("ext")
			).also {
				if (expect<String>("kty") != "RSA") {
					throw PlatformMethodException("Key type should be RSA")
				}
			}
		}

	override suspend fun <A : RsaAlgorithm> loadPrivateKeyJwk(
		algorithm: A,
		privateKeyJwk: PrivateRsaKeyJwk
	): PrivateRsaKey<A> {
		require(algorithm.jwkIdentifier == privateKeyJwk.alg) {
			"Algorithm of JWK does not match provided algorithm - ${privateKeyJwk.alg} != ${algorithm.jwkIdentifier}"
		}
		return PrivateRsaKey(
			jsCrypto.subtle.importKey(
				"jwk",
				json(
					"alg" to privateKeyJwk.alg,
					"d" to privateKeyJwk.d,
					"dp" to privateKeyJwk.dp,
					"dq" to privateKeyJwk.dq,
					"e" to privateKeyJwk.e,
					"ext" to privateKeyJwk.ext,
					"key_ops" to privateKeyJwk.key_ops.toTypedArray(),
					"kty" to privateKeyJwk.kty,
					"n" to privateKeyJwk.n,
					"p" to privateKeyJwk.p,
					"q" to privateKeyJwk.q,
					"qi" to privateKeyJwk.qi
				),
				importAlgorithmParams(algorithm),
				true,
				privateKeyUses(algorithm)
			).await(),
			algorithm
		)
	}

	override suspend fun <A : RsaAlgorithm> loadPublicKeyJwk(
		algorithm: A,
		publicKeyJwk: PublicRsaKeyJwk
	): PublicRsaKey<A> {
		require(algorithm.jwkIdentifier == publicKeyJwk.alg) {
			"Algorithm of JWK does not match provided algorithm - ${publicKeyJwk.alg} != ${algorithm.jwkIdentifier}"
		}
		return PublicRsaKey(
			jsCrypto.subtle.importKey(
				"jwk",
				json(
					"alg" to publicKeyJwk.alg,
					"e" to publicKeyJwk.e,
					"ext" to publicKeyJwk.ext,
					"key_ops" to publicKeyJwk.key_ops.toTypedArray(),
					"kty" to publicKeyJwk.kty,
					"n" to publicKeyJwk.n
				),
				importAlgorithmParams(algorithm),
				true,
				publicKeyUses(algorithm)
			).await(),
			algorithm
		)
	}
}
