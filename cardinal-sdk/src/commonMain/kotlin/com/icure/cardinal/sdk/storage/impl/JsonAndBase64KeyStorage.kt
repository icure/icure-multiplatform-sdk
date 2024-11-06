package com.icure.cardinal.sdk.storage.impl

import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.storage.KeyStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.IllegalEntityException
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString

/**
 * Implementation of [KeyStorageFacade] that encodes the byte arrays as base64 and stores the as json strings.
 * Note that this does not provide any security: if the provided [StorageFacade] stores the strings in plain text the
 * keys (public AND private) will be stored as plain text.
 * @param stringStorage Facade used to store the encoded keys.
 */
class JsonAndBase64KeyStorage(
	private val stringStorage: StorageFacade
) : KeyStorageFacade {
	override suspend fun getPublicKeySpki(storageEntryKey: String): ByteArray? =
		getPartialKeyPair(storageEntryKey)?.let { p ->
			p.publicKey?.let { base64Decode(it) }
				?: throw IllegalEntityException("The stored value is not a public key")
		}

	override suspend fun getPrivateKeyPkcs8(storageEntryKey: String): ByteArray? =
		getPartialKeyPair(storageEntryKey)?.let { p ->
			p.privateKey?.let { base64Decode(it) }
				?: throw IllegalEntityException("The stored value is not a private key")
		}

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

	private suspend fun getPartialKeyPair(storageEntryKey: String): PartialKeyPair? =
		stringStorage.getItem(storageEntryKey)?.let {
			try {
				Serialization.json.decodeFromString(it)
			} catch (e: IllegalArgumentException) {
				throw IllegalEntityException("The stored value is not a valid key pair", e)
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