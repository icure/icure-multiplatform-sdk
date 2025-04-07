package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.api.TopicBasicApi
import com.icure.cardinal.sdk.api.TopicBasicFlavouredApi
import com.icure.cardinal.sdk.api.TopicBasicFlavourlessApi
import com.icure.cardinal.sdk.api.TopicFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawTopicApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapTopicFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.requests.topic.AddParticipant
import com.icure.cardinal.sdk.model.requests.topic.RemoveParticipant
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.serialization.TopicAbstractFilterSerializer
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
private abstract class AbstractTopicBasicFlavouredApi<E : Topic>(
	protected val rawApi: RawTopicApi,
	private val config: BasicApiConfiguration,
) : TopicBasicFlavouredApi<E>, FlavouredApi<EncryptedTopic, E> {
	override suspend fun undeleteTopicById(id: String, rev: String): E =
		rawApi.undeleteTopic(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyTopic(entity: E): E =
		rawApi.modifyTopic(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun getTopic(entityId: String): E = rawApi.getTopic(entityId).successBody().let { maybeDecrypt(null, it) }

	override suspend fun getTopics(entityIds: List<String>): List<E> =
		rawApi.getTopics(ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }
	override suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole) =
		rawApi.addParticipant(entityId, AddParticipant(dataOwnerId, topicRole)).successBody().let { maybeDecrypt(null, it) }
	override suspend fun removeParticipant(entityId: String, dataOwnerId: String) =
		rawApi.removeParticipant(entityId, RemoveParticipant(dataOwnerId)).successBody().let { maybeDecrypt(null, it) }
}

@InternalIcureApi
private abstract class AbstractTopicFlavouredApi<E : Topic>(
	rawApi: RawTopicApi,
	protected val config: ApiConfiguration
) : AbstractTopicBasicFlavouredApi<E>(rawApi, config), TopicFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		topic: E,
		options: TopicShareOptions?,
	): E =
		shareWithMany(topic, mapOf(delegateId to (options ?: TopicShareOptions())))

	override suspend fun shareWithMany(topic: E, delegates: Map<String, TopicShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			topic,
			EntityWithEncryptionMetadataTypeName.Topic,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getTopic(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	override suspend fun filterTopicsBy(filter: FilterOptions<Topic>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchTopicsBy(mapTopicFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)).successBody(),
			this::getTopics
		)

	override suspend fun filterTopicsBySorted(filter: SortableFilterOptions<Topic>): PaginatedListIterator<E> =
		filterTopicsBy(filter)
}

