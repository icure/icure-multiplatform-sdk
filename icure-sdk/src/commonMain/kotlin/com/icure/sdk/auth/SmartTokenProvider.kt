package com.icure.sdk.auth

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Encode
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.model.LoginCredentials
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import com.icure.sdk.utils.decodeClaims
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.ensureNonNull
import com.icure.sdk.utils.isJwtExpiredOrInvalid
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@InternalIcureApi
internal sealed interface DoGetTokenResult {

	data class Success(val bearer: JwtBearer, val refresh: JwtRefresh) : DoGetTokenResult

	enum class DoGetTokenResultFailureReason {
		Needs2FA,
		Invalid2FA,
		InvalidPwOrToken,
		InvalidAuthClassLevel
	}

	data class Failure(val reason: DoGetTokenResultFailureReason) : DoGetTokenResult

}

@InternalIcureApi
internal class SmartTokenProvider(
	private val loginUsername: String?,
	private val groupId: String?,
	private var currentLongLivedSecret: AuthSecretDetails.Cacheable?,
	private var cachedToken: String?,
	private var cachedRefreshToken: String?,
	private val authApi: RawAnonymousAuthApi,
	private val authSecretProvider: AuthSecretProvider,
	private val cryptoService: CryptoService,
	private val passwordClientSideSalt: String?,
	private val cacheSecrets: Boolean,
	private val refreshPadding: Duration = 30.seconds
) {
	enum class RetrievedTokenType { New, Cached, Refreshed }
	data class RetrievedJwt(val jwt: String, val type: RetrievedTokenType)

	private val tokenCacheMutex = Mutex()

	suspend fun getCachedOrRefreshedOrNewToken(): RetrievedJwt = tokenCacheMutex.withLock {
		cachedToken?.takeIf { !isJwtExpiredOrInvalid(it, refreshPadding) }?.let { RetrievedJwt(it, RetrievedTokenType.Cached) }
			?: cachedRefreshToken?.takeIf { !isJwtExpiredOrInvalid(it, refreshPadding) }?.let { refreshAndCacheToken(it) }
			?: RetrievedJwt(getAndCacheNewTokens(null).bearer.token, RetrievedTokenType.New)
	}


	suspend fun getTokenForClass(minimumAuthenticationClass: AuthenticationClass): String = tokenCacheMutex.withLock {
		// By the time the lock is taken another coroutine may have refreshed the cached token and it could now be valid
		this.cachedToken?.takeIf { cachedToken ->
			kotlin.runCatching {
				decodeClaims(cachedToken).isValidForAuthClass(minimumAuthenticationClass, refreshPadding)
			}.getOrNull() == true
		} ?: getAndCacheNewTokens(minimumAuthenticationClass).bearer.token
	}

	suspend fun getCachedTokensOrLoad(): JwtBearerAndRefresh = tokenCacheMutex.withLock {
		val bearer = this.cachedToken
		val refresh = this.cachedRefreshToken
		return if (bearer != null && refresh != null) {
			JwtBearerAndRefresh(JwtBearer(bearer), JwtRefresh(refresh))
		} else getAndCacheNewTokens(null)
	}

	suspend fun switchedGroup(newGroupId: String): SmartTokenProvider {
		// Take the mutable cached data while holding the lock
		val (cachedRefreshToken, currentLongLivedSecret) = tokenCacheMutex.withLock {
			this.cachedRefreshToken to this.currentLongLivedSecret
		}
		val (switchedJwt, switchedRefresh) = cachedRefreshToken?.let { refreshJwt ->
			authApi.switchGroup(refreshJwt, newGroupId).successBodyOrNull()?.let { response ->
				ensure (response.token != null && response.refreshToken != null) {
					"Internal error: group switch succeeded but no token was returned. Unsupported backend version?"
				}
				response.token to response.refreshToken
			}
		} ?: (null to null)
		return SmartTokenProvider(
			loginUsername = loginUsername,
			groupId = newGroupId,
			currentLongLivedSecret = currentLongLivedSecret,
			cachedToken = switchedJwt,
			cachedRefreshToken = switchedRefresh,
			authApi = authApi,
			authSecretProvider = authSecretProvider,
			cryptoService = cryptoService,
			passwordClientSideSalt = passwordClientSideSalt,
			cacheSecrets = cacheSecrets,
			refreshPadding = refreshPadding
		)
	}

	private suspend fun getAndCacheNewTokens(minimumAuthenticationClass: AuthenticationClass?): JwtBearerAndRefresh =
		getNewToken(minimumAuthenticationClass).also {
			cachedToken = it.bearer.token
			cachedRefreshToken = it.refresh.token
		}

	private suspend fun refreshAndCacheToken(refreshToken: String): RetrievedJwt =
		authApi.refresh(refreshToken).successBodyOrNull()?.let {
			if(it.token == null) {
				throw IllegalStateException("Internal error: refresh succeeded but no token was returned. Unsupported backend version?")
			}
			cachedToken = it.token
			RetrievedJwt(it.token, RetrievedTokenType.Refreshed)
		} ?: RetrievedJwt(getAndCacheNewTokens(null).bearer.token, RetrievedTokenType.New)

	private suspend fun getNewToken(minimumAuthenticationClass: AuthenticationClass?): JwtBearerAndRefresh = currentLongLivedSecret?.takeIf {
		minimumAuthenticationClass == null || it.type.level >= minimumAuthenticationClass.level
	}?.let { secret ->
		val result = doGetTokenWithSecret(secret, secret.type)
		if (!cacheSecrets) currentLongLivedSecret = null
		when {
			result is DoGetTokenResult.Success -> JwtBearerAndRefresh(result.bearer, result.refresh)
			result is DoGetTokenResult.Failure
				&& result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA
				&& (minimumAuthenticationClass?.level ?: 0) <= AuthenticationClass.TwoFactorAuthentication.level -> askTotpAndGetToken(secret.secret, minimumAuthenticationClass)
			else -> askSecretAndGetToken(minimumAuthenticationClass, true)
		}
	} ?: askSecretAndGetToken(minimumAuthenticationClass, true)

	private tailrec suspend fun askSecretAndGetToken(
		minimumAuthenticationClass: AuthenticationClass?,
		passwordIsValidAs2fa: Boolean,
		previousAttempts: List<AuthSecretDetails> = emptyList()
	): JwtBearerAndRefresh {
		val minAuthClassLevel = minimumAuthenticationClass?.level ?: 0
		val acceptedSecrets = AuthenticationClass.entries.filter {
			when (it) {
				AuthenticationClass.TwoFactorAuthentication -> false
				AuthenticationClass.Password -> AuthenticationClass.TwoFactorAuthentication.level >= minAuthClassLevel && (passwordIsValidAs2fa || AuthenticationClass.Password.level >= minAuthClassLevel)
				else -> it.level >= minAuthClassLevel
			}
		}.also {
			ensure (it.isNotEmpty()) {
				"Internal error: no secret type is accepted for this request. Group may be misconfigured, or client may be outdated."
			}
		}.let { allAcceptedSecrets ->
			if (loginUsername != null) allAcceptedSecrets else allAcceptedSecrets.filterNot { it.requiresLoginUsername }
		}
		val secretDetails = authSecretProvider.getSecret(acceptedSecrets, previousAttempts)
		if(secretDetails.type !in acceptedSecrets) {
			throw IllegalArgumentException("Accepted secret types are ${acceptedSecrets.joinToString(", ")}, but got a secret of type ${secretDetails.type}.")
		}
		val result = doGetTokenWithSecret(secretDetails, minimumAuthenticationClass)
		return when {
			result is DoGetTokenResult.Success -> {
				if (cacheSecrets && secretDetails is AuthSecretDetails.Cacheable) {
					this.currentLongLivedSecret = secretDetails
				}
				JwtBearerAndRefresh(result.bearer, result.refresh)
			}
			result is DoGetTokenResult.Failure && result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA -> askTotpAndGetToken(secretDetails.secret, minimumAuthenticationClass)
			secretDetails is AuthSecretDetails.PasswordDetails
				&& result is DoGetTokenResult.Failure
				&& result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.InvalidAuthClassLevel -> askSecretAndGetToken(minimumAuthenticationClass, false)
			else -> askSecretAndGetToken(minimumAuthenticationClass, passwordIsValidAs2fa, previousAttempts + secretDetails)
		}
	}

	private tailrec suspend fun askTotpAndGetToken(password: String, minimumAuthenticationClass: AuthenticationClass?, previousAttempts: List<AuthSecretDetails> = emptyList()): JwtBearerAndRefresh {
		ensure ((minimumAuthenticationClass?.level ?: 0) <= AuthenticationClass.TwoFactorAuthentication.level) {
			"Internal error: asking for totp to login but minimumAuthenticationClassLevel is higher than TWO_FACTOR_AUTHENTICATION's level."
		}
		val details = authSecretProvider.getSecret(listOf(AuthenticationClass.TwoFactorAuthentication), previousAttempts)
		if(details !is AuthSecretDetails.TwoFactorAuthTokenDetails) {
			throw IllegalStateException("Was expecting a 2fa token but got a secret of type ${details::class.simpleName}.")
		}
		val result = doGetTokenWithSecret(AuthSecretDetails.TwoFactorAuthTokenDetails(secret = "${password}|${details.secret}"), minimumAuthenticationClass)
		return when {
			result is DoGetTokenResult.Success -> {
				if (cacheSecrets) {
					this.currentLongLivedSecret = AuthSecretDetails.PasswordDetails(password)
				}
				JwtBearerAndRefresh(result.bearer, result.refresh)
			}
			result is DoGetTokenResult.Failure && result.reason != DoGetTokenResult.DoGetTokenResultFailureReason.Invalid2FA -> {
				throw IllegalStateException("Unexpected error while trying to login with (previously) valid password and 2fa token ${result.reason}.")
			}
			else -> {
				askTotpAndGetToken(password, minimumAuthenticationClass, previousAttempts + details)
			}
		}
	}

	private suspend fun doGetTokenWithSecret(
		secret: AuthSecretDetails,
		minimumAuthenticationClass: AuthenticationClass?,
	): DoGetTokenResult {
		val authResponse = when {
			secret is AuthSecretDetails.ExternalAuthenticationDetails -> {
				when (secret.oauthType) {
					ThirdPartyProvider.GOOGLE -> authApi.loginGoogle(secret.secret) // TODO add group id
				}
			}

			secret is AuthSecretDetails.DigitalIdDetails ->
				TODO("Digital id login is not yet implemented for smart auth")

			else -> {
				ensureNonNull(loginUsername) {
					"Internal error: loginUsername is null but accepted authentication secret requires username to login."
				}
				if (passwordClientSideSalt != null && secret is AuthSecretDetails.PasswordDetails) {
					authApi.login(
						loginCredentials = LoginCredentials(
							username = loginUsername,
							password = base64Encode(cryptoService.digest.sha256((secret.secret + passwordClientSideSalt).toByteArray()))
						),
						groupId = groupId
					)
				} else {
					authApi.login(loginCredentials = LoginCredentials(username = loginUsername, password = secret.secret), groupId = groupId)
				}
			}
		}
		return try {
			val authPayload = authResponse.successBody()
			ensure (authPayload.token != null && authPayload.refreshToken != null) {
				"Internal error: login succeeded but no token was returned. Unsupported backend version?"
			}
			val tokenAuthClass = ensureNonNull(
				kotlin.runCatching {
					decodeClaims(authPayload.token)
				}.getOrNull()?.tokenAuthenticationClass
			) { "Could not decode token authentication class from a newly created (not refreshed) token. Unsupported backend version?"}
			if (tokenAuthClass >= (minimumAuthenticationClass?.level ?: 0)) {
				DoGetTokenResult.Success(JwtBearer(authPayload.token), JwtRefresh(authPayload.refreshToken))
			} else {
				DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.InvalidAuthClassLevel)
			}
		} catch (e: RequestStatusException) {
			when (e.statusCode) {
				// Password is wrong (401) or unacceptable (e.g. too short, 412)
				401, 412 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.InvalidPwOrToken)

				// Password is correct, but 2fa token is not
				406 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.Invalid2FA)

				// Password is correct, but the user has 2fa enabled and no 2fa token was provided
				417 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA)

				else -> throw e
			}
		}
	}
}

