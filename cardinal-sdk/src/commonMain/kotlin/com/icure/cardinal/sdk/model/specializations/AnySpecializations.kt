package com.icure.cardinal.sdk.model.specializations

import com.icure.cardinal.sdk.utils.isJsSafe
import kotlin.jvm.JvmInline

@JvmInline
value class AnyPrimitive(val v: Any) {
	init {
		when (v) {
			is Long -> require(v.isJsSafe()) { "Long value is too big for JavaScript: $v" }
			is String, is Boolean, is Int, is Double, is Float -> Unit
			else -> throw IllegalArgumentException("Invalid type for `AnyPrimitive`: ${v::class.simpleName}")
		}
	}
}
