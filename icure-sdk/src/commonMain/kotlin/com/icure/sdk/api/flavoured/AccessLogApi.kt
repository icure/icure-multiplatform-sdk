package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawAccessLogApi
import com.icure.sdk.crypto.BasicInternalCryptoApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
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
import com.icure.sdk.model.requests.RequestedPermission
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
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		descending: Boolean? = null,
    ): PaginatedList<E>

	suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long? = null,
		toEpoch: Long? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
    ): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface AccessLogFlavouredApi<E : AccessLog> : AccessLogBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
	): PaginatedListIterator<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface AccessLogApi : AccessLogBasicFlavourlessApi, AccessLogFlavouredApi<DecryptedAccessLog> {
	suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog
	suspend fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedAccessLog

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
	private val crypto: InternalCryptoServices
) : AbstractAccessLogBasicFlavouredApi<E>(rawApi), AccessLogFlavouredApi<E> {
	override suspend fun getSecureDelegationKeys(): List<String> =
		crypto.exchangeDataManager.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.AccessLog)?.map { it.s } ?: emptyList()

	override suspend fun shareWith(
		delegateId: String,
		accessLog: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			accessLog.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = null,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

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
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest,
	private val autofillAuthor: Boolean,
) : AccessLogApi, AccessLogFlavouredApi<DecryptedAccessLog> by object :
	AbstractAccessLogFlavouredApi<DecryptedAccessLog>(rawApi, crypto) {
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
		object : AbstractAccessLogFlavouredApi<EncryptedAccessLog>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedAccessLog.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity

		}

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> =
		object : AbstractAccessLogFlavouredApi<AccessLog>(rawApi, crypto) {
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

	override suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createAccessLog(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
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
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
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
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	suspend fun decrypt(entity: EncryptedAccessLog, errorMessage: () -> String): DecryptedAccessLog = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedAccessLog.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class AccessLogBasicApiImpl(
	rawApi: RawAccessLogApi,
	private val crypto: BasicInternalCryptoApi,
	private val fieldsToEncrypt: EncryptedFieldsManifest,
) : AccessLogBasicApi, AccessLogBasicFlavouredApi<EncryptedAccessLog> by object :
	AbstractAccessLogBasicFlavouredApi<EncryptedAccessLog>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
		crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedAccessLog.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi)
