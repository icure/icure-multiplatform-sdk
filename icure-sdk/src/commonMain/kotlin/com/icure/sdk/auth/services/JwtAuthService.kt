package com.icure.sdk.auth.services

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.JwtBearer
import com.icure.sdk.auth.JwtBearerAndRefresh
import com.icure.sdk.auth.JwtRefresh
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import com.icure.sdk.utils.ensureNonNull
import com.icure.sdk.utils.isJwtExpiredOrInvalid
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Auth service using only the provided auth tokens.
 * Will automatically refresh the authentication jwt for as long as the refresh jwt is valid.
 *
 * @param authApi an instance of [RawAnonymousAuthApi].
 * @param initialBearer an initial bearer token which may be used, optional.
 * @param refreshToken the refresh token.
 * @param refreshPadding a [Duration]. Both the authentication and refresh will be refreshed before their actual expiration
 * according to the duration specified in the parameter, to avoid the mid-flight expiration of the token.
 */
@InternalIcureApi
class JwtAuthService(
	private val authApi: RawAnonymousAuthApi,
	initialBearer: JwtBearer?,
	private val refreshToken: JwtRefresh,
	private val refreshPadding: Duration = 30L.seconds
) : TokenBasedAuthService<JwtBearer>, JwtBasedAuthProvider {
	private var jwt: JwtBearer? = initialBearer
	private val jwtMutex = Mutex()

	private var lastRecordedError: RequestStatusException? = null
	private val errorMutex = Mutex()

	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: AuthenticationClass?
	) {
		if(authenticationClass != null) {
			throw AuthService.UnavailableAuthenticationClassException(authenticationClass)
		}
		val currentJwt = getOrRefreshToken(false)

		errorMutex.withLock {
			lastRecordedError?.also {
				throw it
			}
		}

		builder.bearerAuth(currentJwt.token)
	}

	override suspend fun getToken(): JwtBearer = getOrRefreshToken(false)

	override fun getAuthService() = this

	override suspend fun invalidateCurrentToken(error: RequestStatusException) = errorMutex.withLock {
		lastRecordedError = error
	}

	private suspend fun getOrRefreshToken(acceptExpired: Boolean): JwtBearer =
		jwtMutex.withLock {
			if (jwt == null || (isJwtExpiredOrInvalid(jwt!!.token, refreshPadding) && !acceptExpired)) {
				jwt = refreshBearer()
				errorMutex.withLock {
					lastRecordedError = null
				}
			}
			jwt!!
		}


	private suspend fun refreshBearer(): JwtBearer =
		if (!isJwtExpiredOrInvalid(refreshToken.token, refreshPadding))
			JwtBearer(
				ensureNonNull(
					try {
						authApi.refresh(refreshToken.token).successBody().token
					} catch (e: Exception) {
						throw IllegalStateException("Could not refresh token", e)
					}
				) {
					"Token refresh was successful but bearer is null"
				}
			)
		else
			throw IllegalStateException("Cannot refresh bearer, refresh JWT expired.")

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh =
		JwtBearerAndRefresh(getOrRefreshToken(true), refreshToken)
}
