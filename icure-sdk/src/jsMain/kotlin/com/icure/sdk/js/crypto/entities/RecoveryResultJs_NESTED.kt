// auto-generated file
@file:JsQualifier("model.RecoveryResult")

package com.icure.sdk.js.crypto.entities

import kotlin.Boolean
import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Success")
public external class RecoveryResultJs_SuccessJs<T>(
	partial: dynamic,
) : RecoveryResultJs<T> {
	public val `data`: T

	override val isSuccess: Boolean

	override val `value`: T

	override val ktClass: String
}

@JsName("Failure")
public external class RecoveryResultJs_FailureJs(
	partial: dynamic,
) : RecoveryResultJs<Nothing> {
	public val reason: String

	override val isSuccess: Boolean

	override val `value`: Nothing

	override val ktClass: String
}
