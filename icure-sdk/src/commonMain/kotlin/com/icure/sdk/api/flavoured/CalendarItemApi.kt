package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.api.raw.RawDataOwnerApi
import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.crypto.entities.DelegateShareOptions
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.crypto.entities.SecretIdOption
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
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface CalendarItemBasicFlavourlessApi {
	/**
	 * Deletes a calendar item. If you don't have write access to the calendar item the method will fail.
	 * @param entityId id of the calendar item.
	 * @return the id and revision of the deleted calendar item.
	 */
	suspend fun deleteCalendarItem(entityId: String): DocIdentifier

	/**
	 * Deletes many calendar items. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the calendar items.
	 * @return the id and revision of the deleted calendar items. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteCalendarItems(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface CalendarItemBasicFlavouredApi<E : CalendarItem> {
	/**
	 * Modifies a calendar item. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a calendar item with update content
	 * @return the calendar item updated with the provided content and a new revision.
	 */
	suspend fun modifyCalendarItem(entity: E): E

	/**
	 * Get a calendar item by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a calendar item, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a calendar item id.
	 * @return the calendar item with id [entityId].
	 */
	suspend fun getCalendarItem(entityId: String): E

	/**
	 * Get multiple calendar items by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a calendar item, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of calendar items ids
	 * @return all calendar items that you can access with one of the provided ids.
	 */
	suspend fun getCalendarItems(entityIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun getCalendarItemsByPeriodAndHcPartyId(startDate: Long, endDate: Long, hcPartyId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun getCalendarsByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int
	): PaginatedList<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface CalendarItemFlavouredApi<E : CalendarItem> : CalendarItemBasicFlavouredApi<E> {
	/**
	 * Share a calendar item with another data owner. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the calendar item
	 * @param calendarItem the calendar item to share with [delegateId]
	 * @param options specifies how the calendar item will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the calendar item. Refer
	 * to the documentation of [CalendarItemShareOptions] for more information.
	 * @return the updated calendar item if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		@DefaultValue("null")
		options: CalendarItemShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a calendar item with multiple data owners. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param calendarItem the calendar item to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated calendar item if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		calendarItem: E,
		delegates: Map<String, CalendarItemShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a calendar item with multiple data owners. The calendar item must already exist in the database for this method to
	 * succeed. If you want to share the calendar item before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param calendarItem the calendar item to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated calendar item.
	 */
	suspend fun shareWithMany(
		calendarItem: E,
		delegates: Map<String, CalendarItemShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
	suspend fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

	/**
	 * Links a calendar item with a patient. Note that this operation is not reversible: it is not possible to change the patient linked to a calendar
	 * item.
	 * @param calendarItem a calendar item.
	 * @param patient the patient which will be linked to the calendar item.
	 * @param shareLinkWithDelegates data owners other than the current data owner which will also be able to decrypt the id of the newly linked
	 * patient. If any of these data owners do not already have access to the calendar item, they will be granted read access (no write).
	 * @return the updated calendar item.
	 */
	suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface CalendarItemApi : CalendarItemBasicFlavourlessApi, CalendarItemFlavouredApi<DecryptedCalendarItem> {
	/**
	 * Create a new calendar item. The provided calendar item must have the encryption metadata initialized.
	 * @param entity a calendar item with initialized encryption metadata
	 * @return the created calendar item with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createCalendarItem(entity: DecryptedCalendarItem): DecryptedCalendarItem

	/**
	 * Creates a new calendar item with initialized encryption metadata
	 * @param base a calendar item with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the calendar item.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new calendar item
	 * @return a calendar item with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedCalendarItem

	/**
	 * Attempts to extract the encryption keys of a calendar item. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param calendarItem a calendar item
	 * @return the encryption keys extracted from the provided calendar item.
	 */
	suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString>

	/**
	 * Specifies if the current user has write access to a calendar item.
	 * @param calendarItem a calendar item
	 * @return if the current user has write access to the provided calendar item
	 */
	suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean

	/**
	 * Attempts to extract the patient id linked to a calendar item.
	 * Note: calendar items usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param calendarItem a calendar item
	 * @return the id of the patient linked to the calendar item, or empty if the current user can't access any patient id
	 * of the calendar item.
	 */
	suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a calendar item.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided calendar item. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the calendar item the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any CalendarItem,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a calendar item E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any calendar item that you have shared with P, H will be able to know that the calendar item was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a calendar item that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a calendar item
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>)

	/**
	 * Decrypts a calendar item, throwing an exception if it is not possible.
	 * @param calendarItem a calendar item
	 * @return the decrypted calendar item
	 * @throws EntityEncryptionException if the calendar item could not be decrypted
	 */
	suspend fun decrypt(calendarItem: EncryptedCalendarItem): DecryptedCalendarItem

	/**
	 * Tries to decrypt a calendar item, returns the input if it is not possible.
	 * @param calendarItem an encrypted calendar item
	 * @return the decrypted calendar item if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(calendarItem: EncryptedCalendarItem): CalendarItem

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
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

	@Deprecated("Will be replaced by filter")
	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): List<E> = rawApi.getCalendarItemsByPeriodAndHcPartyId(startDate, endDate, hcPartyId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): List<E> = rawApi.getCalendarsByPeriodAndAgendaId(startDate, endDate, agendaId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
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
	private val dataOwnerApi: RawDataOwnerApi,
	private val config: ApiConfiguration
) : AbstractCalendarItemBasicFlavouredApi<E>(rawApi), CalendarItemFlavouredApi<E> {
	protected val crypto get() = config.crypto


	override suspend fun getSecureDelegationKeys(): List<String> =
		crypto.exchangeDataManager
			.getAccessControlKeysValue(EntityWithEncryptionMetadataTypeName.CalendarItem)?.map { it.s } ?: emptyList()

	override suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		options: CalendarItemShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			calendarItem.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: CalendarItemShareOptions()),
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

	@Deprecated("Will be replaced by filter")
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

	override suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E {
		require(calendarItem.secretForeignKeys.isNotEmpty()) { "Calendar item ${calendarItem.id} is already linked to a patient" }
		val currentDataOwnerId = dataOwnerApi.getCurrentDataOwner().successBody().dataOwner.id
		val delegates = shareLinkWithDelegates + currentDataOwnerId
		val secretForeignKeys = crypto.entity.getConfidentialSecretIdsOf(patient.withTypeInfo(), currentDataOwnerId)
		require(secretForeignKeys.isNotEmpty()) { "Could not find any secret id for patient ${patient.id} which is shared with the topmost ancestor of the current data owner" }
		val shareResult = crypto.entity.bulkShareOrUpdateEncryptedEntityMetadata(
			listOf(Pair(
				calendarItem.withTypeInfo(),
				delegates.associateWith { DelegateShareOptions(
					shareSecretIds = emptySet(),
					shareEncryptionKeys = emptySet(),
					shareOwningEntityIds = setOf(patient.id),
					requestedPermissions = RequestedPermission.FullRead
				) }
			))
		) { rawApi.bulkShare(it).successBody() }
		if(shareResult.updatedEntities.isEmpty() || shareResult.updatedEntities.first().id != calendarItem.id) {
			val errorsForEntity = shareResult.updateErrors.filter { it.entityId == calendarItem.id }
			if (errorsForEntity.isEmpty() || errorsForEntity.none { it.code == 409 }) {
				throw IllegalStateException("Unexpected error while linking calendar item ${calendarItem.id}")
			} else {
				throw IllegalStateException("Outdated calendar item revision ${calendarItem.id}-${calendarItem.rev}")
			}
		}
		return maybeDecrypt((shareResult.updatedEntities.first() as EncryptedCalendarItem).copy(secretForeignKeys = secretForeignKeys))
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
	private val rawDataOwnerApi: RawDataOwnerApi,
	private val config: ApiConfiguration
) : CalendarItemApi, CalendarItemFlavouredApi<DecryptedCalendarItem> by object :
	AbstractCalendarItemFlavouredApi<DecryptedCalendarItem>(rawApi, rawDataOwnerApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedCalendarItem): EncryptedCalendarItem =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedCalendarItem.serializer(),
			config.encryption.calendarItem,
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
		object : AbstractCalendarItemFlavouredApi<EncryptedCalendarItem>(rawApi, rawDataOwnerApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), config.encryption.calendarItem)

			override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
		}

	override val tryAndRecover: CalendarItemFlavouredApi<CalendarItem> =
		object : AbstractCalendarItemFlavouredApi<CalendarItem>(rawApi, rawDataOwnerApi, config) {
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
					config.encryption.calendarItem,
				)

				is DecryptedCalendarItem -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedCalendarItem.serializer(),
					config.encryption.calendarItem,
				) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }
			}
		}

	override suspend fun createCalendarItem(entity: DecryptedCalendarItem): DecryptedCalendarItem {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createCalendarItem(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	private val crypto get() = config.crypto

	override suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
	) =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedCalendarItem(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initializeEncryptionKey = true,
			initializeSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString> = crypto.entity.encryptionKeysOf(calendarItem.withTypeInfo(), null)

	override suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean = crypto.entity.hasWriteAccess(calendarItem.withTypeInfo())

	override suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<String> = crypto.entity.owningEntityIdsOf(calendarItem.withTypeInfo(), null)

	private suspend fun encrypt(entity: DecryptedCalendarItem) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedCalendarItem.serializer(),
		config.encryption.calendarItem,
	) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }

	private suspend fun decryptOrNull(entity: EncryptedCalendarItem): DecryptedCalendarItem? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedCalendarItem.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(it) }


	override suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun decrypt(calendarItem: EncryptedCalendarItem): DecryptedCalendarItem =
		decryptOrNull(calendarItem) ?: throw EntityEncryptionException("CalendarItem cannot be decrypted")

	override suspend fun tryDecrypt(calendarItem: EncryptedCalendarItem): CalendarItem =
		decryptOrNull(calendarItem) ?: calendarItem

}

@InternalIcureApi
internal class CalendarItemBasicApiImpl(
	rawApi: RawCalendarItemApi,
	private val config: BasicApiConfiguration
) : CalendarItemBasicApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem> by object :
	AbstractCalendarItemBasicFlavouredApi<EncryptedCalendarItem>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), config.encryption.calendarItem)

	override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi)
