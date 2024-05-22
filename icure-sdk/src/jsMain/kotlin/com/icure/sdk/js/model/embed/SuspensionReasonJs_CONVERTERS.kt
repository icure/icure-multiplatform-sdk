package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.SuspensionReason
import kotlin.String

public fun suspensionReason_toJs(obj: SuspensionReason): String = obj.name

public fun suspensionReason_fromJs(obj: String): SuspensionReason = when (obj) {
	"NotInsured" -> SuspensionReason.NotInsured
	"NoReasonGiven" -> SuspensionReason.NoReasonGiven
	"IsHospitalized" -> SuspensionReason.IsHospitalized
	"OutsideOfCountry" -> SuspensionReason.OutsideOfCountry
	"ChangeOfMutuality" -> SuspensionReason.ChangeOfMutuality
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.SuspensionReason: $obj""")
}
