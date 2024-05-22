package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.TypedValuesType
import kotlin.String

public fun typedValuesType_toJs(obj: TypedValuesType): String = obj.name

public fun typedValuesType_fromJs(obj: String): TypedValuesType = when (obj) {
	"Boolean" -> TypedValuesType.Boolean
	"Integer" -> TypedValuesType.Integer
	"Double" -> TypedValuesType.Double
	"String" -> TypedValuesType.String
	"Date" -> TypedValuesType.Date
	"Clob" -> TypedValuesType.Clob
	"Json" -> TypedValuesType.Json
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.TypedValuesType: $obj""")
}
