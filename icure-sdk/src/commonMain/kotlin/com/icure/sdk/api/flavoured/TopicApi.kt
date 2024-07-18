package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawTopicApi
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.TopicShareOptions
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.TopicRole
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.requests.topic.AddParticipant
import com.icure.sdk.model.requests.topic.RemoveParticipant
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.serialization.TopicAbstractFilterSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.Subscribable
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface TopicBasicFlavourlessApi : Subscribable<Topic, EncryptedTopic> {
	suspend fun deleteTopic(entityId: String): DocIdentifier
	suspend fun deleteTopics(entityIds: List<String>): List<DocIdentifier>
	suspend fun matchTopicsBy(filter: AbstractFilter<Topic>): List<String>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface TopicBasicFlavouredApi<E : Topic> {
	suspend fun modifyTopic(entity: E): E
	suspend fun getTopic(entityId: String): E
	suspend fun getTopics(entityIds: List<String>): List<E>
	suspend fun filterTopicsBy(filter: AbstractFilter<Topic>): PaginatedListIterator<E>

	suspend fun addParticipant(entityId: String, dataOwnerId: String, topicRole: TopicRole): E
	suspend fun removeParticipant(entityId: String, dataOwnerId: String): E
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface TopicFlavouredApi<E : Topic> : TopicBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		topic: E,
		@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param topic the [Topic] to share.
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
		topic: E,
		delegates: Map<String, TopicShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param topic the [Topic] to share.
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
		topic: E,
		delegates: Map<String, TopicShareOptions>
	): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface TopicApi : TopicBasicFlavourlessApi, TopicFlavouredApi<DecryptedTopic> {
	suspend fun createTopic(entity: DecryptedTopic): DecryptedTopic
	suspend fun withEncryptionMetadata(
		base: DecryptedTopic?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedTopic
	suspend fun getEncryptionKeysOf(topic: Topic): Set<HexString>
	suspend fun hasWriteAccess(topic: Topic): Boolean
	suspend fun decryptPatientIdOf(topic: Topic): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Set<String>)
	suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic
	suspend fun tryDecrypt(topic: EncryptedTopic): Topic

	val encrypted: TopicFlavouredApi<EncryptedTopic>
	val tryAndRecover: TopicFlavouredApi<Topic>
}

interface TopicBasicApi : TopicBasicFlavourlessApi, TopicBasicFlavouredApi<EncryptedTopic>

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
	override suspend fun filterTopicsBy(filter: AbstractFilter<Topic>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchTopicsBy(filter).successBody(),
			this::getTopics
		)
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
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			topic.withTypeInfo(),
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
}

@InternalIcureApi
private class AbstractTopicBasicFlavourlessApi(val rawApi: RawTopicApi, private val config: BasicApiConfiguration) : TopicBasicFlavourlessApi {
	override suspend fun deleteTopic(entityId: String) = rawApi.deleteTopic(entityId).successBody()
	override suspend fun deleteTopics(entityIds: List<String>) = rawApi.deleteTopics(ListOfIds(entityIds)).successBody()
	override suspend fun matchTopicsBy(filter: AbstractFilter<Topic>) = rawApi.matchTopicsBy(filter).successBody()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<Topic>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedTopic> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedTopic.serializer(),
			events = events,
			filter = filter,
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
		) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(it) }
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
				) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(it) }
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
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
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedTopic(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
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
	) { Serialization.json.decodeFromJsonElement<DecryptedTopic>(it) }

	override suspend fun decrypt(topic: EncryptedTopic): DecryptedTopic =
		decryptOrNull(topic) ?: throw EntityEncryptionException("Topic cannot be decrypted")

	override suspend fun tryDecrypt(topic: EncryptedTopic): Topic =
		decryptOrNull(topic) ?: topic
}

@InternalIcureApi
internal class TopicBasicApiImpl(
	rawApi: RawTopicApi,
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
}, TopicBasicFlavourlessApi by AbstractTopicBasicFlavourlessApi(rawApi, config)
