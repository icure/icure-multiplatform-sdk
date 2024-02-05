package com.icure.sdk.auth.services

import com.icure.kryptom.utils.base64Decode
import com.icure.sdk.api.extended.AnonymousAuthApi
import com.icure.sdk.auth.AuthenticationClass
import com.icure.sdk.auth.Credentials
import com.icure.sdk.auth.Jwt
import com.icure.sdk.auth.ThirdPartyTokens
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.utils.Serialization
import io.ktor.client.request.*
import io.ktor.util.date.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * This auth service can generate and provide a valid copy of an authentication and refresh JWTs, refreshing them if
 * needed.
 *
 * @param authApi an instance of [AnonymousAuthApi].
 * @param credentials the [Credentials] to obtain the JWT. Note: if a [Jwt] is passed as credentials, then it will not
 * be refreshed when the refresh token expires.
 * @param refreshPadding a [Duration]. Both the authentication and refresh will be refreshed before their actual expiration
 * according to the duration specified in the parameter, to avoid the mid-flight expiration of the token.
 */
class JwtAuthService(
	private val authApi: AnonymousAuthApi,
	private val credentials: Credentials,
	private val refreshPadding: Duration = 30L.seconds
) : AuthService<Jwt> {

	private lateinit var jwt: Jwt
	private val jwtMutex = Mutex()

	companion object {
		@Serializable
		private data class JwtPayload(val exp: Long)
	}

	/**
	 * Generates a new [Jwt] using the provided credentials.
	 * Note: if the [credentials] are of type [Jwt], then a new Jwt cannot be generated when the refresh token expires.
	 */
	private suspend fun generateJwt(): Jwt = when(credentials) {
		is UsernamePassword -> authApi.login(credentials.username, credentials.password)
		is ThirdPartyTokens -> credentials.tokens.map { (thirdParty, token) ->
				runCatching {
					authApi.loginWithThirdPartyToken(thirdParty, token)
				}
			}.let { results ->
				results.firstNotNullOfOrNull { it.getOrNull() }
					?: results.firstNotNullOfOrNull { it.exceptionOrNull() }?.let { throw it }
					?: throw IllegalStateException("Something went wrong while refreshing the jwt")
			}
		is Jwt -> if(!isJwtExpiredOrInvalid(credentials.refreshJwt)) credentials
			else throw IllegalArgumentException("Cannot refresh auth, refresh JWT expired.")
	}

	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: AuthenticationClass?
	) {
		if(authenticationClass != null) {
			throw AuthService.UnavailableAuthenticationClassException(authenticationClass)
		}
		builder.bearerAuth(getOrRefreshToken().jwt)
	}

	override suspend fun getToken(): Jwt = getOrRefreshToken()

	/**
	 * @return the current [Jwt]. It automatically refreshes it if it is expired or if it was never initialized.
	 */
	private suspend fun getOrRefreshToken(): Jwt {
		jwtMutex.withLock {
			if(!::jwt.isInitialized || isJwtExpiredOrInvalid(jwt.jwt)) {
				refreshAuthenticationJwt()
			}
		}
		return jwt
	}

	/**
	 * Refreshes the current [jwt] using the refresh token. If the [jwt] was never initialized or the refresh token
	 * expired, then generated a new jwt.
	 */
	private suspend fun refreshAuthenticationJwt() {
		jwt = if(!::jwt.isInitialized || isJwtExpiredOrInvalid(jwt.refreshJwt)) {
			generateJwt()
		} else {
			authApi.refresh(jwt.refreshJwt)
		}
	}

	/**
	 * Checks if a base-64 encoded JWT has an invalid format or is expired.
	 */
	private fun isJwtExpiredOrInvalid(jwt: String): Boolean {
		val parts = jwt.split(".")
		return parts.size == 3 && runCatching {
			val payload = Serialization.lenientJson.decodeFromString<JwtPayload>(base64Decode(parts[1]).toString())
			(payload.exp * 1000) < (GMTDate().timestamp - refreshPadding.inWholeMilliseconds)
		}.getOrDefault(false)
	}
}