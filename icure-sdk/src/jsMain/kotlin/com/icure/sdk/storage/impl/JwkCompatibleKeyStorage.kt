package com.icure.sdk.storage.impl

import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import com.icure.sdk.storage.KeyStorageFacade
import com.icure.sdk.storage.StorageFacade
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

/**
 * A KeyStorageFacade that can read stored keys even if they were stored in the JWK format. Provides compatibility
 * with the keys that were stored by the native typescript SDK.
 * New keys will be stored in the raw format.
 */
class JwkCompatibleKeyStorage(
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
			(pub as? JsonPrimitive)?.takeIf { it.isString }?.content?.let { base64Decode(it) }
				?: (pub as? JsonObject)?.let { jwkToSpki(it) }
				?: throw IllegalEntityException("Public key is neither a string nor a JWK")
		}

		val privateKeyPkcs8 get() = privateKey?.let { priv ->
			(priv as? JsonPrimitive)?.takeIf { it.isString }?.content?.let { base64Decode(it) }
				?: (priv as? JsonObject)?.let { jwkToPkcs8(it) }
				?: throw IllegalEntityException("Private key is neither a string nor a JWK")
		}
	}

	@Serializable
	private data class PartialKeyPair(
		val publicKey: String? = null,
		val privateKey: String? = null
	) {
		companion object {
			fun fromKeys(
				publicKey: ByteArray? = null,
				privateKey: ByteArray? = null
			): PartialKeyPair = PartialKeyPair(
				publicKey = publicKey?.let { base64Encode(it) },
				privateKey = privateKey?.let { base64Encode(it) },
			)
		}
	}
}

private fun jwkToSpki(json: JsonObject): ByteArray {
	// This method should probably be part of the kryptom library
	// Once implemented we should test this method + the jwk compatible key storage
	// For testing the storage we can use a volatile storage facade with data taken from SDK v7/v8
	// For testing the jwk to spki method we can generate test data using subtle export to jwk and spki of the same key
	TODO()
}

private fun jwkToPkcs8(json: JsonObject): ByteArray {
	// Read notes from jwkToSpki
	TODO()
}
