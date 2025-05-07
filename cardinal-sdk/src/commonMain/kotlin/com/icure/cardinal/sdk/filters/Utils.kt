package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal suspend fun List<Pair<EntityWithEncryptionMetadataStub, String?>>.mapToSecretIds(
	entityEncryptionService: EntityEncryptionService,
	entitiesType: EntityWithEncryptionMetadataTypeName
): Set<String> {
	val allResultsMap = mutableMapOf<String, MutableSet<String>>()
	groupBy { it.second }.forEach { (groupId, entities) ->
		entityEncryptionService.secretIdsOf(
			groupId,
			entities.map { it.first },
			entitiesType,
			null
		).forEach { (entityId, secretIds) ->
			allResultsMap.getOrPut(entityId) { mutableSetOf() }.addAll(secretIds)
		}
	}
	return flatMapTo(mutableSetOf()) { allResultsMap.getValue(it.first.id) }
}