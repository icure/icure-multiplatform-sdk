package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
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
class RawContactApiImpl(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawContactApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Contact)

	// region common endpoints

	override suspend fun getEmptyContent(): HttpResponse<EncryptedContent> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "content", "empty")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createContact(c: EncryptedContact): HttpResponse<EncryptedContact> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getContact(contactId: String): HttpResponse<EncryptedContact> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", contactId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getContacts(contactIds: ListOfIds): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun getServiceCodesOccurrences(
		codeType: String,
		minOccurrences: Long,
	): HttpResponse<List<LabelledOccurence>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "codes", codeType, "$minOccurrences")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listContactByHCPartyServiceId(
		hcPartyId: String,
		serviceId: String,
	): HttpResponse<List<EncryptedContact>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyServiceId")
				parameter("hcPartyId", hcPartyId)
				parameter("serviceId", serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listContactsByExternalId(externalId: String): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byExternalId")
				parameter("externalId", externalId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun listContactsByHCPartyAndFormId(
		hcPartyId: String,
		formId: String,
	): HttpResponse<List<EncryptedContact>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyFormId")
				parameter("hcPartyId", hcPartyId)
				parameter("formId", formId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listContactsByHCPartyAndFormIds(
		hcPartyId: String,
		formIds: ListOfIds,
	): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyFormIds")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun listContactsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		patientForeignKeys: ListOfIds,
	): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyPatientForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientForeignKeys)
		}.wrap()

	override suspend fun listContactIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byDataOwnerPatientOpeningDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretFKeys: String,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): HttpResponse<List<EncryptedContact>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("planOfActionsIds", planOfActionsIds)
				parameter("skipClosedContacts", skipClosedContacts)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("planOfActionsIds", planOfActionsIds)
				parameter("skipClosedContacts", skipClosedContacts)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun listContactsDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findContactsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun closeForHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedContact>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartySecretForeignKeys", "close")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun deleteContacts(contactIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun deleteContact(contactId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", contactId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyContact(contactDto: EncryptedContact): HttpResponse<EncryptedContact> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDto)
		}.wrap()

	override suspend fun modifyContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun createContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun filterContactsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<EncryptedContact>,
	): HttpResponse<PaginatedList<EncryptedContact>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun matchContactsBy(filter: AbstractFilter<EncryptedContact>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	override suspend fun getService(serviceId: String): HttpResponse<EncryptedService> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun filterServicesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<EncryptedService>,
	): HttpResponse<PaginatedList<EncryptedService>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun matchServicesBy(filter: AbstractFilter<EncryptedService>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	override suspend fun getServices(ids: ListOfIds): HttpResponse<List<EncryptedService>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun getServicesLinkedTo(
		linkType: String?,
		ids: ListOfIds,
	): HttpResponse<List<EncryptedService>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "linkedTo")
				parameter("linkType", linkType)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun listServicesByAssociationId(associationId: String): HttpResponse<List<EncryptedService>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "associationId")
				parameter("associationId", associationId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listServicesByHealthElementId(
		healthElementId: String,
		hcPartyId: String,
	): HttpResponse<List<EncryptedService>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "healthElementId", healthElementId)
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedContact>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byOpeningDate")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedContact>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedContact>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
