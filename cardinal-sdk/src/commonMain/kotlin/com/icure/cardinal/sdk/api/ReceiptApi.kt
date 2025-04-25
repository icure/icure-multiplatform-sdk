package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface ReceiptBasicFlavourlessApi {
	suspend fun deleteReceipt(entityId: String): DocIdentifier
	suspend fun deleteReceipts(entityIds: List<String>): List<DocIdentifier>
	suspend fun getRawReceiptAttachment(receiptId: String, attachmentId: String): ByteArray
	suspend fun setRawReceiptAttachment(receiptId: String, rev: String, blobType: String, attachment: ByteArray): EncryptedReceipt
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface ReceiptBasicFlavouredApi<E : Receipt> {
	suspend fun createReceipt(entity: E): E
	suspend fun modifyReceipt(entity: E): E
	suspend fun getReceipt(entityId: String): E?
	suspend fun listByReference(reference: String): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface ReceiptFlavouredApi<E : Receipt> : ReceiptBasicFlavouredApi<E> {
	suspend fun shareWith(
		delegateId: String,
		receipt: E,
		@DefaultValue("null")
		options: ReceiptShareOptions? = null
	): E

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
@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface ReceiptApi : ReceiptBasicFlavourlessApi, ReceiptFlavouredApi<DecryptedReceipt> {
	suspend fun withEncryptionMetadata(
		base: DecryptedReceipt?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
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

@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface ReceiptBasicApi : ReceiptBasicFlavourlessApi, ReceiptBasicFlavouredApi<EncryptedReceipt>

