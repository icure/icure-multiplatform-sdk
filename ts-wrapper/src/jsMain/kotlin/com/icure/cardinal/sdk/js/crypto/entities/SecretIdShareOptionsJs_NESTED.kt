// auto-generated file
@file:JsQualifier("crypto.SecretIdShareOptions")

package com.icure.cardinal.sdk.js.crypto.entities

import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("AllAvailable")
public external class SecretIdShareOptionsJs_AllAvailableJs(
	partial: dynamic,
) : SecretIdShareOptionsJs {
	public val requireAtLeastOne: Boolean

	override val ktClass: String
}

@JsName("UseExactly")
public external class SecretIdShareOptionsJs_UseExactlyJs(
	partial: dynamic,
) : SecretIdShareOptionsJs {
	public val secretIds: Array<String>

	public val createUnknownSecretIds: Boolean

	override val ktClass: String
}
