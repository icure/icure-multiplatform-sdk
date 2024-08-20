@file:JsQualifier("options.SecretProviderAuthenticationOptions.InitialSecret")
package com.icure.sdk.js.options.external

@JsName("Password")
external class InitialSecretPasswordJs : InitialSecretJs {
	val password: String
}

@JsName("LongLivedToken")
external class InitialSecretLongLivedTokenJs : InitialSecretJs {
	val token: String
}

@JsName("OAuth")
external class InitialSecretOAuthJs : InitialSecretJs {
	val secret: String
	val oauthType: String
}
