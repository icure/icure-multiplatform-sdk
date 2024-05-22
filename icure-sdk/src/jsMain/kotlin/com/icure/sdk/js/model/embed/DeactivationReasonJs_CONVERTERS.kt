package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DeactivationReason
import kotlin.String

public fun deactivationReason_toJs(obj: DeactivationReason): String = obj.name

public fun deactivationReason_fromJs(obj: String): DeactivationReason = when (obj) {
	"Deceased" -> DeactivationReason.Deceased
	"Moved" -> DeactivationReason.Moved
	"OtherDoctor" -> DeactivationReason.OtherDoctor
	"Retired" -> DeactivationReason.Retired
	"NoContact" -> DeactivationReason.NoContact
	"Unknown" -> DeactivationReason.Unknown
	"None" -> DeactivationReason.None
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.DeactivationReason: $obj""")
}
