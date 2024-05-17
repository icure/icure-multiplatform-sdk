package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
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
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawPatientApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawPatientApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Patient)

	// region common endpoints

	override suspend fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byNameBirthSsinAuto")
				parameter("healthcarePartyId", healthcarePartyId)
				parameter("filterValue", filterValue)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "ofHcParty", hcPartyId)
				parameter("sortField", sortField)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listOfMergesAfter(date: Long): HttpResponse<List<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "merges", "$date")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findPatientsModifiedAfter(
		date: Long,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "modifiedAfter", "$date")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "hcParty", hcPartyId)
				parameter("sortField", sortField)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getPatientHcPartyKeysForDelegate(patientId: String): HttpResponse<Map<String, String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId, "keys")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getPatientAesExchangeKeysForDelegate(
		patientId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId, "aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun countOfPatients(hcPartyId: String): HttpResponse<EncryptedContent> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "hcParty", hcPartyId, "count")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		sortDirection: SortDirection,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient")
				parameter("hcPartyId", hcPartyId)
				parameter("sortField", sortField)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("sortDirection", sortDirection)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byHcPartyId")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getPatientByExternalId(externalId: String): HttpResponse<EncryptedPatient> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byExternalId", externalId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byAccess", userId)
				parameter("accessType", accessType)
				parameter("startDate", startDate)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun filterPatientsBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skip: Int?,
		sort: String?,
		desc: Boolean?,
		filterChain: FilterChain<EncryptedPatient>,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "filter")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("skip", skip)
				parameter("sort", sort)
				parameter("desc", desc)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun matchPatientsBy(filter: AbstractFilter<EncryptedPatient>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	override suspend fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Int?,
	): HttpResponse<List<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "fuzzy")
				parameter("firstName", firstName)
				parameter("lastName", lastName)
				parameter("dateOfBirth", dateOfBirth)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createPatient(p: EncryptedPatient): HttpResponse<EncryptedPatient> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(p)
		}.wrap()

	override suspend fun deletePatients(patientIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun deletePatient(patientId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findDeletedPatients(
		startDate: Long,
		endDate: Long?,
		desc: Boolean?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "deleted", "byDate")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("desc", desc)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listDeletedPatientsByName(
		firstName: String?,
		lastName: String?,
	): HttpResponse<List<EncryptedPatient>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "deleted", "by_name")
				parameter("firstName", firstName)
				parameter("lastName", lastName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun undeletePatient(patientIds: String): HttpResponse<List<DocIdentifier>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "undelete", patientIds)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun getPatients(patientIds: ListOfIds): HttpResponse<List<EncryptedPatient>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientIds)
		}.wrap()

	override suspend fun getPatient(patientId: String): HttpResponse<EncryptedPatient> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): HttpResponse<EncryptedPatient> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", hcPartyId, id)
				parameter("system", system)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<IdWithRev>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun modifyPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientDto)
		}.wrap()

	override suspend fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Long?,
		end: Long?,
	): HttpResponse<EncryptedPatient> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", patientId, "referral", referralId)
				parameter("start", start)
				parameter("end", end)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "duplicates", "ssin")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "duplicates", "name")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedPatient>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatient,
	): HttpResponse<EncryptedPatient> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "mergeInto", intoId, "from", fromId)
				parameter("expectedFromRev", expectedFromRev)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(updatedInto)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		p: EncryptedPatient,
	): HttpResponse<DataOwnerRegistrationSuccess> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "patient", "register", "forHcp", hcPartyId, "inGroup", groupId)
				parameter("token", token)
				parameter("useShortToken", useShortToken)
				parameter("createAutoDelegation", createAutoDelegation)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(p)
		}.wrap()

	// endregion
}