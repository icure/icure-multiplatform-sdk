package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.FlatRateType
import kotlin.String

public fun flatRateType_toJs(obj: FlatRateType): String = obj.name

public fun flatRateType_fromJs(obj: String): FlatRateType = when (obj) {
	"Physician" -> FlatRateType.Physician
	"Physiotherapist" -> FlatRateType.Physiotherapist
	"Nurse" -> FlatRateType.Nurse
	"Ptd" -> FlatRateType.Ptd
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.FlatRateType: $obj""")
}
