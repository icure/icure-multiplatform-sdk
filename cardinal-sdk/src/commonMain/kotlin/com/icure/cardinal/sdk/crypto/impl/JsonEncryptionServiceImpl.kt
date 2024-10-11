package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.Serialization
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@InternalIcureApi
class JsonEncryptionServiceImpl(
	private val cryptoService: CryptoService
) : JsonEncryptionService {
	companion object {
		private val ENCRYPTED_SELF = Encryptable::encryptedSelf.name
	}

	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		plainJson: JsonObject,
		manifest: EncryptedFieldsManifest
	): JsonObject =
		encrypt(plainJson, manifest, { cryptoService.aes.encrypt(it, encryptionKey) }, { cryptoService.aes.decrypt(it, encryptionKey) })

	override suspend fun encrypt(
		plainJson: JsonObject,
		manifest: EncryptedFieldsManifest,
		doEncrypt: suspend (ByteArray) -> ByteArray,
		doDecrypt: suspend (ByteArray) -> ByteArray
	): JsonObject {
		val objWithoutSecrets = plainJson.mapNotNull { (key, value) ->
			(
				manifest.nestedObjectsKeys[key]?.let { subManifest ->
					when (value) {
						JsonNull -> value
						is JsonObject -> encrypt(value, subManifest, doEncrypt, doDecrypt)
						else -> throw IllegalArgumentException("${manifest.path}$key should be an object or null")
					}
				} ?: manifest.arraysValuesKeys[key]?.let { subManifest ->
					when (value) {
						JsonNull -> value
						is JsonArray -> JsonArray(value.mapIndexed { index, item ->
							when (item) {
								JsonNull -> item
								is JsonObject -> encrypt(item, subManifest, doEncrypt, doDecrypt)
								else -> throw IllegalArgumentException("All items of ${manifest.path}$key should objects or null (invalid item at index ${manifest.path}$key[$index])")
							}
						})
						else -> throw IllegalArgumentException("${manifest.path}$key should be an array or null")
					}
				} ?: manifest.mapsValuesKeys[key]?.let { subManifest ->
					when (value) {
						JsonNull -> value
						is JsonObject -> JsonObject(value.jsonObject.mapValues { (k, v) ->
							when (v) {
								JsonNull -> v
								is JsonObject -> encrypt(v, subManifest, doEncrypt, doDecrypt)
								else -> throw IllegalArgumentException("All values in map-like object ${manifest.path}$key should be objects or null (invalid value at ${manifest.path}$key.$k)")
							}
						})
						else -> throw IllegalArgumentException("${manifest.path}$key should be an object or null")
					}
				} ?: value.takeUnless { manifest.topLevelFields.contains(key) }
				)?.let { key to it }
		}.toMap()
		val objToEncrypt = plainJson.filter { (key, _) ->
			manifest.topLevelFields.contains(key)
		}
		val encryptedSelfContent = plainJson[ENCRYPTED_SELF]?.jsonPrimitive?.content?.let {
			kotlin.runCatching {
				val decryptedBytes = doDecrypt(base64Decode(it))
				Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()).jsonObject
			}.getOrNull()
		}
		return if (encryptedSelfContent != objToEncrypt) {
			JsonObject(
				objWithoutSecrets + Pair(
					ENCRYPTED_SELF,
					JsonPrimitive(
						base64Encode(
							doEncrypt(JsonObject(objToEncrypt).toString().toByteArray(Charsets.UTF_8))
						)
					)
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


	override suspend fun decrypt(encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>, encryptedJson: JsonObject): JsonObject =
		decrypt(encryptedJson) { cryptoService.aes.decrypt(it, encryptionKey) }
	override suspend fun decrypt(encryptedJson: JsonObject, doDecrypt: suspend (ByteArray) -> ByteArray): JsonObject {
		// First decrypt recursively, since values decrypted from encryptedSelf can't contain more encryptedSelf.
		val recursivelyDecrypted = encryptedJson.mapValues { (_, value) ->
			when (value) {
				is JsonObject -> decrypt(value, doDecrypt)
				is JsonArray -> if (value.all { it is JsonObject || it == JsonNull }) {
					JsonArray(value.map { if (it == JsonNull) it else decrypt(it.jsonObject, doDecrypt) })
				} else value
				else -> value
			}
		}
		val decryptedSelf = encryptedJson[ENCRYPTED_SELF]?.jsonPrimitive?.also {
			if (!it.isString) throw IllegalEntityException("Encrypted self must be a string")
		}?.content?.let {
			val decryptedBytes = doDecrypt(base64Decode(it))
			Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()).jsonObject
		}
		return decryptedSelf?.let { JsonObject(recursivelyDecrypted + it) } ?: JsonObject(recursivelyDecrypted)
	}
}
