package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.api.ReceiptBasicApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavouredApi
import com.icure.cardinal.sdk.api.ReceiptBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ReceiptFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawReceiptApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
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
private abstract class AbstractReceiptBasicFlavouredApi<E : Receipt>(
	protected val rawApi: RawReceiptApi
) : ReceiptBasicFlavouredApi<E>, FlavouredApi<EncryptedReceipt, E> {
	override suspend fun createReceipt(entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createReceipt(
			validateAndMaybeEncrypt(null, entity),
		).successBody().let { maybeDecrypt(null, it) }
	}

	override suspend fun modifyReceipt(entity: E): E =
		rawApi.modifyReceipt(validateAndMaybeEncrypt(null, entity)).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun getReceipt(entityId: String): E =
		rawApi.getReceipt(entityId).successBody().let { maybeDecrypt(null, it) }

	override suspend fun listByReference(reference: String): List<E> =
		rawApi.listByReference(reference).successBody().let { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractReceiptFlavouredApi<E : Receipt>(
	rawApi: RawReceiptApi,
	protected val config: ApiConfiguration,
) : AbstractReceiptBasicFlavouredApi<E>(rawApi), ReceiptFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		receipt: E,
		options: ReceiptShareOptions?,
	): E =
		shareWithMany(receipt, mapOf(delegateId to (options ?: ReceiptShareOptions())))

	override suspend fun shareWithMany(receipt: E, delegates: Map<String, ReceiptShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			receipt,
			EntityWithEncryptionMetadataTypeName.Receipt,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getReceipt(it) },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
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
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedReceipt>
	): List<EncryptedReceipt> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Receipt,
			DecryptedReceipt.serializer(),
			this.config.encryption.receipt,
		) { Serialization.json.decodeFromJsonElement<EncryptedReceipt>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedReceipt>
	): List<DecryptedReceipt> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Receipt,
			EncryptedReceipt.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }

}, ReceiptBasicFlavourlessApi by AbstractReceiptBasicFlavourlessApi(rawApi) {
	override val encrypted: ReceiptFlavouredApi<EncryptedReceipt> =
		object : AbstractReceiptFlavouredApi<EncryptedReceipt>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedReceipt>
			): List<EncryptedReceipt> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Receipt,
					EncryptedReceipt.serializer(),
					config.encryption.receipt
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedReceipt>
			): List<EncryptedReceipt> = entities
		}

	override val tryAndRecover: ReceiptFlavouredApi<Receipt> =
		object : AbstractReceiptFlavouredApi<Receipt>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Receipt>
			): List<EncryptedReceipt> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Receipt,
					EncryptedReceipt.serializer(),
					DecryptedReceipt.serializer(),
					config.encryption.receipt
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedReceipt>
			): List<Receipt> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Receipt,
					EncryptedReceipt.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }
		}

	override suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedReceipt =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedReceipt(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Receipt,
			patient?.let {
				OwningEntityDetails(
					null,
					it.id,
					config.crypto.entity.resolveSecretIdOption(
						null,
						it,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty()).keyAsLocalDataOwnerReferences(),
		).updatedEntity

	override suspend fun getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: String) =
		rawApi.getReceiptAttachment(receipt.id, attachmentId).successBody().let {
			val aesKey = config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(
				null,
				listOf(receipt),
				EntityWithEncryptionMetadataTypeName.Receipt
			)[receipt.id]?.key
				?: throw EntityEncryptionException("Cannot extract decryption key from Receipt(\"${receipt.id}\")")
			config.crypto.primitives.aes.decrypt(it, aesKey)
		}

	override suspend fun getEncryptionKeysOf(receipt: Receipt): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(null, receipt, EntityWithEncryptionMetadataTypeName.Receipt, null)

	override suspend fun hasWriteAccess(receipt: Receipt): Boolean =
		config.crypto.entity.hasWriteAccess(null, receipt, EntityWithEncryptionMetadataTypeName.Receipt)

	override suspend fun decryptPatientIdOf(receipt: Receipt): Set<String> =
		config.crypto.entity.owningEntityIdsOf(null, receipt, EntityWithEncryptionMetadataTypeName.Receipt, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Receipt,
			delegates.asLocalDataOwnerReferences()
		)
	}

	override suspend fun logReceipt(user: User, docId: String, refs: List<String>, blobType: String, blob: ByteArray): Receipt {
		val newReceipt = withEncryptionMetadata(
			base = DecryptedReceipt(
				id = config.crypto.primitives.strongRandom.randomUUID(),
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
		val aesKey = config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(
			null,
			listOf(receipt),
			EntityWithEncryptionMetadataTypeName.Receipt
		)[receipt.id]?.key
			?: throw EntityEncryptionException("Cannot extract encryption key from receipt")
		val payload = config.crypto.primitives.aes.encrypt(attachment, aesKey)
		return rawApi.setReceiptAttachment(
			receipt.id,
			receipt.rev ?: throw IllegalArgumentException("Receipt must have a revision set before setting the attachment"),
			blobType,
			payload,
		).successBody()
	}

	override suspend fun decrypt(receipt: EncryptedReceipt): DecryptedReceipt =
		config.crypto.entity.decryptEntities(
			null,
			listOf(receipt),
			EntityWithEncryptionMetadataTypeName.Receipt,
			EncryptedReceipt.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }.single()

	override suspend fun tryDecrypt(receipt: EncryptedReceipt): Receipt =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(receipt),
			EntityWithEncryptionMetadataTypeName.Receipt,
			EncryptedReceipt.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedReceipt>(config.jsonPatcher.patchReceipt(it)) }.single()
}

@InternalIcureApi
internal class ReceiptBasicApiImpl(
	rawApi: RawReceiptApi,
	private val config: BasicApiConfiguration
) : ReceiptBasicApi, ReceiptBasicFlavouredApi<EncryptedReceipt> by object :
	AbstractReceiptBasicFlavouredApi<EncryptedReceipt>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedReceipt>
	): List<EncryptedReceipt> =
		config.crypto.validationService.validateEncryptedEntities(
			entities,
			EntityWithEncryptionMetadataTypeName.Receipt,
			EncryptedReceipt.serializer(),
			config.encryption.receipt
		)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedReceipt>
	): List<EncryptedReceipt> = entities
}, ReceiptBasicFlavourlessApi by AbstractReceiptBasicFlavourlessApi(rawApi)