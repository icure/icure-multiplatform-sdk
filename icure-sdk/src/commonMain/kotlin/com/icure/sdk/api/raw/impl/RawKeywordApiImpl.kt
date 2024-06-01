package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawKeywordApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawKeywordApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawKeywordApi {
	// region common endpoints

	override suspend fun createKeyword(c: Keyword): HttpResponse<Keyword> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "keyword")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getKeyword(keywordId: String): HttpResponse<Keyword> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "keyword", keywordId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getKeywordsByUser(userId: String): HttpResponse<List<Keyword>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "keyword", "byUser", userId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getKeywords(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Keyword>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "keyword")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun deleteKeywords(keywordIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "keyword", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(keywordIds)
		}.wrap()

	override suspend fun modifyKeyword(keywordDto: Keyword): HttpResponse<Keyword> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "keyword")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(keywordDto)
		}.wrap()

	// endregion
}
