// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("TypedValue")
public sealed external interface TypedValueJs : EncryptableJs {
	public val type: String?

	public val booleanValue: Boolean?

	public val integerValue: Double?

	public val doubleValue: Double?

	public val stringValue: String?

	public val dateValue: Double?

	public val isEncrypted: Boolean
}

@JsName("DecryptedTypedValue")
public external class DecryptedTypedValueJs(
	partial: dynamic,
) : TypedValueJs {
	override val type: String?

	override val booleanValue: Boolean?

	override val integerValue: Double?

	override val doubleValue: Double?

	override val stringValue: String?

	override val dateValue: Double?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedTypedValue")
public external class EncryptedTypedValueJs(
	partial: dynamic,
) : TypedValueJs {
	override val type: String?

	override val booleanValue: Boolean?

	override val integerValue: Double?

	override val doubleValue: Double?

	override val stringValue: String?

	override val dateValue: Double?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
