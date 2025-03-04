package com.icure.cardinal.sdk.auth.services

import com.icure.cardinal.sdk.api.raw.RawAnonymousAuthApi
import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.JwtBearerAndRefresh
import com.icure.cardinal.sdk.auth.JwtRefresh
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.isJwtExpiredOrInvalid
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.datetime.Clock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@InternalIcureApi
abstract class AbstractJwtAuthProvider(
	protected val refresher: TokenRefresher
) : JwtBasedAuthProvider {

	override fun getAuthService(): TokenBasedAuthService<JwtBearer> = JwtAuthService(refresher)

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh =
		JwtBearerAndRefresh(refresher.getAuthenticationJwtOrRefresh(true), refresher.getRefreshJwt())
}

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
internal class JwtAuthProvider(
	private val authApi: RawAnonymousAuthApi,
	initialBearer: JwtBearer?,
	private val refreshToken: JwtRefresh,
	private val refreshPadding: Duration = 30L.seconds
) : AbstractJwtAuthProvider(refresher = NoCredentialsTokenRefresher(
	refreshToken = refreshToken,
	initialBearer = initialBearer,
	refreshPadding = refreshPadding,
	authApi = authApi
)) {

	override suspend fun switchGroup(newGroupId: String): AuthProvider {
		val switchedRefresh = authApi.switchGroup(refreshToken.token, newGroupId).successBody()
		return JwtAuthProvider(
			authApi,
			switchedRefresh.token?.let(::JwtBearer),
			JwtRefresh(ensureNonNull(switchedRefresh.refreshToken) { "Switch group gave a null refresh token" }),
			refreshPadding
		)
	}
}

@InternalIcureApi
abstract class TokenRefresher(
	initialBearer: JwtBearer?,
	private var jwtRefresh: JwtRefresh,
	private val refreshPadding: Duration,
	protected val authApi: RawAnonymousAuthApi,
) {

	companion object {
		private const val MILLISECONDS_BETWEEN_ERROR_RETRIES = 10_000
	}

	private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
	private val status = atomic<Deferred<Status>?>(initialBearer?.let { CompletableDeferred(Status.CurrentToken(it)) })

	private fun needsRefresh(status: Status, acceptExpired: Boolean): Boolean = when(status) {
		is Status.CurrentToken -> !acceptExpired && isJwtExpiredOrInvalid(status.jwt.token, refreshPadding)
		is Status.Failure ->
			if (Clock.System.now().toEpochMilliseconds() - status.timestamp < MILLISECONDS_BETWEEN_ERROR_RETRIES) {
				true
			} else {
				throw status.error
			}
		is Status.Unauthorized -> throw status.error
	}

	private fun Status.getToken() = if (this is Status.CurrentToken) jwt else throw IllegalStateException("Cannot get token from status")

	private suspend fun regenerateAuthJwtUsingRefreshToken(refreshToken: JwtRefresh): Status = try {
		authApi.refresh(refreshToken.token).successBody().token?.let {
			Status.CurrentToken(JwtBearer(it))
		} ?: Status.Failure(
			error = InternalCardinalException("Token refresh was successful but token was null"),
			timestamp = Clock.System.now().toEpochMilliseconds()
		)
	} catch (e: Exception) {
		e.toStatus()
	}

	tailrec suspend fun getAuthenticationJwtOrRefresh(acceptExpired: Boolean): JwtBearer {
		val deferredStatus = status.value
		if (deferredStatus != null && !needsRefresh(deferredStatus.await(), acceptExpired)) {
			return deferredStatus.await().getToken()
		} else {
			val newDeferred = scope.async(start = CoroutineStart.LAZY) {
				if (!isJwtExpiredOrInvalid(jwtRefresh.token, refreshPadding)) {
					regenerateAuthJwtUsingRefreshToken(jwtRefresh)
				} else {
					try {
						val refreshResult = regenerateRefreshToken()
						jwtRefresh = refreshResult.refresh
						Status.CurrentToken(refreshResult.bearer)
					} catch (e: Exception) {
						e.toStatus()
					}
				}
			}
			return if (status.compareAndSet(deferredStatus, newDeferred)) {
				newDeferred.await().getToken()
			} else {
				newDeferred.cancel()
				getAuthenticationJwtOrRefresh(acceptExpired)
			}
		}
	}

	fun getRefreshJwt(): JwtRefresh = jwtRefresh

	abstract suspend fun regenerateRefreshToken(): JwtBearerAndRefresh

	sealed interface Status {
		data class CurrentToken(val jwt: JwtBearer): Status
		data class Unauthorized(val error: Throwable): Status
		data class Failure(val error: Throwable, val timestamp: Long): Status
	}

	private fun Throwable.toStatus() = if (this is RequestStatusException && statusCode == 401) {
		Status.Unauthorized(error = this)
	} else {
		Status.Failure(error = this, timestamp = Clock.System.now().toEpochMilliseconds())
	}

}

@InternalIcureApi
private class NoCredentialsTokenRefresher(
	refreshToken: JwtRefresh,
	initialBearer: JwtBearer?,
	refreshPadding: Duration,
	authApi: RawAnonymousAuthApi,
) : TokenRefresher(
	initialBearer = initialBearer,
	jwtRefresh = refreshToken,
	refreshPadding = refreshPadding,
	authApi = authApi
) {

	override suspend fun regenerateRefreshToken(): JwtBearerAndRefresh {
		throw UnsupportedOperationException("Cannot regenerate the refresh JWT without credentials")
	}
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
		refresher.getAuthenticationJwtOrRefresh(false)
}
