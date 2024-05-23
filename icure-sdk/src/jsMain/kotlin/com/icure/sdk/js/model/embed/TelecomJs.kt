// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Telecom")
public sealed external interface TelecomJs : EncryptableJs {
	public val telecomType: String?

	public val telecomNumber: String?

	public val telecomDescription: String?

	public val isEncrypted: Boolean

	@JsName("${'$'}ktClass")
	public val ktClass: String
}

@JsName("DecryptedTelecom")
public external class DecryptedTelecomJs(
	partial: dynamic,
) : TelecomJs {
	override val telecomType: String?

	override val telecomNumber: String?

	override val telecomDescription: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedTelecom")
public external class EncryptedTelecomJs(
	partial: dynamic,
) : TelecomJs {
	override val telecomType: String?

	override val telecomNumber: String?

	override val telecomDescription: String?

	override val encryptedSelf: String?

	override val isEncrypted: Boolean

	override val ktClass: String
}
