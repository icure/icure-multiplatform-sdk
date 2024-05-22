package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.AddressType
import kotlin.String

public fun addressType_toJs(obj: AddressType): String = obj.name

public fun addressType_fromJs(obj: String): AddressType = when (obj) {
	"Home" -> AddressType.Home
	"Work" -> AddressType.Work
	"Vacation" -> AddressType.Vacation
	"Hospital" -> AddressType.Hospital
	"Clinic" -> AddressType.Clinic
	"Hq" -> AddressType.Hq
	"Other" -> AddressType.Other
	"Temporary" -> AddressType.Temporary
	"Postal" -> AddressType.Postal
	"Diplomatic" -> AddressType.Diplomatic
	"Reference" -> AddressType.Reference
	"Careaddress" -> AddressType.Careaddress
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.AddressType: $obj""")
}