@InternalIcureApi
private class AbstractTopicBasicFlavourlessApi(val rawApi: RawTopicApi, private val config: BasicApiConfiguration) :
	TopicBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteTopicUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteTopic(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteTopicsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteTopics(ListOfIds(entityIds)).successBody()
		
	override suspend fun deleteTopicById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteTopic(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteTopicsByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteTopicsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeTopicById(id: String, rev: String) {
		rawApi.purgeTopic(id, rev).successBodyOrThrowRevisionConflict()
	}
}

@InternalIcureApi
internal class TopicApiImpl(
	private val rawApi: RawTopicApi,
	private val config: ApiConfiguration,
) : TopicApi, TopicFlavouredApi<DecryptedTopic> by object : AbstractTopicFlavouredApi<DecryptedTopic>(
	rawApi,
	config
) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedTopic>
	): List<EncryptedTopic> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Topic,
			DecryptedTopic.serializer(),
			this.config.encryption.topic,
		) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }


	override suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedTopic>): List<DecryptedTopic> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Topic,
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }
}, TopicBasicFlavourlessApi by AbstractTopicBasicFlavourlessApi(rawApi, config) {
	override val encrypted: TopicFlavouredApi<EncryptedTopic> =
		object : AbstractTopicFlavouredApi<EncryptedTopic>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedTopic>
			): List<EncryptedTopic> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Topic,
					EncryptedTopic.serializer(),
					config.encryption.topic
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedTopic>
			): List<EncryptedTopic> =
				entities
		}

	override val tryAndRecover: TopicFlavouredApi<Topic> =
		object : AbstractTopicFlavouredApi<Topic>(rawApi, config) {

			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Topic>
			): List<EncryptedTopic> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId = entitiesGroupId,
					entities = entities,
					entitiesType = EntityWithEncryptionMetadataTypeName.Topic,
					encryptedSerializer = EncryptedTopic.serializer(),
					decryptedSerializer = DecryptedTopic.serializer(),
					fieldsToEncrypt = config.encryption.topic
				)

			override suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedTopic>): List<Topic> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Topic,
					EncryptedTopic.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }
		}

	override suspend fun createTopic(entity: DecryptedTopic): DecryptedTopic {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createTopic(
			config.crypto.entity.encryptEntities(
				null,
				listOf(entity),
				EntityWithEncryptionMetadataTypeName.Topic,
				DecryptedTopic.serializer(),
				config.encryption.topic,
			) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }.single(),
		).successBody().let { decrypt(it) }
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedTopic?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedTopic =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedTopic(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Topic,
			patient?.let {
				OwningEntityDetails(
					null,
					it.id,
					config.crypto.entity.resolveSecretIdOption(
						null,
						it,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(topic: Topic): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(null, topic, EntityWithEncryptionMetadataTypeName.Topic, null)

	override suspend fun hasWriteAccess(topic: Topic): Boolean =
		config.crypto.entity.hasWriteAccess(null, topic, EntityWithEncryptionMetadataTypeName.Topic)

	override suspend fun decryptPatientIdOf(topic: Topic): Set<String> =
		config.crypto.entity.owningEntityIdsOf(null, topic, EntityWithEncryptionMetadataTypeName.Topic, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Topic,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic =
		config.crypto.entity.decryptEntities(
			null,
			listOf(topic),
			EntityWithEncryptionMetadataTypeName.Topic,
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }.single()

	override suspend fun tryDecrypt(topic: EncryptedTopic): Topic =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(topic),
			EntityWithEncryptionMetadataTypeName.Topic,
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }.single()

	override suspend fun matchTopicsBy(filter: FilterOptions<Topic>): List<String> =
		rawApi.matchTopicsBy(mapTopicFilterOptions(
			filter,
			config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
			config.crypto.entity
		)).successBody()

	override suspend fun matchTopicsBySorted(filter: SortableFilterOptions<Topic>): List<String> =
		matchTopicsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Topic>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedTopic> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedTopic.serializer(),
			events = events,
			filter = mapTopicFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			),
			qualifiedName = Topic.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(TopicAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal class TopicBasicApiImpl(
	private val rawApi: RawTopicApi,
	private val config: BasicApiConfiguration
) : TopicBasicApi, TopicBasicFlavouredApi<EncryptedTopic> by object :
	AbstractTopicBasicFlavouredApi<EncryptedTopic>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedTopic>
	): List<EncryptedTopic> =
		config.crypto.validationService.validateEncryptedEntities(
			entities,
			EntityWithEncryptionMetadataTypeName.Topic,
			EncryptedTopic.serializer(),
			config.encryption.topic
		)

	override suspend fun maybeDecrypt(entitiesGroupId: String?, entities: List<EncryptedTopic>): List<EncryptedTopic> =
		entities
}, TopicBasicFlavourlessApi by AbstractTopicBasicFlavourlessApi(rawApi, config) {
	override suspend fun matchTopicsBy(filter: BaseFilterOptions<Topic>): List<String> =
		rawApi.matchTopicsBy(mapTopicFilterOptions(filter, null, null)).successBody()

	override suspend fun matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): List<String> =
		matchTopicsBy(filter)

	override suspend fun filterTopicsBy(filter: BaseFilterOptions<Topic>): PaginatedListIterator<EncryptedTopic> =
		IdsPageIterator(
			matchTopicsBy(filter),
			this::getTopics
		)

	override suspend fun filterTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): PaginatedListIterator<EncryptedTopic> =
		filterTopicsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Topic>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedTopic> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedTopic.serializer(),
			events = events,
			filter = mapTopicFilterOptions(filter, null, null),
			qualifiedName = Topic.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(TopicAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
