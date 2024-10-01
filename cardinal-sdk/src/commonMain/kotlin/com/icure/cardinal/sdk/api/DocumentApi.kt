package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.JsonElement
import kotlin.js.JsName

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface DocumentBasicFlavourlessApi {
	@Deprecated("Deletion without rev is unsafe")
	@JsName("deleteDocumentUnsafe")
	suspend fun deleteDocument(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	@JsName("deleteDocumentsUnsafe")
	suspend fun deleteDocuments(entityIds: List<String>): List<DocIdentifier>
	
	/**
	 * Deletes a document. If you don't have write access to the document the method will fail.
	 * @param entityId id of the document.
	 * @param rev the latest known rev of the document to delete
	 * @return the id and revision of the deleted document.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteDocumentById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many documents. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the documents to delete.
	 * @return the id and revision of the deleted documents. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteDocumentsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a document.
	 * @param id id of the document to purge
	 * @param rev latest revision of the document
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeDocumentById(id: String, rev: String)

	/**
	 * Deletes a document. If you don't have write access to the document the method will fail.
	 * @param document the document to delete
	 * @return the id and revision of the deleted document.
	 * @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	suspend fun deleteDocument(document: Document): DocIdentifier =
		deleteDocumentById(document.id, requireNotNull(document.rev) { "Can't delete an document that has no rev" })

	/**
	 * Deletes many documents. Ignores document for which you don't have write access or that don't match the latest revision.
	 * @param documents the documents to delete
	 * @return the id and revision of the deleted documents. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteDocuments(documents: List<Document>): List<DocIdentifier> =
		deleteDocumentsByIds(documents.map { document ->
			IdWithMandatoryRev(document.id, requireNotNull(document.rev) { "Can't delete an document that has no rev" })
		})

	/**
	 * Permanently deletes a document.
	 * @param document the document to purge.
	 * @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	suspend fun purgeDocument(document: Document) {
		purgeDocumentById(document.id, requireNotNull(document.rev) { "Can't delete an document that has no rev" })
	}
	
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
	 * 
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
	 * Restores a document that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteDocumentById(id: String, rev: String): E
	
	/**
	 * Restores a document that was marked as deleted.
	 * @param document the document to undelete
	 * @return the restored document.
	 * @throws RevisionConflictException if the provided document doesn't match the latest known revision
	 */
	suspend fun undeleteDocument(document: Document): E =
		undeleteDocumentById(document.id, requireNotNull(document.rev) { "Can't delete an document that has no rev" })

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

	@Deprecated("Use filter instead (then you can get the first result in case of multiple matches)")
	// Note: if multiple documents have the same uuid there is no discriminant field used to chose which one to return.
	// We need to either define a proper discriminant or remove this method.
	suspend fun getDocumentByExternalUuid(externalUuid: String): E

	@Deprecated("Use filter instead")
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

	@Deprecated("Use filter instead")
	suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: List<String>,
	): List<E>

	@Deprecated("Use filter instead")
	suspend fun findWithoutDelegation(limit: Int?): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface DocumentFlavouredApi<E : Document> : DocumentBasicFlavouredApi<E> {
	/**
	 * Share a document with another data owner. The document must already exist in the database for this method to
	 * succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the document
	 * @param document the document to share with [delegateId]
	 * @param options specifies how the document will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the document. Refer
	 * to the documentation of [DocumentShareOptions] for more information.
	 * @return the updated document if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		document: E,
		@DefaultValue("null")
		options: DocumentShareOptions? = null
	): E

	/**
	 * Share a document with multiple data owners. The document must already exist in the database for this method to
	 * succeed. If you want to share the document before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
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

	@Deprecated("Use filter instead")
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


	/**
	 * Get an iterator that iterates through all documents matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterDocumentsBySorted] instead.
	 *
	 * @param filter a document filter
	 * @return an iterator that iterates over all documents matching the provided filter.
	 */
	suspend fun filterDocumentsBy(
		filter: FilterOptions<Document>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all documents matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterDocumentsBy].
	 *
	 * @param filter a document filter
	 * @return an iterator that iterates over all documents matching the provided filter.
	 */
	suspend fun filterDocumentsBySorted(
		filter: SortableFilterOptions<Document>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface DocumentApi : DocumentBasicFlavourlessApi, DocumentFlavouredApi<DecryptedDocument> {
	/**
	 * Create a new document. The provided document must have the encryption metadata initialized.
	 * @param entity a document with initialized encryption metadata
	 * @return the created document with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createDocument(entity: DecryptedDocument): DecryptedDocument

	/**
	 * Creates a new document with initialized encryption metadata
	 * @param base a document with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param message the message linked to the document, if any.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [message] to use for the new document
	 * @return a document with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedDocument?,
		message: Message?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
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
	/**
	 * Get the ids of all documents matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchDocumentsBySorted] instead.
	 *
	 * @param filter a document filter
	 * @return a list of document ids
	 */
	suspend fun matchDocumentsBy(filter: FilterOptions<Document>): List<String>

	/**
	 * Get the ids of all documents matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchDocumentsBy].
	 *
	 * @param filter a document filter
	 * @return a list of document ids
	 */
	suspend fun matchDocumentsBySorted(filter: SortableFilterOptions<Document>): List<String>
}

interface DocumentBasicApi : DocumentBasicFlavourlessApi, DocumentBasicFlavouredApi<EncryptedDocument> {
	/**
	 * Get the ids of all documents matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchDocumentsBySorted] instead.
	 *
	 * @param filter a document filter
	 * @return a list of document ids
	 */
	suspend fun matchDocumentsBy(filter: BaseFilterOptions<Document>): List<String>

	/**
	 * Get the ids of all documents matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchDocumentsBy].
	 *
	 * @param filter a document filter
	 * @return a list of document ids
	 */
	suspend fun matchDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): List<String>

	/**
	 * Get an iterator that iterates through all documents matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterDocumentsBySorted] instead.
	 *
	 * @param filter a document filter
	 * @return an iterator that iterates over all documents matching the provided filter.
	 */
	suspend fun filterDocumentsBy(
		filter: BaseFilterOptions<Document>
	): PaginatedListIterator<EncryptedDocument>

	/**
	 * Get an iterator that iterates through all documents matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterDocumentsBy].
	 *
	 * @param filter a document filter
	 * @return an iterator that iterates over all documents matching the provided filter.
	 */
	suspend fun filterDocumentsBySorted(
		filter: BaseSortableFilterOptions<Document>
	): PaginatedListIterator<EncryptedDocument>
}

