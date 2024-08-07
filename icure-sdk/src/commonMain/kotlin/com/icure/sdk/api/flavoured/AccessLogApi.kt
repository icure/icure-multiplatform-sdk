package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawAccessLogApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.AccessLogShareOptions
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.DecryptedAccessLog
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochInstant
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface AccessLogBasicFlavourlessApi {
	/**
	 * Deletes an access log. If you don't have write access to the entity the method will fail.
	 * @param entityId id of the access log.
	 * @return the id and revision of the deleted entity.
	 */
	suspend fun deleteAccessLog(entityId: String): DocIdentifier
	/**
	 * Deletes many access logs. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of access logs.
	 * @return the id and revision of the deleted access logs. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteAccessLogs(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface AccessLogBasicFlavouredApi<E : AccessLog> {
	/**
	 * Modifies an access log. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity an access log with update content
	 * @return the updated access log with a new revision.
	 */
	suspend fun modifyAccessLog(entity: E): E

	/**
	 * Get an access log by its id. You must have read access to the access log. Fails if the access log does not exist
	 * or if you don't have read access to it.
	 * Flavoured method.
	 * @param entityId an access log id.
	 * @return the access log with id [entityId].
	 */
	suspend fun getAccessLog(entityId: String): E

	/**
	 * Get multiple access logs by their ids. Ignores all ids that do not exist, or access logs that you can't access.
	 * Flavoured method.
	 * @param entityIds a list of access log ids
	 * @return all access logs that you can access with one of the provided ids.
	 */
	suspend fun getAccessLogs(entityIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		@DefaultValue("null")
		accessType: String? = null,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedList<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findAccessLogsInGroup(
		groupId: String,
		@DefaultValue("null")
		fromEpoch: Long? = null,
		@DefaultValue("null")
		toEpoch: Long? = null,
		@DefaultValue("null")
		startKey: Long? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface AccessLogFlavouredApi<E : AccessLog> : AccessLogBasicFlavouredApi<E> {
	/**
	 * Share an access log with another data owner.
	 * @param delegateId the owner that will gain access to [accessLog]
	 * @param accessLog the access log to share with [delegateId]
	 * @param options specifies how the access log will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the access log.
	 * @return the updated access log if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		@DefaultValue("null")
		options: AccessLogShareOptions? = null,
	): SimpleShareResult<E>

	/**
	 * Share an access log with multiple data owners.
	 * @param accessLog the access log to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated access log if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		accessLog: E,
		delegates: Map<String, AccessLogShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share an access log with multiple data owners. Throws an exception if the operation fails.
	 * @param accessLog the access log to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated access log.
	 */
	suspend fun shareWithMany(
		accessLog: E,
		delegates: Map<String, AccessLogShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
	suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface AccessLogApi : AccessLogBasicFlavourlessApi, AccessLogFlavouredApi<DecryptedAccessLog> {
	/**
	 * Create a new access log. The provided access log must have the encryption metadata initialized.
	 * @param entity an access log with initialized encryption metadata
	 * @return the created access log with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog

	/**
	 * Creates a new access log with initialized encryption metadata
	 * @param base an access log with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the access log.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new access log
	 * @return an access log with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedAccessLog

	/**
	 * Attempts to extract the encryption keys of an access log. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param accessLog an access log
	 * @return the encryption keys extracted from the provided access log.
	 */
	suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString>

	/**
	 * Specifies if the current user has write access to an access log.
	 * @param accessLog an access log
	 * @return if the current user has write access to the provided access log
	 */
	suspend fun hasWriteAccess(accessLog: AccessLog): Boolean

	/**
	 * Attempts to extract the patient id linked to an access log.
	 * Note: access logs usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param accessLog an access log
	 * @return the id of the patient linked to the access log, or empty if the current user can't access any patient id
	 * of the access log.
	 */
	suspend fun decryptPatientIdOf(accessLog: AccessLog): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of an entity.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided entity. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the `entity` the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any AccessLog,
	 * not only in the provided entity.
	 *
	 * ## Example
	 *
	 * If you have an access log E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any access log that you have shared with P, H will be able to know that the access log was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to an access log that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 * 
	 * @param entity an access log
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>)

	/**
	 * Decrypts an access log, throwing an exception if it is not possible.
	 * @param accessLog an encrypted access log
	 * @return the decrypted access log
	 * @throws EntityEncryptionException if the access log could not be decrypted
	 */
	suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog

	/**
	 * Tries to decrypt an access log, returns the input if it is not possible.
	 * @param accessLog an encrypted access log
	 * @return the decrypted access log if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: AccessLogFlavouredApi<EncryptedAccessLog>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: AccessLogFlavouredApi<AccessLog>
}

interface AccessLogBasicApi : AccessLogBasicFlavourlessApi, AccessLogBasicFlavouredApi<EncryptedAccessLog>

@InternalIcureApi
private abstract class AbstractAccessLogBasicFlavouredApi<E : AccessLog>(
	protected val rawApi: RawAccessLogApi
) : AccessLogBasicFlavouredApi<E> {
	protected open suspend fun getSecureDelegationKeys() = emptyList<String>()

	override suspend fun modifyAccessLog(entity: E): E =
		rawApi.modifyAccessLog(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getAccessLog(entityId: String): E = rawApi.getAccessLog(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getAccessLogs(entityIds: List<String>): List<E> =
		rawApi.getAccessLogByIds(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): PaginatedList<E> =
		rawApi.findAccessLogsByUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit, descending).successBody()
			.map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findAccessLogsInGroup(groupId, fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedAccessLog
	abstract suspend fun maybeDecrypt(entity: EncryptedAccessLog): E
}

@InternalIcureApi
private abstract class AbstractAccessLogFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	private val config: ApiConfiguration
) : AbstractAccessLogBasicFlavouredApi<E>(rawApi), AccessLogFlavouredApi<E> {
	protected val crypto: InternalCryptoServices get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.accessLog

	override suspend fun getSecureDelegationKeys(): List<String> =
		crypto.exchangeDataManager.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.AccessLog)?.map { it.s } ?: emptyList()

	override suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		options: AccessLogShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			accessLog.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: AccessLogShareOptions()),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			accessLog.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(accessLog: E, delegates: Map<String, AccessLogShareOptions>): E =
		tryShareWithMany(accessLog, delegates).updatedEntityOrThrow()

	@Deprecated("Will be replaced by filter")
	override suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listAccessLogIdsByDataOwnerPatientDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())).successBody()
	) { ids ->
		rawApi.getAccessLogByIds(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractAccessLogBasicFlavourlessApi(val rawApi: RawAccessLogApi) : AccessLogBasicFlavourlessApi {
	override suspend fun deleteAccessLog(entityId: String) = rawApi.deleteAccessLog(entityId).successBody()
	override suspend fun deleteAccessLogs(entityIds: List<String>) = rawApi.deleteAccessLogs(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class AccessLogApiImpl(
	private val rawApi: RawAccessLogApi,
	private val config: ApiConfiguration
) : AccessLogApi, AccessLogFlavouredApi<DecryptedAccessLog> by object :
	AbstractAccessLogFlavouredApi<DecryptedAccessLog>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedAccessLog): EncryptedAccessLog =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedAccessLog.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): DecryptedAccessLog {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedAccessLog.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {

	override val encrypted: AccessLogFlavouredApi<EncryptedAccessLog> =
		object : AbstractAccessLogFlavouredApi<EncryptedAccessLog>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedAccessLog.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity

		}

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> =
		object : AbstractAccessLogFlavouredApi<AccessLog>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): AccessLog =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedAccessLog.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: AccessLog): EncryptedAccessLog = when (entity) {
				is EncryptedAccessLog -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedAccessLog.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedAccessLog -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedAccessLog.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }
			}
		}

	private val crypto get() = config.crypto

	override suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString> = crypto.entity.encryptionKeysOf(accessLog.withTypeInfo(), null)

	override suspend fun hasWriteAccess(accessLog: AccessLog): Boolean = crypto.entity.hasWriteAccess(accessLog.withTypeInfo())

	override suspend fun decryptPatientIdOf(accessLog: AccessLog): Set<String> = crypto.entity.owningEntityIdsOf(accessLog.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createAccessLog(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	): DecryptedAccessLog =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedAccessLog(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				date = base?.date ?: currentEpochInstant(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initializeEncryptionKey = true,
			initializeSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedAccessLog) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedAccessLog.serializer(),
		config.encryption.accessLog,
	) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	private suspend fun decryptOrNull(entity: EncryptedAccessLog): DecryptedAccessLog? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedAccessLog.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }

	override suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog =
		decryptOrNull(accessLog) ?: throw EntityEncryptionException("AccessLog cannot be decrypted")

	override suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog =
		decryptOrNull(accessLog) ?: accessLog
}

@InternalIcureApi
internal class AccessLogBasicApiImpl(
	rawApi: RawAccessLogApi,
	private val config: BasicApiConfiguration
) : AccessLogBasicApi, AccessLogBasicFlavouredApi<EncryptedAccessLog> by object :
	AbstractAccessLogBasicFlavouredApi<EncryptedAccessLog>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
		config.crypto.validationService.validateEncryptedEntity(
			entity.withTypeInfo(),
			EncryptedAccessLog.serializer(),
			config.encryption.accessLog
		)

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi)
