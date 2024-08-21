package com.icure.sdk.api.raw

import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawPatientApi {
	// region common endpoints

	suspend fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String? = null,
		filterValue: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listOfMergesAfter(date: Long): HttpResponse<List<EncryptedPatient>>

	suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun getPatientHcPartyKeysForDelegate(patientId: String): HttpResponse<Map<String, String>>

	suspend fun getPatientAesExchangeKeysForDelegate(
		patientId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>

	suspend fun countOfPatients(hcPartyId: String): HttpResponse<EncryptedContent>

	suspend fun findPatientsByHealthcareParty(
		hcPartyId: String? = null,
		sortField: String = "name",
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		sortDirection: SortDirection = SortDirection.Asc,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<String>>

	suspend fun getPatientByExternalId(externalId: String): HttpResponse<EncryptedPatient>

	suspend fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun filterPatientsBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null,
		filterChain: FilterChain<Patient>,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun matchPatientsBy(filter: AbstractFilter<Patient>): HttpResponse<List<String>>

	suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int? = null,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun createPatient(p: EncryptedPatient): HttpResponse<EncryptedPatient>

	suspend fun deletePatients(patientIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deletePatient(patientId: String): HttpResponse<DocIdentifier>

	suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long? = null,
		desc: Boolean? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun listDeletedPatientsByName(
		firstName: String? = null,
		lastName: String? = null,
	): HttpResponse<List<EncryptedPatient>>

	suspend fun undeletePatient(patientIds: String): HttpResponse<List<DocIdentifier>>

	suspend fun getPatients(patientIds: ListOfIds): HttpResponse<List<EncryptedPatient>>

	suspend fun getPatient(patientId: String): HttpResponse<EncryptedPatient>

	suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String? = null,
	): HttpResponse<EncryptedPatient>

	suspend fun createPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>>

	suspend fun modifyPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>>

	suspend fun modifyPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient>

	suspend fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Long? = null,
		end: Long? = null,
	): HttpResponse<EncryptedPatient>

	suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatient,
	): HttpResponse<EncryptedPatient>
	// endregion

	// region cloud endpoints

	suspend fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String? = null,
		useShortToken: Boolean? = null,
		createAutoDelegation: Boolean = true,
		p: EncryptedPatient,
	): HttpResponse<DataOwnerRegistrationSuccess>

	suspend fun matchPatientsInGroupBy(
		groupId: String,
		filter: AbstractFilter<Patient>,
	): HttpResponse<List<String>>
	// endregion
}
