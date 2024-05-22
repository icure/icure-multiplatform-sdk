package com.icure.sdk.js.model.requests

import com.icure.sdk.model.requests.RequestedPermission
import kotlin.String

public fun requestedPermission_toJs(obj: RequestedPermission): String = obj.name

public fun requestedPermission_fromJs(obj: String): RequestedPermission = when (obj) {
	"MaxRead" -> RequestedPermission.MaxRead
	"FullRead" -> RequestedPermission.FullRead
	"MaxWrite" -> RequestedPermission.MaxWrite
	"FullWrite" -> RequestedPermission.FullWrite
	"Root" -> RequestedPermission.Root
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.requests.RequestedPermission: $obj""")
}
