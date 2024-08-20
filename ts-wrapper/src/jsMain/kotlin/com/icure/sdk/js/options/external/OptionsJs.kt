@file:JsQualifier("options")
package com.icure.sdk.js.options.external

import kotlin.js.Promise

@JsName("AuthenticationMethod")
external interface AuthenticationMethodJs

@JsName("SecretProviderAuthenticationOptions")
external interface SecretProviderAuthenticationOptionsJs {
	val loginUsername: String?
	val initialSecret: InitialSecretJs?
	val existingJwt: String?
	val existingRefreshJwt: String?
	val cacheSecrets: Boolean?
}

@JsName("AuthSecretProvider")
external interface AuthSecretProviderJs {
	fun getSecret(
		acceptedSecrets: Array<String>,
		previousAttempts: Array<AuthSecretDetailsJs>,
		authProcessApi: AuthenticationProcessApiJs
	): Promise<AuthSecretDetailsJs>
}

@JsName("AuthenticationProcessRequest")
external class AuthenticationProcessRequestJs(
	messageGwUrl: String,
	specId: String,
	requestId: String
) {
	val messageGwUrl: String
	val specId: String
	val requestId: String
}

@JsName("AuthSecretDetails")
external interface AuthSecretDetailsJs

@JsName("AuthenticationProcessApi")
external interface AuthenticationProcessApiJs {
	fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaType: String,
		captchaKey: String,
		processTemplateParameters: AuthenticationProcessTemplateParametersJs?
	): Promise<AuthenticationProcessRequestJs>
}

@JsName("AuthenticationProcessTemplateParameters")
external interface AuthenticationProcessTemplateParametersJs {
	val firstName: String?
	val lastName: String?
}