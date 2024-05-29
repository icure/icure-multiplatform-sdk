// auto-generated file
@file:JsQualifier("crypto")

package com.icure.sdk.js.crypto.entities

import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("PatientShareOptions")
public external class PatientShareOptionsJs(
	partial: dynamic,
) : SimpleDelegateShareOptionsJs {
	override val requestedPermissions: String

	override val shareEncryptionKey: String

	override val shareSecretIds: Array<String>

	override val shareOwningEntityIds: String
}
