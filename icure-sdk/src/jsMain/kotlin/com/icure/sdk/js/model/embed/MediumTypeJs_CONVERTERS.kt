package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.MediumType
import kotlin.String

public fun mediumType_toJs(obj: MediumType): String = obj.name

public fun mediumType_fromJs(obj: String): MediumType = when (obj) {
	"Cdrom" -> MediumType.Cdrom
	"Eattest" -> MediumType.Eattest
	"Efact" -> MediumType.Efact
	"Email" -> MediumType.Email
	"Mediprima" -> MediumType.Mediprima
	"Paper" -> MediumType.Paper
	"Stat" -> MediumType.Stat
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.MediumType: $obj""")
}
