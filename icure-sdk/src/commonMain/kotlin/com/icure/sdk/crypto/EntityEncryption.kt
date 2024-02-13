package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.Encryptable
import com.icure.sdk.model.EntityBulkShareResult
import com.icure.sdk.model.HexString
import com.icure.sdk.model.MinimalEntityBulkShareResult
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNames

@InternalIcureApi
data class HierarchicallyDecryptedMetadata<T : Any>(
	/**
	 * The decrypted metadata
	 */
	val extracted: List<T>,
	/**
	 * The ids of a data owner part
	 */
	val ownerId: String
)

@InternalIcureApi
data class EntityEncryptionKeyDetails(
	val key: AesKey,
	val raw: HexString
)

/**
 * Configuration for the encryption of an object.
 * @param topLevelFields the fields of the object to encrypt. All the fields will be encrypted in a single encryptedSelf field which is added to the
 * object.
 * @param nestedObjectsKeys the name of fields which are expected to contain a nested object (or undefined). Allows to specify
 */
@InternalIcureApi
data class EncryptedFieldsManifest(
	val path: String,
	val topLevelFields: List<String>,
	val nestedObjectsKeys: Map<String, EncryptedFieldsManifest>,
	val mapsValuesKeys: Map<String, EncryptedFieldsManifest>,
	val arraysValuesKeys: Map<String, EncryptedFieldsManifest>,
)

@InternalIcureApi
data class EntityDataEncryptionResult<T : Encryptable>(
	val updatedEntity: T,
	val encryptedData: ByteArray
)

@InternalIcureApi
data class EntityEncryptionMetadataInitialisationResult<T : Encryptable>(
	val updatedEntity: T,
	val rawEncryptionKey: HexString?,
	val secretId: String?
)

data class DelegateShareOptions(
	val shareSecretIds: List<String>,
	val shareEncryptionKeys: List<HexString>,
	val shareOwningEntityIds: List<String>,
	val requestedPermissions: RequestedPermission
)

@InternalIcureApi
data class SimpleDelegateShareOptions(
	val shareSecretIds: List<String>,
	val shareEncryptionKeys: ShareMetadataBehaviour,
	val shareOwningEntityIds: ShareMetadataBehaviour,
	val requestedPermissions: RequestedPermission
)

/**
 * Specifies a behaviour for the sharing of encryption keys or owning entity ids in the extended apis 'share' methods.
 */
enum class ShareMetadataBehaviour {
	/**
	 * The method must share the metadata with the delegate. If this is not possible, because for example the current user has no access to this kind of
	 * metadata, the method will throw an error.
	 */
	@SerialName("REQUIRED")
	Required,
	/**
	 * The method must share the metadata with the delegate if available. If this is not possible, because for example the current user has no access to
	 * this kind of metadata, the method will simply not share this metadata.
	 */
	@SerialName("IF_AVAILABLE")
	IfAvailable,
	/**
	 * The method must not share the metadata with the delegate, even if the current data owner can access it.
	 */
	@SerialName("NEVER")
	Never
}

data class FailedRequestDetails(
	val entityId: String,
	val delegateId: String,
	val updatedForMigration: Boolean,
	val code: Int?,
	val reason: String?,
	val request: DelegateShareOptions
)

data class BulkShareResult<T : Encryptable>(
	val updatedEntities: List<T>,
	val unmodifiedEntitiesIds: List<String>,
	val updateErrors: List<FailedRequestDetails>
)

data class MinimalBulkShareResult(
	val updatedEntitiesIds: List<String>,
	val unmodifiedEntitiesIds: List<String>,
	val updateErrors: List<FailedRequestDetails>
)

interface ShareResult<out T : Encryptable> {
	val isSuccess: Boolean

	/**
	 * Return the updated entity if the share operation was successful, else throw an error.
	 */
	fun updatedEntityOrThrow(): T

	/**
	 * Represents the result of a successful share operation.
	 */
	data class Success<T : Encryptable>(val updatedEntity: T) : ShareResult<T> {
		override val isSuccess: Boolean get() = true
		override fun updatedEntityOrThrow(): T = updatedEntity
	}

