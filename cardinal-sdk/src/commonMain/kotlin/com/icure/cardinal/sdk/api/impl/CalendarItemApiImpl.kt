package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CalendarItemApi
import com.icure.cardinal.sdk.api.CalendarItemBasicApi
import com.icure.cardinal.sdk.api.CalendarItemBasicFlavouredApi
import com.icure.cardinal.sdk.api.CalendarItemBasicFlavourlessApi
import com.icure.cardinal.sdk.api.CalendarItemFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapCalendarItemFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractCalendarItemBasicFlavouredApi<E : CalendarItem>(
	protected val rawApi: RawCalendarItemApi
) : CalendarItemBasicFlavouredApi<E> {
	override suspend fun undeleteCalendarItemById(id: String, rev: String): E =
		rawApi.undeleteCalendarItem(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }

	protected open suspend fun getSecureDelegationKeys(): List<String> =
		emptyList()

	override suspend fun modifyCalendarItem(entity: E): E =
		rawApi.modifyCalendarItem(validateAndMaybeEncrypt(entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }

	override suspend fun getCalendarItem(entityId: String): E = rawApi.getCalendarItem(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getCalendarItems(entityIds: List<String>): List<E> =
		rawApi.getCalendarItemsWithIds(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): List<E> = rawApi.getCalendarItemsByPeriodAndHcPartyId(startDate, endDate, hcPartyId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): List<E> = rawApi.getCalendarsByPeriodAndAgendaId(startDate, endDate, agendaId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
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
	): E =
		shareWithMany(calendarItem, mapOf(delegateId to (options ?: CalendarItemShareOptions())))

	override suspend fun shareWithMany(calendarItem: E, delegates: Map<String, CalendarItemShareOptions>): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			calendarItem.withTypeInfo(),
			delegates,
			true,
			{ getCalendarItem(it).withTypeInfo() },
			{ rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } } }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
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
				delegates.associateWith {
					DelegateShareOptions(
						shareSecretIds = emptySet(),
						shareEncryptionKeys = emptySet(),
						shareOwningEntityIds = setOf(patient.id),
						requestedPermissions = RequestedPermission.FullRead
					)
				}
			)),
			true,
			{ getCalendarItem(it).withTypeInfo() },
			{ rawApi.bulkShare(it).successBody() }
		)
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

	override suspend fun filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): PaginatedListIterator<E> =
		filterCalendarItemsBy(filter)

	override suspend fun filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchCalendarItemsBy(
				mapCalendarItemFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					config.crypto.entity
				)
			).successBody(),
			::getCalendarItems
		)
}

@InternalIcureApi
private class AbstractCalendarItemBasicFlavourlessApi(val rawApi: RawCalendarItemApi) :
	CalendarItemBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteCalendarItemUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteCalendarItem(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteCalendarItemsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteCalendarItems(ListOfIds(entityIds)).successBody()
		
	override suspend fun deleteCalendarItemById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteCalendarItem(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteCalendarItemsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteCalendarItemsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeCalendarItemById(id: String, rev: String) {
		rawApi.purgeCalendarItem(id, rev).successBodyOrThrowRevisionConflict()
	}
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
		) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }
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
				) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }
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
		secretId: SecretIdUseOption,
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
	) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }


	override suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun decrypt(calendarItem: EncryptedCalendarItem): DecryptedCalendarItem =
		decryptOrNull(calendarItem) ?: throw EntityEncryptionException("CalendarItem cannot be decrypted")

	override suspend fun tryDecrypt(calendarItem: EncryptedCalendarItem): CalendarItem =
		decryptOrNull(calendarItem) ?: calendarItem

	override suspend fun matchCalendarItemsBy(filter: FilterOptions<CalendarItem>): List<String> =
		rawApi.matchCalendarItemsBy(
			mapCalendarItemFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)
		).successBody()

	override suspend fun matchCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): List<String> =
		matchCalendarItemsBy(filter)
}

@InternalIcureApi
internal class CalendarItemBasicApiImpl(
	private val rawApi: RawCalendarItemApi,
	private val config: BasicApiConfiguration
) : CalendarItemBasicApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem> by object :
	AbstractCalendarItemBasicFlavouredApi<EncryptedCalendarItem>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedCalendarItem.serializer(), config.encryption.calendarItem)

	override suspend fun maybeDecrypt(entity: EncryptedCalendarItem): EncryptedCalendarItem = entity
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi) {
	override suspend fun matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): List<String> =
		rawApi.matchCalendarItemsBy(mapCalendarItemFilterOptions(filter, null, null)).successBody()

	override suspend fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): List<String> =
		matchCalendarItemsBy(filter)

	override suspend fun filterCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): PaginatedListIterator<EncryptedCalendarItem> =
		IdsPageIterator(matchCalendarItemsBy(filter), ::getCalendarItems)

	override suspend fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): PaginatedListIterator<EncryptedCalendarItem> =
		filterCalendarItemsBy(filter)
}