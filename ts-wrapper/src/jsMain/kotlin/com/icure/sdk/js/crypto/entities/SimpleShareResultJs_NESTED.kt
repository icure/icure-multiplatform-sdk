// auto-generated file
@file:JsQualifier("crypto.SimpleShareResult")

package com.icure.sdk.js.crypto.entities

import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import kotlin.Array
import kotlin.Deprecated
import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Success")
public external class SimpleShareResultJs_SuccessJs<T : HasEncryptionMetadataJs>(
	partial: dynamic,
) : SimpleShareResultJs<T> {
	public val updatedEntity: T

	@Deprecated(
		level = DeprecationLevel.ERROR,
		message = "This virtual member does not actually exist on the js entity",
	)
	override val isSuccess: Nothing

	override val ktClass: String
}

@JsName("Failure")
public external class SimpleShareResultJs_FailureJs(
	partial: dynamic,
) : SimpleShareResultJs<Nothing> {
	public val errorsDetails: Array<FailedRequestDetailsJs>

	@Deprecated(
		level = DeprecationLevel.ERROR,
		message = "This virtual member does not actually exist on the js entity",
	)
	override val isSuccess: Nothing

	override val ktClass: String
}