	data class Failure(val errorsDetails: List<FailedRequestDetails>) : ShareResult<Nothing> {
		override val isSuccess: Boolean get() = false

		override fun updatedEntityOrThrow(): Nothing {
			throw IllegalStateException("One or more share requests failed. Details: $errorsDetails")
		}
	}
}

/**
 * Gives access to several functions to access encrypted entities metadata.
 */
@InternalIcureApi
interface EntityEncryptionService {
	// region metadata decryption
	/**
	 * Get the encryption keys of an entity that the provided data owner can access, potentially using the keys for his parent.
	 * There should only be one encryption key for each entity, but the method supports more to allow to deal with conflicts and merged duplicate data.
	 * @param entity an encrypted entity.
	 * @param dataOwnerId optionally a data owner part of the hierarchy for the current data owner, defaults to the current data owner.
	 * @return the encryption keys that the provided data owner can decrypt, deduplicated.
	 */
	suspend fun encryptionKeysOf(entity: Encryptable, dataOwnerId: String?): List<HexString>

	/**
	 * Get the encryption keys of an entity that the current data owner and his parents can access. The resulting array contains the keys for each data
	 * owner in the hierarchy which can be decrypted using only that data owner keys (excludes keys accessible through the parent keys). The order of
	 * the array is the same as in {@link IccDataOwnerXApi.getCurrentDataOwnerHierarchyIds}.
	 * Note that different data owners may have access to the same keys, but the keys extracted for each data owner are deduplicated.
	 * There should only be one encryption key for each entity, but the method supports more to allow to deal with conflicts and merged duplicate data.
	 * @param entity an encrypted entity.
	 * @return the encryption keys that each member of the current data owner hierarchy can decrypt using only his keys and not keys of his parents.
	 */
	suspend fun encryptionKeysForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<HexString>>

	/**
	 * Get the secret ids (SFKs) of an entity that the provided data owner can access, potentially using the keys for his parent.
	 * @param entity an encrypted entity.
	 * @param dataOwnerId optionally a data owner part of the hierarchy for the current data owner, defaults to the current data owner.
	 * @return the secret ids (SFKs) that the provided data owner can decrypt, deduplicated.
	 */
	suspend fun secretIdsOf(entity: Encryptable, dataOwnerId: String?): List<String>

	/**
	 * Get the secret ids (SFKs) of an entity that the current data owner and his parents can access. The resulting array contains the ids for each data
	 * owner in the hierarchy which can be decrypted using only that data owner keys (excludes ids accessible through the parent keys). The order of
	 * the array is the same as in {@link IccDataOwnerXApi.getCurrentDataOwnerHierarchyIds}.
	 * Note that different data owners may have access to the same secret ids, but the secret ids extracted for each data owner are deduplicated.
	 * @param entity an encrypted entity.
	 * @return the secret ids that each member of the current data owner hierarchy can decrypt using only his keys and not keys of his parents.
	 */
	suspend fun secretIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>>

	/**
	 * Get the decrypted owning entity ids (formerly CFKs) for the provided entity that can be decrypted using the private keys of the current data
	 * owner and his parents. The owning entity id would be, for example, the id of a patient for contact and healthcare elements, or the id of a
	 * message for documents.
	 * There should only be one owning entity id for each entity, but the method supports more to allow to deal with conflicts and merged duplicate
	 * data.
	 * @param entity an encrypted entity.
	 * @param dataOwnerId optionally a data owner part of the hierarchy for the current data owner, defaults to the current data owner.
	 * @return the owning entity ids (CFKs) that the provided data owner can decrypt, deduplicated.
	 */
	suspend fun owningEntityIdsOf(entity: Encryptable, dataOwnerId: String?): List<String>

