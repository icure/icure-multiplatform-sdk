// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("MessageShareOptions")
public external class MessageShareOptionsJs(
	partial: dynamic,
) {
	public val requestedPermissions: String

	public val shareEncryptionKey: String

	public val sharePatientId: String

	public val shareSecretIds: SecretIdShareOptionsJs
}
