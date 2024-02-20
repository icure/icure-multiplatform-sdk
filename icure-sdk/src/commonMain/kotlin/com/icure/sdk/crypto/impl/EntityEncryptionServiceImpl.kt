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
import com.icure.sdk.crypto.entities.MinimalBulkShareResult
import com.icure.sdk.crypto.SecureDelegationsManager
import com.icure.sdk.crypto.SecurityMetadataDecryptor
import com.icure.sdk.crypto.entities.ShareResult
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.EntityBulkShareResult
import com.icure.sdk.model.HexString
import com.icure.sdk.model.MinimalEntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toSet
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
class EntityEncryptionServiceImpl(
	private val secureDelegationsManager: SecureDelegationsManager,
	private val securityMetadataDecryptor: SecurityMetadataDecryptor,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService,
	private val jsonEncryptionService: JsonEncryptionService
) : EntityEncryptionService {

	override suspend fun secretIdsOf(entity: Encryptable, dataOwnerId: String?): Set<String> =
		securityMetadataDecryptor
			.decryptSecretIdsOf(entity, dataOwnerApi.getCurrentDataOwnerHierarchyIds())
			.map { it.value }
			.toSet()

	override suspend fun <E : Encryptable, D : Encryptable> tryEncryptEntity(
		unencryptedEntity: D,
		unencryptedEntityJson: JsonElement,
		fieldsToEncrypt: EncryptedFieldsManifest,
		requireEncryption: Boolean, // Ignoring it right now
		constructor: (json: JsonElement) -> E
	): E {
		val key = decryptAndImportAnyEncryptionKey(unencryptedEntity)
		val encrypted = jsonEncryptionService.encrypt(key.key, unencryptedEntityJson.jsonObject, fieldsToEncrypt)
		return constructor(encrypted)
	}


	override suspend fun <E : Encryptable, D : Encryptable> decryptEntity(
		encryptedEntity: E,
		encryptedEntityJson: JsonElement,
		constructor: (json: JsonElement) -> D
	): D? {
		// TODO decryptAndImportAnyEncryptionKey should return nullable (if key is not available)
		val key = decryptAndImportAnyEncryptionKey(encryptedEntity)
		return constructor(jsonEncryptionService.decrypt(key.key, encryptedEntityJson.jsonObject))
	}

	override suspend fun <T : Encryptable> entityWithInitialisedEncryptedMetadata(
		entity: T,
		owningEntityId: String?,
		owningEntitySecretId: String?,
		initialiseEncryptionKey: Boolean,
		initialiseSecretId: Boolean,
		autoDelegations: Map<String, AccessLevel>
	): EntityEncryptionMetadataInitialisationResult<T> {
		require (entity.securityMetadata == null) { "Entity already has initialised security metadata" }
		require (entity.secretForeignKeys.isEmpty()) { "Entity already has initialised secret foreign keys" }
		// TODO check old delegations & friends are empty
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
			// TODO could be set instead of list
			secretIds = listOfNotNull(newSecretId),
			owningEntityIds = listOfNotNull(owningEntityId),
			encryptionKeys = listOfNotNull(newRawKey),
			owningEntitySecretIds = listOfNotNull(owningEntitySecretId),
			autoDelegations = autoDelegations,
		)
		return EntityEncryptionMetadataInitialisationResult(
			updatedEntity = entityWitSecurityMetadata,
			secretId = newSecretId,
			rawEncryptionKey = newRawKey
		)
	}

	override suspend fun decryptAndImportAnyEncryptionKey(entity: Encryptable): EntityEncryptionKeyDetails {
		val key = securityMetadataDecryptor.decryptEncryptionKeysOf(entity, dataOwnerApi.getCurrentDataOwnerHierarchyIds()).first().value
		return EntityEncryptionKeyDetails(cryptoService.aes.loadKey(key.decodedBytes()), key)
	}

	override suspend fun encryptionKeysOf(entity: Encryptable, dataOwnerId: String?): Set<HexString> =
		securityMetadataDecryptor
			.decryptEncryptionKeysOf(entity, dataOwnerApi.getCurrentDataOwnerHierarchyIds())
			.map { it.value }
			.toSet()

	// TODO later on

	override suspend fun encryptionKeysForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<HexString>> {
		TODO("Not yet implemented")
	}

	override suspend fun secretIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>> {
		TODO("Not yet implemented")
	}

	override suspend fun owningEntityIdsOf(entity: Encryptable, dataOwnerId: String?): Set<String> {
		TODO("Not yet implemented")
	}

	override suspend fun owningEntityIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>> {
		TODO("Not yet implemented")
	}

	override suspend fun hasWriteAccess(entity: Encryptable): Boolean {
		TODO("Not yet implemented")
	}

	override fun hasEmptyEncryptionMetadata(entity: Encryptable): Boolean {
		TODO("Not yet implemented")
	}

	override suspend fun <T : Encryptable> bulkShareOrUpdateEncryptedEntityMetadata(
		entitiesUpdates: List<Pair<T, Map<String, DelegateShareOptions>>>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): BulkShareResult<T> {
		TODO("Not yet implemented")
	}

	override suspend fun bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
		entitiesUpdates: List<Pair<Encryptable, Map<String, DelegateShareOptions>>>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<MinimalEntityBulkShareResult>
	): MinimalBulkShareResult {
		TODO("Not yet implemented")
	}

	override suspend fun <T : Encryptable> simpleShareOrUpdateEncryptedEntityMetadata(
		entity: T,
		unusedSecretIds: Boolean,
		delegates: Map<String, SimpleDelegateShareOptions>,
		doRequestBulkShareOrUpdate: (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): ShareResult<T> {
		TODO("Not yet implemented")
	}

	override suspend fun <T : Encryptable> encryptDataOf(
		entity: T,
		content: ByteArray,
		saveEntity: suspend (entity: T) -> T
	): EntityDataEncryptionResult<T> {
		TODO("Not yet implemented")
	}

	override suspend fun tryDecryptDataOf(
		entity: Encryptable,
		content: ByteArray,
		validator: suspend (decryptedData: ByteArray) -> Boolean
	): ByteArray? {
		TODO("Not yet implemented")
	}

	override suspend fun tryDecryptJson(
		potentialKeys: List<EntityEncryptionKeyDetails>,
		encrypted: ByteArray,
		truncateTrailingDecryptedNulls: Boolean
	): JsonElement {
		TODO("Not yet implemented")
	}

	override suspend fun decryptAndImportAllDecryptionKeys(entity: Encryptable): List<EntityEncryptionKeyDetails> {
		TODO("Not yet implemented")
	}

	override suspend fun <T : Encryptable> ensureEncryptionKeysInitialised(entity: T): T? {
		TODO("Not yet implemented")
	}
}