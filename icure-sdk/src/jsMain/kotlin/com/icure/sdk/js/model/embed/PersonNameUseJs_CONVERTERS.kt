package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.PersonNameUse
import kotlin.String

public fun personNameUse_toJs(obj: PersonNameUse): String = obj.name

public fun personNameUse_fromJs(obj: String): PersonNameUse = when (obj) {
	"Usual" -> PersonNameUse.Usual
	"Official" -> PersonNameUse.Official
	"Temp" -> PersonNameUse.Temp
	"Nickname" -> PersonNameUse.Nickname
	"Anonymous" -> PersonNameUse.Anonymous
	"Maiden" -> PersonNameUse.Maiden
	"Old" -> PersonNameUse.Old
	"Other" -> PersonNameUse.Other
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.PersonNameUse: $obj""")
}
