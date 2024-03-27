package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.Serialization
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
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
		private val ENCRYPTED_FIELD_MANIFEST_REGEX =
			Regex("^([_a-zA-Z][_a-zA-Z0-9]*)(?:(\\.\\*\\.|\\[]\\.|\\.)(?:[_a-zA-Z].*|\\[.*]))?$")
	}

	override suspend fun encrypt(
		encryptionKey: AesKey,
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


	override suspend fun decrypt(encryptionKey: AesKey, encryptedJson: JsonObject): JsonObject =
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

	override fun parseEncryptedFields(encryptedFields: Set<String>, path: String): EncryptedFieldsManifest {
		val topLevelFields = mutableSetOf<String>()
		val nestedObjectsKeys = mutableMapOf<String, MutableSet<String>>()
		val mapsValuesKeys = mutableMapOf<String, MutableSet<String>>()
		val arraysValuesKeys = mutableMapOf<String, MutableSet<String>>()
		fun addSubkeyToGroupedData(
			currFieldName: String,
			currFieldSeparator: String,
			currEncryptedField: String,
			groupedData: MutableMap<String, MutableSet<String>>
		) {
			val existingOrNew = groupedData.getOrPut(currFieldName) { mutableSetOf() }
			val subKey = currEncryptedField.drop(currFieldName.length + currFieldSeparator.length)
			if (subKey.startsWith('[')) {
				val parsedJson: JsonElement = try {
					Json.parseToJsonElement(subKey)
				} catch (e: Exception) {
					throw IllegalArgumentException(
						"Invalid encrypted field ${path}${currEncryptedField} (not a valid JSON subkey)",
						e
					)
				}
				if (parsedJson is JsonArray && parsedJson.all { it is JsonPrimitive && it.isString }) {
					existingOrNew += parsedJson.map { it.jsonPrimitive.content }
				} else throw IllegalArgumentException("Invalid encrypted field ${path}${currEncryptedField} (not an array of strings)")
			} else {
				existingOrNew += subKey
			}
		}
		encryptedFields.forEach { currEncryptedField ->
			val (currFieldName, currFieldSeparator) = requireNotNull(
				ENCRYPTED_FIELD_MANIFEST_REGEX.find(
					currEncryptedField
				)
			) {
				"Invalid encrypted field $path$currEncryptedField"
			}.groupValues.let { groups ->
				groups[1] to groups[2].takeIf { it.isNotEmpty() }
			}
			when (currFieldSeparator) {
				null -> {
					if (currFieldName in topLevelFields) throw IllegalArgumentException("Duplicate encrypted field $path$currFieldName")
					if (currFieldName in nestedObjectsKeys || currFieldName in mapsValuesKeys || currFieldName in arraysValuesKeys) {
						throw IllegalArgumentException("Encrypted field appears multiple times as different nested types and or top-level-field: $path$currFieldName")
					}
					topLevelFields += currFieldName
				}

				"." -> {
					if (currFieldName in topLevelFields || currFieldName in mapsValuesKeys || currFieldName in arraysValuesKeys) {
						throw IllegalArgumentException("Encrypted field appears multiple times as different nested types and or top-level-field: $path$currFieldName")
					}
					addSubkeyToGroupedData(currFieldName, currFieldSeparator, currEncryptedField, nestedObjectsKeys)
				}

				".*." -> {
					if (currFieldName in topLevelFields || currFieldName in nestedObjectsKeys || currFieldName in arraysValuesKeys) {
						throw IllegalArgumentException("Encrypted field appears multiple times as different nested types and or top-level-field: $path$currFieldName")
					}
					addSubkeyToGroupedData(currFieldName, currFieldSeparator, currEncryptedField, mapsValuesKeys)
				}

				"[]." -> {
					if (currFieldName in topLevelFields || currFieldName in nestedObjectsKeys || currFieldName in mapsValuesKeys) {
						throw IllegalArgumentException("Encrypted field appears multiple times as different nested types and or top-level-field: $path$currFieldName")
					}
					addSubkeyToGroupedData(currFieldName, currFieldSeparator, currEncryptedField, arraysValuesKeys)
				}

				else -> throw InternalIcureException("Unknown separator $currFieldSeparator passed regex validation in $path$currEncryptedField")
			}
		}
		return EncryptedFieldsManifest(
			path = path,
			topLevelFields = topLevelFields,
			nestedObjectsKeys = nestedObjectsKeys.mapValues { (fieldName, fieldNames) ->
				parseEncryptedFields(fieldNames, "$path$fieldName.")
			},
			mapsValuesKeys = mapsValuesKeys.mapValues { (fieldName, fieldNames) ->
				parseEncryptedFields(fieldNames, "$path$fieldName.*.")
			},
			arraysValuesKeys = arraysValuesKeys.mapValues { (fieldName, fieldNames) ->
				parseEncryptedFields(fieldNames, "$path$fieldName[].")
			}
		)
	}
}