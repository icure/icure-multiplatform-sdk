package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.HealthElementApi
import com.icure.cardinal.sdk.api.HealthElementBasicApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavouredApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavourlessApi
import com.icure.cardinal.sdk.api.HealthElementFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
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
import com.icure.cardinal.sdk.utils.EntityEncryptionException
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
) : HealthElementBasicFlavouredApi<E> {
	override suspend fun modifyHealthElement(entity: E): E =
		rawApi.modifyHealthElement(validateAndMaybeEncrypt(entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }

	override suspend fun modifyHealthElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getHealthElement(entityId: String): E =
		rawApi.getHealthElement(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getHealthElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
	abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E

	override suspend fun undeleteHealthElementById(id: String, rev: String): E =
		rawApi.undeleteHealthElement(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractHealthElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : AbstractHealthElementBasicFlavouredApi<E>(rawApi, config), HealthElementFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.healthElement

	override suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		options: HealthElementShareOptions?,
	): E =
		shareWithMany(healthElement, mapOf(delegateId to (options ?: HealthElementShareOptions())))

	override suspend fun shareWithMany(healthElement: E, delegates: Map<String, HealthElementShareOptions>): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			healthElement.withTypeInfo(),
			delegates,
			true,
			{ getHealthElement(it).withTypeInfo() },
			{ rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } } }
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
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getHealthElements(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
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
	override suspend fun deleteHealthElement(entityId: String): DocIdentifier =
		rawApi.deleteHealthElement(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteHealthElements(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteHealthElements(ListOfIds(entityIds)).successBody()
	
	override suspend fun deleteHealthElementById(entityId: String, rev: String?): DocIdentifier =
		rawApi.deleteHealthElement(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteHealthElementsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteHealthElementsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeHealthElementById(id: String, rev: String) {
		rawApi.purgeHealthElement(id, rev).successBodyOrThrowRevisionConflict()
	}

	@Deprecated("Use filter instead")
	override suspend fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()
}

@InternalIcureApi
internal class HealthElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: ApiConfiguration
) : HealthElementApi, HealthElementFlavouredApi<DecryptedHealthElement> by object :
	AbstractHealthElementFlavouredApi<DecryptedHealthElement>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedHealthElement): EncryptedHealthElement =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedHealthElement.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(config.jsonPatcher.patchHealthElement(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be decrypted")
	}
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi(rawApi, config) {

	override val encrypted: HealthElementFlavouredApi<EncryptedHealthElement> =
		object : AbstractHealthElementFlavouredApi<EncryptedHealthElement>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
		}

	override val tryAndRecover: HealthElementFlavouredApi<HealthElement> =
		object : AbstractHealthElementFlavouredApi<HealthElement>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedHealthElement): HealthElement =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(config.jsonPatcher.patchHealthElement(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: HealthElement): EncryptedHealthElement = when (entity) {
				is EncryptedHealthElement -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedHealthElement.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedHealthElement -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedHealthElement.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }
			}
		}

	override suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElement(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	override suspend fun createHealthElements(entities: List<DecryptedHealthElement>): List<DecryptedHealthElement> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createHealthElements(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it)
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.healthElement

	override suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedHealthElement =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedHealthElement(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient.id,
			crypto.entity.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initializeEncryptionKey = true,
			autoDelegations = delegates  + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString> = crypto.entity.encryptionKeysOf(healthElement.withTypeInfo(), null)

	override suspend fun hasWriteAccess(healthElement: HealthElement): Boolean = crypto.entity.hasWriteAccess(healthElement.withTypeInfo())

	override suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<String> = crypto.entity.owningEntityIdsOf(healthElement.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedHealthElement) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedHealthElement.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

	private suspend fun decryptOrNull(entity: EncryptedHealthElement): DecryptedHealthElement? =
		crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedHealthElement.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(config.jsonPatcher.patchHealthElement(it)) }

	override suspend fun decrypt(healthElement: EncryptedHealthElement): DecryptedHealthElement =
		decryptOrNull(healthElement) ?: throw EntityEncryptionException("HealthElement cannot be decrypted")

	override suspend fun tryDecrypt(healthElement: EncryptedHealthElement): HealthElement =
		decryptOrNull(healthElement) ?: healthElement

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
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedHealthElement.serializer(), config.encryption.healthElement)

	override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
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
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
