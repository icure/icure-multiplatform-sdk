package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.GroupType
import kotlin.String

public fun groupType_toJs(obj: GroupType): String = obj.name

public fun groupType_fromJs(obj: String): GroupType = when (obj) {
	"Root" -> GroupType.Root
	"App" -> GroupType.App
	"Database" -> GroupType.Database
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.GroupType: $obj""")
}
