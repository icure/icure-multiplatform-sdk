package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.UserType
import kotlin.String

public fun userType_toJs(obj: UserType): String = obj.name

public fun userType_fromJs(obj: String): UserType = when (obj) {
	"Hcp" -> UserType.Hcp
	"Patient" -> UserType.Patient
	"Device" -> UserType.Device
	"User" -> UserType.User
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.UserType: $obj""")
}
