package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.api.TopicBasicApi
import com.icure.cardinal.sdk.api.TopicBasicFlavouredApi
import com.icure.cardinal.sdk.api.TopicBasicFlavourlessApi
import com.icure.cardinal.sdk.api.TopicFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawTopicApi
import com.icure.cardinal.sdk.crypto.entities.SecretIdOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapTopicFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.model.User
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
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractTopicBasicFlavouredApi<E : Topic>(
	protected val rawApi: RawTopicApi,
	private val config: BasicApiConfiguration,
) :
	TopicBasicFlavouredApi<E> {
	override suspend fun modifyTopic(entity: E): E =
		rawApi.modifyTopic(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getTopic(entityId: String): E = rawApi.getTopic(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getTopics(entityIds: List<String>): List<E> =
		rawApi.getTopics(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }
	override suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole) =
		rawApi.addParticipant(entityId, AddParticipant(dataOwnerId, topicRole)).successBody().let { maybeDecrypt(it) }
	override suspend fun removeParticipant(entityId: String, dataOwnerId: String) =
		rawApi.removeParticipant(entityId, RemoveParticipant(dataOwnerId)).successBody().let { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedTopic
	abstract suspend fun maybeDecrypt(entity: EncryptedTopic): E
}

@InternalIcureApi
private abstract class AbstractTopicFlavouredApi<E : Topic>(
	rawApi: RawTopicApi,
	private val config: ApiConfiguration
) : AbstractTopicBasicFlavouredApi<E>(rawApi, config), TopicFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.topic

	override suspend fun shareWith(
		delegateId: String,
		topic: E,
		options: TopicShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			topic.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: TopicShareOptions()),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(topic: E, delegates: Map<String, TopicShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			topic.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(topic: E, delegates: Map<String, TopicShareOptions>): E =
		tryShareWithMany(topic, delegates).updatedEntityOrThrow()

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
	override suspend fun deleteTopic(entityId: String) = rawApi.deleteTopic(entityId).successBody()
	override suspend fun deleteTopics(entityIds: List<String>) = rawApi.deleteTopics(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class TopicApiImpl(
	private val rawApi: RawTopicApi,
	private val config: ApiConfiguration,
) : TopicApi, TopicFlavouredApi<DecryptedTopic> by object : AbstractTopicFlavouredApi<DecryptedTopic>(
	rawApi,
	config
) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedTopic): EncryptedTopic =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedTopic.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedTopic): DecryptedTopic {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedTopic.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, TopicBasicFlavourlessApi by AbstractTopicBasicFlavourlessApi(rawApi, config) {
	override val encrypted: TopicFlavouredApi<EncryptedTopic> =
		object : AbstractTopicFlavouredApi<EncryptedTopic>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedTopic): EncryptedTopic =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedTopic.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedTopic): EncryptedTopic = entity
		}

	override val tryAndRecover: TopicFlavouredApi<Topic> =
		object : AbstractTopicFlavouredApi<Topic>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedTopic): Topic =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedTopic.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Topic): EncryptedTopic = when (entity) {
				is EncryptedTopic -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedTopic.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedTopic -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedTopic.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }
			}
		}

	override suspend fun createTopic(entity: DecryptedTopic): DecryptedTopic {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createTopic(
			encrypt(entity),
		).successBody().let { decrypt(it) }
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.topic

	override suspend fun withEncryptionMetadata(
		base: DecryptedTopic?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedTopic =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedTopic(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initializeEncryptionKey = true,
			initializeSecretId = false,
			autoDelegations = delegates  + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(topic: Topic): Set<HexString> = crypto.entity.encryptionKeysOf(topic.withTypeInfo(), null)

	override suspend fun hasWriteAccess(topic: Topic): Boolean = crypto.entity.hasWriteAccess(topic.withTypeInfo())

	override suspend fun decryptPatientIdOf(topic: Topic): Set<String> = crypto.entity.owningEntityIdsOf(topic.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedTopic) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedTopic.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedTopic>(it) }

	private suspend fun decryptOrNull(entity: EncryptedTopic): DecryptedTopic? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedTopic.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(config.jsonPatcher.patchTopic(it)) }

	override suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic =
		decryptOrNull(topic) ?: throw EntityEncryptionException("Topic cannot be decrypted")

	override suspend fun tryDecrypt(topic: EncryptedTopic): Topic =
		decryptOrNull(topic) ?: topic

	override suspend fun matchTopicsBy(filter: FilterOptions<Topic>): List<String> =
		rawApi.matchTopicsBy(mapTopicFilterOptions(
			filter,
			crypto.dataOwnerApi.getCurrentDataOwnerId(),
			crypto.entity
		)).successBody()

	override suspend fun matchTopicsBySorted(filter: SortableFilterOptions<Topic>): List<String> =
		matchTopicsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Topic>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedTopic> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedTopic.serializer(),
			events = events,
			filter = mapTopicFilterOptions(
				filter,
				crypto.dataOwnerApi.getCurrentDataOwnerId(),
				crypto.entity
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
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedTopic): EncryptedTopic =
		config.crypto.validationService.validateEncryptedEntity(
			entity.withTypeInfo(),
			EncryptedTopic.serializer(),
			config.encryption.topic
		)

	override suspend fun maybeDecrypt(entity: EncryptedTopic): EncryptedTopic = entity
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
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
