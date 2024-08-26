package com.icure.sdk.js.options

import com.icure.sdk.auth.AuthSecretDetails
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.AuthenticationProcessApi
import com.icure.sdk.auth.AuthenticationProcessCaptchaType
import com.icure.sdk.auth.AuthenticationProcessRequest
import com.icure.sdk.auth.AuthenticationProcessTelecomType
import com.icure.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.sdk.auth.JwtBearer
import com.icure.sdk.auth.JwtCredentials
import com.icure.sdk.auth.JwtRefresh
import com.icure.sdk.auth.ThirdPartyAuthentication
import com.icure.sdk.auth.ThirdPartyProvider
import com.icure.sdk.auth.UsernameLongToken
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.js.options.external.AuthSecretDetailsJs
import com.icure.sdk.js.options.external.AuthSecretProviderJs
import com.icure.sdk.js.options.external.AuthenticationMethodJs
import com.icure.sdk.js.options.external.AuthenticationMethodUsingCredentialsJwtCredentialsJs
import com.icure.sdk.js.options.external.AuthenticationMethodUsingCredentialsThirdPartyAuthJs
import com.icure.sdk.js.options.external.AuthenticationMethodUsingCredentialsUsernameLongTokenJs
import com.icure.sdk.js.options.external.AuthenticationMethodUsingCredentialsUsernamePasswordJs
import com.icure.sdk.js.options.external.AuthenticationMethodUsingSecretProviderJs
import com.icure.sdk.js.options.external.AuthenticationProcessApiJs
import com.icure.sdk.js.options.external.AuthenticationProcessRequestJs
import com.icure.sdk.js.options.external.AuthenticationProcessTemplateParametersJs
import com.icure.sdk.js.options.external.DigitalIdDetailsJs
import com.icure.sdk.js.options.external.ExternalAuthenticationDetailsJs
import com.icure.sdk.js.options.external.InitialSecretJs
import com.icure.sdk.js.options.external.InitialSecretLongLivedTokenJs
import com.icure.sdk.js.options.external.InitialSecretOAuthJs
import com.icure.sdk.js.options.external.InitialSecretPasswordJs
import com.icure.sdk.js.options.external.LongLivedTokenDetailsJs
import com.icure.sdk.js.options.external.PasswordDetailsJs
import com.icure.sdk.js.options.external.ShortLivedTokenDetailsJs
import com.icure.sdk.js.options.external.TwoFactorAuthTokenDetailsJs
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise
import kotlin.js.Promise


@OptIn(InternalIcureApi::class)
internal fun AuthenticationMethodJs.toKt() = when (this) {
	is AuthenticationMethodUsingCredentialsUsernamePasswordJs ->
		AuthenticationMethod.UsingCredentials(UsernamePassword(
			username = username,
			password = password
		))
	is AuthenticationMethodUsingCredentialsUsernameLongTokenJs ->
		AuthenticationMethod.UsingCredentials(UsernameLongToken(
			username = username,
			token = token
		))
	is AuthenticationMethodUsingCredentialsThirdPartyAuthJs ->
		AuthenticationMethod.UsingCredentials(ThirdPartyAuthentication(
			token = token,
			provider = ThirdPartyProvider.valueOf(provider)
		))
	is AuthenticationMethodUsingCredentialsJwtCredentialsJs ->
		AuthenticationMethod.UsingCredentials(JwtCredentials(
			refresh = JwtRefresh(refresh),
			initialBearer = bearer?.let { JwtBearer(it) }
		))
	is AuthenticationMethodUsingSecretProviderJs ->
		AuthenticationMethod.UsingSecretProvider(
			loginUsername = options?.loginUsername,
			initialSecret = options?.initialSecret?.toKt(),
			existingJwt = options?.existingJwt,
			existingRefreshJwt = options?.existingRefreshJwt,
			secretProvider = AuthSecretProviderBridge(secretProvider),
			cacheSecrets = options?.cacheSecrets ?: false,
		)
	else -> throw IllegalArgumentException("Unrecognised authentication method: ${this::class.simpleName}")
}

private fun InitialSecretJs.toKt(): AuthenticationMethod.UsingSecretProvider.InitialSecret = when (this) {
	is InitialSecretPasswordJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.Password(password)
	is InitialSecretOAuthJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.OAuth(
			secret,
			ThirdPartyProvider.valueOf(oauthType)
		)
	is InitialSecretLongLivedTokenJs ->
		AuthenticationMethod.UsingSecretProvider.InitialSecret.LongLivedToken(token)
	else -> throw IllegalArgumentException("Unrecognised initial secret: ${this::class.simpleName}")
}

