package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.crypto.SecureDelegationsManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.toPublicKeyInfo
import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.requests.EntityShareOrMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.EntityShareRequest
import com.icure.cardinal.sdk.model.requests.EntitySharedMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.EntryUpdateType
import com.icure.cardinal.sdk.model.requests.RequestedPermission

import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.SynchronisedLruCache

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

	override suspend fun <T : HasEncryptionMetadata> entityWithInitializedEncryptedMetadata(
		entity: EntityWithTypeInfo<T>,
		secretIds: Set<String>,
		owningEntityIds: Set<String>,
		owningEntitySecretIds: Set<String>,
		encryptionKeys: Set<HexString>,
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
		return entity.entity.copyWithSecurityMetadata(
			securityMetadata = SecurityMetadata(
				secureDelegations = (listOf(rootDelegationInfo) + otherDelegationsInfo).associate { it.canonicalDelegationKey to it.delegation },
			),
			secretForeignKeys = owningEntitySecretIds.toSet(),
		) as T
	}

	override suspend fun makeShareOrUpdateRequestParams(
		entity: EntityWithTypeInfo<*>,
		delegateId: String,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
		newDelegationPermissions: RequestedPermission
	): EntityShareOrMetadataUpdateRequest? {
		val exchangeData = exchangeDataManager.getOrCreateEncryptionDataTo(delegateId, false)
		val accessControlKey = exchangeData.unencryptedContent.accessControlSecret.toAccessControlKeyStringFor(
			entity.type,
			cryptoService
		)
		val secureDelegationKey = accessControlKey.toSecureDelegationKeyString(cryptoService)
		val existingDelegation = entity.entity.securityMetadata?.secureDelegations?.get(secureDelegationKey)
		return if (existingDelegation != null) {
			makeUpdateRequestParams(
				canonicalKey = secureDelegationKey,
				existingDelegation = existingDelegation,
				exchangeDataInfo = exchangeData,
				shareSecretIds = shareSecretIds,
				shareEncryptionKeys = shareEncryptionKeys,
				shareOwningEntityIds = shareOwningEntityIds
			)?.wrap()
		} else {
			makeShareRequestParams(
				exchangeDataInfo = exchangeData,
				accessControlKey = accessControlKey,
				delegateId = delegateId,
				shareSecretIds = shareSecretIds,
				shareEncryptionKeys = shareEncryptionKeys,
				shareOwningEntityIds = shareOwningEntityIds,
				newDelegationPermissions = newDelegationPermissions
			).wrap()
		}
	}

	override suspend fun clearCachedDataOwnersInfo() {
		dataOwnerAnonymityCache.clear()
	}

	private suspend fun makeSecureDelegationInfo(
		entity: EntityWithTypeInfo<*>,
		delegateId: String,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
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
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>
	): EntitySharedMetadataUpdateRequest? {
		val existingSecretIds = secureDelegationsEncryption.decryptSecretIds(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey)
		val existingEncryptionKeys = secureDelegationsEncryption.decryptEncryptionKeys(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey)
		val existingOwningEntityIds = secureDelegationsEncryption.decryptOwningEntityIds(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey)

		val newSecretIds = shareSecretIds.filterTo(mutableSetOf()) { !existingSecretIds.contains(it) }
		val newEncryptionKeys = shareEncryptionKeys.filterTo(mutableSetOf()) { !existingEncryptionKeys.contains(it) }
		val newOwningEntityIds = shareOwningEntityIds.filterTo(mutableSetOf()) { !existingOwningEntityIds.contains(it) }

		return if (newSecretIds.isNotEmpty() || newEncryptionKeys.isNotEmpty() || newOwningEntityIds.isNotEmpty()) {
			val encryptedNewSecretIds = secureDelegationsEncryption.encryptSecretIds(newSecretIds, exchangeDataInfo.unencryptedContent.exchangeKey)
			val encryptedNewEncryptionKeys = secureDelegationsEncryption.encryptEncryptionKeys(newEncryptionKeys, exchangeDataInfo.unencryptedContent.exchangeKey)
			val encryptedNewOwningEntityIds = secureDelegationsEncryption.encryptOwningEntityIds(newOwningEntityIds, exchangeDataInfo.unencryptedContent.exchangeKey)

			EntitySharedMetadataUpdateRequest(
				metadataAccessControlHash = canonicalKey,
				secretIds = encryptedNewSecretIds.associateWith { EntryUpdateType.Create },
				encryptionKeys = encryptedNewEncryptionKeys.associateWith { EntryUpdateType.Create },
				owningEntityIds = encryptedNewOwningEntityIds.associateWith { EntryUpdateType.Create }
			)
		} else null
	}

	private suspend fun makeShareRequestParams(
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		accessControlKey: AccessControlKeyHexString,
		delegateId: String,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
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
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>
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
			dataOwnerAnonymityCache.get(delegateId)?.let { it to null } ?: dataOwnerApi.getCryptoActorStub(delegateId).let {
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
					encryptedExchangeDataId = (retrievedDelegate ?: dataOwnerApi.getCryptoActorStub(delegateId)).let { delegate ->
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
		val canonicalAccessControlKey: AccessControlKeyHexString,
		val delegation: SecureDelegation,
		val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String>?
	)
}
