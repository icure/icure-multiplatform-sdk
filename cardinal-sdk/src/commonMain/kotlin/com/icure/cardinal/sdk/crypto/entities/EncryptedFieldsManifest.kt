package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi

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
) {
	val allKeys get() = topLevelFields + nestedObjectsKeys.keys + mapsValuesKeys.keys + arraysValuesKeys.keys
}