package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawKeywordApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun createKeyword(c: Keyword): HttpResponse<Keyword> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","keyword")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun getKeyword(keywordId: String): HttpResponse<Keyword> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","keyword",keywordId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getKeywordsByUser(userId: String): HttpResponse<List<Keyword>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","keyword","byUser",userId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getKeywords(startDocumentId: String? = null, limit: Int? = null):
			HttpResponse<PaginatedList<Keyword, JsonString>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","keyword")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteKeywords(keywordIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
			post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","keyword","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(keywordIds)
		}.wrap()


	suspend fun modifyKeyword(keywordDto: Keyword): HttpResponse<Keyword> = put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","keyword")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(keywordDto)
		}.wrap()

	// endregion

}
