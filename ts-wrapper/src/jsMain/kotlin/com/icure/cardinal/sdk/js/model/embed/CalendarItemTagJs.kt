// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("CalendarItemTag")
public sealed external interface CalendarItemTagJs : EncryptableJs {
	public val code: String?

	public val date: Double?

	public val userId: String?

	public val userName: String?

	public val isEncrypted: Boolean
}

@JsName("DecryptedCalendarItemTag")
public external class DecryptedCalendarItemTagJs(
	partial: dynamic,
) : CalendarItemTagJs {
	override val code: String?

	override val date: Double?

	override val userId: String?

	override val userName: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedCalendarItemTag")
public external class EncryptedCalendarItemTagJs(
	partial: dynamic,
) : CalendarItemTagJs {
	override val code: String?

	override val date: Double?

	override val userId: String?

	override val userName: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
