// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.security

import com.icure.sdk.js.model.filter.predicate.PredicateJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PermissionItem")
public sealed external interface PermissionItemJs {
	public val type: String

	public val predicate: PredicateJs

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
