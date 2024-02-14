package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.json.JsonObject

@InternalIcureApi
interface JsonEncryptionService {
	/**
	 * Encrypts the fields of the given [plainJson] according to the [manifest] and returns the encrypted JSON.
	 * If a field that should be encrypted is not present in the [plainJson], it will be ignored.
	 * As long as the field is present, even if the value is null or empty, it will be encrypted.
	 */
	suspend fun encrypt(encryptionKey: AesKey, plainJson: JsonObject, manifest: EncryptedFieldsManifest): JsonObject
	fun requiresEncryption(plainJson: JsonObject, manifest: EncryptedFieldsManifest): Boolean
	suspend fun decrypt(encryptionKey: AesKey, encryptedJson: JsonObject): JsonObject
}