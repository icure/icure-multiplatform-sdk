package com.icure.sdk.js.model.base

import com.icure.sdk.model.base.AppendixType
import kotlin.String

public fun appendixType_toJs(obj: AppendixType): String = obj.name

public fun appendixType_fromJs(obj: String): AppendixType = when (obj) {
	"ExternalLink" -> AppendixType.ExternalLink
	"Video" -> AppendixType.Video
	"Description" -> AppendixType.Description
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.base.AppendixType: $obj""")
}
