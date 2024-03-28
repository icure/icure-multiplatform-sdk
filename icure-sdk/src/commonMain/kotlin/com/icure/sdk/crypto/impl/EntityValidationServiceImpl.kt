package com.icure.sdk.crypto.impl

import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
class EntityValidationServiceImpl(
	private val jsonEncryptionService: JsonEncryptionService
) : EntityValidationService {
	override suspend fun <E> validateEncryptedEntity(
		encryptedEntity: EntityWithTypeInfo<E>,
		encryptedEntitySerializer: SerializationStrategy<E>,
		fieldsToEncrypt: EncryptedFieldsManifest
	): E where E : Encryptable, E : HasEncryptionMetadata {
		val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, encryptedEntity.entity).jsonObject
		require (!jsonEncryptionService.requiresEncryption(encryptedJson, fieldsToEncrypt)) {
			"${encryptedEntity.type.id} ${encryptedEntity.id} has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
		}
		return encryptedEntity.entity
	}
}
