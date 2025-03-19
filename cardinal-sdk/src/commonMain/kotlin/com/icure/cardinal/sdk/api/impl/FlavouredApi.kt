package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.KSerializer

internal interface FlavouredApi<EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> {
	suspend fun validateAndMaybeEncrypt(entitiesGroupId: String?, entities: List<FlavouredEntity>): List<EncryptedEntity>
	suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedEntity>): List<FlavouredEntity>
}

internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.validateAndMaybeEncrypt(entitiesGroupId: String?, entity: FlavouredEntity): EncryptedEntity =
	validateAndMaybeEncrypt(entitiesGroupId, listOf(entity)).single()
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(entitiesGroupId: String?, entity: EncryptedEntity): FlavouredEntity =
	maybeDecrypt(entitiesGroupId, listOf(entity)).single()
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.validateAndMaybeEncrypt(entities: List<FlavouredEntity>): List<EncryptedEntity> =
	validateAndMaybeEncrypt(null, entities)
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(entities: List<EncryptedEntity>): List<FlavouredEntity> =
	maybeDecrypt(null, entities)
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(paginatedList: PaginatedList<EncryptedEntity>): PaginatedList<FlavouredEntity> =
	PaginatedList(maybeDecrypt(null, paginatedList.rows), paginatedList.nextKeyPair)
internal suspend inline fun <EncryptedEntity : HasEncryptionMetadata, FlavouredEntity : HasEncryptionMetadata> FlavouredApi<EncryptedEntity, FlavouredEntity>.maybeDecrypt(entitiesGroupId: String?, shareResults: List<EntityBulkShareResult<EncryptedEntity>>): List<EntityBulkShareResult<FlavouredEntity>> {
	val decryptedById = maybeDecrypt(entitiesGroupId, shareResults.mapNotNull { it.updatedEntity }).associateBy { it.id }
	return shareResults.map { shareResult ->
		shareResult.map { decryptedById.getValue(it.id) }
	}
}

@InternalIcureApi
internal suspend inline fun <Base, reified EncryptedEntity : Base, reified DecryptedEntity : Base> EntityEncryptionService.validateOrEncryptEntities(
	entitiesGroupId: String?,
	entities: List<Base>,
	entitiesType: EntityWithEncryptionMetadataTypeName,
	encryptedSerializer: KSerializer<EncryptedEntity>,
	decryptedSerializer: KSerializer<DecryptedEntity>,
	fieldsToEncrypt: EncryptedFieldsManifest
): List<EncryptedEntity> where Base : HasEncryptionMetadata, Base : Encryptable =
	validateOrEncryptEntities<Base, EncryptedEntity, DecryptedEntity>(
		entities = entities,
		doEncrypt = { decryptedEntities ->
			encryptEntities(
				entitiesGroupId,
				decryptedEntities,
				entitiesType,
				decryptedSerializer,
				fieldsToEncrypt
			) { Serialization.json.decodeFromJsonElement(encryptedSerializer, it) }
		},
		doValidate = {
			validateEncryptedEntities(
				it,
				entitiesType,
				encryptedSerializer,
				fieldsToEncrypt
			)
		}
	)

@InternalIcureApi
internal inline fun <Base, reified EncryptedEntity : Base, reified DecryptedEntity : Base> validateOrEncryptEntities(
	entities: List<Base>,
	// Should fail if any can't be encrypted
	doEncrypt: (List<DecryptedEntity>) -> List<EncryptedEntity>,
	// Should fail if any is not properly encrypted
	doValidate: (List<EncryptedEntity>) -> Unit
): List<EncryptedEntity> where Base : HasEncryptionMetadata, Base : Encryptable {
	val encryptedById = doEncrypt(entities.filterIsInstance<DecryptedEntity>()).associateBy { it.id }
	doValidate(entities.filterIsInstance<EncryptedEntity>())
	return entities.map { encryptedById[it.id] ?: it as EncryptedEntity }
}