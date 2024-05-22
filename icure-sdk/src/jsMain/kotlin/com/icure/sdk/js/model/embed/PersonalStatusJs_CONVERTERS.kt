package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.PersonalStatus
import kotlin.String

public fun personalStatus_toJs(obj: PersonalStatus): String = obj.name

public fun personalStatus_fromJs(obj: String): PersonalStatus = when (obj) {
	"Single" -> PersonalStatus.Single
	"InCouple" -> PersonalStatus.InCouple
	"Married" -> PersonalStatus.Married
	"Separated" -> PersonalStatus.Separated
	"Divorced" -> PersonalStatus.Divorced
	"Divorcing" -> PersonalStatus.Divorcing
	"Widowed" -> PersonalStatus.Widowed
	"Widower" -> PersonalStatus.Widower
	"Complicated" -> PersonalStatus.Complicated
	"Unknown" -> PersonalStatus.Unknown
	"Contract" -> PersonalStatus.Contract
	"Other" -> PersonalStatus.Other
	"Annulled" -> PersonalStatus.Annulled
	"Polygamous" -> PersonalStatus.Polygamous
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.PersonalStatus: $obj""")
}
