// auto-generated file
@file:JsQualifier("crypto")

package com.icure.sdk.js.crypto.entities

import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("AccessLogShareOptions")
public external class AccessLogShareOptionsJs(
	partial: dynamic,
) : SimpleDelegateShareOptionsJs {
	override val requestedPermissions: String

	override val shareEncryptionKey: String

	public val sharePatientId: String

	override val shareOwningEntityIds: String

	override val shareSecretIds: Nothing?
}
