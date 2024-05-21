package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawFrontEndMigrationApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.FrontEndMigration
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
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawFrontEndMigrationApiImpl(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawFrontEndMigrationApi {
	// region common endpoints

	override suspend fun getFrontEndMigrations(): HttpResponse<List<FrontEndMigration>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createFrontEndMigration(frontEndMigrationDto: FrontEndMigration): HttpResponse<FrontEndMigration> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(frontEndMigrationDto)
		}.wrap()

	override suspend fun deleteFrontEndMigration(frontEndMigrationId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration", frontEndMigrationId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getFrontEndMigration(frontEndMigrationId: String): HttpResponse<FrontEndMigration> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration", frontEndMigrationId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getFrontEndMigrationByName(frontEndMigrationName: String): HttpResponse<List<FrontEndMigration>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration", "byName", frontEndMigrationName)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyFrontEndMigration(frontEndMigrationDto: FrontEndMigration): HttpResponse<FrontEndMigration> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(frontEndMigrationDto)
		}.wrap()

	// endregion
}
