package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawMessageApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
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
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Message.", emptySet(), emptyMap(), emptyMap(), emptyMap())

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MessageBasicFlavourlessApi {
	suspend fun matchMessagesBy(filter: AbstractFilter<EncryptedMessage>): List<String>
	suspend fun deleteMessage(entityId: String): DocIdentifier
	suspend fun deleteMessages(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MessageBasicFlavouredApi<E : Message> {
	suspend fun modifyMessage(entity: E): E
	suspend fun getMessage(entityId: String): E
	suspend fun filterMessagesBy(filterChain: FilterChain<EncryptedMessage>, startDocumentId: String?, limit: Int?): PaginatedList<E>
	suspend fun findMessagesByHcPartyPatientForeignKey(
		secretPatientKey: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E>

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
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MessageApi : MessageBasicFlavourlessApi, MessageFlavouredApi<DecryptedMessage> {
	suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedMessage,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedMessage

	val encrypted: MessageFlavouredApi<EncryptedMessage>
	val tryAndRecover: MessageFlavouredApi<Message>
	suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage
}

interface MessageBasicApi : MessageBasicFlavourlessApi, MessageBasicFlavouredApi<EncryptedMessage>

@InternalIcureApi
private abstract class AbstractMessageBasicFlavouredApi<E : Message>(protected val rawApi: RawMessageApi) :
	MessageBasicFlavouredApi<E> {
	override suspend fun modifyMessage(entity: E): E =
		rawApi.modifyMessage(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }


	override suspend fun getMessage(entityId: String): E = rawApi.getMessage(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun filterMessagesBy(
		filterChain: FilterChain<EncryptedMessage>,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.filterMessagesBy(startDocumentId, limit, filterChain).successBody().map { maybeDecrypt(it) }

	override suspend fun findMessagesByHcPartyPatientForeignKey(
		secretPatientKey: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<E> =
		rawApi.findMessagesByHCPartyPatientForeignKey(secretPatientKey, startKey.encodeStartKey(), startDocumentId, limit).successBody()
			.map { maybeDecrypt(it) }

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
	private val encryptionService: EntityEncryptionService,
) : AbstractMessageBasicFlavouredApi<E>(rawApi), MessageFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			healthcareElement.withTypeInfo(),
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = null,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission,
				),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}
}

@InternalIcureApi
private class AbstractMessageBasicFlavourlessApi(val rawApi: RawMessageApi) : MessageBasicFlavourlessApi {
	override suspend fun matchMessagesBy(filter: AbstractFilter<EncryptedMessage>) = rawApi.matchMessagesBy(filter).successBody()
	override suspend fun deleteMessage(entityId: String) = rawApi.deleteMessage(entityId).successBody()
	override suspend fun deleteMessages(entityIds: List<String>) = rawApi.deleteMessages(ListOfIds(entityIds)).successBody()
}

@InternalIcureApi
internal class MessageApiImpl(
	private val rawApi: RawMessageApi,
	private val encryptionService: EntityEncryptionService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : MessageApi, MessageFlavouredApi<DecryptedMessage> by object :
	AbstractMessageFlavouredApi<DecryptedMessage>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedMessage): EncryptedMessage =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedMessage.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedMessage): DecryptedMessage {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedMessage.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi) {
	override val encrypted: MessageFlavouredApi<EncryptedMessage> =
		object : AbstractMessageFlavouredApi<EncryptedMessage>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
		}

	override val tryAndRecover: MessageFlavouredApi<Message> =
		object : AbstractMessageFlavouredApi<Message>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedMessage): Message =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedMessage.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedMessage>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Message): EncryptedMessage = when (entity) {
				is EncryptedMessage -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedMessage.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedMessage -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedMessage.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }
			}
		}

	override suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createMessage(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage =
		rawApi.createMessageInTopic(encrypt(entity)).successBody().let { decrypt(it) { "Created entity cannot be decrypted" } }

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedMessage,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedMessage =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			healthcareElement.withTypeInfo(),
			patient.id,
			encryptionService.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + (
				(user.autoDelegations[DelegationTag.MedicalInformation] ?: emptySet()) +
					(user.autoDelegations[DelegationTag.All] ?: emptySet())
				).associateWith { AccessLevel.Write },
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedMessage) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedMessage.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedMessage>(it) }

	suspend fun decrypt(entity: EncryptedMessage, errorMessage: () -> String): DecryptedMessage = encryptionService.tryDecryptEntity(
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
) : MessageBasicApi, MessageBasicFlavouredApi<EncryptedMessage> by object :
	AbstractMessageBasicFlavouredApi<EncryptedMessage>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedMessage): EncryptedMessage =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedMessage.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedMessage): EncryptedMessage = entity
}, MessageBasicFlavourlessApi by AbstractMessageBasicFlavourlessApi(rawApi)
