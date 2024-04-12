package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawExchangeDataApi(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout) {
	// region common endpoints

	suspend fun createExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(exchangeData)
		}.wrap()

	suspend fun modifyExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(exchangeData)
		}.wrap()

	suspend fun getExchangeDataById(exchangeDataId: String): HttpResponse<ExchangeData> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedata", exchangeDataId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
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
		}.wrap()

	suspend fun getExchangeDataByDelegatorDelegate(
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
		}.wrap()

	suspend fun getParticipantCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String? = null,
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
		}.wrap()

	// endregion
}
