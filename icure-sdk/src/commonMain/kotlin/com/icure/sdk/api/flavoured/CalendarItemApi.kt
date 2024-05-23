package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.crypto.BasicInternalCryptoApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
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
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface CalendarItemBasicFlavourlessApi {
	suspend fun deleteCalendarItem(entityId: String): DocIdentifier
	suspend fun deleteCalendarItems(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface CalendarItemBasicFlavouredApi<E : CalendarItem> {
	suspend fun modifyCalendarItem(entity: E): E
	suspend fun getCalendarItem(entityId: String): E
	suspend fun getCalendarItems(entityIds: List<String>): List<E>
	suspend fun deleteCalendarItems(entityIds: String): List<DocIdentifier>
	suspend fun getCalendarItemsByPeriodAndHcPartyId(startDate: Long, endDate: Long, hcPartyId: String): List<E>
	suspend fun getCalendarsByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>
	suspend fun getCalendarItemsWithIds(entityIds: List<String>): List<E>
	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int
	): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface CalendarItemFlavouredApi<E : CalendarItem> : CalendarItemBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param calendarItem the [CalendarItem] to share.
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
		calendarItem: E,
		delegates: Map<String, CalendarItemShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param calendarItem the [CalendarItem] to share.
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
		calendarItem: E,
		delegates: Map<String, CalendarItemShareOptions>
	): E

	suspend fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
	): PaginatedListIterator<E>

}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface CalendarItemApi : CalendarItemBasicFlavourlessApi, CalendarItemFlavouredApi<DecryptedCalendarItem> {
	suspend fun createCalendarItem(entity: DecryptedCalendarItem): DecryptedCalendarItem
	suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
		): DecryptedCalendarItem
	suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString>
	suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean
	suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<String>

	val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>
	val tryAndRecover: CalendarItemFlavouredApi<CalendarItem>
}

interface CalendarItemBasicApi : CalendarItemBasicFlavourlessApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem>

@InternalIcureApi
private abstract class AbstractCalendarItemBasicFlavouredApi<E : CalendarItem>(
	protected val rawApi: RawCalendarItemApi
) : CalendarItemBasicFlavouredApi<E> {

	protected open suspend fun getSecureDelegationKeys(): List<String> =
		emptyList()

	override suspend fun modifyCalendarItem(entity: E): E =
		rawApi.modifyCalendarItem(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getCalendarItem(entityId: String): E = rawApi.getCalendarItem(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getCalendarItems(entityIds: List<String>): List<E> =
		rawApi.getCalendarItemsWithIds(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

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

	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): PaginatedList<E> =
		rawApi.findCalendarItemsByRecurrenceId(recurrenceId, startKey, startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedCalendarItem
	abstract suspend fun maybeDecrypt(entity: EncryptedCalendarItem): E
}

@InternalIcureApi
private abstract class AbstractCalendarItemFlavouredApi<E : CalendarItem>(
	rawApi: RawCalendarItemApi,
	private val crypto: InternalCryptoServices
) : AbstractCalendarItemBasicFlavouredApi<E>(rawApi), CalendarItemFlavouredApi<E> {
	override suspend fun getSecureDelegationKeys(): List<String> =
		crypto.exchangeDataManager
			.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.CalendarItem)?.map { it.s } ?: emptyList()

	override suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			calendarItem.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptionsImpl(
					shareSecretIds = null,
					shareEncryptionKey = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(calendarItem: E, delegates: Map<String, CalendarItemShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			calendarItem.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(calendarItem: E, delegates: Map<String, CalendarItemShareOptions>): E = tryShareWithMany(calendarItem, delegates).updatedEntityOrThrow()

	override suspend fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.findCalendarItemIdsByDataOwnerPatientStartTime(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getCalendarItemsWithIds(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractCalendarItemBasicFlavourlessApi(val rawApi: RawCalendarItemApi) : CalendarItemBasicFlavourlessApi {
	override suspend fun deleteCalendarItem(entityId: String) = rawApi.deleteCalendarItem(entityId).successBody()
	override suspend fun deleteCalendarItems(entityIds: List<String>) = rawApi.deleteCalendarItems(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class CalendarItemApiImpl(
	private val rawApi: RawCalendarItemApi,
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest,
	private val autofillAuthor: Boolean,
) : CalendarItemApi, CalendarItemFlavouredApi<DecryptedCalendarItem> by object :
	AbstractCalendarItemFlavouredApi<DecryptedCalendarItem>(rawApi, crypto) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedCalendarItem): EncryptedCalendarItem =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedCalendarItem.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): DecryptedCalendarItem {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedCalendarItem.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi) {
	override val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem> =
		object : AbstractCalendarItemFlavouredApi<EncryptedCalendarItem>(rawApi, crypto) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
		}

	override val tryAndRecover: CalendarItemFlavouredApi<CalendarItem> =
		object : AbstractCalendarItemFlavouredApi<CalendarItem>(rawApi, crypto) {
			override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): CalendarItem =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedCalendarItem.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: CalendarItem): EncryptedCalendarItem = when (entity) {
				is EncryptedCalendarItem -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedCalendarItem.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedCalendarItem -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedCalendarItem.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }
			}
		}

	override suspend fun createCalendarItem(entity: DecryptedCalendarItem): DecryptedCalendarItem {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createCalendarItem(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	) =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedCalendarItem(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString> = crypto.entity.encryptionKeysOf(calendarItem.withTypeInfo(), null)

	override suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean = crypto.entity.hasWriteAccess(calendarItem.withTypeInfo())

	override suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<String> = crypto.entity.owningEntityIdsOf(calendarItem.withTypeInfo(), null)

	private suspend fun encrypt(entity: DecryptedCalendarItem) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedCalendarItem.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }

	suspend fun decrypt(entity: EncryptedCalendarItem, errorMessage: () -> String): DecryptedCalendarItem = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedCalendarItem.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class CalendarItemBasicApiImpl(
	rawApi: RawCalendarItemApi,
	private val crypto: BasicInternalCryptoApi,
	private val fieldsToEncrypt: EncryptedFieldsManifest
) : CalendarItemBasicApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem> by object :
	AbstractCalendarItemBasicFlavouredApi<EncryptedCalendarItem>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
		crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi)
