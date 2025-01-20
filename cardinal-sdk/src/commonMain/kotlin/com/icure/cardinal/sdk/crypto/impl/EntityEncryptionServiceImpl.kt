package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.EntityValidationService
import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.SecureDelegationsDecryptor
import com.icure.cardinal.sdk.crypto.SecureDelegationsManager
import com.icure.cardinal.sdk.crypto.SecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.entities.BulkShareResult
import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityDataEncryptionResult
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionKeyDetails
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionMetadataInitialisationResult
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.crypto.entities.HierarchicallyDecryptedMetadata
import com.icure.cardinal.sdk.crypto.entities.MinimalBulkShareResult
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.requests.EntityShareOrMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
class EntityEncryptionServiceImpl(
	private val secureDelegationsManager: SecureDelegationsManager,
	private val secureDelegationsDecryptor: SecureDelegationsDecryptor,
	private val legacyDelegationsDecryptor: LegacyDelegationsDecryptor,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService,
	private val jsonEncryptionService: JsonEncryptionService,
	private val useParentKeys: Boolean,
	private val autoCreateEncryptionKeyForExistingLegacyData: Boolean
) : EntityEncryptionService, EntityValidationService by EntityValidationServiceImpl(jsonEncryptionService) {
	companion object {
		private val log = getLogger("EntityEncryptionService")
	}

	private val allDecryptors = SecurityMetadataDecryptorChain(listOf(secureDelegationsDecryptor, legacyDelegationsDecryptor))

	override suspend fun <E, D> encryptEntity(
		unencryptedEntity: EntityWithTypeInfo<D>,
		unencryptedEntitySerializer: SerializationStrategy<D>,
		fieldsToEncrypt: EncryptedFieldsManifest,
		constructor: (json: JsonElement) -> E
	): E where E : HasEncryptionMetadata, E : Encryptable, D : HasEncryptionMetadata, D : Encryptable {
		val updatedEntity = ensureEncryptionKeysInitialized(unencryptedEntity)?.let { EntityWithTypeInfo(it, unencryptedEntity.type) } ?: unencryptedEntity
		val keyInfo = tryDecryptAndImportAnyEncryptionKey(updatedEntity)
			?: throw EntityEncryptionException("${updatedEntity.type.id} ${updatedEntity.entity.id} has no encryption key, and can't be encrypted; entity may have not been initialized properly.")
		val plainJson = Serialization.json.encodeToJsonElement(unencryptedEntitySerializer, updatedEntity.entity).jsonObject
		val encryptedJson = jsonEncryptionService.encrypt(keyInfo.key, plainJson, fieldsToEncrypt)
		return constructor(encryptedJson)
	}

	override suspend fun <E, D> tryDecryptEntity(
		encryptedEntity: EntityWithTypeInfo<E>,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D
	): D? where E : HasEncryptionMetadata, E : Encryptable, D : HasEncryptionMetadata, D : Encryptable =
		tryDecryptAndImportAnyEncryptionKey(encryptedEntity)?.let { keyInfo ->
			val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, encryptedEntity.entity).jsonObject
			constructor(jsonEncryptionService.decrypt(keyInfo.key, encryptedJson))
		}

	override suspend fun <T : HasEncryptionMetadata> encryptAttachmentOf(
		entity: EntityWithTypeInfo<T>,
		content: ByteArray,
		saveEntity: suspend (entity: T) -> T
	): EntityDataEncryptionResult<T> {
		val updatedEntity = ensureEncryptionKeysInitialized(entity)?.let { EntityWithTypeInfo(saveEntity(it), entity.type) }
		val encryptionKey = tryDecryptAndImportAnyEncryptionKey(updatedEntity ?: entity)?.key
			?: throw IllegalArgumentException("Could not decrypt any encryption key for ${entity.type.id} ${entity.entity.id}")
		return EntityDataEncryptionResult(
			updatedEntity?.entity,
			cryptoService.aes.encrypt(content, encryptionKey),
		)
	}

	override suspend fun tryDecryptAttachmentOf(
		entity: EntityWithTypeInfo<*>,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?
	): ByteArray? {
		return allDecryptors.decryptEncryptionKeysOf(entity, dataOwnersForDecryption(null).toSet()).mapNotNull { decryptedKeyInfo ->
			kotlin.runCatching {
				cryptoService.aes.decrypt(
					content,
					cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, decryptedKeyInfo.value.decodedBytes())
				).takeIf { validator == null || validator(it) }
			}.getOrNull()
		}.firstOrNull()
	}

	override suspend fun decryptAttachmentOf(
		entity: EntityWithTypeInfo<*>,
		content: ByteArray,
		validator: (suspend (decryptedData: ByteArray) -> Boolean)?
	): ByteArray {
		val triedKeys = mutableSetOf<HexString>()
		return allDecryptors.decryptEncryptionKeysOf(entity, dataOwnersForDecryption(null).toSet()).mapNotNull { decryptedKeyInfo ->
			if (triedKeys.add(decryptedKeyInfo.value)) {
				kotlin.runCatching {
					cryptoService.aes.decrypt(
						content,
						cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, decryptedKeyInfo.value.decodedBytes())
					).takeIf { validator == null || validator(it) }
				}.getOrNull()
			} else {
				null
			}
		}.firstOrNull() ?: throw EntityEncryptionException(
			if (triedKeys.isEmpty()) {
				"Could not extract any encryption key from ${entity.type.id} ${entity.entity.id}"
			} else {
				"Attachment can't be properly decrypted with any of the available keys (validator or decryption failed with available keys)"
			}
		)
	}

	override suspend fun <T : HasEncryptionMetadata> entityWithInitializedEncryptedMetadata(
		entity: EntityWithTypeInfo<T>,
		owningEntityId: String?,
		owningEntitySecretId: Set<String>?,
		initializeEncryptionKey: Boolean,
		autoDelegations: Map<String, AccessLevel>
	): EntityEncryptionMetadataInitialisationResult<T> {
		hasEmptyEncryptionMetadata(entity, throwIfNonEmpty = true)
		val newRawKey = if (initializeEncryptionKey)
			HexString(cryptoService.aes.exportKey(cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)).toHexString())
		else
			null
		val newSecretId = cryptoService.strongRandom.randomUUID()
		val entityWitSecurityMetadata = secureDelegationsManager.entityWithInitializedEncryptedMetadata(
			entity = entity,
			secretIds = setOf(newSecretId),
			owningEntityIds = setOfNotNull(owningEntityId),
			encryptionKeys = setOfNotNull(newRawKey),
			owningEntitySecretIds = owningEntitySecretId ?: emptySet(),
			autoDelegations = autoDelegations,
		)
		return EntityEncryptionMetadataInitialisationResult(
			updatedEntity = entityWitSecurityMetadata,
			secretId = newSecretId,
			rawEncryptionKey = newRawKey
		)
	}

	override suspend fun tryDecryptAndImportAnyEncryptionKey(entity: EntityWithTypeInfo<*>): EntityEncryptionKeyDetails? =
		decryptAndImportDecryptionKeysFlow(entity).firstOrNull()

	override suspend fun decryptAndImportAllDecryptionKeys(entity: EntityWithTypeInfo<*>): List<EntityEncryptionKeyDetails> =
		decryptAndImportDecryptionKeysFlow(entity).toList()

	private suspend fun decryptAndImportDecryptionKeysFlow(entity: EntityWithTypeInfo<*>): Flow<EntityEncryptionKeyDetails> =
		allDecryptors.decryptEncryptionKeysOf(entity, dataOwnersForDecryption(null).toSet()).mapNotNull {
			kotlin.runCatching {
				EntityEncryptionKeyDetails(cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, it.value.decodedBytes()), it.value)
			}.getOrNull()
		}

	override suspend fun encryptionKeysOf(entity: EntityWithTypeInfo<*>, dataOwnerId: String?): Set<HexString> =
		allDecryptors
			.decryptEncryptionKeysOf(entity, dataOwnersForDecryption(dataOwnerId).toSet())
			.map { it.value }
			.toSet()

	override suspend fun secretIdsOf(entity: EntityWithTypeInfo<*>, dataOwnerId: String?): Set<String> =
		allDecryptors
			.decryptSecretIdsOf(entity, dataOwnerId?.let(::setOf) ?: dataOwnersForDecryption(null).toSet())
			.map { it.value }
			.toSet()

	override suspend fun owningEntityIdsOf(entity: EntityWithTypeInfo<*>, dataOwnerId: String?): Set<String> =
		allDecryptors
			.decryptOwningEntityIdsOf(entity, dataOwnersForDecryption(dataOwnerId).toSet())
			.map { it.value }
			.toSet()

	override suspend fun encryptionKeysForHcpHierarchyOf(entity: EntityWithTypeInfo<*>): List<HierarchicallyDecryptedMetadata<HexString>> =
		decryptDataForHierarchy(entity) { e, h -> decryptEncryptionKeysOf(e, h) }

	override suspend fun secretIdsForHcpHierarchyOf(entity: EntityWithTypeInfo<*>): List<HierarchicallyDecryptedMetadata<String>> =
		decryptDataForHierarchy(entity) { e, h -> decryptSecretIdsOf(e, h) }

	override suspend fun owningEntityIdsForHcpHierarchyOf(entity: EntityWithTypeInfo<*>): List<HierarchicallyDecryptedMetadata<String>> =
		decryptDataForHierarchy(entity) { e, h -> decryptOwningEntityIdsOf(e, h) }

	private suspend fun <T : Any> decryptDataForHierarchy(
		entity: EntityWithTypeInfo<*>,
		doDecrypt: SecurityMetadataDecryptor.(entity: EntityWithTypeInfo<*>, dataOwnersHierarchyIds: Set<String>) -> Flow<DecryptedMetadataDetails<T>>
	): List<HierarchicallyDecryptedMetadata<T>> {
		val dataOwnersHierarchyIds = dataOwnersForDecryption(null)
		val allDecryptedData = allDecryptors.doDecrypt(entity, dataOwnersHierarchyIds.toSet()).toList()
		return dataOwnersHierarchyIds.map { currDataOwner ->
			val decryptedDataForCurr = allDecryptedData
				.filter { currDataOwner in it.dataOwnersWithAccess }
				.map { it.value }
				.toSet()
			HierarchicallyDecryptedMetadata(decryptedDataForCurr, currDataOwner)
		}
	}

	override suspend fun hasWriteAccess(entity: EntityWithTypeInfo<*>): Boolean =
		allDecryptors.getEntityAccessLevel(entity, dataOwnersForDecryption(null).toSet()) == AccessLevel.Write

	override fun hasEmptyEncryptionMetadata(entity: EntityWithTypeInfo<*>): Boolean =
		hasEmptyEncryptionMetadata(entity, throwIfNonEmpty = false)

	private fun hasEmptyEncryptionMetadata(entity: EntityWithTypeInfo<*>, throwIfNonEmpty: Boolean): Boolean {
		if (entity.entity.securityMetadata != null) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialized security metadata")
			}
			return false
		}
		if (entity.entity.secretForeignKeys.isNotEmpty()) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialized secret foreign keys")
			}
			return false
		}
		if (entity.entity.delegations.isNotEmpty() || entity.entity.cryptedForeignKeys.isNotEmpty() || entity.entity.encryptionKeys.isNotEmpty()) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialized legacy security metadata")
			}
			return false
		}
		return true
	}

	override suspend fun <T : HasEncryptionMetadata> bulkShareOrUpdateEncryptedEntityMetadata(
		entitiesUpdates: List<Pair<EntityWithTypeInfo<T>, Map<String, DelegateShareOptions>>>,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> EntityWithTypeInfo<T>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): BulkShareResult<T> {
		val requestDetails = prepareBulkShareRequests(entitiesUpdates)
		val shareResult = doRequestBulkShareOrUpdate(
			BulkShareOrUpdateMetadataParams(
				requestDetails.requestsByEntityId.mapValues { (_, details) ->
					BulkShareOrUpdateMetadataParams.EntityRequestInformation(
						details.requests.mapValues { it.value.request },
						details.potentialParentDelegations
					)
				}
			)
		)
		val updatedEntities = shareResult.mapNotNull { it.updatedEntity }
		val updateErrors = shareResult.flatMap { result ->
			makeFailedRequestDetails(result.entityId, result.rejectedRequests, requestDetails)
		}
		if (autoRetry && updateErrors.isNotEmpty()) {
			val updateErrorsByEntityId = updateErrors.groupBy { it.entityId }
			val updatedEntitiesId = updatedEntities.map { it.id }.toSet()
			val toRetryEntitiesId = updateErrorsByEntityId.filter { (k, v) ->
				v.all { it.shouldRetry } && k !in requestDetails.unmodifiedEntityIds && k !in updatedEntitiesId
			}.keys
			if (toRetryEntitiesId.isNotEmpty()) {
				val updatedRequests = entitiesUpdates.mapNotNull { (entity, request) ->
					if (entity.entity.id in toRetryEntitiesId) {
						val updatedEntity = getUpdatedEntity(entity.entity.id)
						if (updatedEntity.entity.rev != entity.entity.rev) {
							Pair(updatedEntity, request)
						} else null
					} else null
				}
				if (updatedRequests.isNotEmpty()) {
					val newResults = bulkShareOrUpdateEncryptedEntityMetadata(
						updatedRequests,
						autoRetry,
						getUpdatedEntity,
						doRequestBulkShareOrUpdate
					)
					return BulkShareResult(
						updatedEntities = newResults.updatedEntities + updatedEntities.filter { it.id !in toRetryEntitiesId },
						unmodifiedEntitiesIds = newResults.unmodifiedEntitiesIds + requestDetails.unmodifiedEntityIds,
						updateErrors = newResults.updateErrors + updateErrors.filter { it.entityId !in toRetryEntitiesId }
					)
				}
			}
		}
		return BulkShareResult(updatedEntities, requestDetails.unmodifiedEntityIds, updateErrors)
	}

	override suspend fun bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
		entitiesUpdates: List<Pair<EntityWithTypeInfo<*>, Map<String, DelegateShareOptions>>>,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> EntityWithTypeInfo<*>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<Nothing>>
	): MinimalBulkShareResult {
		val requestDetails = prepareBulkShareRequests(entitiesUpdates)
		val shareResult = doRequestBulkShareOrUpdate(
			BulkShareOrUpdateMetadataParams(
				requestDetails.requestsByEntityId.mapValues { (_, details) ->
					BulkShareOrUpdateMetadataParams.EntityRequestInformation(
						details.requests.mapValues { it.value.request },
						details.potentialParentDelegations
					)
				}
			)
		)
		val updateErrors = shareResult.flatMap { result ->
			makeFailedRequestDetails(result.entityId, result.rejectedRequests, requestDetails)
		}
		val failedRequestsMinimalDetails = updateErrors.mapTo(mutableSetOf()) {
			MinimalBulkShareResult.MinimalRequestDetails(delegateId = it.delegateId, entityId = it.entityId)
		}
		val successfulUpdates =  requestDetails.requestsByEntityId.flatMapTo(mutableSetOf()) { (entityId, request) ->
			request.requests.values.mapNotNull { delegateRequest ->
				MinimalBulkShareResult.MinimalRequestDetails(delegateId = delegateRequest.delegateId, entityId = entityId).takeIf {
					!failedRequestsMinimalDetails.contains(it)
				}
			}
		}
		if (autoRetry && updateErrors.isNotEmpty()) {
			val updateErrorsByEntityId = updateErrors.groupBy { it.entityId }
			val toRetryEntitiesId = updateErrorsByEntityId.filter { (k, v) ->
				v.all { it.shouldRetry } && k !in requestDetails.unmodifiedEntityIds && successfulUpdates.none { it.entityId == k }
			}.keys
			if (toRetryEntitiesId.isNotEmpty()) {
				val updatedRequests = entitiesUpdates.mapNotNull { (entity, request) ->
					if (entity.entity.id in toRetryEntitiesId) {
						val updatedEntity = getUpdatedEntity(entity.entity.id)
						if (updatedEntity.entity.rev != entity.entity.rev) {
							Pair(updatedEntity, request)
						} else null
					} else null
				}
				if (updatedRequests.isNotEmpty()) {
					val newResults = bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
						updatedRequests,
						autoRetry,
						getUpdatedEntity,
						doRequestBulkShareOrUpdate
					)
					return MinimalBulkShareResult(
						successfulUpdates = newResults.successfulUpdates + successfulUpdates.filter { it.entityId !in toRetryEntitiesId },
						unmodifiedEntitiesIds = newResults.unmodifiedEntitiesIds + requestDetails.unmodifiedEntityIds,
						updateErrors = newResults.updateErrors + updateErrors.filter { it.entityId !in toRetryEntitiesId }
					)
				}
			}
		}
		return MinimalBulkShareResult(successfulUpdates, requestDetails.unmodifiedEntityIds, updateErrors)
	}

	private fun makeFailedRequestDetails(
		entityId: String,
		shareResultRejectedRequests: Map<String, EntityBulkShareResult.RejectedShareOrMetadataUpdateRequest>,
		requestDetails: BulkShareRequestsDetails
	) =
		shareResultRejectedRequests.map { (rejectedRequestId, error) ->
			val originalRequestDetails = requestDetails.requestsByEntityId.getValue(entityId).requests.getValue(rejectedRequestId)
			FailedRequestDetails(
				delegateId = originalRequestDetails.delegateId,
				entityId = entityId,
				request = originalRequestDetails.options,
				updatedForMigration = originalRequestDetails.updatedForMigration,
				code = error.code,
				reason = error.reason,
				shouldRetry = error.shouldRetry
			)
		}


	private data class BulkShareRequestsDetails(
		// Entities that haven't been modified because no request was made. Doesn't include entities not modified due to errors.
		val unmodifiedEntityIds: Set<String>,
		val requestsByEntityId: Map<String, EntityShareRequestDetails>
	)
	private data class EntityShareRequestDetails(
		val requests: Map<String, DelegateShareRequestDetails>, // requestId (unique for the entity) -> request for a delegate
		val potentialParentDelegations: Set<SecureDelegationKeyString>
	)
	private data class DelegateShareRequestDetails(
		val delegateId: String,
		val options: DelegateShareOptions?,
		val updatedForMigration: Boolean,
		val request: EntityShareOrMetadataUpdateRequest
	)

	private suspend fun prepareBulkShareRequests(
		entitiesUpdates: List<Pair<EntityWithTypeInfo<*>, Map<String, DelegateShareOptions>>>
	): BulkShareRequestsDetails {
		require (entitiesUpdates.distinctBy { it.first.entity.id }.size == entitiesUpdates.size) {
			"Duplicate requests: the same entity id is present more than once in the input"
		}
		require (entitiesUpdates.distinctBy { it.first.type }.size <= 1) {
			"Entities of different types are not allowed in the same bulk share request"
		}
		require (entitiesUpdates.all { it.first.entity.rev != null }) {
			"Only existing entities can be shared"
		}
		val hierarchySet = dataOwnersForDecryption(null).toSet()
		val requestsByEntityId = mutableMapOf<String, EntityShareRequestDetails>()
		val unmodifiedEntityIds = mutableSetOf<String>()
		entitiesUpdates.forEach { (entity, optionsForDelegates) ->
			val migrationRequests = prepareMigrationRequestsIfNeeded(entity, optionsForDelegates)
			val otherRequests = optionsForDelegates.mapNotNull { (delegate, options) ->
				(
					if (!migrationRequests.containsKey(delegate)) {
						secureDelegationsManager.makeShareOrUpdateRequestParams(
							entity,
							delegate,
							options.shareSecretIds,
							options.shareEncryptionKeys,
							options.shareOwningEntityIds,
							options.requestedPermissions
						)
					} else null
				)?.let { delegate to it }
			}
			val allRequests = migrationRequests.map {
				DelegateShareRequestDetails(it.key, optionsForDelegates[it.key], true, it.value)
			} + otherRequests.map {
				DelegateShareRequestDetails(it.first, optionsForDelegates[it.first], false, it.second)
			}
			if (allRequests.isNotEmpty()) {
				val potentialParentDelegations = secureDelegationsDecryptor.getDelegationMemberDetails(entity).mapNotNullTo(
					mutableSetOf()
				) { (delegationKey, delegationInfo) ->
					if (delegationInfo.delegate in hierarchySet || delegationInfo.delegator in hierarchySet)
						delegationKey
					else
						null
				}
				requestsByEntityId[entity.entity.id] = EntityShareRequestDetails(
					allRequests.mapIndexed { index, it ->
						// Even though the delegate id could be a valid request id it could leak some secret information if it is a patient id.
						index.toString() to it
					}.toMap(),
					potentialParentDelegations
				)
			} else unmodifiedEntityIds.add(entity.entity.id)
		}
		return BulkShareRequestsDetails(unmodifiedEntityIds, requestsByEntityId)
	}

	private suspend fun prepareMigrationRequestsIfNeeded(
		entity: EntityWithTypeInfo<*>,
		optionsForDelegates: Map<String, DelegateShareOptions>
	): Map<String, EntityShareOrMetadataUpdateRequest> {
		val hierarchy = dataOwnersForDecryption(null)
		val legacySecretIds = legacyDelegationsDecryptor.decryptSecretIdsOf(entity, hierarchy.toSet()).toList()
		val legacyOwningEntityIds = legacyDelegationsDecryptor.decryptOwningEntityIdsOf(entity, hierarchy.toSet()).toList()
		val legacyEncryptionKeys = legacyDelegationsDecryptor.decryptEncryptionKeysOf(entity, hierarchy.toSet()).toList()
		return hierarchy.mapNotNull { currMember ->
			makeMigrationRequestForMemberOfHierarchy(
				entity,
				currMember,
				optionsForDelegates[currMember],
				legacySecretIds,
				legacyOwningEntityIds,
				legacyEncryptionKeys
			)?.let { currMember to it }
		}.toMap()
	}

	private suspend fun makeMigrationRequestForMemberOfHierarchy(
		entity: EntityWithTypeInfo<*>,
		currMember: String,
		userRequest: DelegateShareOptions?,
		legacySecretIds: List<DecryptedMetadataDetails<String>>,
		legacyOwningEntityIds: List<DecryptedMetadataDetails<String>>,
		legacyEncryptionKeys: List<DecryptedMetadataDetails<HexString>>
	): EntityShareOrMetadataUpdateRequest? {
		val selfId = dataOwnerApi.getCurrentDataOwnerId()
		val subHierarchy = dataOwnersForDecryption(currMember)
		val subHierarchySet = subHierarchy.toSet()
		val legacyAccess =
			if (selfId == entity.entity.id && currMember == selfId)
				AccessLevel.Write
			else
				legacyDelegationsDecryptor.getEntityAccessLevel(entity, subHierarchySet)
		if (legacyAccess == null) return null
		val delegateLegacySecretIds = legacySecretIds.valuesAvailableToDataOwners(subHierarchySet)
		val delegateLegacyOwningEntityIds = legacyOwningEntityIds.valuesAvailableToDataOwners(subHierarchySet)
		val delegateLegacyEncryptionKeys = legacyEncryptionKeys.valuesAvailableToDataOwners(subHierarchySet)
		val missingLegacySecretIds =
			if (delegateLegacySecretIds.isEmpty())
				delegateLegacySecretIds
			else
				(delegateLegacySecretIds - secureDelegationsDecryptor.decryptSecretIdsOf(entity, setOf(currMember)).map { it.value }.toSet())
		val missingLegacyOwningEntityIds =
			if (delegateLegacyOwningEntityIds.isEmpty())
				delegateLegacyOwningEntityIds
			else
				(delegateLegacyOwningEntityIds - secureDelegationsDecryptor.decryptOwningEntityIdsOf(entity, setOf(currMember)).map { it.value }.toSet())
		val missingLegacyEncryptionKeys =
			if (delegateLegacyEncryptionKeys.isEmpty())
				delegateLegacyEncryptionKeys
			else
				(delegateLegacyEncryptionKeys - secureDelegationsDecryptor.decryptEncryptionKeysOf(entity, setOf(currMember)).map { it.value }.toSet())
		return if (missingLegacySecretIds.isNotEmpty() || missingLegacyOwningEntityIds.isNotEmpty() || missingLegacyEncryptionKeys.isNotEmpty()) {
			val requestedPermissions =
				if (currMember == selfId)
					RequestedPermission.Root
				else
					RequestedPermission.FullWrite // Legacy permission if present is always write
			secureDelegationsManager.makeShareOrUpdateRequestParams(
				entity,
				currMember,
				missingLegacySecretIds + (userRequest?.shareSecretIds ?: emptySet()),
				missingLegacyEncryptionKeys + (userRequest?.shareEncryptionKeys ?: emptySet()),
				missingLegacyOwningEntityIds + (userRequest?.shareOwningEntityIds ?: emptySet()),
				requestedPermissions
			)
		} else null
	}

	override suspend fun <T : HasEncryptionMetadata> simpleShareOrUpdateEncryptedEntityMetadata(
		entity: EntityWithTypeInfo<T>,
		delegates: Map<String, SimpleDelegateShareOptions>,
		autoRetry: Boolean,
		getUpdatedEntity: suspend (String) -> EntityWithTypeInfo<T>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): SimpleShareResult<T> {
		val availableEncryptionKeys = encryptionKeysOf(entity, null)
		val availableOwningEntityIds = owningEntityIdsOf(entity, null)
		val availableSecretIds = secretIdsOf(entity, null)
		val extendedDelegateOptions = delegates.mapValues { (_, simpleShareOptions) ->
			if (availableEncryptionKeys.isEmpty() && simpleShareOptions.shareEncryptionKey == ShareMetadataBehaviour.Required) {
				throw IllegalArgumentException("The current data owner can't access any encryption key in ${entity.type.id} ${entity.entity.id}, but sharing is required.")
			}
			if (availableOwningEntityIds.isEmpty() && simpleShareOptions.shareOwningEntityIds == ShareMetadataBehaviour.Required) {
				throw IllegalArgumentException("The current data owner can't access any owning entity id in ${entity.type.id} ${entity.entity.id}, but sharing is required.")
			}
			DelegateShareOptions(
				shareSecretIds = simpleShareOptions.shareSecretIds.resolve(availableSecretIds, entity),
				shareEncryptionKeys = if (simpleShareOptions.shareEncryptionKey == ShareMetadataBehaviour.Never) emptySet() else availableEncryptionKeys,
				shareOwningEntityIds = if (simpleShareOptions.shareOwningEntityIds == ShareMetadataBehaviour.Never) emptySet() else availableOwningEntityIds,
				requestedPermissions = simpleShareOptions.requestedPermissions
			)
		}
		val shareResult = bulkShareOrUpdateEncryptedEntityMetadata(
			listOf(entity to extendedDelegateOptions),
			false,
			getUpdatedEntity,
			doRequestBulkShareOrUpdate
		)
		if (shareResult.unmodifiedEntitiesIds.contains(entity.entity.id)) {
			return SimpleShareResult.Success(entity.entity)
		}
		if (shareResult.updateErrors.isEmpty() && shareResult.updatedEntities.size == 1) {
			return SimpleShareResult.Success(shareResult.updatedEntities.first())
		}
		val errorsOfRequestedDelegates = shareResult.updateErrors.filter { delegates.containsKey(it.delegateId) }
		if (errorsOfRequestedDelegates.isEmpty() && shareResult.updatedEntities.size == 1) {
			log.w { "There was an internal error with the migration of encrypted metadata: ${shareResult.updateErrors}" }
			return SimpleShareResult.Success(shareResult.updatedEntities.first())
		}
		if (autoRetry && shareResult.updateErrors.all { it.shouldRetry }) {
			val updatedEntity = getUpdatedEntity(entity.entity.id)
			if (updatedEntity.entity.rev != entity.entity.rev) {
				return simpleShareOrUpdateEncryptedEntityMetadata(updatedEntity, delegates, autoRetry, getUpdatedEntity, doRequestBulkShareOrUpdate)
			}
		}
		return SimpleShareResult.Failure(shareResult.updateErrors)
	}

	override suspend fun <T : HasEncryptionMetadata> ensureEncryptionKeysInitialized(entity: EntityWithTypeInfo<T>): T? {
		if (allDecryptors.hasAnyEncryptionKeys(entity.entity)) {
			return null
		}
		require(entity.entity.rev != null) {
			"A new ${entity.type.id} does not have encryption keys initialized: make sure the entity was created using the `newInstance` method from the appropriate api before trying to save it."
		}
		if (autoCreateEncryptionKeyForExistingLegacyData && entity.entity.delegations.isNotEmpty()) {
			/*
			 * Handle rare pre-2018 cases where entities was using delegation key (-> secretId) as encryption key.
			 *
			 * If entity was using delegations as legacy encryption keys we will essentially revoke the access to the encrypted data for all other data
			 * owners. This however should not be a problem as this form of legacy entities should not exist anymore, and it should be present only in the
			 * databases of hcps without collaborators.
			 */
			val newKey = cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
			return secureDelegationsManager.entityWithInitializedEncryptedMetadata(
				entity = entity,
				secretIds = emptySet(), // Will still be available through legacy delegations
				owningEntityIds = emptySet(), // Will still be available through legacy delegations
				encryptionKeys = setOf(HexString(cryptoService.aes.exportKey(newKey).toHexString())),
				owningEntitySecretIds = entity.entity.secretForeignKeys,
				autoDelegations = emptyMap(),
			)
		} else throw IllegalEntityException(
			"Existing ${entity.type.id} ${entity.entity.id} does not have any recognised encryption metadata available, but encryption keys are required to perform an operation."
		)
	}

	override suspend fun <T : HasEncryptionMetadata> initializeConfidentialSecretId(
		entity: EntityWithTypeInfo<T>,
		getUpdatedEntity: suspend (String) -> EntityWithTypeInfo<T>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<out T>>
	): T? {
		if (entity.entity.rev == null) {
			throw IllegalArgumentException("Entity must be an existing entity to initialize a confidential secret id")
		}
		if (getConfidentialSecretIdsOf(entity, null).isNotEmpty()) return null
		return simpleShareOrUpdateEncryptedEntityMetadata(
			entity,
			mapOf(dataOwnerApi.getCurrentDataOwnerId() to SimpleDelegateShareOptionsImpl(
				shareSecretIds = SecretIdShareOptions.UseExactly(
					secretIds = setOf(cryptoService.strongRandom.randomUUID()),
					createUnknownSecretIds = true
				),
				shareEncryptionKey = ShareMetadataBehaviour.Never,
				shareOwningEntityIds = ShareMetadataBehaviour.Never,
				requestedPermissions = RequestedPermission.MaxWrite
			)),
			true,
			getUpdatedEntity,
			doRequestBulkShareOrUpdate
		).updatedEntityOrThrow()
	}

	override suspend fun getConfidentialSecretIdsOf(entity: EntityWithTypeInfo<*>, dataOwnerId: String?): Set<String> {
		val secretIdsInfo = secretIdsForHcpHierarchyOf(entity)
		val targetDataOwner = dataOwnerId ?: dataOwnerApi.getCurrentDataOwnerId()
		val parents = secretIdsInfo.takeWhile { it.ownerId != targetDataOwner }
		require(parents.size < secretIdsInfo.size) {
			"Target data owner $targetDataOwner is not in the hierarchy of the logged data owner"
		}
		val res = secretIdsInfo[parents.size].extracted.toMutableSet()
		parents.forEach { res -= it.extracted }
		return res
	}

	override suspend fun getSecretIdsSharedWithParentsOf(entity: EntityWithTypeInfo<*>): Set<String> =
		secretIdsForHcpHierarchyOf(entity).first().extracted

	override suspend fun resolveSecretIdOption(entity: EntityWithTypeInfo<*>, secretIdUseOption: SecretIdUseOption): Set<String> =
		when (secretIdUseOption) {
			is SecretIdUseOption.Use -> secretIdUseOption.secretIds
			SecretIdUseOption.UseAnyConfidential -> getConfidentialSecretIdsOf(entity, null).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}.let { setOf(it.first()) }
			SecretIdUseOption.UseAllConfidential -> getConfidentialSecretIdsOf(entity, null).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}
			SecretIdUseOption.UseAnySharedWithParent -> getSecretIdsSharedWithParentsOf(entity).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}.let { setOf(it.first()) }
			SecretIdUseOption.UseAllSharedWithParent -> getSecretIdsSharedWithParentsOf(entity).also {
				require(it.isNotEmpty()) {
					"No valid secret id found for option $secretIdUseOption"
				}
			}
			SecretIdUseOption.UseNone -> emptySet()
		}

	private suspend fun dataOwnersForDecryption(startingFrom: String?) =
		if (useParentKeys) {
			if (startingFrom != null)
				dataOwnerApi.getCurrentDataOwnerHierarchyIdsFrom(startingFrom)
			else
				dataOwnerApi.getCurrentDataOwnerHierarchyIds()
		} else {
			val self = dataOwnerApi.getCurrentDataOwnerId()
			ensure(startingFrom == null || startingFrom == self) {
				"$startingFrom is not part of the current data owner hierarchy"
			}
			listOf(self)
		}

	private fun <T : Any> Iterable<DecryptedMetadataDetails<T>>.valuesAvailableToDataOwners(dataOwners: Set<String>): Set<T> =
		mapNotNullTo(mutableSetOf()) { decryptedDataDetails -> if (dataOwners.any { it in decryptedDataDetails.dataOwnersWithAccess }) decryptedDataDetails.value else null }

	private suspend fun SecretIdShareOptions.resolve(entitySecretIds: Set<String>, entity: EntityWithTypeInfo<*>) = when (this) {
		is SecretIdShareOptions.AllAvailable -> entitySecretIds.also {
			require (!requireAtLeastOne || it.isNotEmpty()) {
				"No secret id could be extracted by the current user for ${entity.type} ${entity.entity.id}"
			}
		}
		is SecretIdShareOptions.UseExactly ->
			secretIds.also {
				if (!createUnknownSecretIds) {
					require (entitySecretIds.containsAll(secretIds)) {
						"Unknown secret ids for ${entity.type} ${entity.entity.id} and `createUnknownSecretIds` is false: ${
							secretIds - entitySecretIds
						}"
					}
				}
			}
	}
}
