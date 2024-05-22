package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.AuthenticationClass
import kotlin.String

public fun authenticationClass_toJs(obj: AuthenticationClass): String = obj.name

public fun authenticationClass_fromJs(obj: String): AuthenticationClass = when (obj) {
	"DigitalId" -> AuthenticationClass.DigitalId
	"TwoFactorAuthentication" -> AuthenticationClass.TwoFactorAuthentication
	"ShortLivedToken" -> AuthenticationClass.ShortLivedToken
	"ExternalAuthentication" -> AuthenticationClass.ExternalAuthentication
	"Password" -> AuthenticationClass.Password
	"LongLivedToken" -> AuthenticationClass.LongLivedToken
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.AuthenticationClass: $obj""")
}
