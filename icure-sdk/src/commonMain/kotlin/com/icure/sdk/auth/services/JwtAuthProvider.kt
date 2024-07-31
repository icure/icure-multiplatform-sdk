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
class JwtAuthProvider(
	authApi: RawAnonymousAuthApi,
	initialBearer: JwtBearer?,
	private val refreshToken: JwtRefresh,
	refreshPadding: Duration = 30L.seconds
) : JwtBasedAuthProvider {
	private val refresher = TokenRefresher(refreshToken, initialBearer, refreshPadding, authApi)

	override fun getAuthService(): TokenBasedAuthService<JwtBearer> = JwtAuthService(refresher)

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh =
		JwtBearerAndRefresh(refresher.getOrRefreshToken(true), refreshToken)
}

@InternalIcureApi
private class TokenRefresher(
	private val refreshToken: JwtRefresh,
	initialBearer: JwtBearer?,
	private val refreshPadding: Duration,
	private val authApi: RawAnonymousAuthApi,
) {
	private var jwt: JwtBearer? = initialBearer
	private val jwtMutex = Mutex()

	suspend fun getOrRefreshToken(acceptExpired: Boolean): JwtBearer =
		jwtMutex.withLock {
			if (jwt == null || (isJwtExpiredOrInvalid(jwt!!.token, refreshPadding) && !acceptExpired)) {
				jwt = refreshBearer()
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
}

@InternalIcureApi
private class JwtAuthService(
	private val refresher: TokenRefresher
) : TokenBasedAuthService<JwtBearer> {
	private lateinit var usedToken: String

	override suspend fun setAuthenticationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: AuthenticationClass?
	) {
		if(authenticationClass != null) {
			throw AuthService.UnavailableAuthenticationClassException(authenticationClass)
		}
		val currentJwt = getToken()
		usedToken = currentJwt.token
		builder.bearerAuth(currentJwt.token)
	}

	override suspend fun invalidateCurrentAuthentication(
		error: RequestStatusException,
		requiredAuthClass: AuthenticationClass?
	) {
		throw error
	}

	override suspend fun getToken(): JwtBearer =
		refresher.getOrRefreshToken(false)
}