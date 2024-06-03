package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawMessageApi
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.MessageShareOptions
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.Message
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.Message
import com.icure.sdk.model.MessagesReadStatusUpdate
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.currentEpochMs
import com.icure.sdk.websocket.Connection
import com.icure.sdk.websocket.ConnectionImpl
import com.icure.sdk.websocket.EmittedEvent
import com.icure.sdk.websocket.Subscribable
import com.icure.sdk.websocket.WebSocketAuthProvider
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.time.Duration

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Message.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MessageBasicFlavourlessApi {
	suspend fun matchMessagesBy(filter: AbstractFilter<Message>): List<String>
	suspend fun deleteMessage(entityId: String): DocIdentifier
	suspend fun deleteMessages(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MessageBasicFlavouredApi<E : Message>: Subscribable<Message, E> {
	suspend fun modifyMessage(entity: E): E
	suspend fun getMessage(entityId: String): E
	suspend fun getMessages(entityIds: List<String>): List<E>
	suspend fun filterMessagesBy(filterChain: FilterChain<Message>, startDocumentId: String?, limit: Int?): PaginatedList<E>

	suspend fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: List<String>): List<E>
	suspend fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: List<String>): List<E>
	suspend fun findMessages(startKey: JsonElement?, startDocumentId: String?, limit: Int?): PaginatedList<E>
	suspend fun getChildrenMessages(messageId: String): List<E>
	suspend fun getMessagesChildren(messageIds: List<String>): List<E>
	suspend fun listMessagesByInvoices(invoiceIds: List<String>): List<E>
	suspend fun findMessagesByTransportGuid(transportGuid: String): PaginatedList<E>
	suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		hcpId: String? = null,
	): PaginatedList<E>

	suspend fun findMessagesByToAddress(toAddress: String, startKey: JsonElement?, startDocumentId: String?, limit: Int?): PaginatedList<E>
	suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<E>

	suspend fun setMessagesStatusBits(entityIds: List<String>, statusBits: Int): List<E>
	suspend fun setMessagesReadStatus(entityIds: List<String>, time: Long?, readStatus: Boolean, userId: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MessageFlavouredApi<E : Message> : MessageBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		message: E,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param message the [Message] to share.
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
		message: E,
		delegates: Map<String, MessageShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param message the [Message] to share.
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
		message: E,
		delegates: Map<String, MessageShareOptions>
	): E

	suspend fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MessageApi : MessageBasicFlavourlessApi, MessageFlavouredApi<DecryptedMessage> {
	suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage
	suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedMessage
	suspend fun getEncryptionKeysOf(message: Message): Set<HexString>
	suspend fun hasWriteAccess(message: Message): Boolean
	suspend fun decryptPatientIdOf(message: Message): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Message, delegates: Set<String>)

	val encrypted: MessageFlavouredApi<EncryptedMessage>
	val tryAndRecover: MessageFlavouredApi<Message>
	suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage
}

interface MessageBasicApi : MessageBasicFlavourlessApi, MessageBasicFlavouredApi<EncryptedMessage>

