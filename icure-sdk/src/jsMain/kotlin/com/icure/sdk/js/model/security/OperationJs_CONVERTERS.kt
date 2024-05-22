package com.icure.sdk.js.model.security

import com.icure.sdk.model.security.Operation
import kotlin.String

public fun operation_toJs(obj: Operation): String = obj.name

public fun operation_fromJs(obj: String): Operation = when (obj) {
	"TransferGroup" -> Operation.TransferGroup
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.security.Operation: $obj""")
}