private class AuthSecretProviderBridge(
	private val jsProvider: AuthSecretProviderJs
) : AuthSecretProvider {
	override suspend fun getSecret(
		acceptedSecrets: Set<AuthenticationClass>,
		previousAttempts: List<AuthSecretDetails>,
		authProcessApi: AuthenticationProcessApi
	): AuthSecretDetails =
		jsProvider.getSecret(
			acceptedSecrets.map { it.name }.toTypedArray(),
			previousAttempts.map { it.toJs() }.toTypedArray(),
			AuthenticationProcessApiBridge(authProcessApi)
		).await().toKt()
}

private fun AuthSecretDetailsJs.toKt(): AuthSecretDetails = when (this) {
	is ExternalAuthenticationDetailsJs ->
		AuthSecretDetails.ExternalAuthenticationDetails(secret = secret, oauthType = ThirdPartyProvider.valueOf(oauthType))
	is LongLivedTokenDetailsJs ->
		AuthSecretDetails.LongLivedTokenDetails(secret = secret)
	is PasswordDetailsJs ->
		AuthSecretDetails.PasswordDetails(secret = secret)
	is DigitalIdDetailsJs ->
		AuthSecretDetails.DigitalIdDetails(secret = secret)
	is ShortLivedTokenDetailsJs ->
		AuthSecretDetails.ShortLivedTokenDetails(secret = secret, authenticationProcessInfo = authenticationProcessInfo.toKt())
	is TwoFactorAuthTokenDetailsJs ->
		AuthSecretDetails.TwoFactorAuthTokenDetails(secret = secret)
	else -> throw IllegalArgumentException("Unrecognised auth secret details: ${this::class.simpleName}")
}
private fun AuthSecretDetails.toJs(): AuthSecretDetailsJs = when (this) {
	is AuthSecretDetails.ExternalAuthenticationDetails ->
		ExternalAuthenticationDetailsJs(secret = secret, oauthType = oauthType.name)
	is AuthSecretDetails.LongLivedTokenDetails ->
		LongLivedTokenDetailsJs(secret = secret)
	is AuthSecretDetails.PasswordDetails ->
		PasswordDetailsJs(secret = secret)
	is AuthSecretDetails.DigitalIdDetails ->
		DigitalIdDetailsJs(secret = secret)
	is AuthSecretDetails.ShortLivedTokenDetails ->
		ShortLivedTokenDetailsJs(secret = secret, authenticationProcessInfo = authenticationProcessInfo.toJs())
	is AuthSecretDetails.TwoFactorAuthTokenDetails ->
		TwoFactorAuthTokenDetailsJs(secret = secret)
}
@OptIn(InternalIcureApi::class)
private fun AuthenticationProcessRequest.toJs(): AuthenticationProcessRequestJs = AuthenticationProcessRequestJs(
	messageGwUrl = messageGwUrl,
	specId = specId,
	requestId = requestId,
)
@OptIn(InternalIcureApi::class)
private fun AuthenticationProcessRequestJs.toKt(): AuthenticationProcessRequest = AuthenticationProcessRequest(
	messageGwUrl = messageGwUrl,
	specId = specId,
	requestId = requestId,
)

private class AuthenticationProcessApiBridge(
	private val ktApi: AuthenticationProcessApi
) : AuthenticationProcessApiJs {
	override fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaType: String,
		captchaKey: String,
		processTemplateParameters: AuthenticationProcessTemplateParametersJs?
	): Promise<AuthenticationProcessRequestJs> = GlobalScope.promise {
		ktApi.executeProcess(
			messageGatewayUrl,
			externalServicesSpecId,
			processId,
			AuthenticationProcessTelecomType.valueOf(userTelecomType),
			userTelecom,
			AuthenticationProcessCaptchaType.valueOf(captchaType),
			captchaKey,
			processTemplateParameters?.toKt() ?: AuthenticationProcessTemplateParameters()
		).toJs()
	}
}

internal fun AuthenticationProcessTemplateParametersJs.toKt() =
	AuthenticationProcessTemplateParameters(
		firstName = this.firstName,
		lastName = this.lastName
	)