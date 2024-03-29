package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.RecoveryData
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.Content
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawRecoveryDataApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
	// region common endpoints

	suspend fun createRecoveryData(recoveryData: RecoveryData): HttpResponse<RecoveryData> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(recoveryData)
		}.wrap()

	suspend fun getRecoveryData(id: String): HttpResponse<RecoveryData> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun deleteRecoveryData(id: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydata", id)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun deleteAllRecoveryDataForRecipient(recipientId: String): HttpResponse<Content> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydataforRecipient", recipientId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun deleteAllRecoveryDataOfTypeForRecipient(
		type: RecoveryData.Type,
		recipientId: String,
	): HttpResponse<Content> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "recoverydataforRecipient", recipientId, "ofType", "$type")
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion
}
