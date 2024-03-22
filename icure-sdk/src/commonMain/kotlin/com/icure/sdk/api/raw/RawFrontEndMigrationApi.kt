package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.FrontEndMigration
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawFrontEndMigrationApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getFrontEndMigrations(): HttpResponse<List<FrontEndMigration>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","frontendmigration")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createFrontEndMigration(frontEndMigrationDto: FrontEndMigration):
			HttpResponse<FrontEndMigration> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","frontendmigration")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(frontEndMigrationDto)
		}.wrap()


	suspend fun deleteFrontEndMigration(frontEndMigrationId: String):
			HttpResponse<DocIdentifier> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","frontendmigration",frontEndMigrationId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFrontEndMigration(frontEndMigrationId: String):
			HttpResponse<FrontEndMigration> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","frontendmigration",frontEndMigrationId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getFrontEndMigrationByName(frontEndMigrationName: String):
			HttpResponse<List<FrontEndMigration>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","frontendmigration","byName",frontEndMigrationName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyFrontEndMigration(frontEndMigrationDto: FrontEndMigration):
			HttpResponse<FrontEndMigration> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","frontendmigration")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(frontEndMigrationDto)
		}.wrap()

	// endregion

}
