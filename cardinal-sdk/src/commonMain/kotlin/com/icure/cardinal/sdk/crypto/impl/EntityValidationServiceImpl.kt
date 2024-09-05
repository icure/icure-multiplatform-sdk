package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.EntityValidationService
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.Serialization
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
		if (jsonEncryptionService.requiresEncryption(encryptedJson, fieldsToEncrypt)) throw EntityEncryptionException(
			"${encryptedEntity.type.id} ${encryptedEntity.id} has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
		)
		return encryptedEntity.entity
	}
}
