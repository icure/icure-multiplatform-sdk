package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawAccessLogApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.ExchangeDataManager
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
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityDecryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.pagination.MultipleSourcePageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import com.icure.sdk.utils.vectorProduct
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("AccessLog.", setOf("detail", "objectId"), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface AccessLogBasicFlavourlessApi {
	suspend fun deleteAccessLog(entityId: String): DocIdentifier
	suspend fun deleteAccessLogs(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface AccessLogBasicFlavouredApi<E : AccessLog> {
	suspend fun modifyAccessLog(entity: E): E
	suspend fun getAccessLog(entityId: String): E
	suspend fun findAccessLogsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<E, *>

	suspend fun findAccessLogsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): PaginatedListIterator<E>
	suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<E, *>

	suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		descending: Boolean? = null,
    ): PaginatedList<E, *>

	suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long? = null,
		toEpoch: Long? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
    ): PaginatedList<E, *>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface AccessLogFlavouredApi<E : AccessLog> : AccessLogBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): List<E>


}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface AccessLogApi : AccessLogBasicFlavourlessApi, AccessLogFlavouredApi<DecryptedAccessLog> {
	suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedAccessLog,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedAccessLog

	suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
	): PaginatedListIterator<DecryptedAccessLog>

	val encrypted: AccessLogFlavouredApi<EncryptedAccessLog>
	val tryAndRecover: AccessLogFlavouredApi<AccessLog>
}

interface AccessLogBasicApi : AccessLogBasicFlavourlessApi, AccessLogBasicFlavouredApi<EncryptedAccessLog>

@InternalIcureApi
private abstract class AbstractAccessLogBasicFlavouredApi<E : AccessLog>(
	protected val rawApi: RawAccessLogApi,
	protected val exchangeDataManager: ExchangeDataManager
) : AccessLogBasicFlavouredApi<E> {

	private suspend fun getSecureDelegationKeys() = exchangeDataManager
		.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.AccessLog)?.map { it.s } ?: emptyList()

	override suspend fun modifyAccessLog(entity: E): E =
		rawApi.modifyAccessLog(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getAccessLog(entityId: String): E = rawApi.getAccessLog(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun findAccessLogsByHcPartyPatientForeignKey(
		hcPartyId: String,
		secretPatientKey: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E, *> =
		rawApi.findAccessLogsByHCPartyPatientForeignKey(hcPartyId, secretPatientKey, startKey, startDocumentId, limit).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun findAccessLogsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>
	): PaginatedListIterator<E> {
		val accessKeys = getSecureDelegationKeys() + hcPartyId
		return MultipleSourcePageIterator(
			requestParameters = accessKeys vectorProduct secretPatientKeys
		) { params, nextKey ->
			rawApi.findAccessLogsByHCPartyPatientForeignKey(
				hcPartyId = params.first,
				secretFKey = params.second,
				startKey = nextKey?.startKey,
				startDocumentId = nextKey?.startKeyDocId,
				limit = 1000
			).successBody().map { maybeDecrypt(it) }
		}
	}

	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E, *> =
		rawApi.findAccessLogsBy(fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	override suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): PaginatedList<E, *> =
		rawApi.findAccessLogsByUserAfterDate(userId, accessType, startDate, startKey, startDocumentId, limit, descending).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E, *> =
		rawApi.findAccessLogsInGroup(groupId, fromEpoch, toEpoch, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedAccessLog
	abstract suspend fun maybeDecrypt(entity: EncryptedAccessLog): E
}

@InternalIcureApi
private abstract class AbstractAccessLogFlavouredApi<E : AccessLog>(
	rawApi: RawAccessLogApi,
	private val encryptionService: EntityEncryptionService,
	exchangeDataManager: ExchangeDataManager
) : AbstractAccessLogBasicFlavouredApi<E>(rawApi, exchangeDataManager), AccessLogFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			healthcareElement.withTypeInfo(),
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
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): List<E> = rawApi.findAccessLogsByHCPartyPatientForeignKeys(
		hcPartyId,
		encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList(),
	).successBody().map { maybeDecrypt(it) }

}