	/**
	 * Get the decrypted owning entity ids (formerly CFKs) for the provided entity that can be decrypted using the private keys of the current data
	 * owner and his parents. The owning entity id would be, for example, the id of a patient for contact and healthcare elements, or the id of a
	 * message for documents.
	 * The resulting array contains the ids for each data owner in the hierarchy which can be decrypted using only that data owner keys (excludes ids
	 * accessible through the parent keys). The order of the array is the same as in {@link IccDataOwnerXApi.getCurrentDataOwnerHierarchyIds}.
	 * Note that different data owners may have access to the same owning entity ids, but the owning entity ids extracted for each data owner are
	 * deduplicated in case they could be accessed through different delegations.
	 * There should only be one owning entity id for each entity, but the method supports more to allow to deal with conflicts and merged duplicate
	 * data.
	 * @param entity an encrypted entity.
	 * @return the owning entity ids that each member of the current data owner hierarchy can decrypt using only his keys and not keys of his parents.
	 */
	suspend fun owningEntityIdsForHcpHierarchyOf(entity: Encryptable): List<HierarchicallyDecryptedMetadata<String>>

	/**
	 * Get if the current data owner has write access to the content of the entity.
	 * @param entity an entity
	 * @return if the current data owner (or one of his parents) has write access to the content of the entity.
	 */
	suspend fun hasWriteAccess(entity: Encryptable): Boolean

	/**
	 * @param entity an entity
	 * @return if the entity has no encryption metadata and can be safely initialised using .
	 */
	fun hasEmptyEncryptionMetadata(entity: Encryptable): Boolean
	// endregion

	// region metadata initialisation and share
	/**
	 * Initializes encryption metadata for an entity. This includes the encrypted secret id, owning entity id, encryption key for the entity, and
	 * the clear text secret foreign key of the parent entity.
	 * This method returns a modified copy of the entity and DOES NOT SAVE the entity to the cloud/DB: you will have to save the entity manually.
	 * @param entity entity which requires encryption metadata initialisation.
	 * @param owningEntityId id of the owning entity, if any (e.g. patient id for Contact/HealtchareElement, message id for Document, ...).
	 * @param owningEntitySecretId secret id of the parent entity, to use in the secret foreign keys for the provided entity, if any.
	 * @param initialiseEncryptionKey if false this method will not initialize an encryption key for the entity. Use only for entities which use
	 * delegations for access control but don't actually have any encrypted content.
	 * @param initialiseSecretId if false this method will not initialize any secret id, use it for entities which can not be 'owning entities' (e.g.
	 * HealthcareElement).
	 * @param autoDelegations automatically shares the metadata with the provided data owners, with the provided access level.
	 * @throws if the entity already has non-empty values for encryption metadata.
	 * @return an updated copy of the entity.
	 */
	suspend fun <T : Encryptable> entityWithInitialisedEncryptedMetadata(
		entity: T,
		owningEntityId: String?,
		owningEntitySecretId: String?,
		initialiseEncryptionKey: Boolean,
		initialiseSecretId: Boolean,
		autoDelegations: Map<String, AccessLevel>
	): EntityEncryptionMetadataInitialisationResult<T>

	/**
	 * Updates encryption metadata for an entity in order to share it with a delegate or in order to add additional encrypted metadata for an existing
	 * delegate.
	 * The first time this method is used for a specific delegate it will give access to all unencrypted content of the entity to the delegate data
	 * owner. Additionally, this method also allows to share new or existing secret ids (shareSecretId), encryption keys (shareEncryptionKeys) and
	 * owning entity ids (shareOwningEntityIds) for the entity.
	 * You can use methods like {@link secretIdsOf}, {@link secretIdsForHcpHierarchyOf}, {@link encryptionKeysOf}, ... to retrieve the data you want to
	 * share. In most cases you may want to share everything related to the entity, but note that if you use confidential delegations for patients you
	 * may want to avoid sharing the confidential secret ids of the current user with other hcps.
	 * This updates the entity in the cloud/DB (the updated entities in the returned promise are already saved in the DB). NOTE: this method can only
	 * be used with entities which already exist in the cloud (the entities must have been saved).
	 * @param entitiesType type of entities to update
	 * @param entitiesUpdates share/update requests for each entity. An array of objects containing:
	 * - The entity to share/update (or at least its encrypted metadata)
	 * - The data to share/update for each delegate. An object associating to each delegate id the data to share/update for that delegate, and the
	 * permissions requested for the delegate (ignored if the request will only update already existing shared metadata).
	 * @param doRequestBulkShareOrUpdate perform the request to share or update an entity encrypted metadata on the cloud API (and save to DB).
	 * @throws if there are duplicate entities in the requested updates or if not all the entities have the same type.
	 * @return a promise which will be completed with an object containing:
	 * - the updated entities, only for entities were at least one update was successful
	 * - information on the individual requests failed, containing the id of the entity, id of the delegate that the request was for, the content,
	 * an error code mirroring an http status code, and a human-friendly description of the error (but not necessarily end-user friendly).
	 */
	suspend fun <T : Encryptable> bulkShareOrUpdateEncryptedEntityMetadata(
		entitiesUpdates: List<Pair<T, Map<String, DelegateShareOptions>>>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): BulkShareResult<T>

