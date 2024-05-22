package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.CareTeamMemberType
import kotlin.String

public fun careTeamMemberType_toJs(obj: CareTeamMemberType): String = obj.name

public fun careTeamMemberType_fromJs(obj: String): CareTeamMemberType = when (obj) {
	"Physician" -> CareTeamMemberType.Physician
	"Specialist" -> CareTeamMemberType.Specialist
	"Other" -> CareTeamMemberType.Other
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.CareTeamMemberType: $obj""")
}
