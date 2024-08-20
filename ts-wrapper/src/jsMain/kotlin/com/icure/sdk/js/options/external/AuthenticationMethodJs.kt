@file:JsQualifier("options.AuthenticationMethod")
package com.icure.sdk.js.options.external

@JsName("UsingSecretProvider")
external class AuthenticationMethodUsingSecretProviderJs : AuthenticationMethodJs {
	val secretProvider: AuthSecretProviderJs
	val options: SecretProviderAuthenticationOptionsJs?
}