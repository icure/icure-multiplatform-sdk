package com.icure.sdk.auth.services

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.Credentials
import com.icure.sdk.auth.Jwt
import com.icure.sdk.auth.ServerAuthenticationClass
import com.icure.sdk.auth.ThirdPartyProvider
import com.icure.sdk.auth.ThirdPartyTokens
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.model.LoginCredentials
import com.icure.sdk.model.security.jwt.JwtResponse
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import com.icure.sdk.utils.isJwtExpiredOrInvalid
import io.ktor.client.request.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * This auth service can generate and provide a valid copy of an authentication and refresh JWTs, refreshing them if
 * needed.
 *
 * @param authApi an instance of [RawAnonymousAuthApi].
 * @param credentials the [Credentials] to obtain the JWT. Note: if a [Jwt] is passed as credentials, then it will not
 * be refreshed when the refresh token expires.
 * @param refreshPadding a [Duration]. Both the authentication and refresh will be refreshed before their actual expiration
 * according to the duration specified in the parameter, to avoid the mid-flight expiration of the token.
 */
@InternalIcureApi
class JwtAuthService(
	private val authApi: RawAnonymousAuthApi,
	private val credentials: Credentials,
	private val refreshPadding: Duration = 30L.seconds
) : TokenBasedAuthService<Jwt>, AuthProvider {

	private lateinit var jwt: Jwt
	private val jwtMutex = Mutex()

	private var lastRecordedError: RequestStatusException? = null
	private val errorMutex = Mutex()

	/**
	 * Generates a new [Jwt] using the provided credentials.
	 * Note: if the [credentials] are of type [Jwt], then a new Jwt cannot be generated when the refresh token expires.
	 */
	private suspend fun generateJwt(): Jwt = when(credentials) {
		is UsernamePassword -> authApi.login(
			loginCredentials = LoginCredentials(credentials.username, credentials.password)
		).successBody().toJwt()
		is ThirdPartyTokens -> credentials.tokens.map { (thirdParty, token) ->
				runCatching {
					loginWithThirdParty(thirdParty, token)
				}
			}.let { results ->
				results.firstNotNullOfOrNull { it.getOrNull() }
					?: results.firstNotNullOfOrNull { it.exceptionOrNull() }?.let { throw it }
					?: throw IllegalStateException("Something went wrong while refreshing the jwt")
			}
		is Jwt -> if(!isJwtExpiredOrInvalid(credentials.refreshJwt)) credentials
			else throw IllegalArgumentException("Cannot refresh auth, refresh JWT expired.")
	}

	private suspend fun loginWithThirdParty(thirdPartyProvider: ThirdPartyProvider, token: String) = when(thirdPartyProvider) {
		ThirdPartyProvider.GOOGLE -> authApi.loginGoogle(token).successBody().toJwt()
	}

	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: ServerAuthenticationClass?
	) {
		if(authenticationClass != null) {
			throw AuthService.UnavailableAuthenticationClassException(authenticationClass)
		}
		val currentJwt = getOrRefreshToken().jwt

		errorMutex.withLock {
			lastRecordedError?.also {
				throw it
			}
		}

		builder.bearerAuth(currentJwt)
	}

	override suspend fun getToken(): Jwt = getOrRefreshToken()

	override fun getAuthService() = this

	override suspend fun invalidateCurrentHeader(error: RequestStatusException) = errorMutex.withLock {
		lastRecordedError = error
	}

	/**
	 * Retrieves the current [Jwt], automatically refreshing it if it is expired of never initialized.
	 * This function has 2 side effects:
	 * - sets the [jwt] internal state.
	 * - resets the [lastRecordedError] if the jwt was refreshed successfully, the rationale being that [lastRecordedError] is set when
	 * a request fails with a 401, the new token may reset this state.
	 *
	 * @return the current [Jwt]. It automatically refreshes it if it is expired or if it was never initialized.
	 */
	private suspend fun getOrRefreshToken(): Jwt {
		jwtMutex.withLock {
			if(!::jwt.isInitialized || isJwtExpiredOrInvalid(jwt.jwt, refreshPadding)) {
				refreshAuthenticationJwt()
				errorMutex.withLock {
					lastRecordedError = null
				}
			}
		}
		return jwt
	}

	/**
	 * Refreshes the current [jwt] using the refresh token. If the [jwt] was never initialized or the refresh token
	 * expired, then generated a new jwt.
	 */
	private suspend fun refreshAuthenticationJwt() {
		jwt = if(!::jwt.isInitialized || isJwtExpiredOrInvalid(jwt.refreshJwt, refreshPadding)) {
			generateJwt()
		} else {
			authApi.refresh(jwt.refreshJwt).successBody().toJwt()
		}
	}

	private fun JwtResponse.toJwt() = Jwt(requireNotNull(token), requireNotNull(refreshToken))
}
