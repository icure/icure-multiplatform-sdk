package com.icure.sdk.api.flavoured

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.raw.RawReceiptApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
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
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
private val ENCRYPTED_FIELDS_MANIFEST =
	EncryptedFieldsManifest("Receipt.", emptySet(), emptyMap(), emptyMap(), emptyMap())

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
		healthcareElement: E,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite,
	): SimpleShareResult<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface ReceiptApi : ReceiptBasicFlavourlessApi, ReceiptFlavouredApi<DecryptedReceipt> {
	suspend fun createReceipt(entity: DecryptedReceipt): DecryptedReceipt
	suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedReceipt,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): DecryptedReceipt
	suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String): ByteArray
	suspend fun encryptAndSetReceiptAttachment(receipt: Receipt, blobType: String, attachment: ByteArray): EncryptedReceipt


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
	private val encryptionService: EntityEncryptionService,
) : AbstractReceiptBasicFlavouredApi<E>(rawApi), ReceiptFlavouredApi<E> {
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
	private val encryptionService: EntityEncryptionService,
	private val cryptoService: CryptoService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : ReceiptApi, ReceiptFlavouredApi<DecryptedReceipt> by object :
	AbstractReceiptFlavouredApi<DecryptedReceipt>(rawApi, encryptionService) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedReceipt): EncryptedReceipt =
		encryptionService.encryptEntity(
			entity.withTypeInfo(),
			DecryptedReceipt.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedReceipt): DecryptedReceipt {
		return encryptionService.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedReceipt.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, ReceiptBasicFlavourlessApi by AbstractReceiptBasicFlavourlessApi(rawApi) {
	override val encrypted: ReceiptFlavouredApi<EncryptedReceipt> =
		object : AbstractReceiptFlavouredApi<EncryptedReceipt>(rawApi, encryptionService) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedReceipt): EncryptedReceipt =
				encryptionService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedReceipt.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedReceipt): EncryptedReceipt = entity
		}

	override val tryAndRecover: ReceiptFlavouredApi<Receipt> =
		object : AbstractReceiptFlavouredApi<Receipt>(rawApi, encryptionService) {
			override suspend fun maybeDecrypt(entity: EncryptedReceipt): Receipt =
				encryptionService.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedReceipt.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Receipt): EncryptedReceipt = when (entity) {
				is EncryptedReceipt -> encryptionService.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedReceipt.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedReceipt -> encryptionService.encryptEntity(
					entity.withTypeInfo(),
					DecryptedReceipt.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }
			}
		}

	override suspend fun createReceipt(entity: DecryptedReceipt): DecryptedReceipt {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the initialiseEncryptionMetadata for that very purpose." }
		return rawApi.createReceipt(
			encrypt(entity),
		).successBody().let {
			decrypt(it) { "Created entity cannot be decrypted" }
		}
	}

	override suspend fun initialiseEncryptionMetadata(
		healthcareElement: DecryptedReceipt,
		patient: Patient,
		user: User,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedReceipt =
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

	override suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String) =
		rawApi.getReceiptAttachment(receipt.id, attachmentId).successBody().let {
			val aesKey = encryptionService.tryDecryptAndImportAnyEncryptionKey(receipt.withTypeInfo())?.key
				?: throw EntityEncryptionException("Cannot extract decryption key from receipt")
			cryptoService.aes.decrypt(it, aesKey)
		}

	override suspend fun encryptAndSetReceiptAttachment(receipt: Receipt, blobType: String, attachment: ByteArray): EncryptedReceipt {
		val aesKey = encryptionService.tryDecryptAndImportAnyEncryptionKey(receipt.withTypeInfo())?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from receipt")
		val payload = cryptoService.aes.encrypt(attachment, aesKey)
		return rawApi.setReceiptAttachment(
			receipt.id,
			receipt.rev ?: throw IllegalArgumentException("Receipt must have a revision set before setting the attachment"),
			blobType,
			payload,
		).successBody()
	}

	private suspend fun encrypt(entity: DecryptedReceipt) = encryptionService.encryptEntity(
		entity.withTypeInfo(),
		DecryptedReceipt.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	suspend fun decrypt(entity: EncryptedReceipt, errorMessage: () -> String): DecryptedReceipt = encryptionService.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedReceipt.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(it) }
		?: throw EntityEncryptionException(errorMessage())

}

@InternalIcureApi
internal class ReceiptBasicApiImpl(
	rawApi: RawReceiptApi,
	private val validationService: EntityValidationService,
	private val fieldsToEncrypt: EncryptedFieldsManifest = ENCRYPTED_FIELDS_MANIFEST,
) : ReceiptBasicApi, ReceiptBasicFlavouredApi<EncryptedReceipt> by object :
	AbstractReceiptBasicFlavouredApi<EncryptedReceipt>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedReceipt): EncryptedReceipt =
		validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedReceipt.serializer(), fieldsToEncrypt)

	override suspend fun maybeDecrypt(entity: EncryptedReceipt): EncryptedReceipt = entity
}, ReceiptBasicFlavourlessApi by AbstractReceiptBasicFlavourlessApi(rawApi)
