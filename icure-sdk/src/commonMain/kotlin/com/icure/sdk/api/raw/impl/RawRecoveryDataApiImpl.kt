package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawRecoveryDataApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.model.RecoveryData
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.EncryptedContent
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
import kotlin.String
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawRecoveryDataApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawRecoveryDataApi {
	// region common endpoints

	override suspend fun createRecoveryData(recoveryData: RecoveryData): HttpResponse<RecoveryData> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(recoveryData)
		}.wrap()

	override suspend fun getRecoveryData(id: String): HttpResponse<RecoveryData> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteRecoveryData(id: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", id)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteAllRecoveryDataForRecipient(recipientId: String): HttpResponse<EncryptedContent> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydataforRecipient", recipientId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteAllRecoveryDataOfTypeForRecipient(
		type: RecoveryData.Type,
		recipientId: String,
	): HttpResponse<EncryptedContent> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydataforRecipient", recipientId, "ofType", "$type")
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
