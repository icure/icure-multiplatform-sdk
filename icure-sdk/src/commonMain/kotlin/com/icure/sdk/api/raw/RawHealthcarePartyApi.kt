package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.PublicKey
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
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
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawHealthcarePartyApi(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout) {
	// region common endpoints

	suspend fun getCurrentHealthcareParty(): HttpResponse<HealthcareParty> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "current")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findHealthcarePartiesBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		desc: Boolean? = null,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("desc", desc)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findHealthcarePartiesByName(
		name: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		desc: Boolean? = null,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byName")
				parameter("name", name)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("desc", desc)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		desc: Boolean = false,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byNihiiOrSsin", searchValue)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("desc", desc)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listHealthcarePartiesByName(name: String): HttpResponse<List<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byNameStrict", name)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "bySpecialityAndPostCode", type, spec, firstCode, "to", lastCode)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun createHealthcareParty(h: HealthcareParty): HttpResponse<HealthcareParty> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(h)
		}.wrap()

	suspend fun getAesExchangeKeysForDelegate(
		healthcarePartyId: String,
	): HttpResponse<Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "aesExchangeKeys")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getHealthcareParty(healthcarePartyId: String): HttpResponse<HealthcareParty> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<HealthcareParty>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	suspend fun listHealthcarePartiesByParentId(parentId: String): HttpResponse<List<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", parentId, "children")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getPublicKey(healthcarePartyId: String): HttpResponse<PublicKey> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "publicKey")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun deleteHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	suspend fun deleteHealthcareParty(healthcarePartyId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun modifyHealthcareParty(healthcarePartyDto: HealthcareParty): HttpResponse<HealthcareParty> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyDto)
		}.wrap()

	suspend fun matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	suspend fun filterHealthPartiesBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<HealthcareParty>,
	): HttpResponse<PaginatedList<HealthcareParty>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	// endregion

	// region cloud endpoints

	suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds? =
			null,
	): HttpResponse<List<HealthcareParty>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId, "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	suspend fun deleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds,
	): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	suspend fun deleteHealthcarePartyInGroup(
		healthcarePartyId: String,
		groupId: String,
	): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "inGroup", groupId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun modifyHealthcarePartyInGroup(
		groupId: String,
		healthcarePartyDto: HealthcareParty,
	): HttpResponse<HealthcareParty> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyDto)
		}.wrap()

	suspend fun createHealthcarePartyInGroup(
		groupId: String,
		h: HealthcareParty,
	): HttpResponse<HealthcareParty> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(h)
		}.wrap()

	suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String? = null,
		token: String? = null,
		useShortToken: Boolean? = null,
		hcp: HealthcareParty,
	): HttpResponse<DataOwnerRegistrationSuccess> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "register", "inGroup", groupId)
				parameter("parentHcPartyId", parentHcPartyId)
				parameter("token", token)
				parameter("useShortToken", useShortToken)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(hcp)
		}.wrap()

	// endregion
}
