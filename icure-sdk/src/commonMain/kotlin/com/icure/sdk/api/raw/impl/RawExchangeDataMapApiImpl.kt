package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawExchangeDataMapApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.model.ExchangeDataMap
import com.icure.sdk.model.ExchangeDataMapCreationBatch
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawExchangeDataMapApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawExchangeDataMapApi {
	// region common endpoints

	override suspend fun createOrUpdateExchangeDataMapBatch(batch: ExchangeDataMapCreationBatch): HttpResponse<String> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedatamap", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(batch)
		}.wrap()

	override suspend fun getExchangeDataMapBatch(ids: ListOfIds): HttpResponse<List<ExchangeDataMap>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "exchangedatamap", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	// endregion
}
