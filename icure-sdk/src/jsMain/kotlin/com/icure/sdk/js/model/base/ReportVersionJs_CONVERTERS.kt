package com.icure.sdk.js.model.base

import com.icure.sdk.model.base.ReportVersion
import kotlin.String

public fun reportVersion_toJs(obj: ReportVersion): String = obj.name

public fun reportVersion_fromJs(obj: String): ReportVersion = when (obj) {
	"V1_0_0" -> ReportVersion.V1_0_0
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.base.ReportVersion: $obj""")
}
