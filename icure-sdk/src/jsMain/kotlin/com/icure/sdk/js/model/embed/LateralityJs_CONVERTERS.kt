package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.Laterality
import kotlin.String

public fun laterality_toJs(obj: Laterality): String = obj.name

public fun laterality_fromJs(obj: String): Laterality = when (obj) {
	"Left" -> Laterality.Left
	"Right" -> Laterality.Right
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.Laterality: $obj""")
}
