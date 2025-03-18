package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.EntityValidationService
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
class EntityValidationServiceImpl(
	private val jsonEncryptionService: JsonEncryptionService
) : EntityValidationService {
	override suspend fun <E> validateEncryptedEntities(
		encryptedEntities: List<E>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		encryptedEntitySerializer: SerializationStrategy<E>,
		fieldsToEncrypt: EncryptedFieldsManifest
	): List<E> where E : Encryptable, E : HasEncryptionMetadata {
		encryptedEntities.forEach { encryptedEntity ->
			val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, encryptedEntity).jsonObject
			if (jsonEncryptionService.requiresEncryption(encryptedJson, fieldsToEncrypt)) throw EntityEncryptionException(
				"$entitiesType(\"${encryptedEntity.id}\") has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
			)
		}
		return encryptedEntities
	}
}
