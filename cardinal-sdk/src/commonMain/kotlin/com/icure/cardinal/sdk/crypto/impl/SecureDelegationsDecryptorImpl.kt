package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.crypto.SecureDelegationsDecryptor
import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.ensure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList

@InternalIcureApi
class SecureDelegationsDecryptorImpl(
	private val exchangeData: ExchangeDataManager,
	private val exchangeDataMap: ExchangeDataMapManager,
	private val secureDelegationsEncryption: SecureDelegationsEncryption,
	private val dataOwnerApi: DataOwnerApi
) : SecureDelegationsDecryptor {
	override fun decryptEncryptionKeysOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<HexString>> =
		decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset,
			{ it.encryptionKeys },
			{ e, k -> this.secureDelegationsEncryption.decryptEncryptionKey(e, k) }
		)

	override fun decryptSecretIdsOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> =
		decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset,
			{ it.secretIds },
			{ e, k -> this.secureDelegationsEncryption.decryptSecretId(e, k) }
		)
	override fun decryptOwningEntityIdsOf(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): Flow<DecryptedMetadataDetails<String>> =
		decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset,
			{ it.owningEntityIds },
			{ e, k -> this.secureDelegationsEncryption.decryptOwningEntityId(e, k) }
		)

	override fun hasAnyEncryptionKeys(entity: HasEncryptionMetadata): Boolean =
		entity.securityMetadata?.secureDelegations?.values?.any { it.encryptionKeys.isNotEmpty() } ?: false

	override suspend fun getEntityAccessLevel(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? {
		ensure(dataOwnersHierarchySubset.isNotEmpty()) { "`dataOwnersHierarchySubset` should not be empty" }
		val allAccessibleDelegations = dataOwnersHierarchySubset.flatMap {
			accessibleDelegationsForDataOwnerOfHierarchy(typedEntity, it)
		}
		return when {
			allAccessibleDelegations.isEmpty() -> null
			allAccessibleDelegations.any { it.permissions == AccessLevel.Write } -> AccessLevel.Write
			else -> AccessLevel.Read
		}
	}

	// Only works if the provided data owner id comes from the current data owner hierarchy
	private suspend fun accessibleDelegationsForDataOwnerOfHierarchy(
		entity: EntityWithTypeInfo<*>,
		dataOwnerId: String,
	): Collection<SecureDelegation> {
		// If the data owner is explicit all delegations he can access has his id. If the delegator is anonymous all delegations he can access are
		// accessible by hash. No mixed scenario possible.
		return entity.entity.securityMetadata?.secureDelegations?.values?.filter { delegation ->
			dataOwnerId == delegation.delegator || dataOwnerId == delegation.delegate
		}?.takeIf { it.isNotEmpty() } ?: entity.entity.securityMetadata?.secureDelegations?.let { secureDelegations ->
			val accessibleKeys = exchangeData.getCachedDecryptionDataKeyByAccessControlHash(secureDelegations.keys, entity.type).keys
			secureDelegations.filter { it.key in accessibleKeys }.values
		} ?: emptyList()
	}

	private fun <T : Any> decryptSecureDelegations(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>,
		getDataToDecrypt: (delegation: SecureDelegation) -> Set<Base64String>,
		decryptDataWithKey: suspend (encryptedData: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>) -> T
	): Flow<DecryptedMetadataDetails<T>> {
		ensure(dataOwnersHierarchySubset.isNotEmpty()) { "`dataOwnersHierarchySubset` should not be empty" }
		return decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset
		) { _, secureDelegation, exchangeData, unencryptedExchangeDataContent ->
			unencryptedExchangeDataContent?.exchangeKey?.let { exchangeKey ->
				getDataToDecrypt(secureDelegation).takeIf { data ->
					data.isNotEmpty() && dataOwnersHierarchySubset.any { it == exchangeData.delegator || it == exchangeData.delegate }
				}?.map {
					DecryptedMetadataDetails(
						decryptDataWithKey(it, exchangeKey),
						setOf(exchangeData.delegator, exchangeData.delegate)
					)
				}
			} ?: emptyList()
		}
	}

	override suspend fun getDelegationMemberDetails(
		entity: EntityWithTypeInfo<*>
	): Map<SecureDelegationKeyString, SecureDelegationMembersDetails> = entity.entity.securityMetadata?.let { securityMetadata ->
		// 1. Add all information from fully explicit delegations.
		val fullyExplicitInfo = securityMetadata.secureDelegations.mapNotNull { (key, delegation) ->
			if (delegation.delegate != null && delegation.delegator != null) {
				key to SecureDelegationMembersDetails(
					delegator = delegation.delegator,
					delegate = delegation.delegate,
					fullyExplicit = true,
					accessControlSecret = null,
					accessLevel = delegation.permissions
				)
			} else null
		}
		// Check fully anonymous and mixed delegations
		val mixedAndFullyAnonymousInfo = flow {
			// 2. Attempt to identify the anonymous data owner of remaining delegations by checking if we have the exchange data cached by hash
			// Note: we can find exchange data by hash only if we could successfully decrypt it
			processDelegationsWithCachedKeyAndEmit(
				entity.entity.securityMetadata?.secureDelegations?.toList()?.filter {
					it.second.delegate == null || it.second.delegator == null
				} ?: emptyList(),
				entity,
			) { delegationKey, delegation, exchangeData, unencryptedExchangeDataContent ->
				listOf(delegationKey to SecureDelegationMembersDetails(
					delegator = exchangeData.delegator,
					delegate = exchangeData.delegate,
					fullyExplicit = false,
					accessControlSecret = unencryptedExchangeDataContent.accessControlSecret,
					accessLevel = delegation.permissions
				)
				)
			}.let { remainingDelegations ->
				// 3. Emit all remaining delegations where the current user and/or parent is not an explicit member; keep the rest for next step
				val currentHierarchyIds = dataOwnerApi.getCurrentDataOwnerHierarchyIds()
				val delegationsWithCurrentHierarchyMember = mutableListOf<Pair<SecureDelegationKeyString, SecureDelegation>>()
				remainingDelegations.forEach { secureDelegationInfo ->
					if (currentHierarchyIds.any { it == secureDelegationInfo.second.delegator || it == secureDelegationInfo.second.delegate }) {
						delegationsWithCurrentHierarchyMember.add(secureDelegationInfo)
					} else emit(secureDelegationInfo.first to SecureDelegationMembersDetails(
						delegator = secureDelegationInfo.second.delegator,
						delegate = secureDelegationInfo.second.delegate,
						fullyExplicit = false,
						accessControlSecret = null,
						accessLevel = secureDelegationInfo.second.permissions
					)
					)
				}
				delegationsWithCurrentHierarchyMember
			}.let { remainingDelegations ->
				// 4. Attempt to identify the anonymous data owner of remaining delegations between us (or one of our parents) and an anonymous data owner
				processMixedExplicitAndAnonymousDelegationsAndEmit(
					remainingDelegations
				) { delegationKey, delegation, exchangeData, unencryptedExchangeDataContent ->
					listOf(delegationKey to SecureDelegationMembersDetails(
						delegator = exchangeData.delegator,
						delegate = exchangeData.delegate,
						fullyExplicit = false,
						accessControlSecret = unencryptedExchangeDataContent?.accessControlSecret,
						accessLevel = delegation.permissions
					)
					)
				}
			}.forEach { (delegationKey, delegation) ->
				// 5. Emit all remaining delegations where the current user and/or parent is an explicit member but could not identify the anonymous data owner
				emit(delegationKey to SecureDelegationMembersDetails(
					delegator = delegation.delegator,
					delegate = delegation.delegate,
					fullyExplicit = false,
					accessControlSecret = null,
					accessLevel = delegation.permissions
				)
				)
			}
		}.toList()
		(mixedAndFullyAnonymousInfo + fullyExplicitInfo).toMap()
	} ?: emptyMap()

	private fun <T : Any> decryptSecureDelegations(
		typedEntity: EntityWithTypeInfo<*>,
		dataOwnersHierarchySubset: Set<String>,
		decryptExchangeData: suspend (SecureDelegationKeyString, SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<DecryptedMetadataDetails<T>>
	): Flow<DecryptedMetadataDetails<T>> = flow {
		/*
		 * Decrypt the exchange data starting from least expensive to most (in terms of amount of requests). This way if
		 * only a subset of the decrypted values is needed (e.g. only one encryption key is needed) the result will be
		 * available faster.
		 * 1) Secure delegations with cached exchange data by hash (no requests)
		 * 2) Secure delegations with cached exchange data by id for explicit->explicit delegations where delegator and/or delegate is me or parent (no requests)
		 * 3) Non cached secure delegations for explicit->explicit delegations where delegator and/or delegate is me or parent (a request to get the exchange data)
		 * 4) Decrypt secure delegation id for explicit->anonymous or anonymous->explicit where explicit is me or parent (a request to get the exchange data map + a request to get the exchange data)
		 */

		// Step 1) Secure delegations with cached exchange data by hash
		processDelegationsWithCachedKeyAndEmit(
			typedEntity.entity.securityMetadata?.secureDelegations?.toList() ?: emptyList(),
			typedEntity,
			decryptExchangeData
		).filter { (_ , delegation) ->
			// If the current data owner was anonymous all his delegations were already emitted. Now only keep delegations where the current data owner appears explicitly
			delegation.delegate in dataOwnersHierarchySubset || delegation.delegator in dataOwnersHierarchySubset
		}.let { remainingDelegations ->
			// Step 2) Secure delegations with cached exchange data by id for explicit->explicit delegations where delegator and/or delegate is me or parent
			processFullyExplicitDelegationsAndEmit(
				remainingDelegations,
				false,
				decryptExchangeData
			)
		}.let { remainingDelegations ->
			// Step 3) Non cached secure delegations for explicit->explicit delegations where delegator and/or delegate is me or parent
			processFullyExplicitDelegationsAndEmit(
				remainingDelegations,
				true,
				decryptExchangeData
			)
		}.let { remainingDelegations ->
			// Step 4) Decrypt secure delegation id for explicit->anonymous or anonymous->explicit where explicit is me or parent
			processMixedExplicitAndAnonymousDelegationsAndEmit(
				remainingDelegations,
				decryptExchangeData
			)
		}
	}

	private suspend fun <T : Any> FlowCollector<T>.processDelegationsWithCachedKeyAndEmit(
		remainingDelegations: List<Pair<SecureDelegationKeyString, SecureDelegation>>,
		typedEntity: EntityWithTypeInfo<*>,
		process: suspend (SecureDelegationKeyString, SecureDelegation, ExchangeData, UnencryptedExchangeDataContent) -> List<T>
	): List<Pair<SecureDelegationKeyString, SecureDelegation>> {
		if (remainingDelegations.isEmpty()) return emptyList()
		val cachedDataByDelegationKey = exchangeData.getCachedDecryptionDataKeyByAccessControlHash(
			remainingDelegations.map { it.first },
			typedEntity.type
		)
		val updatedRemaining = mutableListOf<Pair<SecureDelegationKeyString, SecureDelegation>>()
		remainingDelegations.forEach { secureDelegationInfo ->
			val exchangeDataDetails = cachedDataByDelegationKey[secureDelegationInfo.first]
			if (exchangeDataDetails != null) {
				process(
					secureDelegationInfo.first,
					secureDelegationInfo.second,
					exchangeDataDetails.exchangeData,
					exchangeDataDetails.unencryptedContent
				).forEach { emit(it) }
			} else updatedRemaining.add(secureDelegationInfo)
		}
		return updatedRemaining
	}

	private suspend fun <T : Any> FlowCollector<T>.processFullyExplicitDelegationsAndEmit(
		remainingDelegations: List<Pair<SecureDelegationKeyString, SecureDelegation>>,
		retrieveExchangeDataIfNotCached: Boolean,
		process: suspend (SecureDelegationKeyString, SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<T>
	): List<Pair<SecureDelegationKeyString, SecureDelegation>> {
		if (remainingDelegations.isEmpty()) return emptyList()
		val updatedRemaining = mutableListOf<Pair<SecureDelegationKeyString, SecureDelegation>>()
		remainingDelegations.forEach { secureDelegationInfo ->
			val exchangeDataDetails = secureDelegationInfo.second.exchangeDataId?.let {
				exchangeData.getDecryptionDataById(it, retrieveExchangeDataIfNotCached)
			}
			if (exchangeDataDetails != null) {
				process(
					secureDelegationInfo.first,
					secureDelegationInfo.second,
					exchangeDataDetails.exchangeData,
					exchangeDataDetails.decryptedContent
				).forEach { emit(it) }
			} else updatedRemaining.add(secureDelegationInfo)
		}
		return updatedRemaining
	}

	private suspend fun <T : Any> FlowCollector<T>.processMixedExplicitAndAnonymousDelegationsAndEmit(
		remainingDelegations: List<Pair<SecureDelegationKeyString, SecureDelegation>>,
		process: suspend (SecureDelegationKeyString, SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<T>
	): List<Pair<SecureDelegationKeyString, SecureDelegation>>  {
		if (remainingDelegations.isEmpty()) return emptyList()
		val mixedDelegationKeys = remainingDelegations.filter { (_, delegation) ->
			(delegation.delegate == null) != (delegation.delegator == null) // Exactly one of the two is null
		}.map { it.first }
		val exchangeDataMaps = exchangeDataMap.getExchangeDataMapBatch(mixedDelegationKeys).associateBy { SecureDelegationKeyString(it.id) }
		val updatedRemaining = mutableListOf<Pair<SecureDelegationKeyString, SecureDelegation>>()
		remainingDelegations.forEach { secureDelegationInfo ->
			exchangeDataMaps[secureDelegationInfo.first]?.let {
				secureDelegationsEncryption.decryptExchangeDataId(it.encryptedExchangeDataIds)
			}?.let {
				exchangeData.getDecryptionDataById(it, true)
			}?.let { exchangeDataInfo ->
				process(
					secureDelegationInfo.first,
					secureDelegationInfo.second,
					exchangeDataInfo.exchangeData,
					exchangeDataInfo.decryptedContent
				).forEach { emit(it) }
			} ?: updatedRemaining.add(secureDelegationInfo)
		}
		return updatedRemaining
	}
}
