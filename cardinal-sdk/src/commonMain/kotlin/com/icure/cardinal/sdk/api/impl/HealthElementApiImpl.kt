package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.HealthElementApi
import com.icure.cardinal.sdk.api.HealthElementBasicApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavouredApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavourlessApi
import com.icure.cardinal.sdk.api.HealthElementFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapHealthElementFilterOptions
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.HealthElementAbstractFilterSerializer
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
private abstract class AbstractHealthElementBasicFlavouredApi<E : HealthElement>(
	protected val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthElementBasicFlavouredApi<E>, FlavouredApi<EncryptedHealthElement, E> {
	override suspend fun modifyHealthElement(entity: E): E =
		rawApi.modifyHealthElement(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyHealthElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(entities.let { validateAndMaybeEncrypt(it) }).successBody().let { maybeDecrypt(it) }

	override suspend fun getHealthElement(entityId: String): E =
		rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(null, it) }

	override suspend fun getHealthElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }

	override suspend fun undeleteHealthElementById(id: String, rev: String): E =
		rawApi.undeleteHealthElement(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }
}

@InternalIcureApi
private abstract class AbstractHealthElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	protected val config: ApiConfiguration
) : AbstractHealthElementBasicFlavouredApi<E>(rawApi, config), HealthElementFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		options: HealthElementShareOptions?,
	): E =
		shareWithMany(healthElement, mapOf(delegateId to (options ?: HealthElementShareOptions())))

	override suspend fun shareWithMany(healthElement: E, delegates: Map<String, HealthElementShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			healthElement,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getHealthElement(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
	override suspend fun findHealthElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listHealthElementIdsByDataOwnerPatientOpeningDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(
				config.crypto.entity.secretIdsOf(
					null,
					patient,
					EntityWithEncryptionMetadataTypeName.Patient,
					null
				).toList())
		).successBody()
	) { ids ->
		rawApi.getHealthElements(ListOfIds(ids)).successBody().let { maybeDecrypt(it) }
	}

	override suspend fun filterHealthElementsBy(filter: FilterOptions<HealthElement>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchHealthElementsBy(mapHealthElementFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)).successBody(),
			this::getHealthElements
		)

	override suspend fun filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): PaginatedListIterator<E> =
		filterHealthElementsBy(filter)
}

@InternalIcureApi
private class AbstractHealthElementBasicFlavourlessApi(
	val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthElementBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteHealthElementUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteHealthElement(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteHealthElementsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteHealthElements(ListOfIds(entityIds)).successBody()
	
	override suspend fun deleteHealthElementById(entityId: String, rev: String?): DocIdentifier =
		rawApi.deleteHealthElement(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteHealthElementsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteHealthElementsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeHealthElementById(id: String, rev: String) {
		rawApi.purgeHealthElement(id, rev).successBodyOrThrowRevisionConflict()
	}
}

@InternalIcureApi
internal class HealthElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : HealthElementApi, HealthElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthElementFlavouredApi<DecryptedHealthElement>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedHealthElement>
	): List<EncryptedHealthElement> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			DecryptedHealthElement.serializer(),
			this.config.encryption.healthElement,
		) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedHealthElement>
	): List<DecryptedHealthElement> = this.config.crypto.entity.decryptEntities(
		entitiesGroupId,
		entities,
		EntityWithEncryptionMetadataTypeName.HealthElement,
		EncryptedHealthElement.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(config.jsonPatcher.patchHealthElement(it)) }
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi, config) {

	override val encrypted: HealthElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthElementFlavouredApi<EncryptedHealthElement>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedHealthElement>
			): List<EncryptedHealthElement> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.HealthElement,
					EncryptedHealthElement.serializer(),
					config.encryption.healthElement
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedHealthElement>
			): List<EncryptedHealthElement> =
				entities
		}

	override val tryAndRecover: HealthElementFlavouredApi<HealthElement> =
		object : AbstractHealthElementFlavouredApi<HealthElement>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<HealthElement>
			): List<EncryptedHealthElement> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.HealthElement,
					EncryptedHealthElement.serializer(),
					DecryptedHealthElement.serializer(),
					config.encryption.healthElement
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedHealthElement>
			): List<HealthElement> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.HealthElement,
					EncryptedHealthElement.serializer(),
				) {
					Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(
						config.jsonPatcher.patchHealthElement(
							it
						)
					)
				}
		}

	override suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			config.crypto.entity.encryptEntities(
				null,
				listOf(entity),
				EntityWithEncryptionMetadataTypeName.HealthElement,
				DecryptedHealthElement.serializer(),
				config.encryption.healthElement,
			) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }.single(),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElements(
			config.crypto.entity.encryptEntities(
				null,
				entities,
				EntityWithEncryptionMetadataTypeName.HealthElement,
				DecryptedHealthElement.serializer(),
				config.encryption.healthElement,
			) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) },
		).successBody().map {
			decrypt(it)
		}
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedHealthElement =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedHealthElement(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.HealthElement,
			patient.id,
			config.crypto.entity.resolveSecretIdOption(
				null,
				patient,
				EntityWithEncryptionMetadataTypeName.Patient,
				secretId
			),
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			null,
			healthElement,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			null
		)

	override suspend fun hasWriteAccess(healthElement: HealthElement): Boolean =
		config.crypto.entity.hasWriteAccess(null, healthElement, EntityWithEncryptionMetadataTypeName.HealthElement)

	override suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<String> =
		config.crypto.entity.owningEntityIdsOf(
			null,
			healthElement,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			null
		)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun decrypt(healthElement: EncryptedHealthElement): DecryptedHealthElement =
		config.crypto.entity.decryptEntities(
			null,
			listOf(healthElement),
			EntityWithEncryptionMetadataTypeName.HealthElement,
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(config.jsonPatcher.patchHealthElement(it)) }
			.single()

	override suspend fun tryDecrypt(healthElement: EncryptedHealthElement): HealthElement =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(healthElement),
			EntityWithEncryptionMetadataTypeName.HealthElement,
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(config.jsonPatcher.patchHealthElement(it)) }
			.single()

	override suspend fun matchHealthElementsBy(filter: FilterOptions<HealthElement>): List<String> =
		rawApi.matchHealthElementsBy(mapHealthElementFilterOptions(
			filter,
			config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
			config.crypto.entity
		)).successBody()

	override suspend fun matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): List<String> =
		matchHealthElementsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<HealthElement>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedHealthElement> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = events,
			filter = mapHealthElementFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthElementAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class HealthElementBasicApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration
) : HealthElementBasicApi, HealthElementBasicFlavouredApi<EncryptedHealthElement> by object :
	AbstractHealthElementBasicFlavouredApi<EncryptedHealthElement>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedHealthElement>
	): List<EncryptedHealthElement> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.HealthElement, EncryptedHealthElement.serializer(), config.encryption.healthElement)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedHealthElement>
	): List<EncryptedHealthElement> = entities
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi, config) {
	override suspend fun matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): List<String> =
		rawApi.matchHealthElementsBy(mapHealthElementFilterOptions(filter, null, null)).successBody()

	override suspend fun matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): List<String> =
		matchHealthElementsBy(filter)

	override suspend fun filterHealthElementsBy(filter: BaseFilterOptions<HealthElement>): PaginatedListIterator<EncryptedHealthElement> =
		IdsPageIterator(matchHealthElementsBy(filter), this::getHealthElements)

	override suspend fun filterHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): PaginatedListIterator<EncryptedHealthElement> =
		filterHealthElementsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<HealthElement>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedHealthElement> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = events,
			filter = mapHealthElementFilterOptions(filter, null, null),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthElementAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