@InternalIcureApi
private abstract class AbstractMessageBasicFlavouredApi<E : Message>(
	protected val rawApi: RawMessageApi,
	private val webSocketAuthProvider: WebSocketAuthProvider,
) :
	MessageBasicFlavouredApi<E> {
	override suspend fun modifyMessage(entity: E): E =
		rawApi.modifyMessage(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getMessage(entityId: String): E = rawApi.getMessage(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun getMessages(entityIds: List<String>): List<E> =
		rawApi.getMessages(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun filterMessagesBy(
		filterChain: FilterChain<Message>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.filterMessagesBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: List<String>) =
		rawApi.listMessagesByTransportGuids(hcPartyId, ListOfIds(transportGuids)).successBody().map { maybeDecrypt(it) }

	override suspend fun findMessagesByHCPartyPatientForeignKeys(
		secretPatientKeys: List<String>,
	) = rawApi.findMessagesByHCPartyPatientForeignKeys(secretPatientKeys).successBody().map { maybeDecrypt(it) }

	override suspend fun findMessages(
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessages(startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	override suspend fun getChildrenMessages(
		messageId: String,
	) = rawApi.getChildrenMessages(messageId).successBody().map { maybeDecrypt(it) }

	override suspend fun getMessagesChildren(messageIds: List<String>) =
		rawApi.getMessagesChildren(ListOfIds(messageIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun listMessagesByInvoices(invoiceIds: List<String>) =
		rawApi.listMessagesByInvoices(ListOfIds(invoiceIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun findMessagesByTransportGuid(transportGuid: String) =
		rawApi.findMessagesByTransportGuid(transportGuid).successBody().map { maybeDecrypt(it) }

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

	override suspend fun findMessagesByToAddress(
		toAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessagesByToAddress(toAddress, startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	override suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findMessagesByFromAddress(fromAddress, startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	override suspend fun setMessagesStatusBits(
		entityIds: List<String>,
		statusBits: Int,
	) = rawApi.setMessagesStatusBits(statusBits, ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun setMessagesReadStatus(
		entityIds: List<String>,
		time: Long?,
		readStatus: Boolean,
		userId: String,
	) = rawApi.setMessagesReadStatus(MessagesReadStatusUpdate(entityIds, time, readStatus, userId)).successBody().map { maybeDecrypt(it) }

	@OptIn(InternalAPI::class)
	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: AbstractFilter<Message>,
		onConnected: suspend () -> Unit,
		channelCapacity: Int,
		retryDelay: Duration,
		retryDelayExponentFactor: Double,
		maxRetries: Int,
		eventFired: suspend (E) -> Unit
	): Connection {
		return ConnectionImpl.initialize(
			client = rawApi.httpClient,
			hostname = this.rawApi.apiUrl.replace("https://", "").replace("http://", ""),
			path = "/ws/v2/notification/subscribe",
			serializer = EncryptedMessage.serializer(),
			events = events,
			filter = filter,
			qualifiedName = Message.KRAKEN_QUALIFIED_NAME,
			subscriptionSerializer = { Serialization.json.encodeToString(it) },
			webSocketAuthProvider = webSocketAuthProvider,
			onOpenListener = onConnected,
			retryDelay = retryDelay,
			retryDelayExponentFactor = retryDelayExponentFactor,
			maxRetries = maxRetries,
			eventCallback = { entity, onEvent ->
				try {
					eventFired(maybeDecrypt(entity))
				} catch (e: EntityEncryptionException) {
					onEvent(EmittedEvent.Error(e.message, false))
				}
			}
		)
	}

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedMessage
	abstract suspend fun maybeDecrypt(entity: EncryptedMessage): E
}

@InternalIcureApi
private abstract class AbstractMessageFlavouredApi<E : Message>(
	rawApi: RawMessageApi,
	private val crypto: InternalCryptoServices,
	webSocketAuthProvider: WebSocketAuthProvider
) : AbstractMessageBasicFlavouredApi<E>(rawApi, webSocketAuthProvider), MessageFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		message: E,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			message.withTypeInfo(),
			false,
			mapOf(
				delegateId to SimpleDelegateShareOptionsImpl(
					shareSecretIds = shareSecretIds,
					shareEncryptionKey = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
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
}

@InternalIcureApi
private class AbstractMessageBasicFlavourlessApi(val rawApi: RawMessageApi) : MessageBasicFlavourlessApi {
	override suspend fun matchMessagesBy(filter: AbstractFilter<Message>) = rawApi.matchMessagesBy(filter).successBody()
	override suspend fun deleteMessage(entityId: String) = rawApi.deleteMessage(entityId).successBody()
	override suspend fun deleteMessages(entityIds: List<String>) = rawApi.deleteMessages(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class MessageApiImpl(
	private val rawApi: RawMessageApi,
	private val crypto: InternalCryptoServices,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	private val autofillAuthor: Boolean,
	webSocketAuthProvider: WebSocketAuthProvider,
	) : MessageApi, MessageFlavouredApi<DecryptedMessage> by object :
	AbstractMessageFlavouredApi<DecryptedMessage>(rawApi, crypto, webSocketAuthProvider) {
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
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi) {
	override val encrypted: MessageFlavouredApi<EncryptedMessage> =
		object : AbstractMessageFlavouredApi<EncryptedMessage>(rawApi, crypto, webSocketAuthProvider) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
		}

	override val tryAndRecover: MessageFlavouredApi<Message> =
		object : AbstractMessageFlavouredApi<Message>(rawApi, crypto, webSocketAuthProvider) {
			override suspend fun maybeDecrypt(entity: EncryptedMessage): Message =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedMessage.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createMessage(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage =
		rawApi.createMessageInTopic(encrypt(entity)).successBody().let { decrypt(it) { "Created entity cannot be decrypted" } }

	override suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedMessage =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedMessage(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initialiseEncryptionKey = true,
			initialiseSecretId = true,
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

	suspend fun decrypt(entity: EncryptedMessage, errorMessage: () -> String): DecryptedMessage = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedMessage.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class MessageBasicApiImpl(
	rawApi: RawMessageApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
	webSocketAuthProvider: WebSocketAuthProvider,
) : MessageBasicApi, MessageBasicFlavouredApi<EncryptedMessage> by object :
	AbstractMessageBasicFlavouredApi<EncryptedMessage>(rawApi, webSocketAuthProvider) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi)
