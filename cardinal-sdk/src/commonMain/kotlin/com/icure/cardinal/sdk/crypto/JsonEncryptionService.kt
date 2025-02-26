package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive

@InternalIcureApi
interface JsonEncryptionService {
	/**
	 * Encrypts the fields of the given [plainJson] according to the [manifest] and returns the encrypted JSON.
	 */
	suspend fun encrypt(encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>, plainJson: JsonObject, manifest: EncryptedFieldsManifest): JsonObject
	suspend fun encrypt(plainJson: JsonObject, manifest: EncryptedFieldsManifest, doEncrypt: suspend (ByteArray) -> ByteArray, doDecrypt: suspend (ByteArray) -> ByteArray  ): JsonObject

	/**
	 * Returns true if the given [plainJson] specifies a value at least a value that according to the provided
	 * [manifest] should be encrypted.
	 */
	fun requiresEncryption(plainJson: JsonObject, manifest: EncryptedFieldsManifest): Boolean

	/**
	 * Decrypts the provided json using the given [encryptionKey] and returns the decrypted JSON. This method
	 * explores all nested objects in the original encrypted object to check if they need to be decrypted.
	 * If for some reason the encrypted content of the object is recursively encrypted only the first level of
	 * encryption is done.
	 */
	suspend fun decrypt(encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>, encryptedJson: JsonObject): JsonObject
	suspend fun decrypt(encryptedJson: JsonObject, doDecrypt: suspend (ByteArray) -> ByteArray): JsonObject

	companion object {
		/**
		 * Parse the encrypted fields configuration for a specific entity type.
		 *
		 * ## Grammar
		 *
		 * The grammar for each encrypted field is the following:
		 * ```
		 * fieldName :=
		 *   regex([a-zA-Z_][a-zA-Z0-9_]+)
		 * encryptedField :=
		 *   fieldName
		 *   | fieldName + ("." | ".*." | "[].") + encryptedField
		 * ```
		 *
		 * This grammar allows you to specify the fields to encrypt for the object and recursively for nested objects.
		 * - A string containing only a single `fieldName` will encrypt the field with the given name.
		 * - A string starting with `fieldName.` allows to specify the encrypted fields of a nested object. The encrypted values of the
		 *   fields in the nested object will be saved in the nested object.
		 * - A string starting with `fieldName.*.` treats `fieldName` as a map/dictionary data structure and allows to specify the encrypted fields of the
		 *   values of the map. Note that the values of the map must be objects as well. The encrypted content of each map value is stored in that value.
		 * - A string starting with `fieldName[].` treats `fieldName` as an array and allows to specify the encrypted fields of the values of the array.
		 *   Note that the values of the array must be objects as well. The encrypted content of each array element is stored in that element.
		 *
		 * ## Example
		 *
		 * Consider the following object and encryption keys:
		 * ```javascript
		 * const obj = {
		 *   a: { x: 0, y: 1 },
		 *   b: "hello",
		 *   c: [ { public: "a", secret: "b" }, { public: "c", secret: "d" } ],
		 *   d: "ok",
		 *   e: {
		 *     info: "something",
		 *     private: "secret",
		 *     dataMap: {
		 *       "en": {
		 *         a: 1,
		 *         b: 2
		 *       },
		 *       "fr": {
		 *         a: 3,
		 *         b: 4
		 *       }
		 *     }
		 *   }
		 * }
		 * const encryptedFields = [
		 *   "a",
		 *   "c[].secret",
		 *   "d",
		 *   "e.private",
		 *   "e.datamap.*.a"
		 * ]
		 * ```
		 * If you use them with the crypt method you will get the following result:
		 * ```json
		 * {
		 *   b: "hello",
		 *   c: [
		 *     { public: "a", encryptedSelf: "...encrypted data of c[0]" },
		 *     { public: "c", encryptedSelf: "...encrypted data of c[1]" }
		 *   ],
		 *   e: {
		 *     info: "something",
		 *     dataMap: {
		 *       "en": { b: 2, encryptedSelf: "...encrypted data of e.dataMap['en']" },
		 *       "fr": { b: 4, encryptedSelf: "...encrypted data of e.dataMap['fr']" }
		 *     },
		 *     encryptedSelf: "...encrypted data of e"
		 *   },
		 *   encryptedSelf: "...encrypted data of obj"
		 * }
		 * ```
		 *
		 * ## Shortened representation
		 *
		 * You can also group encrypted fields having the same prefix by concatenating to the prefix the JSON representation of an array of all the postfixes.
		 * For example the following encrypted fields:
		 * ```javascript
		 * const encryptedFields = ["a.b.c.d.e.f1", "a.b.c.d.e.f2", "a.b.c.d.e.f3", "a.b.c.d.e.f4"]
		 * ```
		 * can be shortened to
		 * ```javascript
		 * const encryptedFields = ['a.b.c.d.e.["f1","f2","f3","f4"]'] // Note the use of single quotes to avoid escaping the double quotes
		 * ```
		 * If you use the shortened representation you may need to escape nested json representations. In that case the use of `JSON.stringify` is
		 * recommended.
		 *
		 * @param encryptedFields
		 * @param path
		 */
		fun parseEncryptedFields(encryptedFields: Set<String>, path: String): EncryptedFieldsManifest {
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
				val (currFieldName, currFieldSeparator) = parseCurrentFieldAndSeparator(path, currEncryptedField)
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

					else -> throw InternalCardinalException("Unknown separator $currFieldSeparator passed regex validation in $path$currEncryptedField")
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

		private val LOWER_RANGE = 'a' .. 'z'
		private val UPPER_RANGE = 'A' .. 'Z'
		private val DIGIT_RANGE = '0' .. '9'
		private fun parseCurrentFieldAndSeparator(
			path: String,
			currEncryptedField: String
		): Pair<String, String?> {
			val fieldName = if (currEncryptedField.first() == '*') {
				"*"
			} else {
				require(currEncryptedField.first().let { it in LOWER_RANGE || it in UPPER_RANGE || it == '_'}) {
					"Invalid encrypted field $path$currEncryptedField - $currEncryptedField must start with a valid identifier"
				}
				currEncryptedField.takeWhile { it in LOWER_RANGE || it in UPPER_RANGE || it == '_' || it in DIGIT_RANGE }
			}
			if (fieldName.length == currEncryptedField.length) return Pair(currEncryptedField, null)
			val currWithoutFieldName = currEncryptedField.substring(fieldName.length)
			val separator = when {
				currWithoutFieldName.startsWith(".*.") -> ".*."
				currWithoutFieldName.startsWith("[].") -> "[]."
				currWithoutFieldName.startsWith(".") -> "."
				else -> throw IllegalArgumentException("Invalid encrypted field $path$currEncryptedField - $currWithoutFieldName contains an invalid separator")
			}
			require(
				(currWithoutFieldName.length > separator.length && currWithoutFieldName[separator.length].let {
					it in LOWER_RANGE || it in UPPER_RANGE || it == '_' || it == '['
				}) || (currWithoutFieldName.length == separator.length + 1 && currWithoutFieldName.last() == '*')
			) {
				"Invalid encrypted field $path$currEncryptedField - Invalid followup to separator ${currWithoutFieldName.substring(separator.length)}"
			}
			return Pair(fieldName, separator)
		}
	}
}