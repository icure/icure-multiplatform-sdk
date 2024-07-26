package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawMessageApi
import com.icure.sdk.crypto.entities.MessageShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.ListOfIds
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
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.serialization.MessageAbstractFilterSerializer
import com.icure.sdk.serialization.SubscriptionSerializer
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
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MessageBasicFlavourlessApi: Subscribable<Message, EncryptedMessage> {
	/**
	 * Get the ids of all health elements matching the provided filter.
	 * @param filter a health element filter
	 * @return a list of health element ids
	 */
	suspend fun matchMessagesBy(filter: AbstractFilter<Message>): List<String>

	/**
	 * Deletes a message. If you don't have write access to the Message the method will fail.
	 * @param entityId id of the Message.
	 * @return the id and revision of the deleted Message.
	 */
	suspend fun deleteMessage(entityId: String): DocIdentifier

	/**
	 * Deletes many messages. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the messages.
	 * @return the id and revision of the deleted messages. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteMessages(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MessageBasicFlavouredApi<E : Message> {
	/**
	 * Modifies a message. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a message with update content
	 * @return the Message updated with the provided content and a new revision.
	 */
	suspend fun modifyMessage(entity: E): E

	/**
	 * Get a message by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a message, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a message id.
	 * @return the Message with id [entityId].
	 */
	suspend fun getMessage(entityId: String): E

	/**
	 * Get multiple messages by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a message, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of messages ids
	 * @return all messages that you can access with one of the provided ids.
	 */
	suspend fun getMessages(entityIds: List<String>): List<E>

	/**
	 * @param filter a message filter
	 * @return an iterator that iterates over all messages matching the provided filter.
	 */
	suspend fun filterMessagesBy(filter: AbstractFilter<Message>): PaginatedListIterator<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findMessages(startKey: JsonElement?, startDocumentId: String?, limit: Int?): PaginatedList<E>

	@Deprecated("Will be replaced by filter")
	suspend fun getChildrenMessages(messageId: String): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun getMessagesChildren(messageIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listMessagesByInvoices(invoiceIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findMessagesByTransportGuid(transportGuid: String): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterMessagesBy()"))
	suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		hcpId: String? = null,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterMessagesBy()"))
	suspend fun findMessagesByToAddress(toAddress: String, startKey: JsonElement?, startDocumentId: String?, limit: Int?): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterMessagesBy()"))
	suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<E>

	@Deprecated("Status bits have unclear meaning, use read status instead")
	suspend fun setMessagesStatusBits(entityIds: List<String>, statusBits: Int): List<E>

	/**
	 * Updates the read status of the messages with the provided id. You can use this method even if you don't have write permissions
	 * on the message, as long as you have read permissions.
	 * @param entityIds the ids of the messages to update
	 * @param time the unix timestamp of when the message was read
	 * @param readStatus if the message was read
	 * @param userId the id of the user for which the status should be updated
	 * @return the updated messages.
	 */
	// TODO improve security by making that by default a user can only update his own information unless they have special permissions
	suspend fun setMessagesReadStatus(entityIds: List<String>, time: Long?, readStatus: Boolean, userId: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MessageFlavouredApi<E : Message> : MessageBasicFlavouredApi<E> {
	/**
	 * Share a message with another data owner. The Message must already exist in the database for this method to
	 * succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the Message
	 * @param healthElement the Message to share with [delegateId]
	 * @param options specifies how the Message will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the Message. Refer
	 * to the documentation of [MessageShareOptions] for more information.
	 * @return the updated Message if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		message: E,
		options: MessageShareOptions
	): SimpleShareResult<E>

	/**
	 * Share a message with multiple data owners. The Message must already exist in the database for this method to
	 * succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param healthElement the Message to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated Message if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		message: E,
		delegates: Map<String, MessageShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a message with multiple data owners. The Message must already exist in the database for this method to
	 * succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param healthElement the Message to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated Message.
	 */
	suspend fun shareWithMany(
		message: E,
		delegates: Map<String, MessageShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
	suspend fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MessageApi : MessageBasicFlavourlessApi, MessageFlavouredApi<DecryptedMessage> {
	/**
	 * Create a new Message. The provided Message must have the encryption metadata initialised. This method requires
	 * the permission to create messages outside of topics. If you want to create a message within a topic use the
	 * [createMessageInTopic] method instead.
	 * @param entity a message with initialised encryption metadata
	 * @return the created Message with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage

	/**
	 * Create a new Message. The provided Message must have the encryption metadata initialised, and the id of the topic
	 * set in [Message.transportGuid] (note that your configuration must not encrypt the transport guid). The user needs
	 * to be a participant in that topic for this method to succeed.
	 * @param entity a message with initialised encryption metadata and with a transportGuid set to the topic
	 * @return the created Message with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage

	/**
	 * Creates a new Message with initialised encryption metadata
	 * @param base a message with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the Message.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new Message
	 * @return a message with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedMessage

	/**
	 * Attempts to extract the encryption keys of a message. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param healthElement a message
	 * @return the encryption keys extracted from the provided Message.
	 */
	suspend fun getEncryptionKeysOf(message: Message): Set<HexString>

	/**
	 * Specifies if the current user has write access to a message.
	 * @param healthElement a message
	 * @return if the current user has write access to the provided Message
	 */
	suspend fun hasWriteAccess(message: Message): Boolean

	/**
	 * Attempts to extract the patient id linked to a message.
	 * Note: messages usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param healthElement a message
	 * @return the id of the patient linked to the Message, or empty if the current user can't access any patient id
	 * of the Message.
	 */
	suspend fun decryptPatientIdOf(message: Message): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a message.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided Message. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the Message the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Message,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a message E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any Message that you have shared with P, H will be able to know that the Message was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a message that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a message
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Message, delegates: Set<String>)

	/**
	 * Decrypts a message, throwing an exception if it is not possible.
	 * @param healthElement a message
	 * @return the decrypted Message
	 * @throws EntityEncryptionException if the Message could not be decrypted
	 */
	suspend fun decrypt(message: EncryptedMessage): DecryptedMessage

	/**
	 * Tries to decrypt a message, returns the input if it is not possible.
	 * @param healthElement an encrypted Message
	 * @return the decrypted Message if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(message: EncryptedMessage): Message
	
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: MessageFlavouredApi<EncryptedMessage>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: MessageFlavouredApi<Message>
}

interface MessageBasicApi : MessageBasicFlavourlessApi, MessageBasicFlavouredApi<EncryptedMessage>

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

	override suspend fun filterMessagesBy(filter: AbstractFilter<Message>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchMessagesBy(filter).successBody(),
			this::getMessages
		)

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
private class AbstractMessageBasicFlavourlessApi(val rawApi: RawMessageApi, private val config: BasicApiConfiguration) : MessageBasicFlavourlessApi {
	override suspend fun matchMessagesBy(filter: AbstractFilter<Message>) = rawApi.matchMessagesBy(filter).successBody()
	override suspend fun deleteMessage(entityId: String) = rawApi.deleteMessage(entityId).successBody()
	override suspend fun deleteMessages(entityIds: List<String>) = rawApi.deleteMessages(ListOfIds(entityIds)).successBody()

	override suspend fun subscribeToEvents(
		events: Set<com.icure.sdk.subscription.SubscriptionEventType>,
		filter: AbstractFilter<Message>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMessage> {
		return WebSocketSubscription.initialize(
			client = config.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.clientJson,
			entitySerializer = EncryptedMessage.serializer(),
			events = events,
			filter = filter,
			qualifiedName = Message.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MessageAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
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
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }
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
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedMessage(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
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

	private suspend fun decryptOrNull(entity: EncryptedMessage): DecryptedMessage? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedMessage.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }

	override suspend fun decrypt(message: EncryptedMessage): DecryptedMessage =
		decryptOrNull(message) ?: throw EntityEncryptionException("Message cannot be decrypted")

	override suspend fun tryDecrypt(message: EncryptedMessage): Message =
		decryptOrNull(message) ?: message
}

@InternalIcureApi
internal class MessageBasicApiImpl(
	rawApi: RawMessageApi,
	private val config: BasicApiConfiguration
) : MessageBasicApi, MessageBasicFlavouredApi<EncryptedMessage> by object :
	AbstractMessageBasicFlavouredApi<EncryptedMessage>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), config.encryption.message)

	override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi, config)
