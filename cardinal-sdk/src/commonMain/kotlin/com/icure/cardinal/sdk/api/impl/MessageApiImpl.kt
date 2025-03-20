package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.MessageApi
import com.icure.cardinal.sdk.api.MessageBasicApi
import com.icure.cardinal.sdk.api.MessageBasicFlavouredApi
import com.icure.cardinal.sdk.api.MessageBasicFlavourlessApi
import com.icure.cardinal.sdk.api.MessageFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawMessageApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapMessageFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.MessagesReadStatusUpdate
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
import com.icure.cardinal.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.cardinal.sdk.utils.pagination.encodeStartKey
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractMessageBasicFlavouredApi<E : Message>(
	protected val rawApi: RawMessageApi,
	private val config: BasicApiConfiguration,
) : MessageBasicFlavouredApi<E>, FlavouredApi<EncryptedMessage, E> {
	override suspend fun undeleteMessageById(id: String, rev: String): E =
		rawApi.undeleteMessage(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyMessage(entity: E): E =
		rawApi.modifyMessage(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun getMessage(entityId: String): E = rawApi.getMessage(entityId).successBody().let { maybeDecrypt(null, it) }

	override suspend fun getMessages(entityIds: List<String>): List<E> =
		rawApi.getMessages(ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: List<String>) =
		rawApi.listMessagesByTransportGuids(hcPartyId, ListOfIds(transportGuids)).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findMessages(
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessages(startKey.encodeStartKey(), startDocumentId, limit).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getChildrenMessages(
		messageId: String,
	) = rawApi.getChildrenMessages(messageId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getMessagesChildren(messageIds: List<String>) =
		rawApi.getMessagesChildren(ListOfIds(messageIds)).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listMessagesByInvoices(invoiceIds: List<String>) =
		rawApi.listMessagesByInvoices(ListOfIds(invoiceIds)).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findMessagesByTransportGuid(transportGuid: String) =
		rawApi.findMessagesByTransportGuid(transportGuid).successBody().let { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterMessagesBy()"))
	override suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
		hcpId: String?,
	) = rawApi.findMessagesByTransportGuidSentDate(transportGuid, from, to, startKey.encodeStartKey(), startDocumentId, limit, hcpId).successBody()
		.let { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterMessagesBy()"))
	override suspend fun findMessagesByToAddress(
		toAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessagesByToAddress(toAddress, startKey.encodeStartKey(), startDocumentId, limit).successBody().let { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterMessagesBy()"))
	override suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessagesByFromAddress(fromAddress, startKey.encodeStartKey(), startDocumentId, limit).successBody().let { maybeDecrypt(it) }

	@Deprecated("Status bits have unclear meaning, use read status instead")
	override suspend fun setMessagesStatusBits(
		entityIds: List<String>,
		statusBits: Int,
	) = rawApi.setMessagesStatusBits(statusBits, ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }

	override suspend fun setMessagesReadStatus(
		entityIds: List<String>,
		time: Long?,
		readStatus: Boolean,
		userId: String?,
	) = rawApi.setMessagesReadStatus(MessagesReadStatusUpdate(entityIds, time, readStatus, userId)).successBody().let { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractMessageFlavouredApi<E : Message>(
	rawApi: RawMessageApi,
	protected val config: ApiConfiguration
) : AbstractMessageBasicFlavouredApi<E>(rawApi, config), MessageFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		message: E,
		options: MessageShareOptions?,
	): E =
		shareWithMany(message, mapOf(delegateId to (options ?: MessageShareOptions())))

	override suspend fun shareWithMany(message: E, delegates: Map<String, MessageShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			message,
			EntityWithEncryptionMetadataTypeName.Message,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getMessage(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
	override suspend fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listMessageIdsByDataOwnerPatientSentDate(
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
		maybeDecrypt(rawApi.getMessages(ListOfIds(ids)).successBody())
	}

	override suspend fun filterMessagesBy(filter: FilterOptions<Message>): PaginatedListIterator<E> =
		IdsPageIterator(rawApi.matchMessagesBy(
			mapMessageFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)
		).successBody(), this::getMessages)

	override suspend fun filterMessagesBySorted(filter: SortableFilterOptions<Message>): PaginatedListIterator<E> =
		filterMessagesBy(filter)
}

@InternalIcureApi
private class AbstractMessageBasicFlavourlessApi(val rawApi: RawMessageApi, private val config: BasicApiConfiguration) :
	MessageBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteMessageUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteMessage(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteMessagesUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteMessages(ListOfIds(entityIds)).successBody()
		
	override suspend fun deleteMessageById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteMessage(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteMessagesByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteMessagesWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeMessageById(id: String, rev: String) {
		rawApi.purgeMessage(id, rev).successBodyOrThrowRevisionConflict()
	}
}

@InternalIcureApi
internal class MessageApiImpl(
	private val rawApi: RawMessageApi,
	private val config: ApiConfiguration,
) : MessageApi, MessageFlavouredApi<DecryptedMessage> by object :
	AbstractMessageFlavouredApi<DecryptedMessage>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedMessage>
	): List<EncryptedMessage> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Message,
			DecryptedMessage.serializer(),
			this.config.encryption.message,
		) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedMessage>
	): List<DecryptedMessage> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Message,
			EncryptedMessage.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi, config) {
	override val encrypted: MessageFlavouredApi<EncryptedMessage> =
		object : AbstractMessageFlavouredApi<EncryptedMessage>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedMessage>
			): List<EncryptedMessage> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Message,
					EncryptedMessage.serializer(),
					config.encryption.message
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedMessage>
			): List<EncryptedMessage> =
				entities
		}

	override val tryAndRecover: MessageFlavouredApi<Message> =
		object : AbstractMessageFlavouredApi<Message>(rawApi, config) {

			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Message>
			): List<EncryptedMessage> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Message,
					EncryptedMessage.serializer(),
					DecryptedMessage.serializer(),
					config.encryption.message
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedMessage>
			): List<Message> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Message,
					EncryptedMessage.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }
		}

	override suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createMessage(
			config.crypto.entity.encryptEntities(
				null,
				listOf(entity),
				EntityWithEncryptionMetadataTypeName.Message,
				DecryptedMessage.serializer(),
				config.encryption.message,
			) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }.single(),
		).successBody().let { decrypt(it) }
	}

	override suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage =
		rawApi.createMessageInTopic(
			config.crypto.entity.encryptEntities(
				null,
				listOf(entity),
				EntityWithEncryptionMetadataTypeName.Message,
				DecryptedMessage.serializer(),
				config.encryption.message,
			) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }.single()
		).successBody().let { decrypt(it) }

	override suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedMessage =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedMessage(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Message,
			patient?.id,
			patient?.let {
				config.crypto.entity.resolveSecretIdOption(
					null,
					it,
					EntityWithEncryptionMetadataTypeName.Patient,
					secretId
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(message: Message): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(null, message, EntityWithEncryptionMetadataTypeName.Message, null)

	override suspend fun hasWriteAccess(message: Message): Boolean =
		config.crypto.entity.hasWriteAccess(null, message, EntityWithEncryptionMetadataTypeName.Message)

	override suspend fun decryptPatientIdOf(message: Message): Set<String> =
		config.crypto.entity.owningEntityIdsOf(null, message, EntityWithEncryptionMetadataTypeName.Message, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Message, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Message,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun decrypt(message: EncryptedMessage): DecryptedMessage =
		config.crypto.entity.decryptEntities(
			null,
			listOf(message),
			EntityWithEncryptionMetadataTypeName.Message,
			EncryptedMessage.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }.single()

	override suspend fun tryDecrypt(message: EncryptedMessage): Message =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(message),
			EntityWithEncryptionMetadataTypeName.Message,
			EncryptedMessage.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }.single()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Message>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMessage> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedMessage.serializer(),
			events = events,
			filter = mapMessageFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity),
			qualifiedName = Message.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MessageAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun matchMessagesBy(filter: FilterOptions<Message>): List<String> =
		rawApi.matchMessagesBy(mapMessageFilterOptions(filter, config.crypto.dataOwnerApi.getCurrentDataOwnerId(), config.crypto.entity)).successBody()

	override suspend fun matchMessagesBySorted(filter: SortableFilterOptions<Message>): List<String> =
		matchMessagesBy(filter)
}

@InternalIcureApi
internal class MessageBasicApiImpl(
	private val rawApi: RawMessageApi,
	private val config: BasicApiConfiguration
) : MessageBasicApi, MessageBasicFlavouredApi<EncryptedMessage> by object :
	AbstractMessageBasicFlavouredApi<EncryptedMessage>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedMessage>
	): List<EncryptedMessage> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.Message, EncryptedMessage.serializer(), config.encryption.message)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedMessage>
	): List<EncryptedMessage> =
		entities
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi, config) {
	override suspend fun matchMessagesBy(filter: BaseFilterOptions<Message>): List<String> =
		rawApi.matchMessagesBy(mapMessageFilterOptions(filter, null, null)).successBody()

	override suspend fun matchMessagesBySorted(filter: BaseSortableFilterOptions<Message>): List<String> =
		matchMessagesBy(filter)

	override suspend fun filterMessagesBy(filter: BaseFilterOptions<Message>): PaginatedListIterator<EncryptedMessage> =
		IdsPageIterator(matchMessagesBy(filter), this::getMessages)

	override suspend fun filterMessagesBySorted(filter: BaseSortableFilterOptions<Message>): PaginatedListIterator<EncryptedMessage> =
		filterMessagesBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Message>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMessage> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedMessage.serializer(),
			events = events,
			filter = mapMessageFilterOptions(filter, null, null),
			qualifiedName = Message.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MessageAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
