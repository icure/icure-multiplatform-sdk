package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.BaseSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class BaseSecurityMetadataDecryptorImpl(
	private val boundGroup: SdkBoundGroup?,
	private val cryptoService: CryptoService,
	private val exchangeKeysManager: ExchangeKeysManager,
	private val exchangeDataManager: ExchangeDataManager,
	private val secureDelegationsEncryption: SecureDelegationsEncryption,
	private val exchangeDataMap: ExchangeDataMapManager
) : BaseSecurityMetadataDecryptor {
	override suspend fun <T : Any> decryptLegacyDelegations(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		require(dataOwnersHierarchySubset.isNotEmpty()) { "Data owners hierarchy subset can't be empty" }
		// Legacy delegations use only cached data, no need to operate in bulk
		return entities.associate { e ->
			e.id to extractFromLegacyDelegations(
				entitiesGroupId,
				e,
				dataOwnersHierarchySubset,
				metadataType
			).map {
				it.value
			}.distinct().mapTo(mutableSetOf()) {
				metadataType.mapLegacyDecrypted(it)
			}
		}
	}

	private suspend fun extractFromLegacyDelegations(
		entitiesGroupId: String?,
		entity: HasEncryptionMetadata,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<*>
	): List<DecryptedMetadataDetails<String>> = if (boundGroup.resolve(entitiesGroupId) != null) {
		// Legacy delegations don't support inter-group sharing
		emptyList()
	} else {
		metadataType.extractLegacyDelegations(entity).flatMap { (delegateId, delegations) ->
			populateLegacyDelegationDelegate(
				delegateId,
				if (delegateId in dataOwnersHierarchySubset) {
					delegations
				} else {
					delegations.filterTo(mutableSetOf()) { it.owner in dataOwnersHierarchySubset }
				}
			)
		}.mapNotNull {
			tryDecryptLegacyDelegation(it, metadataType)
		}
	}

	private fun populateLegacyDelegationDelegate(delegateId: String, delegations: Set<Delegation>): Set<Delegation> {
		return delegations.mapTo(mutableSetOf()) {
			if (it.delegatedTo == delegateId) it else it.copy(delegatedTo = delegateId)
		}
	}

	private suspend fun tryDecryptLegacyDelegation(
		delegation: Delegation,
		metadataType: SecurityMetadataType<*>
	): DecryptedMetadataDetails<String>? {
		if (delegation.key == null) {
			return null
		}
		if (delegation.owner == null || delegation.delegatedTo == null) {
			return null
		}
		val exchangeKeys = exchangeKeysManager.getDecryptionExchangeKeysFor(
			delegatorId = delegation.owner,
			delegateId = delegation.delegatedTo,
		)
		return exchangeKeys.firstNotNullOfOrNull {
			kotlin.runCatching {
				// Format of encrypted key for any delegation should be entityId:key, but with the merging of entities the entityId might not match the
				// current id. As a checksum we are only verifying that the decrypted bytes can be represented as a string with exactly one ':'.
				// Additionally, we also have a validator that is specific for each type of delegation content (encryption key, secret id, ...)
				cryptoService.aes.decrypt(delegation.key.decodedBytes(), it)
					.decodeToString().split(":").takeIf { it.size == 2 }?.last()
					?.takeIf { metadataType.validateLegacyDecrypted(it) }
					?.let {
						DecryptedMetadataDetails(
							it,
							setOf(delegation.owner, delegation.delegatedTo)
						)
					}
			}.getOrNull()
		}
	}

	override suspend fun <T : Any> decryptSecureDelegationsUsingCache(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchById = mutableSetOf<String>()
		val toSearchByDelegationKey = mutableSetOf<SecureDelegationKeyString>()
		entities.forEach { e ->
			e.securityMetadata?.secureDelegations?.forEach { (delegationKey, delegation) ->
				if (
					delegation.delegator == null ||
					delegation.delegate == null ||
					delegation.delegator in dataOwnersHierarchyReferences ||
					delegation.delegate in dataOwnersHierarchyReferences
				) {
					if (delegation.exchangeDataId != null) {
						toSearchById.add(delegation.exchangeDataId)
					} else {
						toSearchByDelegationKey.add(delegationKey)
					}
				}
			}
		}
		val cachedByExchangeDataId = exchangeDataManager.getDecryptionDataByIds(
			entitiesGroupId,
			toSearchById,
			false
		)
		val cachedByDelegationKey = exchangeDataManager.getCachedDecryptionDataKeyByAccessControlHash(
			entitiesGroupId,
			toSearchByDelegationKey
		)
		return entities.associate { entity ->
			entity.id to entity.securityMetadata?.secureDelegations?.flatMapTo(mutableSetOf()) { (delegationKey, delegation) ->
				val cached =
					if (delegation.exchangeDataId != null)
						cachedByExchangeDataId[delegation.exchangeDataId]
					else
						cachedByDelegationKey[delegationKey]
				val exchangeKey = cached?.unencryptedContent?.exchangeKey
				if (
					exchangeKey != null && (
						cached.exchangeData.delegate in dataOwnersHierarchyReferences ||
							cached.exchangeData.delegator in dataOwnersHierarchyReferences
					)
				) {
					metadataType.decryptSecureDelegation(delegation, exchangeKey, secureDelegationsEncryption)
				} else emptySet()
			}.orEmpty()
		}
	}

	override suspend fun <T : Any> decryptSecureDelegationsUsingKnownExchangeData(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchById = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.values?.mapNotNull { delegation ->
				if (
					(
						delegation.delegate in dataOwnersHierarchyReferences ||
						delegation.delegator in dataOwnersHierarchyReferences
					) && delegation.exchangeDataId != null && metadataType.hasValueIn(delegation)
				) {
					delegation.exchangeDataId
				} else null
			}.orEmpty()
		}
		val retrievedByExchangeDataId = if (toSearchById.isNotEmpty()) exchangeDataManager.getDecryptionDataByIds(
			entitiesGroupId,
			toSearchById,
			true
		) else emptyMap()
		return entities.associate { entity ->
			entity.id to entity.securityMetadata?.secureDelegations?.values?.flatMapTo(mutableSetOf()) { delegation ->
				val cached =
					if (delegation.exchangeDataId != null)
						retrievedByExchangeDataId[delegation.exchangeDataId]
					else
						null
				val exchangeKey = cached?.unencryptedContent?.exchangeKey
				if (exchangeKey != null) {
					metadataType.decryptSecureDelegation(delegation, exchangeKey, secureDelegationsEncryption)
				} else emptySet()
			}.orEmpty()
		}
	}

	override suspend fun <T : Any> decryptSecureDelegationsUsingExchangeDataMap(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchByDelegationKey = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.mapNotNull { (delegationKey, delegation) ->
				if (
					(
						delegation.delegate in dataOwnersHierarchyReferences ||
							delegation.delegator in dataOwnersHierarchyReferences
					) && delegation.exchangeDataId == null && metadataType.hasValueIn(delegation)
				) {
					// Note: if the data owner was anonymous we already got the data before.
					delegationKey
				} else null
			}.orEmpty()
		}
		// Note cached could have more than what was cached at decryptSecureDelegationsUsingCache in case of parallel requests
		val alreadyCached = exchangeDataManager.getCachedDecryptionDataKeyByAccessControlHash(
			entitiesGroupId,
			toSearchByDelegationKey
		)
		val uncachedToGetMap = toSearchByDelegationKey.filterTo(mutableSetOf()) { it !in alreadyCached }
		val exchangeDataMaps = if (uncachedToGetMap.isNotEmpty()) exchangeDataMap.getExchangeDataMapBatch(
			entitiesGroupId,
			uncachedToGetMap
		) else emptyList()
		val exchangeDataIdByDelegationKey = exchangeDataMaps.mapNotNull { exchangeDataMap ->
			secureDelegationsEncryption.decryptExchangeDataId(exchangeDataMap.encryptedExchangeDataIds)?.let {
				SecureDelegationKeyString(exchangeDataMap.id) to it
			}
		}.toMap()
		val retrievedByExchangeDataId = if (exchangeDataIdByDelegationKey.isNotEmpty()) exchangeDataManager.getDecryptionDataByIds(
			entitiesGroupId,
			exchangeDataIdByDelegationKey.values.toSet(),
			true
		) else emptyMap()
		return entities.associate { entity ->
			entity.id to entity.securityMetadata?.secureDelegations?.flatMapTo(mutableSetOf()) { (delegationKey, delegation) ->
				val cached = alreadyCached[delegationKey] ?:
					exchangeDataIdByDelegationKey[delegationKey]?.let { retrievedByExchangeDataId[it] }
				val exchangeKey = cached?.unencryptedContent?.exchangeKey
				if (exchangeKey != null) {
					metadataType.decryptSecureDelegation(delegation, exchangeKey, secureDelegationsEncryption)
				} else emptySet()
			}.orEmpty()
		}
	}

	override suspend fun <T : Any> decryptAll(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>> {
//		val fromLegacyDelegations = decryptLegacyDelegations(
//			entitiesGroupId,
//			entities,
//			entitiesType,
//			dataOwnersHierarchySubset,
//			metadataType
//		)
//		val fromSecureDelegations = decryptAllSecureDelegations(
//			entitiesGroupId,
//			entities,
//			entitiesType,
//			dataOwnersHierarchySubset,
//			metadataType
//		)
		TODO("decide how to handle actually the key: plain data owner id or groupId/dataOwnerId")
//		return dataOwnersHierarchySubset.map((dataOwner) => {
//			const decryptedEntriesForDataOwner = allExtractedWithDataOwners
//				.filter((x) => x.dataOwnersWithAccess.some((d) => dataOwner == d))
//			.map((x) => x.decrypted)
//			return {
//				ownerId: dataOwner,
//				extracted: [...new Set(decryptedEntriesForDataOwner)],
//			}
//		})
	}

	override suspend fun <T : Any> decryptAllLegacyDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		TODO("Not yet implemented")
	}

	override suspend fun <T : Any> decryptAllSecureDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		TODO("Not yet implemented")
	}

	override suspend fun getSecureDelegationMemberDetails(
		entityGroupId: String?,
		typedEntity: EntityWithTypeInfo<*>
	): Map<SecureDelegationKeyString, SecureDelegationMembersDetails> {
		TODO("Not yet implemented")
	}

	override suspend fun getEntityLegacyDelegationAccessLevel(
		entityGroupId: String?,
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? {
		TODO("Not yet implemented")
	}

	override suspend fun getEntitySecureDelegationsAccessLevel(
		entityGroupId: String?,
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? {
		TODO("Not yet implemented")
	}

	override fun hasAnyEncryptionKeys(entity: HasEncryptionMetadata): Boolean =
		entity.securityMetadata?.secureDelegations?.values?.any { it.encryptionKeys.isNotEmpty() } == true
			|| entity.encryptionKeys.any { it.value.isNotEmpty() }

	private fun selfHierarchyIdsAsReferenceStrings(
		dataOwnerHierarchyIds: Set<String>,
		entityGroupId: String?
	) = boundGroup.resolve(entityGroupId)?.let { g ->
		dataOwnerHierarchyIds.mapTo(mutableSetOf()) { "$g/$it"}
	} ?: dataOwnerHierarchyIds
}