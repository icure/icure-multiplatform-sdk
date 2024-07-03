package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawDocumentApi
import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.extensions.dataOwnerId
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.BasicApiConfiguration
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
interface DocumentBasicFlavourlessApi {
	suspend fun deleteDocument(entityId: String): DocIdentifier
	suspend fun deleteDocuments(entityIds: List<String>): List<DocIdentifier>
	suspend fun getRawMainAttachment(documentId: String): ByteArray
	suspend fun getMainAttachmentAsPlainText(documentId: String): String
	suspend fun getMainAttachmentAsJson(documentId: String): JsonElement
	suspend fun getRawSecondaryAttachment(documentId: String, key: String): ByteArray
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface DocumentBasicFlavouredApi<E : Document> {
	suspend fun modifyDocument(entity: E): E
	suspend fun getDocument(entityId: String): E
	suspend fun getDocumentByExternalUuid(externalUuid: String): E
	suspend fun getDocumentsByExternalUuid(externalUuid: String): List<E>
	suspend fun getDocuments(entityIds: List<String>): List<E>
	suspend fun modifyDocuments(entities: List<E>): List<E>
	suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: List<String>,
	): List<E>

	suspend fun findWithoutDelegation(limit: Int?): List<E>
	suspend fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: List<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): EncryptedDocument

	suspend fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	): EncryptedDocument

	suspend fun deleteMainAttachment(entityId: String, rev: String): E
	suspend fun deleteSecondaryAttachment(documentId: String, key: String, rev: String): E
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface DocumentFlavouredApi<E : Document> : DocumentBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		document: E,
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
	 * @param document the [Document] to share.
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
		document: E,
		delegates: Map<String, DocumentShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param document the [Document] to share.
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
		document: E,
		delegates: Map<String, DocumentShareOptions>
	): E

	suspend fun findDocumentsByHcPartyPatient(
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
interface DocumentApi : DocumentBasicFlavourlessApi, DocumentFlavouredApi<DecryptedDocument> {
	suspend fun createDocument(entity: DecryptedDocument): DecryptedDocument
	suspend fun withEncryptionMetadata(
		base: DecryptedDocument?,
		message: Message?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedDocument

	suspend fun getAndTryDecryptMainAttachment(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray?
	suspend fun getAndTryDecryptMainAttachmentAsPlainText(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): String?
	suspend fun getAndTryDecryptMainAttachmentAsJson(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): JsonElement?

	suspend fun getAndDecryptMainAttachment(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray
	suspend fun encryptAndSetMainAttachment(document: Document, utis: List<String>, attachment: ByteArray): EncryptedDocument

	suspend fun getAndDecryptSecondaryAttachment(
		document: Document,
		key: String,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray
	suspend fun encryptAndSetSecondaryAttachment(
		document: Document,
		key: String,
		utis: List<String>,
		attachment: ByteArray,
	): EncryptedDocument
	suspend fun getEncryptionKeysOf(document: Document): Set<HexString>
	suspend fun hasWriteAccess(document: Document): Boolean
	suspend fun decryptPatientIdOf(document: Document): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Document, delegates: Set<String>)

	val encrypted: DocumentFlavouredApi<EncryptedDocument>
	val tryAndRecover: DocumentFlavouredApi<Document>
}

interface DocumentBasicApi : DocumentBasicFlavourlessApi, DocumentBasicFlavouredApi<EncryptedDocument>

@InternalIcureApi
private abstract class AbstractDocumentBasicFlavouredApi<E : Document>(protected val rawApi: RawDocumentApi) :
	DocumentBasicFlavouredApi<E> {
	override suspend fun modifyDocument(entity: E) =
		rawApi.modifyDocument(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getDocument(entityId: String) = rawApi.getDocument(entityId).successBody().let { maybeDecrypt(it) }

	override suspend fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: List<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	) =
		rawApi.setDocumentAttachment(documentId, rev, utis, attachment, attachment.size.toLong(), encrypted).successBody()

	override suspend fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>,
		blobType: String,
		attachment: ByteArray,
		encrypted: Boolean,
	) =
		rawApi.setSecondaryAttachment(documentId, key, rev, utis, attachment, attachment.size.toLong(), encrypted).successBody()

	override suspend fun deleteMainAttachment(entityId: String, rev: String) =
		rawApi.deleteAttachment(entityId, rev).successBody().let { maybeDecrypt(it) }

	override suspend fun deleteSecondaryAttachment(documentId: String, key: String, rev: String) =
		rawApi.deleteSecondaryAttachment(documentId, key, rev).successBody().let { maybeDecrypt(it) }

	override suspend fun getDocumentByExternalUuid(externalUuid: String) =
		rawApi.getDocumentByExternalUuid(externalUuid).successBody().let { maybeDecrypt(it) }

	override suspend fun getDocumentsByExternalUuid(externalUuid: String) =
		rawApi.getDocumentsByExternalUuid(externalUuid).successBody().map { maybeDecrypt(it) }

	override suspend fun getDocuments(entityIds: List<String>) =
		rawApi.getDocuments(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun modifyDocuments(entities: List<E>) =
		rawApi.modifyDocuments(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: List<String>,
	) =
		rawApi.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode, ListOfIds(secretMessageKeys)).successBody()
			.map { maybeDecrypt(it) }

	override suspend fun findWithoutDelegation(
		limit: Int?,
	) =
		rawApi.findWithoutDelegation(limit).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedDocument
	abstract suspend fun maybeDecrypt(entity: EncryptedDocument): E
}

@InternalIcureApi
private abstract class AbstractDocumentFlavouredApi<E : Document>(
	rawApi: RawDocumentApi,
	private val config: ApiConfiguration
) : AbstractDocumentBasicFlavouredApi<E>(rawApi), DocumentFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.document

	override suspend fun shareWith(
		delegateId: String,
		document: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			document.withTypeInfo(),
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

	override suspend fun tryShareWithMany(document: E, delegates: Map<String, DocumentShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			document.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(document: E, delegates: Map<String, DocumentShareOptions>): E =
		tryShareWithMany(document, delegates).updatedEntityOrThrow()

	override suspend fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listDocumentIdsByDataOwnerPatientCreated(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getDocuments(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}
}

@InternalIcureApi
private class AbstractDocumentBasicFlavourlessApi(val rawApi: RawDocumentApi) : DocumentBasicFlavourlessApi {
	override suspend fun deleteDocument(entityId: String) = rawApi.deleteDocument(entityId).successBody()
	override suspend fun deleteDocuments(entityIds: List<String>) = rawApi.deleteDocuments(ListOfIds(entityIds)).successBody()

	override suspend fun getRawMainAttachment(documentId: String) =
		rawApi.getMainAttachment(documentId).successBody()

	override suspend fun getRawSecondaryAttachment(documentId: String, key: String) =
		rawApi.getSecondaryAttachment(documentId, key).successBody()

	override suspend fun getMainAttachmentAsPlainText(documentId: String): String = getRawMainAttachment(documentId).decodeToString()

	override suspend fun getMainAttachmentAsJson(documentId: String): JsonElement = getMainAttachmentAsPlainText(documentId).let {
		Serialization.json.decodeFromString<JsonElement>(it)
	}

}

@InternalIcureApi
internal class DocumentApiImpl(
	private val rawApi: RawDocumentApi,
	private val config: ApiConfiguration
) : DocumentApi, DocumentFlavouredApi<DecryptedDocument> by object :
	AbstractDocumentFlavouredApi<DecryptedDocument>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedDocument): EncryptedDocument =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedDocument.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedDocument>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedDocument): DecryptedDocument {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedDocument.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, DocumentBasicFlavourlessApi by AbstractDocumentBasicFlavourlessApi(rawApi) {
	override val encrypted: DocumentFlavouredApi<EncryptedDocument> =
		object : AbstractDocumentFlavouredApi<EncryptedDocument>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedDocument): EncryptedDocument =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedDocument.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedDocument): EncryptedDocument = entity
		}

	override val tryAndRecover: DocumentFlavouredApi<Document> =
		object : AbstractDocumentFlavouredApi<Document>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedDocument): Document =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedDocument.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Document): EncryptedDocument = when (entity) {
				is EncryptedDocument -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedDocument.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedDocument -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedDocument.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedDocument>(it) }
			}
		}

	override suspend fun createDocument(entity: DecryptedDocument): DecryptedDocument {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createDocument(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.document

	override suspend fun withEncryptionMetadata(
		base: DecryptedDocument?,
		message: Message?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedDocument =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedDocument(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			message?.id,
			message?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty(),
		).updatedEntity

	override suspend fun getAndTryDecryptMainAttachment(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): ByteArray? = getRawMainAttachment(document.id).let {
			crypto.entity.tryDecryptAttachmentOf(document.withTypeInfo(), it, decryptedAttachmentValidator)
		}

	override suspend fun getAndTryDecryptMainAttachmentAsPlainText(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): String? = getAndTryDecryptMainAttachment(document, decryptedAttachmentValidator)?.decodeToString()

	override suspend fun getAndTryDecryptMainAttachmentAsJson(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): JsonElement? = getAndTryDecryptMainAttachmentAsPlainText(document, decryptedAttachmentValidator)?.let {
		Serialization.json.decodeFromString<JsonElement>(it)
	}

	override suspend fun getAndDecryptMainAttachment(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	) =
		rawApi.getMainAttachment(document.id).successBody().let {
			crypto.entity.decryptAttachmentOf(document.withTypeInfo(), it, decryptedAttachmentValidator)
		}

	override suspend fun encryptAndSetMainAttachment(document: Document, utis: List<String>, attachment: ByteArray): EncryptedDocument {
		val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(document.withTypeInfo())?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from document")
		val payload = crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setDocumentAttachment(
			document.id,
			document.rev ?: throw IllegalArgumentException("Document must have a revision set before setting the attachment"),
			utis,
			payload,
			attachment.size.toLong(),
			true,
		).successBody()
	}

	override suspend fun getAndDecryptSecondaryAttachment(
		document: Document,
		key: String,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	) =
		rawApi.getSecondaryAttachment(document.id, key).successBody().let {
			crypto.entity.decryptAttachmentOf(document.withTypeInfo(), it, decryptedAttachmentValidator)
		}

	override suspend fun encryptAndSetSecondaryAttachment(
		document: Document,
		key: String,
		utis: List<String>,
		attachment: ByteArray,
	): EncryptedDocument {
		val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(document.withTypeInfo())?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from document")
		val payload = crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setSecondaryAttachment(
			document.id,
			key,
			document.rev ?: throw IllegalArgumentException("Document must have a revision set before setting the attachment"),
			utis,
			payload,
			attachment.size.toLong(),
			true,
		).successBody()
	}

	override suspend fun getEncryptionKeysOf(document: Document): Set<HexString> = crypto.entity.encryptionKeysOf(document.withTypeInfo(), null)

	override suspend fun hasWriteAccess(document: Document): Boolean = crypto.entity.hasWriteAccess(document.withTypeInfo())

	override suspend fun decryptPatientIdOf(document: Document): Set<String> = crypto.entity.owningEntityIdsOf(document.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Document, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	private suspend fun encrypt(entity: DecryptedDocument) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedDocument.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedDocument>(it) }

	suspend fun decrypt(entity: EncryptedDocument, errorMessage: () -> String): DecryptedDocument = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedDocument.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class DocumentBasicApiImpl(
	rawApi: RawDocumentApi,
	private val config: BasicApiConfiguration
) : DocumentBasicApi, DocumentBasicFlavouredApi<EncryptedDocument> by object :
	AbstractDocumentBasicFlavouredApi<EncryptedDocument>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedDocument): EncryptedDocument =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedDocument.serializer(), config.encryption.document)

	override suspend fun maybeDecrypt(entity: EncryptedDocument): EncryptedDocument = entity
}, DocumentBasicFlavourlessApi by AbstractDocumentBasicFlavourlessApi(rawApi)
