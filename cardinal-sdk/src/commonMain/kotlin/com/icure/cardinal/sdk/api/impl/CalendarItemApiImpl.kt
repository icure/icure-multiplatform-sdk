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
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
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
import com.icure.cardinal.sdk.serialization.CalendarItemAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractCalendarItemBasicFlavouredApi<E : CalendarItem>(
	protected val rawApi: RawCalendarItemApi
) : CalendarItemBasicFlavouredApi<E>, FlavouredApi<EncryptedCalendarItem, E> {
	override suspend fun undeleteCalendarItemById(id: String, rev: String): E =
		rawApi.undeleteCalendarItem(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyCalendarItem(entity: E): E =
		rawApi.modifyCalendarItem(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun getCalendarItem(entityId: String, groupId: String?): E =
		(
			if (groupId == null)
				rawApi.getCalendarItem(entityId)
			else
				rawApi.getCalendarItemInGroup(groupId = groupId, calendarItemId = entityId)
		).successBody().let {
			maybeDecrypt(groupId, it)
		}

	override suspend fun getCalendarItems(entityIds: List<String>): List<E> =
		maybeDecrypt(rawApi.getCalendarItemsWithIds(ListOfIds(entityIds)).successBody())

	@Deprecated("Use filter instead")
	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): List<E> = maybeDecrypt(rawApi.getCalendarItemsByPeriodAndHcPartyId(startDate, endDate, hcPartyId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): List<E> = maybeDecrypt(rawApi.getCalendarsByPeriodAndAgendaId(startDate, endDate, agendaId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findCalendarItemsByRecurrenceId(recurrenceId, startKey, startDocumentId, limit).successBody())
}

@InternalIcureApi
private abstract class AbstractCalendarItemFlavouredApi<E : CalendarItem>(
	rawApi: RawCalendarItemApi,
	private val dataOwnerApi: RawDataOwnerApi,
	private val config: ApiConfiguration
) : AbstractCalendarItemBasicFlavouredApi<E>(rawApi), CalendarItemFlavouredApi<E> {
	protected val crypto get() = config.crypto

	override suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		options: CalendarItemShareOptions?,
	): E =
		shareWithMany(calendarItem, mapOf(delegateId to (options ?: CalendarItemShareOptions())))

	override suspend fun shareWithMany(calendarItem: E, delegates: Map<String, CalendarItemShareOptions>): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			calendarItem,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getCalendarItem(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	override suspend fun shareInGroup(
		calendarItem: E,
		entityGroupId: String?,
		delegates: Map<DataOwnerReferenceInGroup, CalendarItemShareOptions>
	): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			calendarItem,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			delegates,
			true,
			{ getCalendarItem(it) },
			{ maybeDecrypt(entityGroupId, rawApi.bulkShare(it).successBody()) }
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
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(null, patient, EntityWithEncryptionMetadataTypeName.Patient, null).toList())
		).successBody()
	) { ids ->
		maybeDecrypt(rawApi.getCalendarItemsWithIds(ListOfIds(ids)).successBody())
	}

	override suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E {
		require(calendarItem.secretForeignKeys.isNotEmpty()) { "Calendar item ${calendarItem.id} is already linked to a patient" }
		val currentDataOwnerId = dataOwnerApi.getCurrentDataOwner().successBody().dataOwner.id
		val delegates = shareLinkWithDelegates + currentDataOwnerId
		val secretForeignKeys = crypto.entity.getConfidentialSecretIdsOf(null, patient, EntityWithEncryptionMetadataTypeName.Patient, currentDataOwnerId)
		require(secretForeignKeys.isNotEmpty()) { "Could not find any secret id for patient ${patient.id} which is shared with the topmost ancestor of the current data owner" }
		val shareResult = crypto.entity.bulkShareOrUpdateEncryptedEntityMetadata(
			null,
			listOf(Pair(
				calendarItem,
				delegates.associateWith {
					DelegateShareOptions(
						shareSecretIds = emptySet(),
						shareEncryptionKeys = emptySet(),
						shareOwningEntityIds = setOf(patient.id),
						requestedPermissions = RequestedPermission.FullRead
					)
				}.keyAsLocalDataOwnerReferences()
			)),
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			true,
			{ rawApi.getCalendarItem(it).successBody() },
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
		return maybeDecrypt(
			null,
			rawApi.modifyCalendarItem(
				(shareResult.updatedEntities.first() as EncryptedCalendarItem).copy(secretForeignKeys = secretForeignKeys)
			).successBody()
		)
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

	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedCalendarItem>
	): List<EncryptedCalendarItem> =
		crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			DecryptedCalendarItem.serializer(),
			config.encryption.calendarItem,
		) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedCalendarItem>
	): List<DecryptedCalendarItem> =
		crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			EncryptedCalendarItem.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi) {
	override val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem> =
		object : AbstractCalendarItemFlavouredApi<EncryptedCalendarItem>(rawApi, rawDataOwnerApi, config) {

			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedCalendarItem>
			): List<EncryptedCalendarItem> =
				crypto.entity.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.CalendarItem, EncryptedCalendarItem.serializer(), config.encryption.calendarItem)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedCalendarItem>
			): List<EncryptedCalendarItem> = entities
		}

	override val tryAndRecover: CalendarItemFlavouredApi<CalendarItem> =
		object : AbstractCalendarItemFlavouredApi<CalendarItem>(rawApi, rawDataOwnerApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<CalendarItem>
			): List<EncryptedCalendarItem> =
				crypto.entity.validateOrEncryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.CalendarItem,
					EncryptedCalendarItem.serializer(),
					DecryptedCalendarItem.serializer(),
					config.encryption.calendarItem
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedCalendarItem>
			): List<CalendarItem> =
				crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.CalendarItem,
					EncryptedCalendarItem.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }
		}

	override suspend fun createCalendarItem(entity: DecryptedCalendarItem, groupId: String?): DecryptedCalendarItem {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		val encrypted = encrypt(groupId, entity)
		return (
			if (groupId == null) {
				rawApi.createCalendarItem(encrypted)
			} else {
				rawApi.createCalendarItemInGroup(groupId, encrypted)
			}
		).successBody().let {
			decrypt(it, groupId)
		}
	}

	private val crypto get() = config.crypto

	override suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
	) =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = null,
			entity = (base ?: DecryptedCalendarItem(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.CalendarItem,
			owningEntityId = patient?.id,
			owningEntitySecretId = patient?.let { crypto.entity.resolveSecretIdOption(null, it, EntityWithEncryptionMetadataTypeName.Patient, secretId) },
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun withEncryptionMetadataForGroup(
		entityGroupId: String?,
		base: DecryptedCalendarItem?,
		patient: Patient?,
		user: User?,
		delegates: Map<DataOwnerReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption
	): DecryptedCalendarItem =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = (base ?: DecryptedCalendarItem(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.CalendarItem,
			owningEntityId = patient?.id,
			owningEntitySecretId = patient?.let { crypto.entity.resolveSecretIdOption(entityGroupId, it, EntityWithEncryptionMetadataTypeName.Patient, secretId) },
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty().keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString> = crypto.entity.encryptionKeysOf(null, calendarItem, EntityWithEncryptionMetadataTypeName.CalendarItem, null)

	override suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean = crypto.entity.hasWriteAccess(null, calendarItem, EntityWithEncryptionMetadataTypeName.CalendarItem)

	override suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<String> = crypto.entity.owningEntityIdsOf(null, calendarItem, EntityWithEncryptionMetadataTypeName.CalendarItem, null)

	private suspend fun encrypt(groupId: String?, entity: DecryptedCalendarItem) = crypto.entity.encryptEntities(
		groupId,
		listOf(entity),
		EntityWithEncryptionMetadataTypeName.CalendarItem,
		DecryptedCalendarItem.serializer(),
		config.encryption.calendarItem,
	) { Serialization.json.decodeFromJsonElement<EncryptedCalendarItem>(it) }.single()


	override suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(null, entity, EntityWithEncryptionMetadataTypeName.CalendarItem, delegates.asLocalDataOwnerReferences())
	}

	override suspend fun createDelegationDeAnonymizationMetadataInGroup(
		entityGroupId: String?,
		entity: CalendarItem,
		delegates: Set<DataOwnerReferenceInGroup>
	) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entityGroupId, entity, EntityWithEncryptionMetadataTypeName.CalendarItem, delegates)
	}

	override suspend fun decrypt(calendarItem: EncryptedCalendarItem, groupId: String?): DecryptedCalendarItem =
		crypto.entity.decryptEntities(
			groupId,
			listOf(calendarItem),
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			EncryptedCalendarItem.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }.single()

	override suspend fun tryDecrypt(calendarItem: EncryptedCalendarItem, groupId: String?): CalendarItem =
		crypto.entity.tryDecryptEntities(
			groupId,
			listOf(calendarItem),
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			EncryptedCalendarItem.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedCalendarItem>(config.jsonPatcher.patchCalendarItem(it)) }.single()

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

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<CalendarItem>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedCalendarItem> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedCalendarItem.serializer(),
			events = events,
			filter = mapCalendarItemFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			),
			qualifiedName = CalendarItem.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(CalendarItemAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class CalendarItemBasicApiImpl(
	private val rawApi: RawCalendarItemApi,
	private val config: BasicApiConfiguration
) : CalendarItemBasicApi, CalendarItemBasicFlavouredApi<EncryptedCalendarItem> by object :
	AbstractCalendarItemBasicFlavouredApi<EncryptedCalendarItem>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedCalendarItem>
	): List<EncryptedCalendarItem> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.CalendarItem, EncryptedCalendarItem.serializer(), config.encryption.calendarItem)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedCalendarItem>
	): List<EncryptedCalendarItem> = entities
}, CalendarItemBasicFlavourlessApi by AbstractCalendarItemBasicFlavourlessApi(rawApi) {
	override suspend fun matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): List<String> =
		rawApi.matchCalendarItemsBy(mapCalendarItemFilterOptions(filter, null, null)).successBody()

	override suspend fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): List<String> =
		matchCalendarItemsBy(filter)

	override suspend fun filterCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): PaginatedListIterator<EncryptedCalendarItem> =
		IdsPageIterator(matchCalendarItemsBy(filter), ::getCalendarItems)

	override suspend fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): PaginatedListIterator<EncryptedCalendarItem> =
		filterCalendarItemsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<CalendarItem>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedCalendarItem> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedCalendarItem.serializer(),
			events = events,
			filter = mapCalendarItemFilterOptions(filter, null, null),
			qualifiedName = CalendarItem.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(CalendarItemAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
