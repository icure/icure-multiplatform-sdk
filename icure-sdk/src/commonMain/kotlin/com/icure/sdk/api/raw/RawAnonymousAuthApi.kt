package com.icure.sdk.api.raw

import com.icure.sdk.model.LoginCredentials
import com.icure.sdk.model.security.jwt.JwtResponse
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Long
import kotlin.String
import kotlin.Unit

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAnonymousAuthApi {
	// region common endpoints

	suspend fun login(
		duration: Long? = null,
		loginCredentials: LoginCredentials,
		groupId: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun refresh(
		refreshToken: String,
		totp: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun check(loginCredentials: LoginCredentials): HttpResponse<Unit>
	// endregion

	// region cloud endpoints

	suspend fun switchGroup(
		refreshToken: String,
		groupId: String,
	): HttpResponse<JwtResponse>

	suspend fun loginGoogle(
		token: String,
		groupId: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun loginFas(
		token: String,
		groupId: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun invalidateRefreshJWT(refreshToken: String): HttpResponse<Unit>
	// endregion
}
