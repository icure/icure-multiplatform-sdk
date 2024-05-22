package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.AccessLevel
import kotlin.String

public fun accessLevel_toJs(obj: AccessLevel): String = obj.name

public fun accessLevel_fromJs(obj: String): AccessLevel = when (obj) {
	"Read" -> AccessLevel.Read
	"Write" -> AccessLevel.Write
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.AccessLevel: $obj""")
}
