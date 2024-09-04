@file:JsQualifier("options.AuthenticationMethod")
package com.icure.cardinal.sdk.js.options.external

@JsName("UsingSecretProvider")
external class AuthenticationMethodUsingSecretProviderJs : AuthenticationMethodJs {
	val secretProvider: AuthSecretProviderJs
	val options: SecretProviderAuthenticationOptionsJs?
}