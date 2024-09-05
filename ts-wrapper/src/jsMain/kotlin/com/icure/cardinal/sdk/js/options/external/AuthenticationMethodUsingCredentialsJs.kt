@file:JsQualifier("options.AuthenticationMethod.UsingCredentials")
package com.icure.cardinal.sdk.js.options.external
@JsName("UsernamePassword")
external class AuthenticationMethodUsingCredentialsUsernamePasswordJs : AuthenticationMethodJs {
	val username: String
	val password: String
}
@JsName("UsernameLongToken")
external class AuthenticationMethodUsingCredentialsUsernameLongTokenJs : AuthenticationMethodJs {
	val username: String
	val token: String
}
@JsName("ThirdPartyAuth")
external class AuthenticationMethodUsingCredentialsThirdPartyAuthJs : AuthenticationMethodJs {
	val token: String
	val provider: String
}
@JsName("JwtCredentials")
external class AuthenticationMethodUsingCredentialsJwtCredentialsJs : AuthenticationMethodJs {
	val refresh: String
	val bearer: String?
}