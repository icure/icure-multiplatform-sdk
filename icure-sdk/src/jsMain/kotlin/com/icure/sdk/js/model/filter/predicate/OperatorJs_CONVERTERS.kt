package com.icure.sdk.js.model.filter.predicate

import com.icure.sdk.model.filter.predicate.Operator
import kotlin.String

public fun operator_toJs(obj: Operator): String = obj.name

public fun operator_fromJs(obj: String): Operator = when (obj) {
	"Equal" -> Operator.Equal
	"Notequal" -> Operator.Notequal
	"Greaterthan" -> Operator.Greaterthan
	"Smallerthan" -> Operator.Smallerthan
	"Greaterthanorequal" -> Operator.Greaterthanorequal
	"Smallerthanorequal" -> Operator.Smallerthanorequal
	"Like" -> Operator.Like
	"Ilike" -> Operator.Ilike
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.filter.predicate.Operator: $obj""")
}
