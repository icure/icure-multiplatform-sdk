package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawFrontEndMigrationApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.utils.InternalIcureApi
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
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration
import com.icure.cardinal.sdk.model.FrontEndMigration as ModelFrontEndMigration
import org.taktik.icure.entities.FrontEndMigration as EntitiesFrontEndMigration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawFrontEndMigrationApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawFrontEndMigrationApi {
	// region common endpoints

	override suspend fun getFrontEndMigrations(): HttpResponse<List<ModelFrontEndMigration>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createFrontEndMigration(frontEndMigrationDto: ModelFrontEndMigration): HttpResponse<ModelFrontEndMigration> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(frontEndMigrationDto)
		}.wrap()

	override suspend fun deleteFrontEndMigration(frontEndMigrationId: String): HttpResponse<EntitiesFrontEndMigration> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration", frontEndMigrationId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFrontEndMigration(frontEndMigrationId: String): HttpResponse<ModelFrontEndMigration> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration", frontEndMigrationId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFrontEndMigrationByName(frontEndMigrationName: String): HttpResponse<List<ModelFrontEndMigration>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration", "byName", frontEndMigrationName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyFrontEndMigration(frontEndMigrationDto: ModelFrontEndMigration): HttpResponse<ModelFrontEndMigration> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "frontendmigration")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(frontEndMigrationDto)
		}.wrap()

	// endregion
}