	suspend fun bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
		entitiesUpdates: List<Pair<Encryptable, Map<String, DelegateShareOptions>>>,
		doRequestBulkShareOrUpdate: suspend (request: BulkShareOrUpdateMetadataParams) -> List<MinimalEntityBulkShareResult>
	): MinimalBulkShareResult

	/**
	 * Simplified version of {@link bulkShareOrUpdateEncryptedEntityMetadata} for a single entity and with automatic retrieval of the encryption keys
	 * and owning entity ids if requested. NOTE: this method can only be used with entities which already exist in the cloud (the entity must have
	 * been saved).
	 * @param entity an entity.
	 * @param unusedSecretIds specifies if the entity should not actually use secret ids but may have some if it was created using older iCure sdk
	 * versions. If true the method expects `shareSecretIds` options to always be undefined and will always share any available secret ids. If false
	 * it expects `shareSecretIds` options to always be defined and will only share the secret ids specified in the options.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKeys specifies if the encryption keys of the entity should be shared. Defaults to
	 * {@link ShareMetadataBehaviour.IF_AVAILABLE}.
	 * - shareOwningEntityIds specifies if the owning entity ids of the entity should be shared. Defaults to
	 * {@link ShareMetadataBehaviour.IF_AVAILABLE}.
	 * - shareSecretIds specifies which secret ids of the entity should be shared. Should be defined only if {@link unusedSecretIds} is false.
	 * - requestedPermissions requested permissions for the delegate. Defaults to {@link RequestedPermissionEnum.MAX_WRITE}.
	 * @param doRequestBulkShareOrUpdate perform the request to share or update an entity encrypted metadata on the cloud API (and save to DB).
	 * @return a promise which will be completed with the result of the operation
	 * @throws if shareEncryptionKeys or shareOwningEntityIds is {@link ShareMetadataBehaviour.REQUIRED} and the current data owner can't access any
	 * value for the required metadata.
	 */
	suspend fun <T : Encryptable> simpleShareOrUpdateEncryptedEntityMetadata(
		entity: T,
		unusedSecretIds: Boolean,
		delegates: Map<String, SimpleDelegateShareOptions>,
		doRequestBulkShareOrUpdate: (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<T>>
	): ShareResult<T>
	// endregion

	// region content encryption and decryption
	/**
	 * Encrypts data using a key of the entity that the provided data owner can access (current data owner by default). If the provided data owner can
	 * access multiple encryption keys of the entity there is no guarantee on which key will be used.
	 * Note: you should not use this method to encrypt the `encryptedSelf` of iCure entities, since that will be automatically handled by the extended
	 * apis. You should use this method only to encrypt additional data, such as document attachments.
	 * @param entity an entity.
	 * @param type type of the entity.
	 * @param content data of the entity which you want to encrypt.
	 * @param saveEntity a function which saves the entity to the cloud/DB. Used only if a new encryption key needed to be initialised for the entity.
	 * @return the encrypted data and, if a new encryption key was initialised for the entity, the updated entity.
	 * @throws if the provided data owner can't access any encryption keys for the entity.
	 */
	suspend fun <T : Encryptable> encryptDataOf(
	entity: T,
	content: ByteArray,
	saveEntity: suspend (entity: T) -> T
	): EntityDataEncryptionResult<T>

	/**
	 * Decrypts data using a key of the entity that the provided data owner can access (current data owner by default). If the provided data owner can
	 * access multiple encryption keys each of them will be tried for decryption until one of them gives a result that is valid according to the
	 * provided validator.
	 * Note: you should not use this method to decrypt the `encryptedSelf` of iCure entities, since that will be automatically handled by the extended
	 * apis. You should use this method only to decrypt additional data, such as document attachments.
	 * @param entity an entity.
	 * @param content data of the entity which you want to decrypt.
	 * @param validator a function which verifies the correctness of decrypted content: helps to identify decryption with the wrong key without relying
	 * solely on padding.
	 * @return the decrypted data, if it could be decrypted, null otherwise.
	 * @throws if the provided data owner can't access any encryption keys for the entity, or if no key could be found which provided valid decrypted
	 * content according to the validator.
	 */
	suspend fun tryDecryptDataOf(
		entity: Encryptable,
		content: ByteArray,
		validator: suspend (decryptedData: ByteArray) -> Boolean
	): ByteArray?

	/**
	 * Decrypts an encrypted entity, returns null if the entity could not be decrypted.
	 */
	suspend fun <E : Encryptable, D: Encryptable> decryptEntity(
		entity: E,
		constructor: (json: JsonElement) -> D
	): D?

	/**
	 * Tries to decrypt data to a json object using the provided keys.
	 */
	suspend fun tryDecryptJson(
		potentialKeys: List<EntityEncryptionKeyDetails>,
		encrypted: ByteArray,
		truncateTrailingDecryptedNulls: Boolean
	): JsonElement

	/**
	 * Tries to encrypt the content of an encrypted entity.
	 * 1. If valid key for encryption is found the method returns the entity with the encrypted fields specified by cryptedKeys
	 * 2. If requireEncryption is true and no key could be found for encryption of the entity the method fails.
	 * 3. If requireEncryption is false and no key could be found for encryption the method will only check that the entity does not specify any value
	 * for fields which should be encrypted according to cryptedKeys (e.g. note in a patient using the default configuration). If the entity specifies
	 * a value for any field which should be encrypted the method throws an error, otherwise the method returns the original entity.
	 */
	suspend fun <E : Encryptable, D: Encryptable> tryEncryptEntity(
		decryptedEntity: D,
		fieldsToEncrypt: EncryptedFieldsManifest,
		encodeBinaryData: Boolean,
		requireEncryption: Boolean,
		constructor: (json: JsonElement) -> E
	): E

	/**
	 * Returns the first encryption key which could be properly decrypted from the entity using the current data owner.
	 * @throws if no key could be decrypted.
	 */
	suspend fun decryptAndImportAnyEncryptionKey(entity: Encryptable): EntityEncryptionKeyDetails

	/**
	 * Returns all encryption keys which could be properly decrypted from the entity using the current data owner. The keys returned by this method
	 * should not be used for encryption of the entity, but only for decryption.
	 * This is because this for data from pre-2018 users this method may return also keys from old formats of entities which are not safe anymore for
	 * encryption.
	 */
	suspend fun decryptAndImportAllDecryptionKeys(entity: Encryptable): List<EntityEncryptionKeyDetails>

	/**
	 * Verifies if the entity has valid encryption keys (regardless of whether the current data owner has access to them or not). If not this method
	 * will throw an error, otherwise it will return undefined. For pre-2018 users there are some cases where the data may have been encrypted with a
	 * key not safe for encryption anymore, in which case this method will return the entity with a new and safe encryption key.
	 * After this method is called, if it returns an entity it should also be re-encrypted (using the new key) and saved to the cloud.
	 */
	suspend fun <T : Encryptable> ensureEncryptionKeysInitialised(entity: T): T?
	// endregion
}
