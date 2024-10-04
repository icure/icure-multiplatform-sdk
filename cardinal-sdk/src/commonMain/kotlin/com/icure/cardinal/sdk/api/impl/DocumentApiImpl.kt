package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.DocumentApi
import com.icure.cardinal.sdk.api.DocumentBasicApi
import com.icure.cardinal.sdk.api.DocumentBasicFlavouredApi
import com.icure.cardinal.sdk.api.DocumentBasicFlavourlessApi
import com.icure.cardinal.sdk.api.DocumentFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawDocumentApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapDocumentFilterOptions
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Message
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
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractDocumentBasicFlavouredApi<E : Document>(protected val rawApi: RawDocumentApi) :
	DocumentBasicFlavouredApi<E> {
	override suspend fun undeleteDocumentById(id: String, rev: String): E =
		rawApi.undeleteDocument(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }

	override suspend fun modifyDocument(entity: E) =
		rawApi.modifyDocument(validateAndMaybeEncrypt(entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }

	override suspend fun getDocument(entityId: String) = rawApi.getDocument(entityId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getDocumentByExternalUuid(externalUuid: String) =
		rawApi.getDocumentByExternalUuid(externalUuid).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun getDocumentsByExternalUuid(externalUuid: String) =
		rawApi.getDocumentsByExternalUuid(externalUuid).successBody().map { maybeDecrypt(it) }

	override suspend fun getDocuments(entityIds: List<String>) =
		rawApi.getDocuments(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun modifyDocuments(entities: List<E>) =
		rawApi.modifyDocuments(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: List<String>,
	) =
		rawApi.listDocumentsByHcPartyMessageForeignKeys(hcPartyId, documentTypeCode, ListOfIds(secretMessageKeys)).successBody()
			.map { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
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
	): E =
		shareWithMany(document, mapOf(Pair(delegateId, options ?: DocumentShareOptions())))

	override suspend fun shareWithMany(document: E, delegates: Map<String, DocumentShareOptions>): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			document.withTypeInfo(),
			delegates,
			true,
			{ getDocument(it).withTypeInfo() },
			{ rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } } }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
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

	override suspend fun filterDocumentsBySorted(filter: SortableFilterOptions<Document>): PaginatedListIterator<E> =
		filterDocumentsBy(filter)

	override suspend fun filterDocumentsBy(filter: FilterOptions<Document>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchDocumentsBy(
				mapDocumentFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					null
				)
			).successBody(),
			::getDocuments
		)
}

@InternalIcureApi
private class AbstractDocumentBasicFlavourlessApi(val rawApi: RawDocumentApi) : DocumentBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteDocumentUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteDocument(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteDocumentsUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteDocuments(ListOfIds(entityIds)).successBody()
	
	override suspend fun deleteDocumentById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteDocument(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteDocumentsByIds(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier> =
		rawApi.deleteDocumentsWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeDocumentById(id: String, rev: String) {
		rawApi.purgeDocument(id, rev).successBodyOrThrowRevisionConflict()
	}

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
		) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(config.jsonPatcher.patchDocument(it)) }
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
				) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(config.jsonPatcher.patchDocument(it)) }
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
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
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
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedDocument =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedDocument(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			message?.id,
			message?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initializeEncryptionKey = true,
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
	) { Serialization.json.decodeFromJsonElement<DecryptedDocument>(config.jsonPatcher.patchDocument(it)) }

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

	override suspend fun matchDocumentsBy(filter: FilterOptions<Document>): List<String> =
		rawApi.matchDocumentsBy(
			mapDocumentFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				null
			)
		).successBody()

	override suspend fun matchDocumentsBySorted(filter: SortableFilterOptions<Document>): List<String> =
		matchDocumentsBy(filter)
}

@InternalIcureApi
internal class DocumentBasicApiImpl(
	private val rawApi: RawDocumentApi,
	private val config: BasicApiConfiguration
) : DocumentBasicApi, DocumentBasicFlavouredApi<EncryptedDocument> by object :
	AbstractDocumentBasicFlavouredApi<EncryptedDocument>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedDocument): EncryptedDocument =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedDocument.serializer(), config.encryption.document)

	override suspend fun maybeDecrypt(entity: EncryptedDocument): EncryptedDocument = entity
}, DocumentBasicFlavourlessApi by AbstractDocumentBasicFlavourlessApi(rawApi) {
	override suspend fun matchDocumentsBy(filter: BaseFilterOptions<Document>): List<String> =
		rawApi.matchDocumentsBy(
			mapDocumentFilterOptions(filter, null, null)
		).successBody()

	override suspend fun matchDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): List<String> =
		matchDocumentsBy(filter)

	override suspend fun filterDocumentsBy(filter: BaseFilterOptions<Document>): PaginatedListIterator<EncryptedDocument> =
		IdsPageIterator(
			matchDocumentsBy(filter),
			::getDocuments
		)

	override suspend fun filterDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): PaginatedListIterator<EncryptedDocument> =
		filterDocumentsBy(filter)
}