// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("RecoveryResult")
public sealed external interface RecoveryResultJs<T : Any> {
	public val isSuccess: Boolean

	public val `value`: T

	@JsName("${'$'}ktClass")
	public val ktClass: String
}
