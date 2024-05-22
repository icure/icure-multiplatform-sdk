package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.Gender
import kotlin.String

public fun gender_toJs(obj: Gender): String = obj.name

public fun gender_fromJs(obj: String): Gender = when (obj) {
	"Male" -> Gender.Male
	"Female" -> Gender.Female
	"Indeterminate" -> Gender.Indeterminate
	"Changed" -> Gender.Changed
	"ChangedToMale" -> Gender.ChangedToMale
	"ChangedToFemale" -> Gender.ChangedToFemale
	"Unknown" -> Gender.Unknown
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.Gender: $obj""")
}
