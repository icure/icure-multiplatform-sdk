package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.BulkShareResult
import com.icure.sdk.crypto.DelegateShareOptions
import com.icure.sdk.crypto.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityDataEncryptionResult
import com.icure.sdk.crypto.EntityEncryptionKeyDetails
import com.icure.sdk.crypto.EntityEncryptionMetadataInitialisationResult
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.HierarchicallyDecryptedMetadata
import com.icure.sdk.crypto.MinimalBulkShareResult
import com.icure.sdk.crypto.SecureDelegationsManager
import com.icure.sdk.crypto.SecurityMetadataDecryptor
import com.icure.sdk.crypto.ShareResult
import com.icure.sdk.crypto.SimpleDelegateShareOptions
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.EntityBulkShareResult
import com.icure.sdk.model.HexString
import com.icure.sdk.model.MinimalEntityBulkShareResult
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@InternalIcureApi
class EntityEncryptionServiceImpl(
	private val secureDelegationsManager: SecureDelegationsManager,
	private val securityMetadataDecryptor: SecurityMetadataDecryptor,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService
) : EntityEncryptionService {

	override suspend fun secretIdsOf(entity: Encryptable, dataOwnerId: String?): List<String> =
		securityMetadataDecryptor
			.decryptSecretIdsOf(entity, dataOwnerApi.getCurrentDataOwnerHierarchyIds())
			.map { it.value }
			.toList()

	override suspend fun <E : Encryptable, D : Encryptable> tryEncryptEntity(
		decryptedEntity: D,
		decryptedEntityJson: JsonElement,
		fieldsToEncrypt: EncryptedFieldsManifest,
		encodeBinaryData: Boolean, // Ignoring it right now
		requireEncryption: Boolean, // Ignoring it right now
		constructor: (json: JsonElement) -> E
	): E {
		val key = decryptAndImportAnyEncryptionKey(decryptedEntity)
		val obj = decryptedEntityJson.jsonObject
		if (
			fieldsToEncrypt.mapsValuesKeys.isNotEmpty()
			|| fieldsToEncrypt.arraysValuesKeys.isNotEmpty()
			|| fieldsToEncrypt.nestedObjectsKeys.isNotEmpty()
		) TODO("Only top level fields encryption is currently supported.")
		val objWithoutEncryptedFields = obj.filter { it.key !in fieldsToEncrypt.topLevelFields }
		val fieldsToEncrypt = JsonObject(obj.filter { it.key in fieldsToEncrypt.topLevelFields })
		// TODO If encrypted self is the same as fields to encrypt no need to update it
		val encryptedSelf = base64Encode(cryptoService.aes.encrypt(
			fieldsToEncrypt.toString().toByteArray(Charsets.UTF_8),
			key.key
		))
		return constructor(JsonObject(objWithoutEncryptedFields + ("encryptedSelf" to JsonPrimitive(encryptedSelf))))
	}


	override suspend fun <E : Encryptable, D : Encryptable> decryptEntity(
		encryptedEntity: E,
		encryptedEntityJson: JsonElement,
		constructor: (json: JsonElement) -> D
	): D? {
		val key = decryptAndImportAnyEncryptionKey(encryptedEntity)
		// TODO nested decrypt
		val obj = encryptedEntityJson.jsonObject
		val encryptedSelf = obj["encryptedSelf"]?.jsonPrimitive?.also {
			if (!it.isString) throw IllegalEntityException("encryptedSelf must be a string")
		}?.content
		if (encryptedSelf == null) return constructor(encryptedEntityJson)
		val decryptedSelf = cryptoService.aes.decrypt(base64Decode(encryptedSelf), key.key).decodeToString()
		val decryptedSelfJson = Serialization.json.parseToJsonElement(decryptedSelf)
		return constructor(JsonObject(obj + decryptedSelfJson.jsonObject))
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

	// TODO later on

	override suspend fun encryptionKeysOf(entity: Encryptable, dataOwnerId: String?): List<HexString> {
		TODO("Not yet implemented")
	}

	override suspend fun encryptionKeysForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<HexString>> {
		TODO("Not yet implemented")
	}

	override suspend fun secretIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>> {
		TODO("Not yet implemented")
	}

	override suspend fun owningEntityIdsOf(entity: Encryptable, dataOwnerId: String?): List<String> {
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