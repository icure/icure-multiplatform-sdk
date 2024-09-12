package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.data.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.InvoicingCode
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.JsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface InvoiceBasicFlavourlessApi {
	/**
	 * Deletes an invoice. If you don't have write access to the invoice the method will fail.
	 * @param entityId id of the invoice.
	 * @return the id and revision of the deleted invoice.
	 */
	suspend fun deleteInvoice(entityId: String): DocIdentifier

	suspend fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<IcureStub>

	/**
	 * Gives an approximation of the amount of times each tarification code ([Invoice.invoicingCodes] ->
	 * [InvoicingCode.tarificationId]) is used in invoices where the current data owner is a direct delegate (does not
	 * count situations where the data owner has access to the service through delegations to a parent data owner).
	 * This number is not exact, and may be cached, so you should not use this method if you need precise values, but
	 * it can be useful if you want to give suggestions.
	 * Only codes that occur at least [minOccurrence] times will be used.
	 * @return the occurrences for each invoicing code that is used at least [minOccurrence] times.
	 */
	suspend fun getTarificationsCodesOccurrences(minOccurrence: Int): List<LabelledOccurence>

}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface InvoiceBasicFlavouredApi<E : Invoice> {
	/**
	 * Modifies an invoice. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity an invoice with update content
	 * @return the invoice updated with the provided content and a new revision.
	 */
	suspend fun modifyInvoice(entity: E): E

	/**
	 * Modifies multiple invoices. Ignores all invoices for which you don't have write access.
	 * Flavoured method.
	 * @param entities invoices with update content
	 * @return the updated invoices with a new revision.
	 */
	suspend fun modifyInvoices(entities: List<E>): List<E>

	/**
	 * Get an invoice by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not an invoice, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId an invoice id.
	 * @return the invoice with id [entityId].
	 */
	suspend fun getInvoice(entityId: String): E

	/**
	 * Get multiple invoices by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not an invoice, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of invoices ids
	 * @return all invoices that you can access with one of the provided ids.
	 */
	suspend fun getInvoices(entityIds: List<String>): List<E>

	suspend fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>

	suspend fun reassignInvoice(invoice: E): E

	suspend fun mergeTo(invoiceId: String, ids: List<String>): E

	suspend fun validate(invoiceId: String, scheme: String, forcedValue: String): E

	suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		@DefaultValue("null")
		insuranceId: String? = null,
		@DefaultValue("null")
		invoiceId: String? = null,
		@DefaultValue("null")
		gracePeriod: Int? = null,
		invoicingCodes: List<EncryptedInvoicingCode>
	): List<E>

	suspend fun removeCodes(userId: String, serviceId: String, secretFKeys: String, tarificationIds: List<String>): List<E>

	suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		@DefaultValue("null")
		fromDate: Long? = null,
		@DefaultValue("null")
		toDate: Long? = null,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<E>

	suspend fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E>

	suspend fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): List<E>

	suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null
	): List<E>

	suspend fun listInvoicesByContactIds(contactIds: List<String>): List<E>

	suspend fun listInvoicesByRecipientsIds(recipientsIds: List<String>): List<E>

	suspend fun listToInsurances(userIds: List<String>): List<E>

	suspend fun listToInsurancesUnsent(userIds: List<String>): List<E>

	suspend fun listToPatients(hcPartyId: String): List<E>

	suspend fun listToPatientsUnsent(hcPartyId: String?): List<E>

	suspend fun listInvoicesByIds(ids: List<String>): List<E>

	suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Long,
		to: Long
	): List<E>

	@Deprecated("Use filter instead")
	suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun listAllHcpsByStatus(
		status: String,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		hcpIds: List<String>
	): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface InvoiceFlavouredApi<E : Invoice> : InvoiceBasicFlavouredApi<E> {
	/**
	 * Share an invoice with another data owner. The invoice must already exist in the database for this method to
	 * succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the invoice
	 * @param invoice the invoice to share with [delegateId]
	 * @param options specifies how the invoice will be shared. By default, all data available to the current user
	 * will be shared, and the delegate will have the same permissions as the current user on the invoice. Refer
	 * to the documentation of [InvoiceShareOptions] for more information.
	 * @return the updated invoice if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		invoice: E,
		@DefaultValue("null")
		options: InvoiceShareOptions? = null
	): SimpleShareResult<E>

	/**
	 * Share an invoice with multiple data owners. The invoice must already exist in the database for this method to
	 * succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param invoice the invoice to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated invoice if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		invoice: E,
		delegates: Map<String, InvoiceShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share an invoice with multiple data owners. The invoice must already exist in the database for this method to
	 * succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param invoice the invoice to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated invoice.
	 */
	suspend fun shareWithMany(
		invoice: E,
		delegates: Map<String, InvoiceShareOptions>
	): E

	@Deprecated("Use filter instead")
	suspend fun findInvoicesByHcPartyPatient(
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
@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface InvoiceApi : InvoiceBasicFlavourlessApi, InvoiceFlavouredApi<DecryptedInvoice> {
	/**
	 * Create a new invoice. The provided invoice must have the encryption metadata initialized.
	 * @param entity an invoice with initialized encryption metadata
	 * @return the created invoice with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createInvoice(entity: DecryptedInvoice, prefix: String?): DecryptedInvoice

	/**
	 * Create multiple invoices. All the provided invoices must have the encryption metadata initialized, otherwise
	 * this method fails without doing anything.
	 * @param entities invoices with initialized encryption metadata
	 * @return the created invoices with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any invoice in the input was not initialized.
	 */
	suspend fun createInvoices(entities: List<DecryptedInvoice>): List<DecryptedInvoice>

	/**
	 * Creates a new invoice with initialized encryption metadata
	 * @param base an invoice with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the invoice.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new invoice
	 * @return an invoice with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedInvoice

	/**
	 * Attempts to extract the encryption keys of an invoice. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param invoice an invoice
	 * @return the encryption keys extracted from the provided invoice.
	 */
	suspend fun getEncryptionKeysOf(invoice: Invoice): Set<HexString>

	/**
	 * Specifies if the current user has write access to an invoice.
	 * @param invoice an invoice
	 * @return if the current user has write access to the provided invoice
	 */
	suspend fun hasWriteAccess(invoice: Invoice): Boolean

	/**
	 * Attempts to extract the patient id linked to an invoice.
	 * Note: invoices usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param invoice an invoice
	 * @return the id of the patient linked to the invoice, or empty if the current user can't access any patient id
	 * of the invoice.
	 */
	suspend fun decryptPatientIdOf(invoice: Invoice): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of an invoice.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided invoice. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the invoice the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Invoice,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have an invoice E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any invoice that you have shared with P, H will be able to know that the invoice was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to an invoice that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity an invoice
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Set<String>)

	/**
	 * Decrypts an invoice, throwing an exception if it is not possible.
	 * @param invoice an invoice
	 * @return the decrypted invoice
	 * @throws EntityEncryptionException if the invoice could not be decrypted
	 */
	suspend fun decrypt(invoice: EncryptedInvoice): DecryptedInvoice

	/**
	 * Tries to decrypt an invoice, returns the input if it is not possible.
	 * @param invoice an encrypted invoice
	 * @return the decrypted invoice if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(invoice: EncryptedInvoice): Invoice

	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: InvoiceFlavouredApi<EncryptedInvoice>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: InvoiceFlavouredApi<Invoice>
}

@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
interface InvoiceBasicApi : InvoiceBasicFlavourlessApi, InvoiceBasicFlavouredApi<EncryptedInvoice>

