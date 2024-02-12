package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.DecryptedMetadataDetails
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.ExchangeDataMapManager
import com.icure.sdk.crypto.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.SecureDelegationsEncryption
import com.icure.sdk.crypto.SecurityMetadataDecryptor
import com.icure.sdk.crypto.UnencryptedExchangeDataContent
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.HexString
import com.icure.sdk.model.SecureDelegation
import com.icure.sdk.model.SecureDelegationKeyString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.ensure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

@InternalIcureApi
class SecureDelegationsDecryptor(
	private val exchangeData: ExchangeDataManager,
	private val exchangeDataMap: ExchangeDataMapManager,
	private val secureDelegationsEncryption: SecureDelegationsEncryption,
	private val dataOwnerApi: DataOwnerApi
) : SecurityMetadataDecryptor {
	override fun decryptEncryptionKeysOf(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
	): Flow<DecryptedMetadataDetails<HexString>> =
		decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset,
			{ it.encryptionKeys },
			{ e, k -> this.secureDelegationsEncryption.decryptEncryptionKey(e, k) }
		)

	override fun decryptSecretIdsOf(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
	): Flow<DecryptedMetadataDetails<String>> =
		decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset,
			{ it.secretIds },
			{ e, k -> this.secureDelegationsEncryption.decryptSecretId(e, k) }
		)
	override fun decryptOwningEntityIdsOf(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
	): Flow<DecryptedMetadataDetails<String>> =
		decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset,
			{ it.owningEntityIds },
			{ e, k -> this.secureDelegationsEncryption.decryptOwningEntityId(e, k) }
		)

	override fun hasAnyEncryptionKeys(entity: Encryptable): Boolean =
		entity.securityMetadata?.secureDelegations?.values?.any { it.encryptionKeys.isNotEmpty() } ?: false

	override suspend fun getEntityAccessLevel(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>
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
		entity: Encryptable,
		dataOwnerId: String,
	): Collection<SecureDelegation> {
		// If the data owner is explicit all delegations he can access has his id. If the delegator is anonymous all delegations he can access are
		// accessible by hash. No mixed scenario possible.
		return entity.securityMetadata?.secureDelegations?.values?.filter { delegation ->
			dataOwnerId == delegation.delegator || dataOwnerId == delegation.delegate
		}?.takeIf { it.isNotEmpty() } ?: entity.securityMetadata?.secureDelegations?.let { secureDelegations ->
			val accessibleKeys = exchangeData.getCachedDecryptionDataKeyByAccessControlHash(secureDelegations.keys, entity.type).keys
			secureDelegations.filter { it.key in accessibleKeys }.values
		} ?: emptyList()
	}

	private fun <T : Any> decryptSecureDelegations(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>,
		getDataToDecrypt: (delegation: SecureDelegation) -> Set<Base64String>,
		decryptDataWithKey: suspend (encryptedData: Base64String, key: AesKey) -> T
	): Flow<DecryptedMetadataDetails<T>> {
		ensure(dataOwnersHierarchySubset.isNotEmpty()) { "`dataOwnersHierarchySubset` should not be empty" }
		return decryptSecureDelegations(
			typedEntity,
			dataOwnersHierarchySubset
		) { secureDelegation, exchangeData, unencryptedExchangeDataContent ->
			unencryptedExchangeDataContent?.exchangeKey?.let { exchangeKey ->
				getDataToDecrypt(secureDelegation).takeIf { data ->
					data.isNotEmpty() && dataOwnersHierarchySubset.any { it == exchangeData.delegator || it == exchangeData.delegate }
				}?.map {
					DecryptedMetadataDetails(
						decryptDataWithKey(it, exchangeKey),
						listOf(exchangeData.delegator, exchangeData.delegate)
					)
				}
			} ?: emptyList()
		}
	}

	private fun <T : Any> decryptSecureDelegations(
		typedEntity: Encryptable,
		dataOwnersHierarchySubset: List<String>,
		decryptExchangeData: suspend (SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<DecryptedMetadataDetails<T>>
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
		decryptByDelegationKeyAndEmit(
			typedEntity.securityMetadata?.secureDelegations?.toList() ?: emptyList(),
			typedEntity,
			decryptExchangeData
		).filter { (_ , delegation) ->
			// If the current data owner was anonymous all his delegations were already emitted. Now only keep delegations where the current data owner appears explicitly
			dataOwnersHierarchySubset.any { it == delegation.delegator || it == delegation.delegate }
		}.let { remainingDelegations ->
			decryptFullyExplicitDelegations(
				remainingDelegations,
				false,
				decryptExchangeData
			)
		}.let { remainingDelegations ->
			decryptFullyExplicitDelegations(
				remainingDelegations,
				true,
				decryptExchangeData
			)
		}
	}

	// Step 1) Secure delegations with cached exchange data by hash
	private suspend fun <T : Any> FlowCollector<DecryptedMetadataDetails<T>>.decryptByDelegationKeyAndEmit(
		remainingDelegations: List<Pair<SecureDelegationKeyString, SecureDelegation>>,
		typedEntity: Encryptable,
		decryptExchangeData: suspend (SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<DecryptedMetadataDetails<T>>
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
				decryptExchangeData(
					secureDelegationInfo.second,
					exchangeDataDetails.exchangeData,
					exchangeDataDetails.unencryptedContent
				).forEach { emit(it) }
			} else updatedRemaining.add(secureDelegationInfo)
		}
		return updatedRemaining
	}

	// Step 2) Secure delegations with cached exchange data by id for explicit->explicit delegations where delegator and/or delegate is me or parent
	// Step 3) Non cached secure delegations for explicit->explicit delegations where delegator and/or delegate is me or parent
	private suspend fun <T : Any> FlowCollector<DecryptedMetadataDetails<T>>.decryptFullyExplicitDelegations(
		remainingDelegations: List<Pair<SecureDelegationKeyString, SecureDelegation>>,
		retrieveExchangeDataIfNotCached: Boolean,
		decryptExchangeData: suspend (SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<DecryptedMetadataDetails<T>>
	): List<Pair<SecureDelegationKeyString, SecureDelegation>> {
		if (remainingDelegations.isEmpty()) return emptyList()
		val updatedRemaining = mutableListOf<Pair<SecureDelegationKeyString, SecureDelegation>>()
		remainingDelegations.forEach { secureDelegationInfo ->
			val exchangeDataDetails = secureDelegationInfo.second.exchangeDataId?.let {
				exchangeData.getDecryptionDataById(it, retrieveExchangeDataIfNotCached)
			}
			if (exchangeDataDetails != null) {
				decryptExchangeData(
					secureDelegationInfo.second,
					exchangeDataDetails.exchangeData,
					exchangeDataDetails.decryptedContent
				).forEach { emit(it) }
			} else updatedRemaining.add(secureDelegationInfo)
		}
		return updatedRemaining
	}

	// Step 4) Decrypt secure delegation id for explicit->anonymous or anonymous->explicit where explicit is me or parent
	private suspend fun <T : Any> FlowCollector<DecryptedMetadataDetails<T>>.decrypteExplicitAndAnonymousDelegations(
		remainingDelegations: List<Pair<SecureDelegationKeyString, SecureDelegation>>,
		decryptExchangeData: suspend (SecureDelegation, ExchangeData, UnencryptedExchangeDataContent?) -> List<DecryptedMetadataDetails<T>>
	) {
		if (remainingDelegations.isEmpty()) return
		val exchangeDataMaps = exchangeDataMap.getExchangeDataMapBatch(remainingDelegations.map { it.first }).associateBy { it.id }
		remainingDelegations.forEach { secureDelegationInfo ->
			exchangeDataMaps[secureDelegationInfo.first]?.let {
				secureDelegationsEncryption.decryptExchangeDataId(it.encryptedExchangeDataIds)
			}?.let {
				exchangeData.getDecryptionDataById(it, true)
			}?.let {
				decryptExchangeData(
					secureDelegationInfo.second,
					it.exchangeData,
					it.decryptedContent
				).forEach { emit(it) }
			}
		}
	}
}