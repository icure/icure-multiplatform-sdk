package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.api.ReceiptBasicApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavouredApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ReceiptFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawReceiptApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.User
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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractReceiptBasicFlavouredApi<E : Receipt>(protected val rawApi: RawReceiptApi) :
	ReceiptBasicFlavouredApi<E> {
	override suspend fun modifyReceipt(entity: E): E =
		rawApi.modifyReceipt(validateAndMaybeEncrypt(entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(it) }

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
		options: ReceiptShareOptions?,
	): E =
		shareWithMany(receipt, mapOf(delegateId to (options ?: ReceiptShareOptions())))

	override suspend fun shareWithMany(receipt: E, delegates: Map<String, ReceiptShareOptions>): E =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			receipt.withTypeInfo(),
			delegates,
			true,
			{ getReceipt(it).withTypeInfo() },
			{ rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } } }
		).updatedEntityOrThrow()

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
		crypto.entity.encryptEntities(
			entity.withTypeInfo(),
			DecryptedReceipt.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedReceipt): DecryptedReceipt {
		return crypto.entity.tryDecryptEntities(
			entity.withTypeInfo(),
			EncryptedReceipt.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }
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
				crypto.entity.tryDecryptEntities(
					entity.withTypeInfo(),
					EncryptedReceipt.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Receipt): EncryptedReceipt = when (entity) {
				is EncryptedReceipt -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedReceipt.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedReceipt -> crypto.entity.encryptEntities(
					entity.withTypeInfo(),
					DecryptedReceipt.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }
			}
		}

	override suspend fun createReceipt(entity: DecryptedReceipt): DecryptedReceipt {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createReceipt(
			encrypt(entity),
		).successBody().let { decrypt(it) }
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.receipt

	override suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedReceipt =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			(base ?: DecryptedReceipt(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initializeEncryptionKey = true,
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

	private suspend fun encrypt(entity: DecryptedReceipt) = crypto.entity.encryptEntities(
		entity.withTypeInfo(),
		DecryptedReceipt.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	private suspend fun decryptOrNull(entity: EncryptedReceipt): DecryptedReceipt? = crypto.entity.tryDecryptEntities(
		entity.withTypeInfo(),
		EncryptedReceipt.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }

	override suspend fun decrypt(receipt: EncryptedReceipt): DecryptedReceipt =
		decryptOrNull(receipt) ?: throw EntityEncryptionException("Receipt cannot be decrypted")

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