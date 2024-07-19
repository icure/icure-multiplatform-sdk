package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawAccessLogApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.AccessLogShareOptions
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
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
	suspend fun deleteAccessLog(entityId: String): DocIdentifier
	suspend fun deleteAccessLogs(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface AccessLogBasicFlavouredApi<E : AccessLog> {
	suspend fun modifyAccessLog(entity: E): E
	suspend fun getAccessLog(entityId: String): E
	suspend fun getAccessLogs(entityIds: List<String>): List<E>

	suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E>

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
	suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		@DefaultValue("null")
		options: AccessLogShareOptions? = null,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param accessLog the [AccessLog] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the [SimpleShareResult] of the operation: the updated entity if the operation was successful or details of the error if
	 * the operation failed.
	 */
	suspend fun tryShareWithMany(
		accessLog: E,
		delegates: Map<String, AccessLogShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param accessLog the [AccessLog] to share.
	 * @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 * - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 * content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 * be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 * encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 * - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 * @return the updated entity.
	 * @throws IllegalStateException if the operation was not successful.
	 */
	suspend fun shareWithMany(
		accessLog: E,
		delegates: Map<String, AccessLogShareOptions>
	): E

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
	suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog
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
	suspend fun getEncryptionKeysOf(accessLog: AccessLog): Set<HexString>
	suspend fun hasWriteAccess(accessLog: AccessLog): Boolean
	suspend fun decryptPatientIdOf(accessLog: AccessLog): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: AccessLog, delegates: Set<String>)
	suspend fun decrypt(accessLog: EncryptedAccessLog): DecryptedAccessLog
	suspend fun tryDecrypt(accessLog: EncryptedAccessLog): AccessLog


	val encrypted: AccessLogFlavouredApi<EncryptedAccessLog>
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

	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
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
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedAccessLog(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				date = base?.date ?: currentEpochInstant(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
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
