package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.RecoveryDataUseFailureReason
import kotlin.String

public fun recoveryDataUseFailureReason_toJs(obj: RecoveryDataUseFailureReason): String = obj.name

public fun recoveryDataUseFailureReason_fromJs(obj: String): RecoveryDataUseFailureReason = when
		(obj) {
	"Missing" -> RecoveryDataUseFailureReason.Missing
	"Unauthorized" -> RecoveryDataUseFailureReason.Unauthorized
	"InvalidType" -> RecoveryDataUseFailureReason.InvalidType
	"InvalidContent" -> RecoveryDataUseFailureReason.InvalidContent
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.crypto.entities.RecoveryDataUseFailureReason: $obj""")
}
