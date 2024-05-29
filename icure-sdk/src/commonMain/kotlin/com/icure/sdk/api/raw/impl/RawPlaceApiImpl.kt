package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawPlaceApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Place
import com.icure.sdk.model.couchdb.DocIdentifier
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
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawPlaceApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawPlaceApi {
	// region common endpoints

	override suspend fun createPlace(placeDto: Place): HttpResponse<Place> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(placeDto)
		}.wrap()

	override suspend fun deletePlaces(placeIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(placeIds)
		}.wrap()

	override suspend fun getPlace(placeId: String): HttpResponse<Place> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place", placeId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getPlaces(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Place>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyPlace(placeDto: Place): HttpResponse<Place> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "place")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(placeDto)
		}.wrap()

	// endregion
}
