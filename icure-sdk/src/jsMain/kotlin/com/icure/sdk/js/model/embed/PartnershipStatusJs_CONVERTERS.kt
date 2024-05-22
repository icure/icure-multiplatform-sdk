package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.PartnershipStatus
import kotlin.String

public fun partnershipStatus_toJs(obj: PartnershipStatus): String = obj.name

public fun partnershipStatus_fromJs(obj: String): PartnershipStatus = when (obj) {
	"Active" -> PartnershipStatus.Active
	"Complicated" -> PartnershipStatus.Complicated
	"Past" -> PartnershipStatus.Past
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.PartnershipStatus: $obj""")
}
