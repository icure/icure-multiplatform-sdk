// auto-generated file
@file:JsQualifier("crypto.RecoveryResult")

package com.icure.cardinal.sdk.js.crypto.entities

import kotlin.Any
import kotlin.Deprecated
import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Success")
public external class RecoveryResultJs_SuccessJs<T : Any>(
	partial: dynamic,
) : RecoveryResultJs<T> {
	public val `data`: T

	@Deprecated(
		level = DeprecationLevel.ERROR,
		message = "This virtual member does not actually exist on the js entity",
	)
	override val isSuccess: Nothing

	@Deprecated(
		level = DeprecationLevel.ERROR,
		message = "This virtual member does not actually exist on the js entity",
	)
	override val `value`: Nothing

	override val ktClass: String
}

@JsName("Failure")
public external class RecoveryResultJs_FailureJs(
	partial: dynamic,
) : RecoveryResultJs<Nothing> {
	public val reason: String

	@Deprecated(
		level = DeprecationLevel.ERROR,
		message = "This virtual member does not actually exist on the js entity",
	)
	override val isSuccess: Nothing

	@Deprecated(
		level = DeprecationLevel.ERROR,
		message = "This virtual member does not actually exist on the js entity",
	)
	override val `value`: Nothing

	override val ktClass: String
}
