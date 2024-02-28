package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.entities.BulkShareResult
import com.icure.sdk.crypto.entities.DelegateShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityDataEncryptionResult
import com.icure.sdk.crypto.entities.EntityEncryptionKeyDetails
import com.icure.sdk.crypto.entities.EntityEncryptionMetadataInitialisationResult
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.HierarchicallyDecryptedMetadata
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.SecureDelegationsDecryptor
import com.icure.sdk.crypto.entities.MinimalBulkShareResult
import com.icure.sdk.crypto.SecureDelegationsManager
import com.icure.sdk.crypto.SecurityMetadataDecryptor
import com.icure.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.sdk.crypto.entities.FailedRequestDetails
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.EntityBulkShareResult
import com.icure.sdk.model.EntityRequestInformationDto
import com.icure.sdk.model.EntityShareOrMetadataUpdateRequest
import com.icure.sdk.model.HexString
import com.icure.sdk.model.MinimalEntityBulkShareResult
import com.icure.sdk.model.RejectedShareOrMetadataUpdateRequest
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.model.SecureDelegationKeyString
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.getLogger
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
) : EntityEncryptionService {
	companion object {
		private val log = getLogger("EntityEncryptionService")
	}

	private val allDecryptors = SecurityMetadataDecryptorChain(listOf(secureDelegationsDecryptor, legacyDelegationsDecryptor))

	override suspend fun <E : Encryptable, D : Encryptable> encryptEntity(
		unencryptedEntity: D,
		unencryptedEntitySerializer: SerializationStrategy<D>,
		fieldsToEncrypt: EncryptedFieldsManifest,
		constructor: (json: JsonElement) -> E
	): E {
		val updatedEntity = ensureEncryptionKeysInitialised(unencryptedEntity) ?: unencryptedEntity
		val keyInfo = requireNotNull(tryDecryptAndImportAnyEncryptionKey(updatedEntity)) {
			"${updatedEntity.type.id} ${updatedEntity.id} has no encryption key, and can't be encrypted; entity may have not been initialised properly."
		}
		val plainJson = Serialization.json.encodeToJsonElement(unencryptedEntitySerializer, updatedEntity).jsonObject
		val encryptedJson = jsonEncryptionService.encrypt(keyInfo.key, plainJson, fieldsToEncrypt)
		return constructor(encryptedJson)
	}

	override suspend fun <E : Encryptable, D : Encryptable> tryDecryptEntity(
		encryptedEntity: E,
		encryptedEntitySerializer: SerializationStrategy<E>,
		constructor: (json: JsonElement) -> D
	): D? = tryDecryptAndImportAnyEncryptionKey(encryptedEntity)?.let { keyInfo ->
		val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, encryptedEntity).jsonObject
		constructor(jsonEncryptionService.decrypt(keyInfo.key, encryptedJson))
	}

	override suspend fun <E : Encryptable> validateEncryptedEntity(
		encryptedEntity: E,
		encryptedEntitySerializer: SerializationStrategy<E>,
		fieldsToEncrypt: EncryptedFieldsManifest
	): E {
		val encryptedJson = Serialization.json.encodeToJsonElement(encryptedEntitySerializer, encryptedEntity).jsonObject
		require (!jsonEncryptionService.requiresEncryption(encryptedJson, fieldsToEncrypt)) {
			"${encryptedEntity.type.id} ${encryptedEntity.id} has some fields which should be encrypted according to the manifest but are not encrypted; you should not modify encrypted fields when working directly with encrypted entities."
		}
		return encryptedEntity
	}

	override suspend fun <T : Encryptable> encryptAttachmentOf(
		entity: T,
		content: ByteArray,
		saveEntity: suspend (entity: T) -> T
	): EntityDataEncryptionResult<T> {
		val updatedEntity = ensureEncryptionKeysInitialised(entity)?.let { saveEntity(it) }
		val encryptionKey = tryDecryptAndImportAnyEncryptionKey(updatedEntity ?: entity)?.key
			?: throw IllegalArgumentException("Could not decrypt any encryption key for ${entity.type.id} ${entity.id}")
		return EntityDataEncryptionResult(
			updatedEntity,
			cryptoService.aes.encrypt(content, encryptionKey),
		)
	}

	override suspend fun tryDecryptAttachmentOf(
		entity: Encryptable,
		content: ByteArray,
		validator: suspend (decryptedData: ByteArray) -> Boolean
	): ByteArray? {
		val triedKeys = mutableSetOf<HexString>()
		return allDecryptors.decryptEncryptionKeysOf(entity, dataOwnersForDecryption(null).toSet()).mapNotNull { decryptedKeyInfo ->
			if (triedKeys.add(decryptedKeyInfo.value)) {
				kotlin.runCatching {
					cryptoService.aes.decrypt(
						content,
						cryptoService.aes.loadKey(decryptedKeyInfo.value.decodedBytes())
					).takeIf { validator(it) }
				}.getOrNull()
			} else {
				null
			}
		}.firstOrNull()
	}

	override suspend fun <T : Encryptable> entityWithInitialisedEncryptedMetadata(
		entity: T,
		owningEntityId: String?,
		owningEntitySecretId: String?,
		initialiseEncryptionKey: Boolean,
		initialiseSecretId: Boolean,
		autoDelegations: Map<String, AccessLevel>
	): EntityEncryptionMetadataInitialisationResult<T> {
		hasEmptyEncryptionMetadata(entity, throwIfNonEmpty = true)
		val newRawKey = if (initialiseEncryptionKey)
			HexString(cryptoService.aes.exportKey(cryptoService.aes.generateKey()).toHexString())
		else
			null
		val newSecretId = if (initialiseSecretId)
			cryptoService.strongRandom.randomUUID()
		else
			null
		val entityWitSecurityMetadata = secureDelegationsManager.entityWithInitialisedEncryptedMetadata(
			entity = entity,
			secretIds = setOfNotNull(newSecretId),
			owningEntityIds = setOfNotNull(owningEntityId),
			encryptionKeys = setOfNotNull(newRawKey),
			owningEntitySecretIds = setOfNotNull(owningEntitySecretId),
			autoDelegations = autoDelegations,
		)
		return EntityEncryptionMetadataInitialisationResult(
			updatedEntity = entityWitSecurityMetadata,
			secretId = newSecretId,
			rawEncryptionKey = newRawKey
		)
	}

	override suspend fun tryDecryptAndImportAnyEncryptionKey(entity: Encryptable): EntityEncryptionKeyDetails? =
		decryptAndImportDecryptionKeysFlow(entity).firstOrNull()

	override suspend fun decryptAndImportAllDecryptionKeys(entity: Encryptable): List<EntityEncryptionKeyDetails> =
		decryptAndImportDecryptionKeysFlow(entity).toList()

	private suspend fun decryptAndImportDecryptionKeysFlow(entity: Encryptable): Flow<EntityEncryptionKeyDetails> =
		allDecryptors.decryptEncryptionKeysOf(entity, dataOwnersForDecryption(null).toSet()).mapNotNull {
			kotlin.runCatching {
				EntityEncryptionKeyDetails(cryptoService.aes.loadKey(it.value.decodedBytes()), it.value)
			}.getOrNull()
		}

	override suspend fun encryptionKeysOf(entity: Encryptable, dataOwnerId: String?): Set<HexString> =
		allDecryptors
			.decryptEncryptionKeysOf(entity, dataOwnerId?.let(::setOf) ?: dataOwnersForDecryption(null).toSet())
			.map { it.value }
			.toSet()

	override suspend fun secretIdsOf(entity: Encryptable, dataOwnerId: String?): Set<String> =
		allDecryptors
			.decryptSecretIdsOf(entity, dataOwnerId?.let(::setOf) ?: dataOwnersForDecryption(null).toSet())
			.map { it.value }
			.toSet()

	override suspend fun owningEntityIdsOf(entity: Encryptable, dataOwnerId: String?): Set<String> =
		allDecryptors
			.decryptOwningEntityIdsOf(entity, dataOwnerId?.let(::setOf) ?: dataOwnersForDecryption(null).toSet())
			.map { it.value }
			.toSet()

	override suspend fun encryptionKeysForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<HexString>> =
		decryptDataForHierarchy(entity) { e, h -> decryptEncryptionKeysOf(e, h) }

	override suspend fun secretIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>> =
		decryptDataForHierarchy(entity) { e, h -> decryptSecretIdsOf(e, h) }

	override suspend fun owningEntityIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>> =
		decryptDataForHierarchy(entity) { e, h -> decryptOwningEntityIdsOf(e, h) }

	private suspend fun <T : Any> decryptDataForHierarchy(
		entity: Encryptable,
		doDecrypt: SecurityMetadataDecryptor.(entity: Encryptable, dataOwnersHierarchyIds: Set<String>) -> Flow<DecryptedMetadataDetails<T>>
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

	override suspend fun hasWriteAccess(entity: Encryptable): Boolean =
		allDecryptors.getEntityAccessLevel(entity, dataOwnersForDecryption(null).toSet()) == AccessLevel.Write

	override fun hasEmptyEncryptionMetadata(entity: Encryptable): Boolean =
		hasEmptyEncryptionMetadata(entity, throwIfNonEmpty = false)

	private fun hasEmptyEncryptionMetadata(entity: Encryptable, throwIfNonEmpty: Boolean): Boolean {
		if (entity.securityMetadata != null) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialised security metadata")
			}
			return false
		}
		if (entity.secretForeignKeys.isNotEmpty()) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialised secret foreign keys")
			}
			return false
		}
		if (entity.delegations.isNotEmpty() || entity.cryptedForeignKeys.isNotEmpty() || entity.encryptionKeys.isNotEmpty()) {
			if (throwIfNonEmpty) {
				throw IllegalArgumentException("Entity already has initialised legacy security metadata")
			}
			return false
		}
		return true
	}

	override suspend fun <T : Encryptable> bulkShareOrUpdateEncryptedEntityMetadata(
		entitiesUpdates: List<Pair<T, Map<String, DelegateShareOptions>>>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): BulkShareResult<T> {
		val requestDetails = prepareBulkShareRequests(entitiesUpdates)
		val shareResult = doRequestBulkShareOrUpdate(
			BulkShareOrUpdateMetadataParams(
				requestDetails.requestsByEntityId.mapValues { (_, details) ->
					EntityRequestInformationDto(
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
		return BulkShareResult(updatedEntities, requestDetails.unmodifiedEntityIds, updateErrors)
	}

	override suspend fun bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
		entitiesUpdates: List<Pair<Encryptable, Map<String, DelegateShareOptions>>>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<MinimalEntityBulkShareResult>
	): MinimalBulkShareResult {
		val requestDetails = prepareBulkShareRequests(entitiesUpdates)
		val shareResult = doRequestBulkShareOrUpdate(
			BulkShareOrUpdateMetadataParams(
				requestDetails.requestsByEntityId.mapValues { (_, details) ->
					EntityRequestInformationDto(
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
		return MinimalBulkShareResult(successfulUpdates, requestDetails.unmodifiedEntityIds, updateErrors)
	}

	private fun makeFailedRequestDetails(
		entityId: String,
		shareResultRejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest>,
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
				reason = error.reason
			)
		}


	private data class BulkShareRequestsDetails(
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
		entitiesUpdates: List<Pair<Encryptable, Map<String, DelegateShareOptions>>>
	): BulkShareRequestsDetails {
		require (entitiesUpdates.distinctBy { it.first.id }.size == entitiesUpdates.size) {
			"Duplicate requests: the same entity id is present more than once in the input"
		}
		require (entitiesUpdates.distinctBy { it.first.type }.size <= 1) {
			"Entities of different types are not allowed in the same bulk share request"
		}
		require (entitiesUpdates.all { it.first.rev != null }) {
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
					if (delegationInfo.delegate in hierarchySet || delegationInfo.delegate in optionsForDelegates.keys)
						delegationKey
					else
						null
				}
				requestsByEntityId[entity.id] = EntityShareRequestDetails(
					allRequests.mapIndexed { index, it ->
						// Even though the delegate id could be a valid request id it could leak some secret information if it is a patient id.
						index.toString() to it
					}.toMap(),
					potentialParentDelegations
				)
			} else unmodifiedEntityIds.add(entity.id)
		}
		return BulkShareRequestsDetails(unmodifiedEntityIds, requestsByEntityId)
	}

	private suspend fun prepareMigrationRequestsIfNeeded(
		entity: Encryptable,
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
		entity: Encryptable,
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
			if (selfId == entity.id && currMember == selfId)
				AccessLevel.Write
			else
				legacyDelegationsDecryptor.getEntityAccessLevel(entity, setOf(currMember))
		if (legacyAccess == null) return null
		val delegateLegacySecretIds = legacySecretIds.valuesAvailableToDataOwners(subHierarchySet)
		val delegateLegacyOwningEntityIds = legacyOwningEntityIds.valuesAvailableToDataOwners(subHierarchySet)
		val delegateLegacyEncryptionKeys = legacyEncryptionKeys.valuesAvailableToDataOwners(subHierarchySet)
		val missingLegacySecretIds =
			if (delegateLegacySecretIds.isEmpty())
				delegateLegacySecretIds
			else
				(secureDelegationsDecryptor.decryptSecretIdsOf(entity, setOf(currMember)).map { it.value }.toSet() - delegateLegacySecretIds)
		val missingLegacyOwningEntityIds =
			if (delegateLegacyOwningEntityIds.isEmpty())
				delegateLegacyOwningEntityIds
			else
				(secureDelegationsDecryptor.decryptOwningEntityIdsOf(entity, setOf(currMember)).map { it.value }.toSet() - delegateLegacyOwningEntityIds)
		val missingLegacyEncryptionKeys =
			if (delegateLegacyEncryptionKeys.isEmpty())
				delegateLegacyEncryptionKeys
			else
				(secureDelegationsDecryptor.decryptEncryptionKeysOf(entity, setOf(currMember)).map { it.value }.toSet() - delegateLegacyEncryptionKeys)
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

	override suspend fun <T : Encryptable> simpleShareOrUpdateEncryptedEntityMetadata(
		entity: T,
		unusedSecretIds: Boolean,
		delegates: Map<String, SimpleDelegateShareOptions>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): SimpleShareResult<T> {
		val availableEncryptionKeys = encryptionKeysOf(entity, null)
		val availableOwningEntityIds = owningEntityIdsOf(entity, null)
		val availableSecretIds = if (unusedSecretIds) secretIdsOf(entity, null) else null
		val extendedDelegateOptions = delegates.mapValues { (_, simpleShareOptions) ->
			if (availableEncryptionKeys.isEmpty() && simpleShareOptions.shareEncryptionKeys == ShareMetadataBehaviour.Required) {
				throw IllegalArgumentException("The current data owner can't access any encryption key in ${entity.type.id} ${entity.id}, but sharing is required.")
			}
			if (availableOwningEntityIds.isEmpty() && simpleShareOptions.shareOwningEntityIds == ShareMetadataBehaviour.Required) {
				throw IllegalArgumentException("The current data owner can't access any owning entity id in ${entity.type.id} ${entity.id}, but sharing is required.")
			}
			if (simpleShareOptions.shareSecretIds == null && !unusedSecretIds) {
				throw IllegalArgumentException("Share secret ids parameter is mandatory for entities of type ${entity.type.id}.")
			} else if (simpleShareOptions.shareSecretIds != null && unusedSecretIds) {
				throw IllegalArgumentException("Share secret ids parameter must not be unused with entities of type ${entity.type.id}.")
			}
			DelegateShareOptions(
				shareSecretIds = simpleShareOptions.shareSecretIds ?: availableSecretIds ?: emptySet(),
				shareEncryptionKeys = if (simpleShareOptions.shareEncryptionKeys == ShareMetadataBehaviour.Never) emptySet() else availableEncryptionKeys,
				shareOwningEntityIds = if (simpleShareOptions.shareOwningEntityIds == ShareMetadataBehaviour.Never) emptySet() else availableOwningEntityIds,
				requestedPermissions = simpleShareOptions.requestedPermissions
			)
		}
		val shareResult = bulkShareOrUpdateEncryptedEntityMetadata(
			listOf(entity to extendedDelegateOptions),
			doRequestBulkShareOrUpdate
		)
		if (shareResult.unmodifiedEntitiesIds.contains(entity.id)) {
			return SimpleShareResult.Success(entity)
		}
		if (shareResult.updateErrors.isEmpty() && shareResult.updatedEntities.size == 1) {
			return SimpleShareResult.Success(shareResult.updatedEntities.first())
		}
		val errorsOfRequestedDelegates = shareResult.updateErrors.filter { delegates.containsKey(it.delegateId) }
		if (errorsOfRequestedDelegates.isEmpty() && shareResult.updatedEntities.size == 1) {
			log.w { "There was an internal error with the migration of encrypted metadata: ${shareResult.updateErrors}" }
			return SimpleShareResult.Success(shareResult.updatedEntities.first())
		}
		return SimpleShareResult.Failure(shareResult.updateErrors)
	}

	override suspend fun <T : Encryptable> ensureEncryptionKeysInitialised(entity: T): T? {
		if (allDecryptors.hasAnyEncryptionKeys(entity)) {
			return null
		}
		require(entity.rev != null) {
			"A new ${entity.type.id} does not have encryption keys initialised: make sure the entity was created using the `newInstance` method from the appropriate api before trying to save it."
		}
		if (autoCreateEncryptionKeyForExistingLegacyData && entity.delegations.isNotEmpty()) {
			/*
			 * Handle rare pre-2018 cases where entities was using delegation key (-> secretId) as encryption key.
			 *
			 * If entity was using delegations as legacy encryption keys we will essentially revoke the access to the encrypted data for all other data
			 * owners. This however should not be a problem as this form of legacy entities should not exist anymore, and it should be present only in the
			 * databases of hcps without collaborators.
			 */
			val newKey = cryptoService.aes.generateKey()
			return secureDelegationsManager.entityWithInitialisedEncryptedMetadata(
				entity = entity,
				secretIds = emptySet(), // Will still be available through legacy delegations
				owningEntityIds = emptySet(), // Will still be available through legacy delegations
				encryptionKeys = setOf(HexString(cryptoService.aes.exportKey(newKey).toHexString())),
				owningEntitySecretIds = entity.secretForeignKeys,
				autoDelegations = emptyMap(),
			)
		} else throw IllegalEntityException(
			"Existing ${entity.type.id} ${entity.id} does not have any recognised encryption metadata available, but encryption keys are required to perform an operation."
		)
	}

	private suspend fun dataOwnersForDecryption(startingFrom: String?) =
		if (useParentKeys)
			if (startingFrom != null)
				dataOwnerApi.getCurrentDataOwnerHierarchyIdsFrom(startingFrom)
			else
				dataOwnerApi.getCurrentDataOwnerHierarchyIds()
		else
			listOf(dataOwnerApi.getCurrentDataOwnerId())

	private suspend inline fun <T : Any> Iterable<DecryptedMetadataDetails<T>>.valuesAvailableToDataOwners(dataOwners: Set<String>): Set<T> =
		mapNotNullTo(mutableSetOf()) { decryptedDataDetails -> if (dataOwners.any { it in decryptedDataDetails.dataOwnersWithAccess }) decryptedDataDetails.value else null }
}