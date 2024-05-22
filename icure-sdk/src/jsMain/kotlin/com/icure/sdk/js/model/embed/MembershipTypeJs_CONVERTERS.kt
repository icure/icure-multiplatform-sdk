package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.MembershipType
import kotlin.String

public fun membershipType_toJs(obj: MembershipType): String = obj.name

public fun membershipType_fromJs(obj: String): MembershipType = when (obj) {
	"Doctor" -> MembershipType.Doctor
	"Mutuality" -> MembershipType.Mutuality
	"Patient" -> MembershipType.Patient
	"Specialist" -> MembershipType.Specialist
	"Other" -> MembershipType.Other
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.MembershipType: $obj""")
}
