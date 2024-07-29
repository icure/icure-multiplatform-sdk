package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawEntityReferenceApi
import com.icure.sdk.api.raw.RawInvoiceApi
import com.icure.sdk.crypto.entities.InvoiceShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.EntityReference
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.data.LabelledOccurence
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.InvoicingCode
import com.icure.sdk.model.embed.MediumType
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
import com.icure.sdk.utils.currentFuzzyDateTime
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

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

	@Deprecated("Will be replaced by filter")
	suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E>

	@Deprecated("Will be replaced by filter")
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
	 * the initialise encryption metadata method.
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
	 * the initialise encryption metadata method.
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
	 * the initialise encryption metadata method.
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

	@Deprecated("Will be replaced by filter")
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
	 * Create a new invoice. The provided invoice must have the encryption metadata initialised.
	 * @param entity an invoice with initialised encryption metadata
	 * @return the created invoice with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialised.
	 */
	suspend fun createInvoice(entity: DecryptedInvoice, prefix: String?): DecryptedInvoice

	/**
	 * Create multiple invoices. All the provided invoices must have the encryption metadata initialised, otherwise
	 * this method fails without doing anything.
	 * @param entities invoices with initialised encryption metadata
	 * @return the created invoices with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of any invoice in the input was not initialised.
	 */
	suspend fun createInvoices(entities: List<DecryptedInvoice>): List<DecryptedInvoice>

	/**
	 * Creates a new invoice with initialised encryption metadata
	 * @param base an invoice with initialised content and uninitialised encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the invoice.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new invoice
	 * @return an invoice with initialised encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
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

@InternalIcureApi
private abstract class AbstractInvoiceBasicFlavouredApi<E : Invoice>(protected val rawApi: RawInvoiceApi) :
	InvoiceBasicFlavouredApi<E> {
	override suspend fun modifyInvoice(entity: E): E =
		rawApi.modifyInvoice(validateAndMaybeEncrypt(entity)).successBody().let { maybeDecrypt(it) }

	override suspend fun modifyInvoices(entities: List<E>): List<E> =
		rawApi.modifyInvoices(entities.map { validateAndMaybeEncrypt(it) }).successBody().map { maybeDecrypt(it) }

	override suspend fun getInvoice(entityId: String): E = rawApi.getInvoice(entityId).successBody().let { maybeDecrypt(it) }
	override suspend fun getInvoices(entityIds: List<String>): List<E> =
		rawApi.getInvoices(ListOfIds(entityIds)).successBody().map { maybeDecrypt(it) }

	override suspend fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.findInvoicesByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody().map { maybeDecrypt(it) }

	override suspend fun reassignInvoice(invoice: E): E =
		rawApi.reassignInvoice(validateAndMaybeEncrypt(invoice)).successBody().let { maybeDecrypt(it) }

	override suspend fun mergeTo(
		invoiceId: String,
		ids: List<String>,
		) = rawApi.mergeTo(invoiceId, ListOfIds(ids)).successBody().let { maybeDecrypt(it) }

	override suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
		): E = rawApi.validate(invoiceId, scheme, forcedValue).successBody().let { maybeDecrypt(it) }

	//TODO: Maybe manage a separate manifest for InvoicingCode and encrypt automatically
	override suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String?,
		invoiceId: String?,
		gracePeriod: Int?,
		invoicingCodes: List<EncryptedInvoicingCode>,
		): List<E> =
		rawApi.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId, invoiceId, gracePeriod, invoicingCodes).successBody().map { maybeDecrypt(it) }

	override suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
		): List<E> =
		rawApi.removeCodes(userId, serviceId, secretFKeys, tarificationIds).successBody().map { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterInvoicesBy()"))
	override suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long?,
		toDate: Long?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
		) = rawApi.findInvoicesByAuthor(hcPartyId, fromDate, toDate, startKey.encodeStartKey(), startDocumentId, limit).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String, secretPatientKeys: List<String>): List<E> =
		rawApi.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, secretPatientKeys.joinToString(",")).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): List<E> =
		rawApi.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long?,
		to: Long?,
	) = rawApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId, sentMediumType, invoiceType, sent, from, to).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByContactIds(contactIds: List<String>): List<E> =
		rawApi.listInvoicesByContactIds(ListOfIds(contactIds)).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByRecipientsIds(recipientsIds: List<String>): List<E> =
		rawApi.listInvoicesByRecipientsIds(recipientsIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listToInsurances(userIds: List<String>): List<E> =
		rawApi.listToInsurances(userIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listToInsurancesUnsent(userIds: List<String>): List<E> =
		rawApi.listToInsurancesUnsent(userIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listToPatients(hcPartyId: String): List<E> =
		rawApi.listToPatients(hcPartyId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listToPatientsUnsent(hcPartyId: String?): List<E> =
		rawApi.listToPatientsUnsent(hcPartyId).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByIds(ids: List<String>): List<E> =
		rawApi.listInvoicesByIds(ids.joinToString(",")).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Long,
		to: Long,
	): List<E> = rawApi.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status, from, to).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E> =
		rawApi.listInvoicesByServiceIds(serviceIds.joinToString(",")).successBody().map { maybeDecrypt(it) }

	@Deprecated("Will be replaced by filter")
	override suspend fun listAllHcpsByStatus(
		status: String,
		from: Long?,
		to: Long?,
		hcpIds: List<String>,
		): List<E> =
		rawApi.listAllHcpsByStatus(status, from, to, ListOfIds(hcpIds)).successBody().map { maybeDecrypt(it) }


	abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedInvoice
	abstract suspend fun maybeDecrypt(entity: EncryptedInvoice): E
}

@InternalIcureApi
private abstract class AbstractInvoiceFlavouredApi<E : Invoice>(
	rawApi: RawInvoiceApi,
	private val config: ApiConfiguration
) : AbstractInvoiceBasicFlavouredApi<E>(rawApi), InvoiceFlavouredApi<E> {
	protected val crypto get() = config.crypto
	protected val fieldsToEncrypt get() = config.encryption.invoice

	override suspend fun shareWith(
		delegateId: String,
		invoice: E,
		options: InvoiceShareOptions?,
	): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			invoice.withTypeInfo(),
			true,
			mapOf(
				delegateId to (options ?: InvoiceShareOptions()),
			),
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun tryShareWithMany(invoice: E, delegates: Map<String, InvoiceShareOptions>): SimpleShareResult<E> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			invoice.withTypeInfo(),
			true,
			delegates
		) {
			rawApi.bulkShare(it).successBody().map { r -> r.map { he -> maybeDecrypt(he) } }
		}

	override suspend fun shareWithMany(invoice: E, delegates: Map<String, InvoiceShareOptions>): E =
		tryShareWithMany(invoice, delegates).updatedEntityOrThrow()

	@Deprecated("Will be replaced by filter")
	override suspend fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listInvoiceIdsByDataOwnerPatientInvoiceDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(crypto.entity.secretIdsOf(patient.withTypeInfo(), null).toList())
		).successBody()
	) { ids ->
		rawApi.getInvoices(ListOfIds(ids)).successBody().map { maybeDecrypt(it) }
	}

}

@InternalIcureApi
private class AbstractInvoiceBasicFlavourlessApi(
	private val rawApi: RawInvoiceApi
) : InvoiceBasicFlavourlessApi {
	override suspend fun deleteInvoice(entityId: String) = rawApi.deleteInvoice(entityId).successBody()
	@Deprecated("Will be replaced by filter")
	override suspend fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	) = rawApi.findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId, secretPatientKeys).successBody()

	override suspend fun getTarificationsCodesOccurrences(
		minOccurrence: Int,
	) = rawApi.getTarificationsCodesOccurrences(minOccurrence.toLong()).successBody()

}

@InternalIcureApi
internal class InvoiceApiImpl(
	private val rawApi: RawInvoiceApi,
	private val rawEntityReferenceApi: RawEntityReferenceApi,
	private val config: ApiConfiguration,
) : InvoiceApi, InvoiceFlavouredApi<DecryptedInvoice> by object :
	AbstractInvoiceFlavouredApi<DecryptedInvoice>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(entity: DecryptedInvoice): EncryptedInvoice =
		crypto.entity.encryptEntity(
			entity.withTypeInfo(),
			DecryptedInvoice.serializer(),
			fieldsToEncrypt,
		) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }

	override suspend fun maybeDecrypt(entity: EncryptedInvoice): DecryptedInvoice {
		return crypto.entity.tryDecryptEntity(
			entity.withTypeInfo(),
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(it) }
			?: throw EntityEncryptionException("Entity ${entity.id} cannot be created")
	}
}, InvoiceBasicFlavourlessApi by AbstractInvoiceBasicFlavourlessApi(rawApi) {
	override val encrypted: InvoiceFlavouredApi<EncryptedInvoice> =
		object : AbstractInvoiceFlavouredApi<EncryptedInvoice>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(entity: EncryptedInvoice): EncryptedInvoice =
				crypto.entity.validateEncryptedEntity(entity.withTypeInfo(), EncryptedInvoice.serializer(), fieldsToEncrypt)

			override suspend fun maybeDecrypt(entity: EncryptedInvoice): EncryptedInvoice = entity
		}

	override val tryAndRecover: InvoiceFlavouredApi<Invoice> =
		object : AbstractInvoiceFlavouredApi<Invoice>(rawApi, config) {
			override suspend fun maybeDecrypt(entity: EncryptedInvoice): Invoice =
				crypto.entity.tryDecryptEntity(
					entity.withTypeInfo(),
					EncryptedInvoice.serializer(),
				) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(it) }
					?: entity

			override suspend fun validateAndMaybeEncrypt(entity: Invoice): EncryptedInvoice = when (entity) {
				is EncryptedInvoice -> crypto.entity.validateEncryptedEntity(
					entity.withTypeInfo(),
					EncryptedInvoice.serializer(),
					fieldsToEncrypt,
				)

				is DecryptedInvoice -> crypto.entity.encryptEntity(
					entity.withTypeInfo(),
					DecryptedInvoice.serializer(),
					fieldsToEncrypt,
				) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }
			}
		}

	private suspend fun createInvoice(entity: DecryptedInvoice): DecryptedInvoice {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createInvoice(
			encrypt(entity),
		).successBody().let {
			decrypt(it)
		}
	}

	private suspend fun getNextInvoiceReference(prefix: String): Int =
		rawEntityReferenceApi.getLatest(prefix).successBodyOrNull()
			?.takeIf { it.id.startsWith(prefix) }
			?.id?.split(":")?.last()
			?.toIntOrNull()?.plus(1) ?: 1

	private suspend fun createInvoiceReference(nextReference: Int, invoiceId: String, prefix: String): EntityReference = rawEntityReferenceApi.createEntityReference(
		EntityReference(
			id = buildString {
				append(prefix)
				if(!prefix.endsWith(":")) {
					append(":")
				}
				append("$nextReference".padStart(6, '0'))
			},
			docId = invoiceId
		)
	).successBody()

	override suspend fun createInvoice(entity: DecryptedInvoice, prefix: String?): DecryptedInvoice = if(prefix != null) {
		val invoiceReference = createInvoiceReference(getNextInvoiceReference(prefix), entity.id, prefix)
		if(entity.internshipNihii != null) {
			entity.copy(invoiceReference = invoiceReference.id.split(":", limit = 2).last().replace("0", "1"))
		} else {
			entity.copy(invoiceReference = invoiceReference.id.split(":", limit = 2).last())
		}.let { createInvoice(it) }
	} else {
		createInvoice(entity)
	}

	override suspend fun createInvoices(entities: List<DecryptedInvoice>): List<DecryptedInvoice> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialised. You can use the withEncryptionMetadata for that very purpose." }
		return rawApi.createInvoices(
			entities.map {
				encrypt(it)
			},
		).successBody().map {
			decrypt(it)
		}
	}

	private val crypto get() = config.crypto
	private val fieldsToEncrypt get() = config.encryption.invoice

	override suspend fun getEncryptionKeysOf(invoice: Invoice): Set<HexString> = crypto.entity.encryptionKeysOf(invoice.withTypeInfo(), null)

	override suspend fun hasWriteAccess(invoice: Invoice): Boolean = crypto.entity.hasWriteAccess(invoice.withTypeInfo())

	override suspend fun decryptPatientIdOf(invoice: Invoice): Set<String> = crypto.entity.owningEntityIdsOf(invoice.withTypeInfo(), null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entity.withTypeInfo(), delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdOption,
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedInvoice =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			(base ?: DecryptedInvoice(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
				groupId = base?.groupId ?: base?.id,
				invoiceDate = base?.invoiceDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
			).withTypeInfo(),
			patient?.id,
			patient?.let { crypto.entity.resolveSecretIdOption(it.withTypeInfo(), secretId) },
			initialiseEncryptionKey = true,
			initialiseSecretId = false,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData).orEmpty(),
		).updatedEntity

	private suspend fun encrypt(entity: DecryptedInvoice) = crypto.entity.encryptEntity(
		entity.withTypeInfo(),
		DecryptedInvoice.serializer(),
		fieldsToEncrypt,
	) { Serialization.json.decodeFromJsonElement<EncryptedInvoice>(it) }

	private suspend fun decryptOrNull(entity: EncryptedInvoice): DecryptedInvoice? = crypto.entity.tryDecryptEntity(
		entity.withTypeInfo(),
		EncryptedInvoice.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(it) }

	override suspend fun decrypt(invoice: EncryptedInvoice): DecryptedInvoice =
		decryptOrNull(invoice) ?: throw EntityEncryptionException("Invoice cannot be decrypted")

	override suspend fun tryDecrypt(invoice: EncryptedInvoice): Invoice =
		decryptOrNull(invoice) ?: invoice
}

@InternalIcureApi
internal class InvoiceBasicApiImpl(
	rawApi: RawInvoiceApi,
	private val config: BasicApiConfiguration
) : InvoiceBasicApi, InvoiceBasicFlavouredApi<EncryptedInvoice> by object :
	AbstractInvoiceBasicFlavouredApi<EncryptedInvoice>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(entity: EncryptedInvoice): EncryptedInvoice =
		config.crypto.validationService.validateEncryptedEntity(entity.withTypeInfo(), EncryptedInvoice.serializer(), config.encryption.invoice)

	override suspend fun maybeDecrypt(entity: EncryptedInvoice): EncryptedInvoice = entity
}, InvoiceBasicFlavourlessApi by AbstractInvoiceBasicFlavourlessApi(rawApi)
