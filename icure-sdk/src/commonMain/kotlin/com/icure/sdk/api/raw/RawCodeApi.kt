package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
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
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCodeApi(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout) {
	// region common endpoints

	suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byLabel")
				parameter("region", region)
				parameter("types", types)
				parameter("language", language)
				parameter("label", label)
				parameter("version", version)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findCodesByType(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code")
				parameter("region", region)
				parameter("type", type)
				parameter("code", code)
				parameter("version", version)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun findCodesByLink(
		linkType: String,
		linkedId: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byLink", linkType)
				parameter("linkedId", linkedId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
	): HttpResponse<List<Code>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byRegionTypeCode")
				parameter("region", region)
				parameter("type", type)
				parameter("code", code)
				parameter("version", version)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listCodeTypesBy(
		region: String? = null,
		type: String? = null,
	): HttpResponse<List<String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "codetype", "byRegionType")
				parameter("region", region)
				parameter("type", type)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun listTagTypesBy(
		region: String? = null,
		type: String? = null,
	): HttpResponse<List<String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "tagtype", "byRegionType")
				parameter("region", region)
				parameter("type", type)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun createCode(c: Code): HttpResponse<Code> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()

	suspend fun createCodes(codeBatch: List<Code>): HttpResponse<List<Code>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(codeBatch)
		}.wrap()

	suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): HttpResponse<BooleanResponse> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "isValid")
				parameter("type", type)
				parameter("code", code)
				parameter("version", version)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): HttpResponse<Code> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byRegionLanguagesTypeLabel")
				parameter("region", region)
				parameter("label", label)
				parameter("type", type)
				parameter("languages", languages)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getCodes(codeIds: ListOfIds): HttpResponse<List<Code>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(codeIds)
		}.wrap()

	suspend fun getCode(codeId: String): HttpResponse<Code> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", codeId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): HttpResponse<Code> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", type, code, version)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun modifyCode(codeDto: Code): HttpResponse<Code> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(codeDto)
		}.wrap()

	suspend fun modifyCodes(codeBatch: List<Code>): HttpResponse<List<Code>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(codeBatch)
		}.wrap()

	suspend fun filterCodesBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null,
		filterChain: FilterChain<Code>,
	): HttpResponse<PaginatedList<Code>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "filter")
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

	suspend fun matchCodesBy(filter: AbstractFilter<Code>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	suspend fun importCodes(codeType: String): HttpResponse<Unit> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "code", codeType)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	// endregion
}
