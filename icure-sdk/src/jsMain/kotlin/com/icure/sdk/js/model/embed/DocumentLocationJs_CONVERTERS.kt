package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DocumentLocation
import kotlin.String

public fun documentLocation_toJs(obj: DocumentLocation): String = obj.name

public fun documentLocation_fromJs(obj: String): DocumentLocation = when (obj) {
	"Annex" -> DocumentLocation.Annex
	"Body" -> DocumentLocation.Body
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.DocumentLocation: $obj""")
}
