package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.LoginCredentials
import com.icure.sdk.model.security.jwt.JwtResponse
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`header`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAnonymousAuthApi(
	private val apiUrl: String,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun login(
		duration: Long? = null,
		loginCredentials: LoginCredentials,
		groupId: String? = null,
	): HttpResponse<JwtResponse> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","login")
				parameter("duration", duration)
				parameter("groupId", groupId)
			}
			contentType(ContentType.Application.Json)
			setBody(loginCredentials)
		}.wrap()


	suspend fun refresh(refreshToken: String, totp: String? = null): HttpResponse<JwtResponse> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","refresh")
				parameter("totp", totp)
			}
			contentType(ContentType.Application.Json)
			header("Refresh-Token", refreshToken)
		}.wrap()


	suspend fun check(loginCredentials: LoginCredentials): HttpResponse<Unit> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","check")
			}
			contentType(ContentType.Application.Json)
			setBody(loginCredentials)
		}.wrap()

	// endregion

	// region cloud endpoints

	suspend fun switchGroup(refreshToken: String, groupId: String): HttpResponse<JwtResponse> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","switch",groupId)
			}
			contentType(ContentType.Application.Json)
			header("Refresh-Token", refreshToken)
		}.wrap()


	suspend fun loginGoogle(token: String, groupId: String? = null): HttpResponse<JwtResponse> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","login","google")
				parameter("groupId", groupId)
			}
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()


	suspend fun loginFas(token: String, groupId: String? = null): HttpResponse<JwtResponse> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","login","be.fas")
				parameter("groupId", groupId)
			}
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()


	suspend fun invalidateRefreshJWT(refreshToken: String): HttpResponse<Unit> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","auth","invalidate")
			}
			contentType(ContentType.Application.Json)
			header("Refresh-Token", refreshToken)
		}.wrap()

	// endregion

}