@InternalIcureApi
private class AbstractAccessLogBasicFlavourlessApi(val rawApi: RawAccessLogApi) : AccessLogBasicFlavourlessApi {
	override suspend fun deleteAccessLog(entityId: String) = rawApi.deleteAccessLog(entityId).successBody()
	override suspend fun deleteAccessLogs(entityIds: List<String>) = rawApi.deleteAccessLogs(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class AccessLogApiImpl(
	private val rawApi: RawAccessLogApi,
	private val encryptionService: EntityEncryptionService,
	private val exchangeDataManager: ExchangeDataManager,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : AccessLogApi, AccessLogFlavouredApi<DecryptedAccessLog> by object :
	AbstractAccessLogFlavouredApi<DecryptedAccessLog>(rawApi, encryptionService, exchangeDataManager) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedAccessLog): EncryptedAccessLog =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedAccessLog.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): DecryptedAccessLog {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedAccessLog.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }
			?: throw EntityDecryptionException("Entity ${entity.id} cannot be created")
	}
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi) {

	private suspend fun getSecureDelegationKeys() = exchangeDataManager
		.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.AccessLog)?.map { it.s } ?: emptyList()

	override val encrypted: AccessLogFlavouredApi<EncryptedAccessLog> =
		object : AbstractAccessLogFlavouredApi<EncryptedAccessLog>(rawApi, encryptionService, exchangeDataManager) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedAccessLog.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity
		}

	override val tryAndRecover: AccessLogFlavouredApi<AccessLog> =
		object : AbstractAccessLogFlavouredApi<AccessLog>(rawApi, encryptionService, exchangeDataManager) {
			override suspend fun maybeDecrypt(entity: EncryptedAccessLog): AccessLog =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedAccessLog.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: AccessLog): EncryptedAccessLog = when (entity) {
				is EncryptedAccessLog -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedAccessLog.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedAccessLog -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedAccessLog.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }
			}
		}

	override suspend fun createAccessLog(entity: DecryptedAccessLog): DecryptedAccessLog {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createAccessLog(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedAccessLog,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedAccessLog =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			healthcareElement.withTypeInfo(),
			patient.id,
			encryptionService.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + (
				(user.autoDelegations[DelegationTag.MedicalInformation] ?: emptySet()) +
					(user.autoDelegations[DelegationTag.All] ?: emptySet())
				).associateWith { AccessLevel.Write },
		).updatedEntity

	override suspend fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient
	): PaginatedListIterator<DecryptedAccessLog> {
		val accessKeys = getSecureDelegationKeys() + hcPartyId
		return MultipleSourcePageIterator(
			requestParameters = accessKeys vectorProduct encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList()
		) { params, nextKey ->
			rawApi.findAccessLogsByHCPartyPatientForeignKey(
				hcPartyId = params.first,
				secretFKey = params.second,
				startKey = nextKey?.startKey,
				startDocumentId = nextKey?.startKeyDocId,
				limit = 1000
			).successBody().map { decrypt(it) { "Found healthcare element cannot be decrypted" } }
		}
	}
	private suspend fun encrypt(entity: DecryptedAccessLog) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedAccessLog.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedAccessLog>(it) }

	suspend fun decrypt(entity: EncryptedAccessLog, errorMessage: () -> String): DecryptedAccessLog = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedAccessLog.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedAccessLog>(it) }
		?: throw EntityDecryptionException(errorMessage())

}

@InternalIcureApi
internal class AccessLogBasicApiImpl(
	rawApi: RawAccessLogApi,
	private val validationService: EntityValidationService,
	exchangeDataManager: ExchangeDataManager,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : AccessLogBasicApi, AccessLogBasicFlavouredApi<EncryptedAccessLog> by object :
	AbstractAccessLogBasicFlavouredApi<EncryptedAccessLog>(rawApi, exchangeDataManager) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedAccessLog): EncryptedAccessLog =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedAccessLog.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedAccessLog): EncryptedAccessLog = entity
}, AccessLogBasicFlavourlessApi by AbstractAccessLogBasicFlavourlessApi(rawApi)
