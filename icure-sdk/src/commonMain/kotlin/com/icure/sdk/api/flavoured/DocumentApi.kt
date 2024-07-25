package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawDocumentApi
import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
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
	/**
	 * Deletes a document. If you don't have write access to the document the method will fail.
	 * @param entityId id of the document.
	 * @return the id and revision of the deleted document.
	 */
	suspend fun deleteDocument(entityId: String): DocIdentifier

	/**
	 * Deletes many documents. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the documents.
	 * @return the id and revision of the deleted documents. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteDocuments(entityIds: List<String>): List<DocIdentifier>

	/**
	 * Get the main attachment from the document with the provided id as raw bytes. This method will not
	 * perform any transformation on the attachment, and if the attachment was encrypted the returned data is encrypted.
	 * @param documentId a document id
	 * @return the main attachment of the document with id [documentId], as stored in the backend.
	 */
	suspend fun getRawMainAttachment(documentId: String): ByteArray

	/**
	 * Get the raw main attachment of the document with the provided id and interpret it as plain text. This method does
	 * not decrypt the attachment, therefore it should be used only with documents where the main attachment is not
	 * encrypted: if the attachment was encrypted the resulting string will be garbage.
	 * @param documentId a document id
	 * @return the main attachment of the document with id [documentId], as stored in the backend and interpreted as
	 * a string.
	 */
	@Deprecated("You should just use getRawMainAttachment and decode the string yourself")
	suspend fun getMainAttachmentAsPlainText(documentId: String): String

	/**
	 * Get the raw main attachment of the document with the provided id and interpret it as json. This method does not
	 * decrypt the attachment, therefore it should be used only with documents where the main attachment is not
	 * encrypted. If the raw attachment does not represent a valid json string this method will fail.
	 * @param documentId a document id
	 * @return the main attachment of the document with id [documentId], as stored in the backend and interpreted as
	 * a json.
	 * @throws kotlinx.serialization.SerializationException if the raw attachment does not represent a valid json
	 * string.
	 */
	@Deprecated("You should just use getRawMainAttachment and parse the json yourself")
	suspend fun getMainAttachmentAsJson(documentId: String): JsonElement

	/**
	 * Get the secondary attachment at [key] from the document with the provided id as raw bytes. This method will not
	 * perform any transformation on the attachment, and if the attachment was encrypted the returned data is encrypted.
	 * @param documentId a document id
	 * @param key the key of the secondary attachment to retrieve.
	 * @return the secondary attachment at [key] of the document with id [documentId], as stored in the backend.
	 */
	suspend fun getRawSecondaryAttachment(documentId: String, key: String): ByteArray

	/**
	 * Sets the main attachment for a document without performing any transformation. Most notably the attachment
	 * will not be encrypted by this method.
	 * If a main attachment already exist on the document it will be replaced.
	 * @param documentId the id of the document.
	 * @param rev the revision of the document
	 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 * If null and there is already a main attachment for the document the current utis will be reused, otherwise it
	 * null will be considered as an empty list. In all other cases overwrites any existing value.
	 * @param attachment the attachment to set
	 * @param encrypted specifies if the attachment you provided is encrypted or not. This will only be used to
	 * have a more accurate representation of the type of attachment in the attachment storage servers; the document
	 * entity won't be affected by this value.
	 * @return the updated document
	 */
	suspend fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): EncryptedDocument

	/**
	 * Sets the secondary attachment at the provided key for a document without performing any transformation. Most
	 * notably the attachment will not be encrypted by this method.
	 * If there is already a secondary attachment for the provided key on the document it will be replaced.
	 * @param documentId the id of the document.
	 * @param key a key to distinguish the secondary attachment from other secondary attachments. The key can be any
	 * string except for the [documentId], which is by convention reserved for the main attachment of the document.
	 * @param rev the revision of the document
	 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 * If null and there is already a secondary attachment at key for the document the current utis will be reused,
	 * otherwise it null will be considered as an empty list. In all other cases overwrites any existing value.
	 * @param attachment the attachment to set
	 * @param encrypted specifies if the attachment you provided is encrypted or not. This will only be used to
	 * have a more accurate representation of the type of attachment in the attachment storage servers; the document
	 * entity won't be affected by this value.
	 * @return the updated document
	 */
	suspend fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): EncryptedDocument

	/**
	 * Deletes the main attachment of a document.
	 * @param entityId the id of the document
	 * @param rev the last known revision of the document
	 * @return the updated document
	 */
	suspend fun deleteMainAttachment(entityId: String, rev: String): EncryptedDocument

	/**
	 * Deletes a secondary attachment of a document.
	 * @param documentId the id of the document
	 * @param key key of the secondary attachment to delete
	 * @param rev the last known revision of the document
	 * @return the updated document
	 */
	suspend fun deleteSecondaryAttachment(documentId: String, key: String, rev: String): EncryptedDocument
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface DocumentBasicFlavouredApi<E : Document> {
	/**
	 * Modifies a document. You need to have write access to the entity. Note that you can't use this method to
	 * change the attachments and/or attachment metadata on the document. You should use various set attachment methods
	 * instead.
	 * Flavoured method.
	 * @param entity a document with update content
	 * @return the document updated with the provided content and a new revision.
	 */
	suspend fun modifyDocument(entity: E): E

	/**
	 * Get a document by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a document, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a document id.
	 * @return the document with id [entityId].
	 */
	suspend fun getDocument(entityId: String): E

	@Deprecated("Will be replaced by filter")
	suspend fun getDocumentByExternalUuid(externalUuid: String): E

	@Deprecated("Will be replaced by filter")
	suspend fun getDocumentsByExternalUuid(externalUuid: String): List<E>

	/**
	 * Get multiple documents by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a document, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of documents ids
	 * @return all documents that you can access with one of the provided ids.
	 */
	suspend fun getDocuments(entityIds: List<String>): List<E>

	/**
	 * Modifies multiple documents. Ignores all documents for which you don't have write access.
	 * Flavoured method.
	 * @param entities documents with update content
	 * @return the updated documents with a new revision.
	 */
	suspend fun modifyDocuments(entities: List<E>): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: List<String>,
	): List<E>

	@Deprecated("Will be replaced by filter")
	suspend fun findWithoutDelegation(limit: Int?): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface DocumentFlavouredApi<E : Document> : DocumentBasicFlavouredApi<E> {
	/**
	 * Share a document with another data owner. The document must already exist in the database for this method to
	 * succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param delegateId the owner that will gain access to the document
	 * @param document the document to share with [delegateId]
	 * @param options specifies how the document will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the document. Refer
	 * to the documentation of [CalendarItemShareOptions] for more information.
	 * @return the updated document if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		document: E,
		@DefaultValue("null")
		options: DocumentShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share a document with multiple data owners. The document must already exist in the database for this method to
	 * succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * @param document the document to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated document if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		document: E,
		delegates: Map<String, DocumentShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a document with multiple data owners. The document must already exist in the database for this method to
	 * succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 * the initialise encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param document the document to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated document.
	 */
	suspend fun shareWithMany(
		document: E,
		delegates: Map<String, DocumentShareOptions>
	): E

	@Deprecated("Will be replaced by filter")
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
	/**
	 * Create a new document. The provided document must have the encryption metadata initialised.
	 * @param entity a document with initialised encryption metadata
	 * @return the created document with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createDocument(entity: DecryptedDocument): DecryptedDocument

	/**
	 * Creates a new document with initialised encryption metadata
	 * @param base a document with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param message the message linked to the document, if any.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [message] to use for the new document
	 * @return a document with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
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

	/**
	 * Retrieves and tries to decrypt the main attachment of a document.
	 * This method returns null if the user has no access to an encryption key of the document that allows to correctly
	 * decrypt the attachment.
	 *
	 * In cases where there could be multiple encryption keys associated to the document, you should also provide a
	 * validator for the decrypted attachment: if you do after decrypting the result with the document encryption key
	 * the sdk  will also pass the decrypted result to the validator before considering the decryption as successful.
	 * This is because due to the nature of the AES-CBC encryption algorithm, it is impossible to know with 100%
	 * certainty if the data was decrypted correctly, therefore additional context is needed.
	 *
	 * @param document a document
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the document may have multiple encryption keys.
	 * @return the decrypted main attachment of the document if it could be correctly decrypted using the keys available
	 * to the current user, null otherwise.
	 */
	suspend fun getAndTryDecryptMainAttachment(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray?

	@Deprecated("You should just use getAndTryDecryptMainAttachment and decode the string yourself")
	suspend fun getAndTryDecryptMainAttachmentAsPlainText(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): String?

	@Deprecated("You should just use getAndTryDecryptMainAttachment and parse the json yourself")
	suspend fun getAndTryDecryptMainAttachmentAsJson(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): JsonElement?

	/**
	 * Similar to [getAndTryDecryptMainAttachment] but throws an exception instead of returning null if the attachment
	 * could not be decrypted.
	 * @param document a document
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the document may have multiple encryption keys.
	 * @return the decrypted main attachment of the document
	 * @throws EntityEncryptionException if the main attachment of the document could not be decrypted
	 */
	suspend fun getAndDecryptMainAttachment(
		document: Document,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray

	/**
	 * Encrypts the provided main attachment using the key of the document and then saves it to the backend, overwriting
	 * the previous attachment if any.
	 * @param document a document
	 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 * If null and there is already a main attachment for the document the current utis will be reused, otherwise it
	 * null will be considered as an empty list. In all other cases overwrites any existing value.
	 * @param attachment the clear main attachment to encrypt and set
	 * @throws EntityEncryptionException if the current user does not have access to any encryption key of the provided
	 * document.
	 * @return the updated document
	 */
	suspend fun encryptAndSetMainAttachment(document: Document, utis: List<String>?, attachment: ByteArray): EncryptedDocument

	/**
	 * Same as [getAndDecryptMainAttachment] but instead of getting the main attachment of the entity gets the secondary
	 * attachment associated with the provided key.
	 * @param document a document
	 * @param key the key of a secondary attachment in the document
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the document may have multiple encryption keys.
	 * @return the decrypted secondary attachment of the document associated with the provided key
	 * @throws EntityEncryptionException if the main attachment of the document could not be decrypted
	 */
	suspend fun getAndDecryptSecondaryAttachment(
		document: Document,
		key: String,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray

	/**
	 * Encrypts the provided secondary attachment using the key of the document and then saves it to the backend,
	 * overwriting the previous attachment if any.
	 * @param document a document
	 * @param key a key to distinguish the secondary attachment from other secondary attachments. The key can be any
	 * string except for the id of the document, which is by convention reserved for the main attachment of the document.
	 * @param utis uniform type identifiers for the attachment (https://en.wikipedia.org/wiki/Uniform_Type_Identifier).
	 * If null and there is already a secondary attachment at key for the document the current utis will be reused,
	 * otherwise it null will be considered as an empty list. In all other cases overwrites any existing value.
	 * @param attachment the clear main attachment to encrypt and set
	 * @throws EntityEncryptionException if the current user does not have access to any encryption key of the provided
	 * document.
	 * @return the updated document
	 */
	suspend fun encryptAndSetSecondaryAttachment(
		document: Document,
		key: String,
		utis: List<String>?,
		attachment: ByteArray,
	): EncryptedDocument

	/**
	 * Attempts to extract the encryption keys of a document. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param document a document
	 * @return the encryption keys extracted from the provided document.
	 */
	suspend fun getEncryptionKeysOf(document: Document): Set<HexString>

	/**
	 * Specifies if the current user has write access to a document.
	 * @param document a document
	 * @return if the current user has write access to the provided document
	 */
	suspend fun hasWriteAccess(document: Document): Boolean

	/**
	 * Attempts to extract the patient id linked to a document.
	 * Note: documents usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param document a document
	 * @return the id of the patient linked to the document, or empty if the current user can't access any patient id
	 * of the document.
	 */
	suspend fun decryptPatientIdOf(document: Document): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a document.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided document. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the document the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Document,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a document E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any document that you have shared with P, H will be able to know that the document was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a document that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a document
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Document, delegates: Set<String>)

	/**
	 * Decrypts a document, throwing an exception if it is not possible.
	 * @param document a document
	 * @return the decrypted document
	 * @throws EntityEncryptionException if the document could not be decrypted
	 */
	suspend fun decrypt(document: EncryptedDocument): DecryptedDocument

	/**
	 * Tries to decrypt a document, returns the input if it is not possible.
	 * @param document an encrypted document
	 * @return the decrypted document if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(document: EncryptedDocument): Document

	/**
	 * Tries to decrypt the attachment of a document, returning null if it is not possible. This method can be used
	 * to decrypt an already retrieved raw attachment.
	 *
	 * In cases where there could be multiple encryption keys associated to the document, you should also provide a
	 * validator for the decrypted attachment: if you do after decrypting the result with the document encryption key
	 * the sdk  will also pass the decrypted result to the validator before considering the decryption as successful.
	 * This is because due to the nature of the AES-CBC encryption algorithm, it is impossible to know with 100%
	 * certainty if the data was decrypted correctly, therefore additional context is needed.
	 *
	 * @param document a document
	 * @param encryptedAttachment a raw attachment of the document
	 * @param decryptedAttachmentValidator a function to verify if the attachment was decrypted correctly. Should be
	 * provided in cases where the document may have multiple encryption keys.
	 * @return the decrypted attachment if it could be decrypted using the keys available to the current data owner,
	 * null otherwise.
	 */
	suspend fun tryDecryptAttachment(
		document: Document,
		encryptedAttachment: ByteArray,
		@DefaultValue("null")
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)? = null
	): ByteArray?

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: DocumentFlavouredApi<EncryptedDocument>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: DocumentFlavouredApi<Document>
}

interface DocumentBasicApi : DocumentBasicFlavourlessApi, DocumentBasicFlavouredApi<EncryptedDocument>

@InternalIcureApi
private abstract class AbstractDocumentBasicFlavouredApi<E : Document>(protected val rawApi: RawDocumentApi) :
	DocumentBasicFlavouredApi<E> {
	override suspend fun modifyDocument(entity: E) =
		rawApi.modifyDocument(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getDocument(entityId: String) = rawApi.getDocument(entityId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getDocumentByExternalUuid(externalUuid: String) =
		rawApi.getDocumentByExternalUuid(externalUuid).successBody().let { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun getDocumentsByExternalUuid(externalUuid: String) =
		rawApi.getDocumentsByExternalUuid(externalUuid).successBody().map { maybeDecrypt(it) }

	override suspend fun getDocuments(entityIds: List<String>) =
		rawApi.getDocuments(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun modifyDocuments(entities: List<E>) =
		rawApi.modifyDocuments(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: List<String>,
	) =
		rawApi.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode, ListOfIds(secretMessageKeys)).successBody()
			.map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
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
		options: DocumentShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			document.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: DocumentShareOptions()),
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

	@Deprecated("Will be replaced by filter")
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

	@Deprecated("You should just use getRawMainAttachment and decode the string yourself")
	override suspend fun getMainAttachmentAsPlainText(documentId: String): String = getRawMainAttachment(documentId).decodeToString()

	@Suppress("DEPRECATION")
	@Deprecated("You should just use getRawMainAttachment and parse the json yourself")
	override suspend fun getMainAttachmentAsJson(documentId: String): JsonElement = getMainAttachmentAsPlainText(documentId).let {
		Serialization.json.parseToJsonElement(it)
	}

	override suspend fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	) =
		rawApi.setDocumentAttachment(documentId, rev, utis, attachment, attachment.size.toLong(), encrypted).successBody()

	override suspend fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: List<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	) =
		rawApi.setSecondaryAttachment(documentId, key, rev, utis, attachment, attachment.size.toLong(), encrypted).successBody()

	override suspend fun deleteMainAttachment(entityId: String, rev: String) =
		rawApi.deleteAttachment(entityId, rev).successBody()

	override suspend fun deleteSecondaryAttachment(documentId: String, key: String, rev: String) =
		rawApi.deleteSecondaryAttachment(documentId, key, rev).successBody()
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
			decrypt(it)
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

	@Deprecated("You should just use getAndTryDecryptMainAttachment and decode the string yourself")
	override suspend fun getAndTryDecryptMainAttachmentAsPlainText(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): String? = getAndTryDecryptMainAttachment(document, decryptedAttachmentValidator)?.decodeToString()

	@Suppress("DEPRECATION")
	@Deprecated("You should just use getAndTryDecryptMainAttachment and parse the json yourself")
	override suspend fun getAndTryDecryptMainAttachmentAsJson(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): JsonElement? = getAndTryDecryptMainAttachmentAsPlainText(document, decryptedAttachmentValidator)?.let {
		Serialization.json.parseToJsonElement(it)
	}

	override suspend fun getAndDecryptMainAttachment(
		document: Document,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	) =
		rawApi.getMainAttachment(document.id).successBody().let {
			crypto.entity.decryptAttachmentOf(document.withTypeInfo(), it, decryptedAttachmentValidator)
		}

	override suspend fun encryptAndSetMainAttachment(document: Document, utis: List<String>?, attachment: ByteArray): EncryptedDocument {
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
		utis: List<String>?,
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

	private suspend fun decryptOrNull(entity: EncryptedDocument): DecryptedDocument? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedDocument.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(it) }

	override suspend fun decrypt(document: EncryptedDocument): DecryptedDocument =
		decryptOrNull(document) ?: throw EntityEncryptionException("Document cannot be decrypted")

	override suspend fun tryDecrypt(document: EncryptedDocument): Document =
		decryptOrNull(document) ?: document

	override suspend fun tryDecryptAttachment(
		document: Document,
		encryptedAttachment: ByteArray,
		decryptedAttachmentValidator: (suspend (document: ByteArray) -> Boolean)?
	): ByteArray? =
		crypto.entity.tryDecryptAttachmentOf(document.withTypeInfo(), encryptedAttachment, decryptedAttachmentValidator)
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
