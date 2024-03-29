package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.model.Contact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedIcureStub
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.Content
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
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
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawContactApi(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
			accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Contact)

	// region common endpoints

	suspend fun getEmptyContent(): HttpResponse<Content> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","content","empty")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createContact(c: Contact): HttpResponse<EncryptedContact> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun getContact(contactId: String): HttpResponse<EncryptedContact> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact",contactId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getContacts(contactIds: ListOfIds): HttpResponse<List<EncryptedContact>> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactIds)
		}.wrap()


	suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long):
			HttpResponse<List<LabelledOccurence>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","codes",codeType,"$minOccurrences")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
			HttpResponse<List<EncryptedContact>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartyServiceId")
				parameter("hcPartyId", hcPartyId)
				parameter("serviceId", serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listContactsByExternalId(externalId: String):
			HttpResponse<List<EncryptedContact>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byExternalId")
				parameter("externalId", externalId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			HttpResponse<List<EncryptedContact>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartyFormId")
				parameter("hcPartyId", hcPartyId)
				parameter("formId", formId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: ListOfIds):
			HttpResponse<List<EncryptedContact>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartyFormIds")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(formIds)
		}.wrap()


	suspend fun listContactsByHCPartyAndPatientForeignKeys(hcPartyId: String,
			patientForeignKeys: ListOfIds): HttpResponse<List<EncryptedContact>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartyPatientForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(patientForeignKeys)
		}.wrap()


	suspend fun findContactsByHCPartyPatientForeignKey(
		hcPartyId: String,
		patientForeignKey: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedContact, JsonString>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartyPatientForeignKey")
				parameter("hcPartyId", hcPartyId)
				parameter("patientForeignKey", patientForeignKey)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretFKeys: String,
		planOfActionsIds: String? = null,
		skipClosedContacts: Boolean? = null,
	): HttpResponse<List<EncryptedContact>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("planOfActionsIds", planOfActionsIds)
				parameter("skipClosedContacts", skipClosedContacts)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		planOfActionsIds: String? = null,
		skipClosedContacts: Boolean? = null,
	): HttpResponse<List<EncryptedContact>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("planOfActionsIds", planOfActionsIds)
				parameter("skipClosedContacts", skipClosedContacts)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun listContactsDelegationsStubsByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretFKeys: String): HttpResponse<List<EncryptedIcureStub>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartySecretForeignKeys","delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findContactsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: List<String>): HttpResponse<List<EncryptedIcureStub>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartySecretForeignKeys","delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretFKeys: String):
			HttpResponse<List<EncryptedContact>> = put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byHcPartySecretForeignKeys","close")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun deleteContacts(contactIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactIds)
		}.wrap()


	suspend fun deleteContact(contactId: String): HttpResponse<DocIdentifier> = delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact",contactId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyContact(contactDto: Contact): HttpResponse<EncryptedContact> = put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDto)
		}.wrap()


	suspend fun modifyContacts(contactDtos: List<Contact>): HttpResponse<List<EncryptedContact>>
			= put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDtos)
		}.wrap()


	suspend fun createContacts(contactDtos: List<Contact>): HttpResponse<List<EncryptedContact>>
			= post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(contactDtos)
		}.wrap()


	suspend fun filterContactsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Contact>,
	): HttpResponse<PaginatedList<EncryptedContact, *>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun matchContactsBy(filter: AbstractFilter<Contact>): HttpResponse<List<String>> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()


	suspend fun getService(serviceId: String): HttpResponse<EncryptedService> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service",serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun filterServicesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Service>,
	): HttpResponse<PaginatedList<EncryptedService, Nothing>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun matchServicesBy(filter: AbstractFilter<Service>): HttpResponse<List<String>> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()


	suspend fun getServices(ids: ListOfIds): HttpResponse<List<EncryptedService>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun getServicesLinkedTo(linkType: String? = null, ids: ListOfIds):
			HttpResponse<List<EncryptedService>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","linkedTo")
				parameter("linkType", linkType)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ids)
		}.wrap()


	suspend fun listServicesByAssociationId(associationId: String):
			HttpResponse<List<EncryptedService>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","associationId")
				parameter("associationId", associationId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listServicesByHealthElementId(healthElementId: String, hcPartyId: String):
			HttpResponse<List<EncryptedService>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","service","healthElementId",healthElementId)
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedContact, JsonString>> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","byOpeningDate")
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


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedContact>>> = put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedContact>>> = put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","contact","bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}
