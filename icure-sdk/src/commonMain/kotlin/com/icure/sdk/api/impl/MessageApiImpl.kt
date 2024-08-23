package com.icure.sdk.api.impl

import com.icure.sdk.api.MessageApi
import com.icure.sdk.api.MessageBasicApi
import com.icure.sdk.api.MessageBasicFlavouredApi
import com.icure.sdk.api.MessageBasicFlavourlessApi
import com.icure.sdk.api.MessageFlavouredApi
import com.icure.sdk.api.raw.RawMessageApi
import com.icure.sdk.crypto.entities.MessageShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.filters.mapMessageFilterOptions
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Message
import com.icure.sdk.model.MessagesReadStatusUpdate
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
import com.icure.sdk.subscription.EntitySubscription
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.subscription.WebSocketSubscription
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import com.icure.sdk.utils.pagination.encodeStartKey
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractMessageBasicFlavouredApi<E : Message>(
	protected val rawApi: RawMessageApi,
	private val config: BasicApiConfiguration,
) :
	MessageBasicFlavouredApi<E> {
	override suspend fun modifyMessage(entity: E): E =
		rawApi.modifyMessage(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getMessage(entityId: String): E = rawApi.getMessage(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getMessages(entityIds: List<String>): List<E> =
		rawApi.getMessages(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: List<String>) =
		rawApi.listMessagesByTransportGuids(hcPartyId, ListOfIds(transportGuids)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findMessagesByHCPartyPatientForeignKeys(
		secretPatientKeys: List<String>,
	) = rawApi.findMessagesByHCPartyPatientForeignKeys(secretPatientKeys).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findMessages(
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessages(startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getChildrenMessages(
		messageId: String,
	) = rawApi.getChildrenMessages(messageId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getMessagesChildren(messageIds: List<String>) =
		rawApi.getMessagesChildren(ListOfIds(messageIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listMessagesByInvoices(invoiceIds: List<String>) =
		rawApi.listMessagesByInvoices(ListOfIds(invoiceIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun findMessagesByTransportGuid(transportGuid: String) =
		rawApi.findMessagesByTransportGuid(transportGuid).successBody().map { maybeDecrypt(it) }

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
		.map { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterMessagesBy()"))
	override suspend fun findMessagesByToAddress(
		toAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessagesByToAddress(toAddress, startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterMessagesBy()"))
	override suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessagesByFromAddress(fromAddress, startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	@Deprecated("Status bits have unclear meaning, use read status instead")
	override suspend fun setMessagesStatusBits(
		entityIds: List<String>,
		statusBits: Int,
	) = rawApi.setMessagesStatusBits(statusBits, ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun setMessagesReadStatus(
		entityIds: List<String>,
		time: Long?,
		readStatus: Boolean,
		userId: String?,
	) = rawApi.setMessagesReadStatus(MessagesReadStatusUpdate(entityIds, time, readStatus, userId)).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedMessage
	abstract suspend fun maybeDecrypt(entity: EncryptedMessage): E
}

@InternalIcureApi
private abstract class AbstractMessageFlavouredApi<E : Message>(
	rawApi: RawMessageApi,
	private val config: ApiConfiguration
) : AbstractMessageBasicFlavouredApi<E>(rawApi, config), MessageFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.message

	override suspend fun shareWith(
		delegateId: String,
		message: E,
		options: MessageShareOptions,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			message.withTypeInfo(),
			false,
			mapOf(
				delegateId to options,
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(message: E, delegates: Map<String, MessageShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			message.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(message: E, delegates: Map<String, MessageShareOptions>): E =
		tryShareWithMany(message, delegates).updatedEntityOrThrow()

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
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getMessages(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
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
	override suspend fun deleteMessage(entityId: String) = rawApi.deleteMessage(entityId).successBody()
	override suspend fun deleteMessages(entityIds: List<String>) = rawApi.deleteMessages(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class MessageApiImpl(
	private val rawApi: RawMessageApi,
	private val config: ApiConfiguration,
) : MessageApi, MessageFlavouredApi<DecryptedMessage> by object :
	AbstractMessageFlavouredApi<DecryptedMessage>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedMessage): EncryptedMessage =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedMessage.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedMessage): DecryptedMessage {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedMessage.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi, config) {
	override val encrypted: MessageFlavouredApi<EncryptedMessage> =
		object : AbstractMessageFlavouredApi<EncryptedMessage>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
		}

	override val tryAndRecover: MessageFlavouredApi<Message> =
		object : AbstractMessageFlavouredApi<Message>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedMessage): Message =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedMessage.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Message): EncryptedMessage = when (entity) {
				is EncryptedMessage -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedMessage.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedMessage -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedMessage.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }
			}
		}

	override suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createMessage(
			encrypt(entity),
		).successBody().let { decrypt(it) }
	}

	override suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage =
		rawApi.createMessageInTopic(encrypt(entity)).successBody().let { decrypt(it) }

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.message

	override suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedMessage =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedMessage(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initializeEncryptionKey = true,
			initializeSecretId = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getEncryptionKeysOf(message: Message): Set<HexString> = crypto.entity.encryptionKeysOf(message.withTypeInfo(), null)

	override suspend fun hasWriteAccess(message: Message): Boolean = crypto.entity.hasWriteAccess(message.withTypeInfo())

	override suspend fun decryptPatientIdOf(message: Message): Set<String> = crypto.entity.owningEntityIdsOf(message.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Message, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedMessage) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedMessage.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }

	private suspend fun decryptOrNull(entity: EncryptedMessage): DecryptedMessage? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedMessage.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(config.jsonPatcher.patchMessage(it)) }

	override suspend fun decrypt(message: EncryptedMessage): DecryptedMessage =
		decryptOrNull(message) ?: throw EntityEncryptionException("Message cannot be decrypted")

	override suspend fun tryDecrypt(message: EncryptedMessage): Message =
		decryptOrNull(message) ?: message

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Message>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMessage> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), config.encryption.message)

	override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
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
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
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
