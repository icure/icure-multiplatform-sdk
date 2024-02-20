package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.ExchangeDataMapManager
import com.icure.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.SecureDelegationsEncryption
import com.icure.sdk.crypto.SecureDelegationsManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.crypto.entities.toPublicKeyInfo
import com.icure.sdk.model.AccessControlKeyString
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.EntityShareOrMetadataUpdateRequest
import com.icure.sdk.model.EntityShareRequest
import com.icure.sdk.model.EntitySharedMetadataUpdateRequest
import com.icure.sdk.model.ExchangeDataMapCreationBatch
import com.icure.sdk.model.HexString
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.model.SecureDelegation
import com.icure.sdk.model.SecureDelegationKeyString
import com.icure.sdk.model.SecurityMetadata
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.SynchronisedLruCache

@InternalIcureApi
class SecureDelegationsManagerImpl (
	private val exchangeDataManager: ExchangeDataManager,
	private val exchangeDataMapManager: ExchangeDataMapManager,
	private val secureDelegationsEncryption: SecureDelegationsEncryption,
	private val userKeys: UserEncryptionKeysManager,
	private val cryptoService: CryptoService,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoStrategies: CryptoStrategies,
	private val selfNeedsAnonymousDelegations: Boolean
) : SecureDelegationsManager {
	// Data owner id -> is anonymous
	private val dataOwnerAnonymityCache = SynchronisedLruCache<String, Boolean>(1000)

	override suspend fun <T : Encryptable> entityWithInitialisedEncryptedMetadata(
		entity: T,
		secretIds: List<String>,
		owningEntityIds: List<String>,
		owningEntitySecretIds: List<String>,
		encryptionKeys: List<HexString>,
		autoDelegations: Map<String, AccessLevel>
	): T {
		val selfId = dataOwnerApi.getCurrentDataOwnerId()
		val rootDelegationInfo = makeSecureDelegationInfo(
			entity = entity,
			delegateId = selfId,
			shareSecretIds = secretIds,
			shareOwningEntityIds = owningEntityIds,
			shareEncryptionKeys = encryptionKeys,
			permissions = AccessLevel.Write,
			parentDelegationKey = null
		)
		val otherDelegationsInfo = autoDelegations.filterNot { it.key == selfId }.map { (delegateId, permissions) ->
			makeSecureDelegationInfo(
				entity = entity,
				delegateId = delegateId,
				shareSecretIds = secretIds,
				shareOwningEntityIds = owningEntityIds,
				shareEncryptionKeys = encryptionKeys,
				permissions = permissions,
				parentDelegationKey = rootDelegationInfo.canonicalDelegationKey
			)
		}
		exchangeDataMapManager.createExchangeDataMaps(ExchangeDataMapCreationBatch(
			otherDelegationsInfo.mapNotNull { info -> info.encryptedExchangeDataId?.let { info.canonicalAccessControlKey to it } }.toMap()
		))
		@Suppress("UNCHECKED_CAST")
		return entity.copyWithSecurityMetadata(
			securityMetadata = SecurityMetadata(
				secureDelegations = (listOf(rootDelegationInfo) + otherDelegationsInfo).associate { it.canonicalDelegationKey to it.delegation },
			),
			secretForeignKeys = owningEntitySecretIds.toSet(),
		) as T
	}

	override suspend fun makeShareOrUpdateRequestParams(
		entity: Encryptable,
		delegateId: String,
		shareSecretIds: List<String>,
		shareEncryptionKeys: List<HexString>,
		shareOwningEntityIds: List<String>,
		newDelegationPermissions: RequestedPermission
	): EntityShareOrMetadataUpdateRequest? {
		val exchangeData = exchangeDataManager.getOrCreateEncryptionDataTo(delegateId, false)
		val accessControlKey = exchangeData.unencryptedContent.accessControlSecret.toAccessControlKeyStringFor(
			entity.type,
			cryptoService
		)
		val secureDelegationKey = accessControlKey.toSecureDelegationKeyString(cryptoService)
		val existingDelegation = entity.securityMetadata?.secureDelegations?.get(secureDelegationKey)
		return if (existingDelegation != null) {
			makeUpdateRequestParams(
				canonicalKey = secureDelegationKey,
				existingDelegation = existingDelegation,
				exchangeDataInfo = exchangeData,
				shareSecretIds = shareSecretIds,
				shareEncryptionKeys = shareEncryptionKeys,
				shareOwningEntityIds = shareOwningEntityIds
			)?.let { EntityShareOrMetadataUpdateRequest(update = it) }
		} else {
			EntityShareOrMetadataUpdateRequest(
				share = makeShareRequestParams(
					exchangeDataInfo = exchangeData,
					accessControlKey = accessControlKey,
					delegateId = delegateId,
					shareSecretIds = shareSecretIds,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					newDelegationPermissions = newDelegationPermissions
				)
			)
		}
	}

	override suspend fun clearCachedDataOwnersInfo() {
		dataOwnerAnonymityCache.clear()
	}

	private suspend fun makeSecureDelegationInfo(
		entity: Encryptable,
		delegateId: String,
		shareSecretIds: List<String>,
		shareEncryptionKeys: List<HexString>,
		shareOwningEntityIds: List<String>,
		permissions: AccessLevel,
		parentDelegationKey: SecureDelegationKeyString?
	): SecureDelegationInfo {
		val exchangeDataInfo = exchangeDataManager.getOrCreateEncryptionDataTo(delegateId, selfNeedsAnonymousDelegations)
		val accessControlKey = exchangeDataInfo.unencryptedContent.accessControlSecret.toAccessControlKeyStringFor(
			entity.type,
			cryptoService
		)
		val secureDelegationKey = accessControlKey.toSecureDelegationKeyString(cryptoService)
		val encryptedDelegationInfo = makeSecureDelegationEncryptedData(
			exchangeDataInfo = exchangeDataInfo,
			delegateId = delegateId,
			shareSecretIds = shareSecretIds,
			shareEncryptionKeys = shareEncryptionKeys,
			shareOwningEntityIds = shareOwningEntityIds
		)
		val delegation = SecureDelegation(
			delegator = encryptedDelegationInfo.idInfo.explicitDelegator,
			delegate = encryptedDelegationInfo.idInfo.explicitDelegate,
			secretIds = encryptedDelegationInfo.secretIds,
			encryptionKeys = encryptedDelegationInfo.encryptionKeys,
			owningEntityIds = encryptedDelegationInfo.owningEntityIds,
			parentDelegations = setOfNotNull(parentDelegationKey),
			exchangeDataId = encryptedDelegationInfo.idInfo.exchangeDataId,
			permissions = permissions
		)
		return SecureDelegationInfo(
			canonicalDelegationKey = secureDelegationKey,
			canonicalAccessControlKey = accessControlKey,
			delegation = delegation,
			encryptedExchangeDataId = encryptedDelegationInfo.idInfo.encryptedExchangeDataId
		)
	}

	private suspend fun makeUpdateRequestParams(
		canonicalKey: SecureDelegationKeyString,
		existingDelegation: SecureDelegation,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		shareSecretIds: List<String>,
		shareEncryptionKeys: List<HexString>,
		shareOwningEntityIds: List<String>
	): EntitySharedMetadataUpdateRequest? {
		val existingSecretIds = secureDelegationsEncryption.decryptSecretIds(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey).toSet()
		val existingEncryptionKeys = secureDelegationsEncryption.decryptEncryptionKeys(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey).toSet()
		val existingOwningEntityIds = secureDelegationsEncryption.decryptOwningEntityIds(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey).toSet()

		val newSecretIds = shareSecretIds.filterTo(mutableSetOf()) { !existingSecretIds.contains(it) }
		val newEncryptionKeys = shareEncryptionKeys.filterTo(mutableSetOf()) { !existingEncryptionKeys.contains(it) }
		val newOwningEntityIds = shareOwningEntityIds.filterTo(mutableSetOf()) { !existingOwningEntityIds.contains(it) }

		return if (newSecretIds.isNotEmpty() || newEncryptionKeys.isNotEmpty() || newOwningEntityIds.isNotEmpty()) {
			val encryptedNewSecretIds = secureDelegationsEncryption.encryptSecretIds(newSecretIds, exchangeDataInfo.unencryptedContent.exchangeKey)
			val encryptedNewEncryptionKeys = secureDelegationsEncryption.encryptEncryptionKeys(newEncryptionKeys, exchangeDataInfo.unencryptedContent.exchangeKey)
			val encryptedNewOwningEntityIds = secureDelegationsEncryption.encryptOwningEntityIds(newOwningEntityIds, exchangeDataInfo.unencryptedContent.exchangeKey)

			EntitySharedMetadataUpdateRequest(
				metadataAccessControlHash = canonicalKey,
				secretIds = encryptedNewSecretIds.associateWith { EntitySharedMetadataUpdateRequest.EntryUpdateTypeDto.Create },
				encryptionKeys = encryptedNewEncryptionKeys.associateWith { EntitySharedMetadataUpdateRequest.EntryUpdateTypeDto.Create },
				owningEntityIds = encryptedNewOwningEntityIds.associateWith { EntitySharedMetadataUpdateRequest.EntryUpdateTypeDto.Create }
			)
		} else null
	}

	private suspend fun makeShareRequestParams(
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		accessControlKey: AccessControlKeyString,
		delegateId: String,
		shareSecretIds: List<String>,
		shareEncryptionKeys: List<HexString>,
		shareOwningEntityIds: List<String>,
		newDelegationPermissions: RequestedPermission
	): EntityShareRequest {
		val secureDelegationInfo = makeSecureDelegationEncryptedData(
			exchangeDataInfo,
			delegateId,
			shareSecretIds,
			shareEncryptionKeys,
			shareOwningEntityIds
		)
		return EntityShareRequest(
			explicitDelegator = secureDelegationInfo.idInfo.explicitDelegator,
			explicitDelegate = secureDelegationInfo.idInfo.explicitDelegate,
			accessControlKeys = setOf(accessControlKey),
			secretIds = secureDelegationInfo.secretIds,
			encryptionKeys = secureDelegationInfo.encryptionKeys,
			owningEntityIds = secureDelegationInfo.owningEntityIds,
			exchangeDataId = secureDelegationInfo.idInfo.exchangeDataId,
			encryptedExchangeDataId = secureDelegationInfo.idInfo.encryptedExchangeDataId ?: emptyMap(),
			requestedPermissions = newDelegationPermissions,
		)
	}

	private suspend fun makeSecureDelegationEncryptedData(
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		delegateId: String,
		shareSecretIds: List<String>,
		shareEncryptionKeys: List<HexString>,
		shareOwningEntityIds: List<String>
	): EncryptedExchangeDataInfo {
		val selfId = this.dataOwnerApi.getCurrentDataOwnerId()
		val exchangeDataIdInfo = if (delegateId === selfId) {
			makeExchangeDataIdInfoForSelf(selfId, exchangeDataInfo)
		} else {
			makeExchangeDataIdInfoForDelegate(selfId, delegateId, exchangeDataInfo)
		}
		val encryptedSecretIds = secureDelegationsEncryption.encryptSecretIds(shareSecretIds.toSet(), exchangeDataInfo.unencryptedContent.exchangeKey)
		val encryptedEncryptionKeys = secureDelegationsEncryption.encryptEncryptionKeys(shareEncryptionKeys.toSet(), exchangeDataInfo.unencryptedContent.exchangeKey)
		val encryptedOwningEntityIds = secureDelegationsEncryption.encryptOwningEntityIds(shareOwningEntityIds.toSet(), exchangeDataInfo.unencryptedContent.exchangeKey)
		return EncryptedExchangeDataInfo(
			secretIds = encryptedSecretIds,
			encryptionKeys = encryptedEncryptionKeys,
			owningEntityIds = encryptedOwningEntityIds,
			idInfo = exchangeDataIdInfo
		)
	}

	private fun makeExchangeDataIdInfoForSelf(
		selfId: String,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent
	): EncryptedExchangeDataIdInfo =
		if (selfNeedsAnonymousDelegations) {
			EncryptedExchangeDataIdInfo(null, null, null, null)
		} else {
			EncryptedExchangeDataIdInfo(
				explicitDelegator = selfId,
				explicitDelegate = selfId,
				exchangeDataId = exchangeDataInfo.exchangeData.id,
				encryptedExchangeDataId = null
			)
		}

	private suspend fun makeExchangeDataIdInfoForDelegate(
		selfId: String,
		delegateId: String,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent
	): EncryptedExchangeDataIdInfo {
		val (delegateIsAnonymous, retrievedDelegate) =
			dataOwnerAnonymityCache.get(delegateId)?.let { it to null } ?: dataOwnerApi.getDataOwnerStub(delegateId).let {
				val anonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(it)
				dataOwnerAnonymityCache.set(delegateId, anonymous)
				anonymous to it
			}
		return when {
			!delegateIsAnonymous && !selfNeedsAnonymousDelegations ->
				EncryptedExchangeDataIdInfo(
					explicitDelegator = selfId,
					explicitDelegate = delegateId,
					exchangeDataId = exchangeDataInfo.exchangeData.id,
					encryptedExchangeDataId = null
				)
			delegateIsAnonymous && !selfNeedsAnonymousDelegations ->
				EncryptedExchangeDataIdInfo(
					explicitDelegator = selfId,
					explicitDelegate = null,
					exchangeDataId = null,
					encryptedExchangeDataId = secureDelegationsEncryption.encryptExchangeDataId(
						exchangeDataInfo.exchangeData.id,
						VerifiedRsaEncryptionKeysSet(userKeys.getSelfVerifiedKeys().map { it.toPublicKeyInfo() })
					)
				)
			!delegateIsAnonymous && selfNeedsAnonymousDelegations ->
				EncryptedExchangeDataIdInfo(
					explicitDelegator = null,
					explicitDelegate = delegateId,
					exchangeDataId = null,
					encryptedExchangeDataId = (retrievedDelegate ?: dataOwnerApi.getDataOwnerStub(delegateId)).let { delegate ->
						val allDelegateKeys = cryptoService.loadEncryptionKeysForDataOwner(delegate.stub)
						// Important: this requires that the exchange data signature also validates the authenticity of the public keys included in there.
						val verifiedDelegateFingerprints = exchangeDataInfo.exchangeData.exchangeKey.keys
						val verifiedDelegateKeys = allDelegateKeys.filter { it.pubSpkiHexString.fingerprintV2() in verifiedDelegateFingerprints }
						secureDelegationsEncryption.encryptExchangeDataId(
							exchangeDataInfo.exchangeData.id,
							VerifiedRsaEncryptionKeysSet(verifiedDelegateKeys)
						)
					}
				)
			else -> //Both anonymous
				EncryptedExchangeDataIdInfo(
					explicitDelegator = null,
					explicitDelegate = null,
					exchangeDataId = null,
					encryptedExchangeDataId = null
				)
		}
	}

	data class EncryptedExchangeDataInfo(
		val secretIds: Set<Base64String>,
		val encryptionKeys: Set<Base64String>,
		val owningEntityIds: Set<Base64String>,
		val idInfo: EncryptedExchangeDataIdInfo
	)

	data class EncryptedExchangeDataIdInfo(
		val explicitDelegator: String?,
		val explicitDelegate: String?,
		val exchangeDataId: String?,
		val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String>?,
	)

	data class SecureDelegationInfo(
		val canonicalDelegationKey: SecureDelegationKeyString,
		val canonicalAccessControlKey: AccessControlKeyString,
		val delegation: SecureDelegation,
		val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String>?
	)
}