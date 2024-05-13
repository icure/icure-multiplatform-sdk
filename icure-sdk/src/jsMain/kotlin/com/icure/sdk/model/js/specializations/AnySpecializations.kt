package com.icure.sdk.model.js.specializations

import com.icure.sdk.model.js.CheckedConverters
import com.icure.sdk.model.specializations.AnyPrimitive
import com.icure.sdk.utils.InternalIcureException

fun anyPrimitive_fromJs(obj: AnyPrimitive) = when (obj) {
	is Long -> CheckedConverters.longToNumber(obj)
	is Int -> CheckedConverters.intToNumber(obj)
	is Double -> obj
	is Float -> obj.toDouble()
	is String -> obj
	is Boolean -> obj
	else -> throw InternalIcureException("Unsupported type for `AnyPrimitive`: ${obj::class.simpleName}")
}
fun anyPrimitive_toJs(obj: Any) = when (obj) {
	is Double -> CheckedConverters.tryNumberToLong(obj) ?: obj
	is String -> obj
	is Boolean -> obj
	else -> throw IllegalArgumentException("Unsupported type for `AnyPrimitive`: ${obj::class.simpleName} - must be a nubmer, string or boolean")
}