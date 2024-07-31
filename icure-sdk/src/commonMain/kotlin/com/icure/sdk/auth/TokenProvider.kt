package com.icure.sdk.auth

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Encode
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.model.LoginCredentials
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import com.icure.sdk.utils.decodeClaims
import com.icure.sdk.utils.isJwtExpiredOrInvalid
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.SerializationException

@InternalIcureApi
sealed interface DoGetTokenResult {

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
class TokenProvider(
	private val login: String,
	private val groupId: String?,
	private var currentLongLivedSecret: AuthSecretDetails.Cacheable?,
	private var cachedToken: String?,
	private var cachedRefreshToken: String?,
	private val authApi: RawAnonymousAuthApi,
	private val authSecretProvider: AuthSecretProvider,
	private val cryptoService: CryptoService,
	private val passwordClientSideSalt: String?,
) {

	enum class RetrievedTokenType { New, Cached, Refreshed }
	data class RetrievedJwt(val jwt: String, val type: RetrievedTokenType)

	suspend fun getCachedOrRefreshedOrNewToken(): RetrievedJwt =
		cachedToken?.takeIf { !isJwtExpiredOrInvalid(it) }?.let { RetrievedJwt(it, RetrievedTokenType.Cached) }
			?: cachedRefreshToken?.takeIf { !isJwtExpiredOrInvalid(it) }?.let { refreshAndCacheToken(it) }
			?: RetrievedJwt(getAndCacheNewToken(null), RetrievedTokenType.New)

	suspend fun getNewTokenWithClass(minimumAuthenticationClass: AuthenticationClass): String = getAndCacheNewToken(minimumAuthenticationClass)

	private suspend fun getAndCacheNewToken(minimumAuthenticationClass: AuthenticationClass?): String =
		getNewToken(minimumAuthenticationClass).let { (bearer, refresh) ->
			cachedToken = bearer.token
			cachedRefreshToken = refresh.token
			bearer.token
		}

	private suspend fun refreshAndCacheToken(refreshToken: String): RetrievedJwt =
		authApi.refresh(refreshToken).successBodyOrNull()?.let {
			if(it.token == null) {
				throw IllegalStateException("Internal error: refresh succeeded but no token was returned. Unsupported backend version?")
			}
			cachedToken = it.token
			RetrievedJwt(it.token, RetrievedTokenType.Refreshed)
		} ?: RetrievedJwt(getAndCacheNewToken(null), RetrievedTokenType.New)

	private suspend fun getNewToken(minimumAuthenticationClass: AuthenticationClass?): Pair<JwtBearer, JwtRefresh> = currentLongLivedSecret?.takeIf {
		minimumAuthenticationClass == null || it.type.level >= minimumAuthenticationClass.level
	}?.let { secret ->
		val result = doGetTokenWithSecret(secret, secret.type)
		when {
			result is DoGetTokenResult.Success -> result.bearer to result.refresh
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
	): Pair<JwtBearer, JwtRefresh> {
		val minAuthClassLevel = minimumAuthenticationClass?.level ?: 0
		val acceptedSecrets = listOfNotNull(
			AuthenticationClass.LongLivedToken.takeIf { minAuthClassLevel <= AuthenticationClass.LongLivedToken.level },
			AuthenticationClass.ShortLivedToken.takeIf { minAuthClassLevel <= AuthenticationClass.ShortLivedToken.level },
			AuthenticationClass.Password.takeIf {
				minAuthClassLevel <= AuthenticationClass.TwoFactorAuthentication.level && (passwordIsValidAs2fa || minAuthClassLevel <= AuthenticationClass.Password.level) }
		).also {
			if(it.isEmpty()) {
				throw IllegalStateException("Internal error: no secret type is accepted for this request. Group may be misconfigured, or client may be outdated.")
			}
		}
		val secretDetails = authSecretProvider.getSecret(acceptedSecrets, previousAttempts)
		if(secretDetails.type !in acceptedSecrets) {
			throw IllegalStateException("Accepted secret types are ${acceptedSecrets.joinToString(", ")}, but got a secret of type ${secretDetails.type}.")
		}
		val result = doGetTokenWithSecret(secretDetails, minimumAuthenticationClass)
		return when {
			result is DoGetTokenResult.Success -> {
				if (secretDetails is AuthSecretDetails.Cacheable) {
					this.currentLongLivedSecret = secretDetails
				}
				result.bearer to result.refresh
			}
			result is DoGetTokenResult.Failure && result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA -> askTotpAndGetToken(secretDetails.secret, minimumAuthenticationClass)
			secretDetails is AuthSecretDetails.PasswordDetails
				&& result is DoGetTokenResult.Failure
				&& result.reason == DoGetTokenResult.DoGetTokenResultFailureReason.InvalidAuthClassLevel -> askSecretAndGetToken(minimumAuthenticationClass, false)
			else -> askSecretAndGetToken(minimumAuthenticationClass, passwordIsValidAs2fa, previousAttempts + secretDetails)
		}
	}

	private tailrec suspend fun askTotpAndGetToken(password: String, minimumAuthenticationClass: AuthenticationClass?, previousAttempts: List<AuthSecretDetails> = emptyList()): Pair<JwtBearer, JwtRefresh> {
		if((minimumAuthenticationClass?.level ?: 0) > AuthenticationClass.TwoFactorAuthentication.level) {
			throw IllegalStateException("Internal error: asking for totp to login but minimumAuthenticationClassLevel is higher than TWO_FACTOR_AUTHENTICATION's level.")
		}
		val details = authSecretProvider.getSecret(listOf(AuthenticationClass.TwoFactorAuthentication), previousAttempts)
		if(details !is AuthSecretDetails.TwoFactorAuthTokenDetails) {
			throw IllegalStateException("Was expecting a 2fa token but got a secret of type ${details::class.simpleName}.")
		}
		val result = doGetTokenWithSecret(AuthSecretDetails.TwoFactorAuthTokenDetails(secret = "${password}|${details.secret}"), minimumAuthenticationClass)
		return when {
			result is DoGetTokenResult.Success -> {
				this.currentLongLivedSecret = AuthSecretDetails.PasswordDetails(password)
				result.bearer to result.refresh
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

			passwordClientSideSalt != null && secret is AuthSecretDetails.PasswordDetails ->
				authApi.login(
					loginCredentials = LoginCredentials(
						username = login,
						password = base64Encode(cryptoService.digest.sha256((secret.secret + passwordClientSideSalt).toByteArray()))
					),
					groupId = groupId
				)
			else -> {
				authApi.login(loginCredentials = LoginCredentials(username = login, password = secret.secret), groupId = groupId)
			}
		}
		return runCatching {
			val authPayload = authResponse.successBody()
			if(authPayload.token == null || authPayload.refreshToken == null) {
				throw IllegalStateException("Internal error: login succeeded but no token was returned. Unsupported backend version?")
			}
			val claims = decodeClaims(authPayload.token)
			if(claims.tokenAuthenticationClass == null || claims.tokenAuthenticationClass >= (minimumAuthenticationClass?.level ?: 0)) {
				DoGetTokenResult.Success(JwtBearer(authPayload.token), JwtRefresh(authPayload.refreshToken))
			} else {
				DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.InvalidAuthClassLevel)
			}
		}.onFailure { error ->
			return when (error) {
				is SerializationException -> throw IllegalStateException("Internal error: authClassLevel is not a number. Unsupported backend version?")
				is RequestStatusException -> when(error.statusCode) {
					// Password is wrong (401) or unacceptable (e.g. too short, 412)
					401, 412 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.InvalidPwOrToken)

					// Password is correct, but 2fa token is not
					406 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.Invalid2FA)

					// Password is correct, but the user has 2fa enabled and no 2fa token was provided
					417 -> DoGetTokenResult.Failure(DoGetTokenResult.DoGetTokenResultFailureReason.Needs2FA)

					else -> throw error
				}
				else -> throw error
			}
		}.getOrThrow()
	}

	suspend fun switchedGroup(newGroupId: String): TokenProvider {
		val (switchedJwt, switchedRefresh) = cachedRefreshToken?.let { refreshJwt ->
			authApi.switchGroup(refreshJwt, newGroupId).successBodyOrNull()?.let { response ->
				if(response.token == null || response.refreshToken == null) {
					throw IllegalStateException("Internal error: group switch succeeded but no token was returned. Unsupported backend version?")
				}
				response.token to response.refreshToken
			}
		} ?: (null to null)
		return TokenProvider(
			login = login,
			groupId = newGroupId,
			currentLongLivedSecret = currentLongLivedSecret,
			cachedToken = switchedJwt,
			cachedRefreshToken = switchedRefresh,
			authApi = authApi,
			authSecretProvider = authSecretProvider,
			cryptoService = cryptoService,
			passwordClientSideSalt = passwordClientSideSalt
		)
	}
}

