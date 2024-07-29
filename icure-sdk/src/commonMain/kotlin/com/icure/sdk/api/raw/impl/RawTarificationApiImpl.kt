package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawTarificationApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Tarification
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
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
class RawTarificationApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawTarificationApi {
	// region common endpoints

	override suspend fun findTarificationsByLabel(
		region: String?,
		types: String?,
		language: String?,
		label: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Tarification>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification", "byLabel")
				parameter("region", region)
				parameter("types", types)
				parameter("language", language)
				parameter("label", label)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findTarificationsBy(
		region: String?,
		type: String?,
		tarification: String?,
		version: String?,
		startDocumentId: String?,
		startKey: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Tarification>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification")
				parameter("region", region)
				parameter("type", type)
				parameter("tarification", tarification)
				parameter("version", version)
				parameter("startDocumentId", startDocumentId)
				parameter("startKey", startKey)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findTarificationsBy(
		region: String?,
		type: String?,
		tarification: String?,
		version: String?,
	): HttpResponse<List<Tarification>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification", "byRegionTypeTarification")
				parameter("region", region)
				parameter("type", type)
				parameter("tarification", tarification)
				parameter("version", version)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTarification(c: Tarification): HttpResponse<Tarification> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getTarifications(tarificationIds: ListOfIds): HttpResponse<List<Tarification>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(tarificationIds)
		}.wrap()

	override suspend fun getTarification(tarificationId: String): HttpResponse<Tarification> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification", tarificationId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): HttpResponse<Tarification> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification", type, tarification, version)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyTarification(tarificationDto: Tarification): HttpResponse<Tarification> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tarification")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(tarificationDto)
		}.wrap()

	// endregion
}
