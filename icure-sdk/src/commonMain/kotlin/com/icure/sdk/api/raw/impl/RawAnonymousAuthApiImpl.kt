package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.model.LoginCredentials
import com.icure.sdk.model.security.jwt.JwtResponse
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.`header`
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.ContentType.contentType
import io.ktor.http.appendPathSegments
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAnonymousAuthApiImpl(
	internal val apiUrl: String,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawAnonymousAuthApi {
	// region common endpoints

	override suspend fun login(
		duration: Long?,
		loginCredentials: LoginCredentials,
		groupId: String?,
	): HttpResponse<JwtResponse> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "login")
				parameter("duration", duration)
				parameter("groupId", groupId)
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(loginCredentials)
		}.wrap()

	override suspend fun refresh(
		refreshToken: String,
		totp: String?,
	): HttpResponse<JwtResponse> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "refresh")
				parameter("totp", totp)
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			header("Refresh-Token", refreshToken)
		}.wrap()

	override suspend fun check(loginCredentials: LoginCredentials): HttpResponse<Unit> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "check")
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(loginCredentials)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun switchGroup(
		refreshToken: String,
		groupId: String,
	): HttpResponse<JwtResponse> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "switch", groupId)
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			header("Refresh-Token", refreshToken)
		}.wrap()

	override suspend fun loginGoogle(
		token: String,
		groupId: String?,
	): HttpResponse<JwtResponse> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "login", "google")
				parameter("groupId", groupId)
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			header("token", token)
		}.wrap()

	override suspend fun loginFas(
		token: String,
		groupId: String?,
	): HttpResponse<JwtResponse> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "login", "be.fas")
				parameter("groupId", groupId)
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			header("token", token)
		}.wrap()

	override suspend fun invalidateRefreshJWT(refreshToken: String): HttpResponse<Unit> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "invalidate")
			}
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			header("Refresh-Token", refreshToken)
		}.wrap()

	// endregion
}
