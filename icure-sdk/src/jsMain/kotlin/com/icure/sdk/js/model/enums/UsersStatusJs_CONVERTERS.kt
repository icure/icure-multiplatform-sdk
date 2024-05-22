package com.icure.sdk.js.model.enums

import com.icure.sdk.model.enums.UsersStatus
import kotlin.String

public fun usersStatus_toJs(obj: UsersStatus): String = obj.name

public fun usersStatus_fromJs(obj: String): UsersStatus = when (obj) {
	"Active" -> UsersStatus.Active
	"Disabled" -> UsersStatus.Disabled
	"Registering" -> UsersStatus.Registering
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.enums.UsersStatus: $obj""")
}
