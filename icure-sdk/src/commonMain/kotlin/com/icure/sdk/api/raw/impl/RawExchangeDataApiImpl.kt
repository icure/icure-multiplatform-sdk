package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawExchangeDataApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.PaginatedList
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
class RawExchangeDataApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawExchangeDataApi {
	// region common endpoints

	override suspend fun createExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(exchangeData)
		}.wrap()

	override suspend fun modifyExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(exchangeData)
		}.wrap()

	override suspend fun getExchangeDataById(exchangeDataId: String): HttpResponse<ExchangeData> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", exchangeDataId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<ExchangeData>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", dataOwnerId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getExchangeDataByDelegatorDelegate(
		delegatorId: String,
		delegateId: String,
	): HttpResponse<List<ExchangeData>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byDelegatorDelegate", delegatorId, delegateId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	override suspend fun getParticipantCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String?,
	): HttpResponse<List<String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", "byParticipant", dataOwnerId, "counterparts")
				parameter("counterpartsTypes", counterpartsTypes)
				parameter("ignoreOnEntryForFingerprint", ignoreOnEntryForFingerprint)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(ContentType.Application.Json)
		}.wrap()

	// endregion
}
