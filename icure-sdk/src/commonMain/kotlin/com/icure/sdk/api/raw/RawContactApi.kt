package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawContactApi {
	// region common endpoints

	suspend fun getEmptyContent(): HttpResponse<EncryptedContent>

	suspend fun createContact(c: EncryptedContact): HttpResponse<EncryptedContact>

	suspend fun getContact(contactId: String): HttpResponse<EncryptedContact>

	suspend fun getContacts(contactIds: ListOfIds): HttpResponse<List<EncryptedContact>>

	suspend fun getServiceCodesOccurrences(
		codeType: String,
		minOccurrences: Long,
	): HttpResponse<List<LabelledOccurence>>

	suspend fun listContactByHCPartyServiceId(
		hcPartyId: String,
		serviceId: String,
	): HttpResponse<List<EncryptedContact>>

	suspend fun listContactsByExternalId(externalId: String): HttpResponse<List<EncryptedContact>>

	suspend fun listContactsByHCPartyAndFormId(
		hcPartyId: String,
		formId: String,
	): HttpResponse<List<EncryptedContact>>

	suspend fun listContactsByHCPartyAndFormIds(
		hcPartyId: String,
		formIds: ListOfIds,
	): HttpResponse<List<EncryptedContact>>

	suspend fun listContactsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		patientForeignKeys: ListOfIds,
	): HttpResponse<List<EncryptedContact>>

	suspend fun listContactIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretFKeys: String,
		planOfActionsIds: String? = null,
		skipClosedContacts: Boolean? = null,
	): HttpResponse<List<EncryptedContact>>

	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String? = null,
		skipClosedContacts: Boolean? = null,
	): HttpResponse<List<EncryptedContact>>

	suspend fun listContactsDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>>

	suspend fun findContactsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>>

	suspend fun closeForHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedContact>>

	suspend fun deleteContacts(contactIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteContact(contactId: String): HttpResponse<DocIdentifier>

	suspend fun modifyContact(contactDto: EncryptedContact): HttpResponse<EncryptedContact>

	suspend fun modifyContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>>

	suspend fun createContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>>

	suspend fun filterContactsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<EncryptedContact>,
	): HttpResponse<PaginatedList<EncryptedContact>>

	suspend fun matchContactsBy(filter: AbstractFilter<EncryptedContact>): HttpResponse<List<String>>

	suspend fun getService(serviceId: String): HttpResponse<EncryptedService>

	suspend fun filterServicesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<EncryptedService>,
	): HttpResponse<PaginatedList<EncryptedService>>

	suspend fun matchServicesBy(filter: AbstractFilter<EncryptedService>): HttpResponse<List<String>>

	suspend fun getServices(ids: ListOfIds): HttpResponse<List<EncryptedService>>

	suspend fun getServicesLinkedTo(
		linkType: String? = null,
		ids: ListOfIds,
	): HttpResponse<List<EncryptedService>>

	suspend fun listServicesByAssociationId(associationId: String): HttpResponse<List<EncryptedService>>

	suspend fun listServicesByHealthElementId(
		healthElementId: String,
		hcPartyId: String,
	): HttpResponse<List<EncryptedService>>

	suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedContact>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedContact>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedContact>>>
	// endregion
}
