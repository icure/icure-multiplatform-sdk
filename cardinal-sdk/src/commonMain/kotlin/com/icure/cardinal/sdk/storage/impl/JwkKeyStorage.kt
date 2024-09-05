package com.icure.cardinal.sdk.storage.impl

import com.icure.kryptom.crypto.PrivateRsaKeyJwk
import com.icure.kryptom.crypto.PublicRsaKeyJwk
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.asn.AsnToJwkConverter
import com.icure.cardinal.sdk.storage.KeyStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.Serialization
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonPrimitive

/**
 * A KeyStorageFacade reads and stores keys as jwk. The algorithm of the stored key is a test double value.
 */
class JwkKeyStorage(
	private val stringStorage: StorageFacade
) : KeyStorageFacade {
	override suspend fun getPublicKeySpki(storageEntryKey: String): ByteArray? =
		getPartialKeyPair(storageEntryKey)?.publicKeySpki

	override suspend fun getPrivateKeyPkcs8(storageEntryKey: String): ByteArray? =
		getPartialKeyPair(storageEntryKey)?.privateKeyPkcs8

	override suspend fun storePublicKey(storageEntryKey: String, publicKeySpki: ByteArray) {
		stringStorage.setItem(
			storageEntryKey,
			Serialization.json.encodeToString(PartialKeyPair.fromKeys(publicKey = publicKeySpki))
		)
	}

	override suspend fun storePrivateKey(storageEntryKey: String, privateKey: ByteArray) {
		stringStorage.setItem(
			storageEntryKey,
			Serialization.json.encodeToString(PartialKeyPair.fromKeys(privateKey = privateKey))
		)
	}

	override suspend fun deleteKey(storageEntryKey: String) =
		stringStorage.removeItem(storageEntryKey)

	private suspend fun getPartialKeyPair(storageEntryKey: String): LoadedPartialKeyPair? =
		stringStorage.getItem(storageEntryKey)?.let {
			try {
				Serialization.json.decodeFromString(it)
			} catch (e: IllegalArgumentException) {
				throw IllegalEntityException("The stored value is not a valid key pair", e)
			}
		}

	@Serializable
	private data class LoadedPartialKeyPair(
		val publicKey: JsonElement? = null,
		val privateKey: JsonElement? = null
	) {
		val publicKeySpki get() = publicKey?.let { pub ->
			(pub as? JsonObject)?.let { AsnToJwkConverter.jwkToSpki(it.toPublicRsaKeyJwk()) }
				?: throw IllegalEntityException("Public key is neither not a JWK")
		}

		val privateKeyPkcs8 get() = privateKey?.let { priv ->
			(priv as? JsonObject)?.let { AsnToJwkConverter.jwkToPkcs8(it.toPrivateRsaKeyJwk()) }
				?: throw IllegalEntityException("Private key is not a JWK")
		}
	}

	@Serializable
	private data class PartialKeyPair(
		val publicKey: JsonElement? = null,
		val privateKey: JsonElement? = null
	) {
		companion object {
			fun fromKeys(
				publicKey: ByteArray? = null,
				privateKey: ByteArray? = null
			): PartialKeyPair = PartialKeyPair(
				publicKey = publicKey?.let {
					AsnToJwkConverter.spkiToJwk(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, it).toJson()
				},
				privateKey = privateKey?.let {
					AsnToJwkConverter.pkcs8ToJwk(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, it).toJson()
				},
			)
		}
	}
}

private fun JsonObject.toPrivateRsaKeyJwk(): PrivateRsaKeyJwk =
	PrivateRsaKeyJwk(
		alg = getValue("alg").also { require(it is JsonPrimitive && it.isString) { "alg is not a string"} }.jsonPrimitive.content,
		d = getValue("d").also { require(it is JsonPrimitive && it.isString) { "d is not a string"} }.jsonPrimitive.content,
		dp = getValue("dp").also { require(it is JsonPrimitive && it.isString) { "dp is not a string"} }.jsonPrimitive.content,
		dq = getValue("dq").also { require(it is JsonPrimitive && it.isString) { "dq is not a string"} }.jsonPrimitive.content,
		e = getValue("e").also { require(it is JsonPrimitive && it.isString) { "e is not a string"} }.jsonPrimitive.content,
		ext = getValue("ext").also { require(it is JsonPrimitive && it.booleanOrNull != null) { "ext is not a boolean"} }.jsonPrimitive.boolean,
		key_ops = Json.decodeFromJsonElement<Set<String>>(getValue("key_ops")),
		n = getValue("n").also { require(it is JsonPrimitive && it.isString) { "n is not a string"} }.jsonPrimitive.content,
		p = getValue("p").also { require(it is JsonPrimitive && it.isString) { "p is not a string"} }.jsonPrimitive.content,
		q = getValue("q").also { require(it is JsonPrimitive && it.isString) { "q is not a string"} }.jsonPrimitive.content,
		qi = getValue("qi").also { require(it is JsonPrimitive && it.isString) { "qi is not a string"} }.jsonPrimitive.content,
	)
private fun JsonObject.toPublicRsaKeyJwk(): PublicRsaKeyJwk =
	PublicRsaKeyJwk(
		alg = getValue("alg").also { require(it is JsonPrimitive && it.isString) { "alg is not a string"} }.jsonPrimitive.content,
		e = getValue("e").also { require(it is JsonPrimitive && it.isString) { "e is not a string"} }.jsonPrimitive.content,
		ext = getValue("ext").also { require(it is JsonPrimitive && it.booleanOrNull != null) { "ext is not a boolean"} }.jsonPrimitive.boolean,
		key_ops = Json.decodeFromJsonElement<Set<String>>(getValue("key_ops")),
		n = getValue("n").also { require(it is JsonPrimitive && it.isString) { "n is not a string"} }.jsonPrimitive.content,
	)
private fun PrivateRsaKeyJwk.toJson(): JsonElement =
	JsonObject(mapOf(
		"alg" to JsonPrimitive(alg),
		"d" to JsonPrimitive(d),
		"dp" to JsonPrimitive(dp),
		"dq" to JsonPrimitive(dq),
		"e" to JsonPrimitive(e),
		"ext" to JsonPrimitive(ext),
		"key_ops" to Json.encodeToJsonElement(key_ops),
		"n" to JsonPrimitive(n),
		"p" to JsonPrimitive(p),
		"q" to JsonPrimitive(q),
		"qi" to JsonPrimitive(qi),
	))
private fun PublicRsaKeyJwk.toJson(): JsonElement =
	JsonObject(mapOf(
		"alg" to JsonPrimitive(alg),
		"e" to JsonPrimitive(e),
		"ext" to JsonPrimitive(ext),
		"key_ops" to Json.encodeToJsonElement(key_ops),
		"n" to JsonPrimitive(n),
	))
