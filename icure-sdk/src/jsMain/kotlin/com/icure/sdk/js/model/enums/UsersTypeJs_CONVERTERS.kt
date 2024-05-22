package com.icure.sdk.js.model.enums

import com.icure.sdk.model.enums.UsersType
import kotlin.String

public fun usersType_toJs(obj: UsersType): String = obj.name

public fun usersType_fromJs(obj: String): UsersType = when (obj) {
	"Database" -> UsersType.Database
	"Ldap" -> UsersType.Ldap
	"Token" -> UsersType.Token
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.enums.UsersType: $obj""")
}
