package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.wrap
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
import com.icure.sdk.serialization.HealthcarePartyAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawHealthcarePartyApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawHealthcarePartyApi {
	// region common endpoints

	override suspend fun getCurrentHealthcareParty(): HttpResponse<HealthcareParty> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "current")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findHealthcarePartiesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
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

	override suspend fun findHealthcarePartiesByName(
		name: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
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

	override suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean,
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

	override suspend fun listHealthcarePartiesByName(name: String): HttpResponse<List<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byNameStrict", name)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
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

	override suspend fun createHealthcareParty(h: HealthcareParty): HttpResponse<HealthcareParty> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(h)
		}.wrap()

	override suspend fun getAesExchangeKeysForDelegate(
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

	override suspend fun getHealthcareParty(healthcarePartyId: String): HttpResponse<HealthcareParty> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<HealthcareParty>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun listHealthcarePartiesByParentId(parentId: String): HttpResponse<List<HealthcareParty>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", parentId, "children")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getPublicKey(healthcarePartyId: String): HttpResponse<PublicKey> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId, "publicKey")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun deleteHealthcareParties(healthcarePartyIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyIds)
		}.wrap()

	override suspend fun deleteHealthcareParty(healthcarePartyId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", healthcarePartyId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyHealthcareParty(healthcarePartyDto: HealthcareParty): HttpResponse<HealthcareParty> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthcarePartyDto)
		}.wrap()

	override suspend fun matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "hcparty", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBodyWithSerializer(HealthcarePartyAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun filterHealthPartiesBy(
		startDocumentId: String?,
		limit: Int?,
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

	override suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: ListOfIds?,
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

	override suspend fun deleteHealthcarePartiesInGroup(
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

	override suspend fun deleteHealthcarePartyInGroup(
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

	override suspend fun modifyHealthcarePartyInGroup(
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

	override suspend fun createHealthcarePartyInGroup(
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

	override suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String?,
		token: String?,
		useShortToken: Boolean?,
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
