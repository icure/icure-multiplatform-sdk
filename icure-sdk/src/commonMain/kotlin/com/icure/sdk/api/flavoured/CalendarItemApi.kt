package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawCalendarItemApi
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
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.EncryptedCalendarItem
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
	EncryptedFieldsManifest("CalendarItem.", setOf("details", "title", "patientId"), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface CalendarItemBasicFlavourlessApi {
	suspend fun deleteCalendarItem(entityId: String): DocIdentifier
	suspend fun deleteCalendarItems(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface CalendarItemBasicFlavouredApi<E : CalendarItem> {
	suspend fun modifyCalendarItem(entity: E): E
	suspend fun getCalendarItem(entityId: String): E
	suspend fun deleteCalendarItems(entityIds: String): List<DocIdentifier>
	suspend fun getCalendarItemsByPeriodAndHcPartyId(startDate: Long, endDate: Long, hcPartyId: String): List<E>
	suspend fun getCalendarsByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>
	suspend fun getCalendarItemsWithIds(entityIds: List<String>): List<E>
	suspend fun listCalendarItemsByHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): PaginatedListIterator<E>
	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int
	): PaginatedList<E, *>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface CalendarItemFlavouredApi<E : CalendarItem> : CalendarItemBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
	suspend fun listCalendarItemsByHcPartyPatient(hcPartyId: String, patient: Patient): List<E>
	suspend fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String?,
		startDocumentId: String?,
		limit: Int
	): PaginatedList<E, *>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface CalendarItemApi : CalendarItemBasicFlavourlessApi, CalendarItemFlavouredApi<DecryptedCalendarItem> {
	suspend fun createCalendarItem(entity: DecryptedCalendarItem): DecryptedCalendarItem
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedCalendarItem,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedCalendarItem

	val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>
	val tryAndRecover: CalendarItemFlavouredApi<CalendarItem>
}

interface CalendarItemBasicApi : CalendarItemBasicFlavourlessApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem>

@InternalIcureApi
private abstract class AbstractCalendarItemBasicFlavouredApi<E : CalendarItem>(
	protected val rawApi: RawCalendarItemApi,
	protected val exchangeDataManager: ExchangeDataManager
) : CalendarItemBasicFlavouredApi<E> {

	private suspend fun getSecureDelegationKeys() = exchangeDataManager
		.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.CalendarItem)?.map { it.s } ?: emptyList()

	override suspend fun modifyCalendarItem(entity: E): E =
		rawApi.modifyCalendarItem(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getCalendarItem(entityId: String): E = rawApi.getCalendarItem(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun deleteCalendarItems(entityIds: String): List<DocIdentifier> =
		rawApi.deleteCalendarItemsWithPost(entityIds).successBody()

	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): List<E> = rawApi.getCalendarItemsByPeriodAndHcPartyId(startDate, endDate, hcPartyId).successBody().map { maybeDecrypt(it) }

	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): List<E> = rawApi.getCalendarsByPeriodAndAgendaId(startDate, endDate, agendaId).successBody().map { maybeDecrypt(it) }

	override suspend fun getCalendarItemsWithIds(entityIds: List<String>): List<E> =
		rawApi.getCalendarItemsWithIds(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): PaginatedListIterator<E> {
		val accessKeys = getSecureDelegationKeys() + hcPartyId
		return MultipleSourcePageIterator(
			requestParameters = accessKeys vectorProduct secretPatientKeys
		) { params, nextKey ->
			rawApi.findCalendarItemsByHCPartyPatientForeignKeys(
				hcPartyId = params.first,
				secretFKeys = params.second,
				startKey = nextKey?.startKey,
				startDocumentId = nextKey?.startKeyDocId,
				limit = 1000
			).successBody().map { maybeDecrypt(it) }
		}
	}

	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): PaginatedList<E, *> =
		rawApi.findCalendarItemsByRecurrenceId(recurrenceId, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedCalendarItem
	abstract suspend fun maybeDecrypt(entity: EncryptedCalendarItem): E
}

@InternalIcureApi
private abstract class AbstractCalendarItemFlavouredApi<E : CalendarItem>(
	rawApi: RawCalendarItemApi,
	private val encryptionService: EntityEncryptionService,
	exchangeDataManager: ExchangeDataManager
) : AbstractCalendarItemBasicFlavouredApi<E>(rawApi, exchangeDataManager), CalendarItemFlavouredApi<E> {
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

	override suspend fun listCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
	): List<E> =
		rawApi.listCalendarItemsByHCPartyPatientForeignKeys(
			hcPartyId,
			encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList(),
		).successBody().map { maybeDecrypt(it) }

	override suspend fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): PaginatedList<E, *> = rawApi.findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId,
		encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList(),
		startKey, startDocumentId, limit
	).successBody().map { maybeDecrypt(it) }


}

@InternalIcureApi
private class AbstractCalendarItemBasicFlavourlessApi(val rawApi: RawCalendarItemApi) : CalendarItemBasicFlavourlessApi {
	override suspend fun deleteCalendarItem(entityId: String) = rawApi.deleteCalendarItem(entityId).successBody()
	override suspend fun deleteCalendarItems(entityIds: List<String>) = rawApi.deleteCalendarItems(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class CalendarItemApiImpl(
	private val rawApi: RawCalendarItemApi,
	private val encryptionService: EntityEncryptionService,
	private val exchangeDataManager: ExchangeDataManager,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST
) : CalendarItemApi, CalendarItemFlavouredApi<DecryptedCalendarItem> by object :
	AbstractCalendarItemFlavouredApi<DecryptedCalendarItem>(rawApi, encryptionService, exchangeDataManager) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedCalendarItem): EncryptedCalendarItem =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedCalendarItem.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): DecryptedCalendarItem {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedCalendarItem.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }
			?: throw EntityDecryptionException("Entity ${entity.id} cannot be created")
	}
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi) {
	override val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem> =
		object : AbstractCalendarItemFlavouredApi<EncryptedCalendarItem>(rawApi, encryptionService, exchangeDataManager) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
		}

	override val tryAndRecover: CalendarItemFlavouredApi<CalendarItem> =
		object : AbstractCalendarItemFlavouredApi<CalendarItem>(rawApi, encryptionService, exchangeDataManager) {
			override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): CalendarItem =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedCalendarItem.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: CalendarItem): EncryptedCalendarItem = when (entity) {
				is EncryptedCalendarItem -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedCalendarItem.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedCalendarItem -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedCalendarItem.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }
			}
		}

	override suspend fun createCalendarItem(entity: DecryptedCalendarItem): DecryptedCalendarItem {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createCalendarItem(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedCalendarItem,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedCalendarItem =
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

	private suspend fun encrypt(entity: DecryptedCalendarItem) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedCalendarItem.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }

	suspend fun decrypt(entity: EncryptedCalendarItem, errorMessage: () -> String): DecryptedCalendarItem = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedCalendarItem.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }
		?: throw EntityDecryptionException(errorMessage())

}

@InternalIcureApi
internal class CalendarItemBasicApiImpl(
	rawApi: RawCalendarItemApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	exchangeDataManager: ExchangeDataManager
) : CalendarItemBasicApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem> by object :
	AbstractCalendarItemBasicFlavouredApi<EncryptedCalendarItem>(rawApi, exchangeDataManager) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi)
