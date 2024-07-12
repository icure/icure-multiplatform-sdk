package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawReceiptApi
import com.icure.sdk.crypto.entities.ReceiptShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedReceipt
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Receipt
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
import kotlinx.serialization.json.decodeFromJsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ReceiptBasicFlavourlessApi {
	suspend fun deleteReceipt(entityId: String): DocIdentifier
	suspend fun deleteReceipts(entityIds: List<String>): List<DocIdentifier>
	suspend fun getRawReceiptAttachment(receiptId: String, attachmentId: String): ByteArray
	suspend fun setRawReceiptAttachment(receiptId: String, rev: String, blobType: String, attachment: ByteArray): EncryptedReceipt
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ReceiptBasicFlavouredApi<E : Receipt> {
	suspend fun modifyReceipt(entity: E): E
	suspend fun getReceipt(entityId: String): E
	suspend fun listByReference(reference: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ReceiptFlavouredApi<E : Receipt> : ReceiptBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		receipt: E,
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
	 * @param receipt the [Receipt] to share.
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
		receipt: E,
		delegates: Map<String, ReceiptShareOptions>
	): SimpleShareResult<E>

	/**
	 * Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 * encrypted content, with read-only or read-write permissions.
	 * @param receipt the [Receipt] to share.
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
		receipt: E,
		delegates: Map<String, ReceiptShareOptions>
	): E
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ReceiptApi : ReceiptBasicFlavourlessApi, ReceiptFlavouredApi<DecryptedReceipt> {
	suspend fun createReceipt(entity: DecryptedReceipt): DecryptedReceipt
	suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedReceipt
	suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String): ByteArray
	suspend fun encryptAndSetReceiptAttachment(receipt: Receipt, blobType: String, attachment: ByteArray): EncryptedReceipt
	suspend fun getEncryptionKeysOf(receipt: Receipt): Set<HexString>
	suspend fun hasWriteAccess(receipt: Receipt): Boolean
	suspend fun decryptPatientIdOf(receipt: Receipt): Set<String>
	suspend fun createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Set<String>)
	suspend fun logReceipt(user: User, docId: String, refs: List<String>, blobType: String, blob: ByteArray): Receipt
	suspend fun decrypt(receipt: EncryptedReceipt): DecryptedReceipt
	suspend fun tryDecrypt(receipt: EncryptedReceipt): Receipt

	val encrypted: ReceiptFlavouredApi<EncryptedReceipt>
	val tryAndRecover: ReceiptFlavouredApi<Receipt>
}

interface ReceiptBasicApi : ReceiptBasicFlavourlessApi, ReceiptBasicFlavouredApi<EncryptedReceipt>

@InternalIcureApi
private abstract class AbstractReceiptBasicFlavouredApi<E : Receipt>(protected val rawApi: RawReceiptApi) :
	ReceiptBasicFlavouredApi<E> {
	override suspend fun modifyReceipt(entity: E): E =
		rawApi.modifyReceipt(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun getReceipt(entityId: String): E = rawApi.getReceipt(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun listByReference(reference: String): List<E> =
		rawApi.listByReference(reference).successBody().map { maybeDecrypt(it) }

	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedReceipt
	abstract suspend fun maybeDecrypt(entity: EncryptedReceipt): E
}

@InternalIcureApi
private abstract class AbstractReceiptFlavouredApi<E : Receipt>(
	rawApi: RawReceiptApi,
	private val config: ApiConfiguration,
) : AbstractReceiptBasicFlavouredApi<E>(rawApi), ReceiptFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.receipt

	override suspend fun shareWith(
		delegateId: String,
		receipt: E,
		shareEncryptionKeys: ShareMetadataBehaviour,
		shareOwningEntityIds: ShareMetadataBehaviour,
		requestedPermission: RequestedPermission,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			receipt.withTypeInfo(),
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

	override suspend fun tryShareWithMany(receipt: E, delegates: Map<String, ReceiptShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			receipt.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(receipt: E, delegates: Map<String, ReceiptShareOptions>): E =
		tryShareWithMany(receipt, delegates).updatedEntityOrThrow()
}

@InternalIcureApi
private class AbstractReceiptBasicFlavourlessApi(val rawApi: RawReceiptApi) : ReceiptBasicFlavourlessApi {
	override suspend fun deleteReceipt(entityId: String) = rawApi.deleteReceipt(entityId).successBody()
	override suspend fun deleteReceipts(entityIds: List<String>) = rawApi.deleteReceipts(ListOfIds(entityIds)).successBody()
	override suspend fun getRawReceiptAttachment(receiptId: String, attachmentId: String) =
		rawApi.getReceiptAttachment(receiptId, attachmentId).successBody()
	override suspend fun setRawReceiptAttachment(receiptId: String, rev: String, blobType: String, attachment: ByteArray) =
		rawApi.setReceiptAttachment(receiptId, rev, blobType, attachment).successBody()

}

@InternalIcureApi
internal class ReceiptApiImpl(
	private val rawApi: RawReceiptApi,
	private val config: ApiConfiguration
	) : ReceiptApi, ReceiptFlavouredApi<DecryptedReceipt> by object :
	AbstractReceiptFlavouredApi<DecryptedReceipt>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedReceipt): EncryptedReceipt =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedReceipt.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedReceipt): DecryptedReceipt {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedReceipt.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, ReceiptBasicFlavourlessApi by AbstractReceiptBasicFlavourlessApi(rawApi) {
	override val encrypted: ReceiptFlavouredApi<EncryptedReceipt> =
		object : AbstractReceiptFlavouredApi<EncryptedReceipt>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedReceipt): EncryptedReceipt =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedReceipt.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedReceipt): EncryptedReceipt = entity
		}

	override val tryAndRecover: ReceiptFlavouredApi<Receipt> =
		object : AbstractReceiptFlavouredApi<Receipt>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedReceipt): Receipt =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedReceipt.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Receipt): EncryptedReceipt = when (entity) {
				is EncryptedReceipt -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedReceipt.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedReceipt -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedReceipt.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }
			}
		}

	override suspend fun createReceipt(entity: DecryptedReceipt): DecryptedReceipt {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createReceipt(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.receipt

	override suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedReceipt =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedReceipt(crypto.primitives.strongRandom.randomUUID())).copy(
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

	override suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String) =
		rawApi.getReceiptAttachment(receipt.id, attachmentId).successBody().let {
			val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(receipt.withTypeInfo())?.key
				?: throw EntityEncryptionException("Cannot extract decryption key from receipt")
			crypto.primitives.aes.decrypt(it, aesKey)
		}

	override suspend fun getEncryptionKeysOf(receipt: Receipt): Set<HexString> = crypto.entity.encryptionKeysOf(receipt.withTypeInfo(), null)

	override suspend fun hasWriteAccess(receipt: Receipt): Boolean = crypto.entity.hasWriteAccess(receipt.withTypeInfo())

	override suspend fun decryptPatientIdOf(receipt: Receipt): Set<String> = crypto.entity.owningEntityIdsOf(receipt.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun logReceipt(user: User, docId: String, refs: List<String>, blobType: String, blob: ByteArray): Receipt {
		val newReceipt = withEncryptionMetadata(
			base = DecryptedReceipt(
				id = crypto.primitives.strongRandom.randomUUID(),
				documentId = docId,
				references = refs
			),
			user = user,
			patient = null
		).let { createReceipt(it) }
		checkNotNull(newReceipt.rev) {
			"Receipt creation failed"
		}
		return if(blob.isNotEmpty()) {
			setRawReceiptAttachment(newReceipt.id, newReceipt.rev, blobType, blob)
		} else {
			newReceipt
		}
	}

	override suspend fun encryptAndSetReceiptAttachment(receipt: Receipt, blobType: String, attachment: ByteArray): EncryptedReceipt {
		val aesKey = crypto.entity.tryDecryptAndImportAnyEncryptionKey(receipt.withTypeInfo())?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from receipt")
		val payload = crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setReceiptAttachment(
			receipt.id,
			receipt.rev ?: throw IllegalArgumentException("Receipt must have a revision set before setting the attachment"),
			blobType,
			payload,
		).successBody()
	}

	private suspend fun encrypt(entity: DecryptedReceipt) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedReceipt.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	suspend fun decrypt(entity: EncryptedReceipt, errorMessage: () -> String): DecryptedReceipt = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedReceipt.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(it) }
		?: throw EntityEncryptionException(errorMessage())

	override suspend fun decrypt(receipt: EncryptedReceipt): DecryptedReceipt =
		decrypt(receipt) { "Receipt cannot be decrypted" }

	override suspend fun tryDecrypt(receipt: EncryptedReceipt): Receipt = runCatching {
		decrypt(receipt)
	}.getOrDefault(receipt)
}

@InternalIcureApi
internal class ReceiptBasicApiImpl(
	rawApi: RawReceiptApi,
	private val config: BasicApiConfiguration
) : ReceiptBasicApi, ReceiptBasicFlavouredApi<EncryptedReceipt> by object :
	AbstractReceiptBasicFlavouredApi<EncryptedReceipt>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedReceipt): EncryptedReceipt =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedReceipt.serializer(), config.encryption.receipt)

	override suspend fun maybeDecrypt(entity: EncryptedReceipt): EncryptedReceipt = entity
}, ReceiptBasicFlavourlessApi by AbstractReceiptBasicFlavourlessApi(rawApi)
