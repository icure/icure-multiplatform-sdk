// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.crypto.entities

import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("RecoveryResult")
public sealed external interface RecoveryResultJs<T> {
	public val isSuccess: Boolean

	public val `value`: T

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
