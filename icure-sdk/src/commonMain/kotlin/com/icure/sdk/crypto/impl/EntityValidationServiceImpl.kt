package com.icure.sdk.crypto.impl

import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
class EntityValidationServiceImpl(
	private val jsonEncryptionService: JsonEncryptionService
) : EntityValidationService {
	override suspend fun <E : Encryptable> validateEncryptedEntity(
		encryptedEntity: E,
		encryptedEntitySerializer: SerializationStrategy<E>,
		fieldsToEncrypt: EncryptedFieldsManifest
	): E {
		val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, encryptedEntity).jsonObject
		require (!jsonEncryptionService.requiresEncryption(encryptedJson, fieldsToEncrypt)) {
			"${encryptedEntity.type.id} ${encryptedEntity.id} has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
		}
		return encryptedEntity
	}
}