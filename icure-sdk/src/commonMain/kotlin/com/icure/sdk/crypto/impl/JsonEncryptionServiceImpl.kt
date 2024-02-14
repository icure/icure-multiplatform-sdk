package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import com.icure.sdk.crypto.EncryptedFieldsManifest
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.model.Encryptable
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@InternalIcureApi
class JsonEncryptionServiceImpl(
	private val cryptoService: CryptoService
): JsonEncryptionService {
	companion object {
		private val ENCRYPTED_SELF = Encryptable::encryptedSelf.name
	}

	override suspend fun encrypt(
		encryptionKey: AesKey,
		plainJson: JsonObject,
		manifest: EncryptedFieldsManifest
	): JsonObject {
		val objWithoutSecrets = plainJson.mapNotNull { (key, value) ->
			(
				manifest.nestedObjectsKeys[key]?.let {
					encrypt(encryptionKey, value.jsonObject, it)
				} ?: manifest.arraysValuesKeys[key]?.let {  manifest ->
					JsonArray(value.jsonArray.map { encrypt(encryptionKey, it.jsonObject, manifest) })
				} ?: manifest.mapsValuesKeys[key]?.let {  manifest ->
					JsonObject(value.jsonObject.mapValues { encrypt(encryptionKey, it.value.jsonObject, manifest) })
				} ?: value.takeUnless { manifest.topLevelFields.contains(key) }
			)?.let { key to it }
		}.toMap()
		val objToEncrypt = plainJson.filter { (key, _) ->
			manifest.topLevelFields.contains(key)
		}
		val encryptedSelfContent = plainJson[ENCRYPTED_SELF]?.jsonPrimitive?.content?.let {
			kotlin.runCatching {
				val decryptedBytes = cryptoService.aes.decrypt(base64Decode(it), encryptionKey)
				Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()).jsonObject
			}.getOrNull()
		}
		return if (encryptedSelfContent != objToEncrypt) {
			JsonObject(
				objWithoutSecrets + Pair(
					ENCRYPTED_SELF,
					JsonPrimitive(base64Encode(cryptoService.aes.encrypt(
						JsonObject(objToEncrypt).toString().toByteArray(Charsets.UTF_8),
						encryptionKey
					)))
				)
			)
		} else JsonObject(objWithoutSecrets)
	}

	override fun requiresEncryption(plainJson: JsonObject, manifest: EncryptedFieldsManifest): Boolean =
		manifest.topLevelFields.any {
			plainJson.containsKey(it)
		} || manifest.nestedObjectsKeys.any { (nestedObjectField, manifest) ->
			plainJson[nestedObjectField]?.let { requiresEncryption(it.jsonObject, manifest) } == true
		} || manifest.arraysValuesKeys.any { (arrayField, manifest) ->
			plainJson[arrayField]?.jsonArray?.any { arrayElement ->
				requiresEncryption(arrayElement.jsonObject, manifest)
			} == true
		} || manifest.mapsValuesKeys.any { (mapField, manifest) ->
			plainJson[mapField]?.jsonObject?.values?.any { mapElement ->
				requiresEncryption(mapElement.jsonObject, manifest)
			} == true
		}

	override suspend fun decrypt(key: AesKey, encryptedJson: JsonObject): JsonObject {
		// First decrypt recursively, since values decrypted from encryptedSelf can't contain more encryptedSelf.
		val recursivelyDecrypted = encryptedJson.mapValues { (_, value) ->
			when (value) {
				is JsonObject -> decrypt(key, value)
				is JsonArray -> if (value.all { it is JsonObject }) {
					JsonArray(value.map { decrypt(key, it.jsonObject) })
				} else value
				else -> value
			}
		}
		val decryptedSelf = encryptedJson[ENCRYPTED_SELF]?.jsonPrimitive?.also {
			if (!it.isString) throw IllegalEntityException("Encrypted self must be a string")
		}?.content?.let {
			val decryptedBytes = cryptoService.aes.decrypt(base64Decode(it), key)
			Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()).jsonObject
		}
		return decryptedSelf?.let { JsonObject(recursivelyDecrypted + it) } ?: JsonObject(recursivelyDecrypted)
	}
}