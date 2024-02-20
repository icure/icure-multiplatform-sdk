package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.json.JsonObject

/**
 * Configuration for the encryption of an object.
 * @param topLevelFields the fields of the object to encrypt. All the fields will be encrypted in a single encryptedSelf
 * field which is added to the object.
 * @param nestedObjectsKeys the name of fields which are expected to contain a nested object (or undefined). Allows to specify
 */
@InternalIcureApi
data class EncryptedFieldsManifest(
	/**
	 * The path of this manifest in the object. For the top-level manifest this should be "Type." where Type is the type
	 * of the object (e.g. patient). For nested fields it should by "Type.nestedField." where nestedField.
	 */
	val path: String,
	/**
	 * Specifies which top-level fields of the object should be encrypted. If a field that should be encrypted is not
	 * present in the json, it will be ignored.
	 * If the field is present, even if the value is null or empty, it will be encrypted.
	 */
	val topLevelFields: Set<String>,
	/**
	 * Specifies manifests to use for nested objects.
	 */
	val nestedObjectsKeys: Map<String, EncryptedFieldsManifest>,
	/**
	 * Specifies manifests to use for all values of nested objects that represent key-value maps.
	 */
	val mapsValuesKeys: Map<String, EncryptedFieldsManifest>,
	/**
	 * Specifies manifests to use for all values of nested arrays.
	 */
	val arraysValuesKeys: Map<String, EncryptedFieldsManifest>,
)

@InternalIcureApi
interface JsonEncryptionService {
	/**
	 * Encrypts the fields of the given [plainJson] according to the [manifest] and returns the encrypted JSON.
	 */
	suspend fun encrypt(encryptionKey: AesKey, plainJson: JsonObject, manifest: EncryptedFieldsManifest): JsonObject
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
	suspend fun decrypt(encryptionKey: AesKey, encryptedJson: JsonObject): JsonObject
	suspend fun decrypt(encryptedJson: JsonObject, doDecrypt: suspend (ByteArray) -> ByteArray): JsonObject

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
	fun parseEncryptedFields(encryptedFields: Set<String>, path: String): EncryptedFieldsManifest
}