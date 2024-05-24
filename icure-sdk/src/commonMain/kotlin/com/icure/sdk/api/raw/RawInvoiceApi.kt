package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawInvoiceApi {
	// region common endpoints

	suspend fun createInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun deleteInvoice(invoiceId: String): HttpResponse<DocIdentifier>

	suspend fun getInvoice(invoiceId: String): HttpResponse<EncryptedInvoice>

	suspend fun getInvoices(invoiceIds: ListOfIds): HttpResponse<List<EncryptedInvoice>>

	suspend fun modifyInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun reassignInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun mergeTo(
		invoiceId: String,
		ids: ListOfIds,
	): HttpResponse<EncryptedInvoice>

	suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): HttpResponse<EncryptedInvoice>

	suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String? = null,
		invoiceId: String? = null,
		gracePeriod: Int? = null,
		invoicingCodes: List<EncryptedInvoicingCode>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long? = null,
		toDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedInvoice>>

	suspend fun listInvoicesByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun findInvoicesByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>>

	suspend fun listInvoiceIdsByDataOwnerPatientInvoiceDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>>

	suspend fun listInvoicesByHcPartyAndGroupId(
		hcPartyId: String,
		groupId: String,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long? = null,
		to: Long? = null,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByContactIds(contactIds: ListOfIds): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByRecipientsIds(recipientIds: String): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToInsurances(userIds: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToInsurancesUnsent(userIds: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToPatients(hcPartyId: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToPatientsUnsent(hcPartyId: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByIds(invoiceIds: String): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String? = null,
		status: String? = null,
		from: Long? = null,
		to: Long? = null,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByServiceIds(serviceIds: String): HttpResponse<List<EncryptedInvoice>>

	suspend fun listAllHcpsByStatus(
		status: String,
		from: Long? = null,
		to: Long? = null,
		hcpIds: ListOfIds,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun getTarificationsCodesOccurrences(minOccurrences: Long): HttpResponse<List<LabelledOccurence>>

	suspend fun filterInvoicesBy(filterChain: FilterChain<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun modifyInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun createInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedInvoice>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion
}
