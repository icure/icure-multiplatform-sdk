// auto-generated file
@file:JsQualifier("crypto.SecretIdUseOption")

package com.icure.cardinal.sdk.js.crypto.entities

import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("UseAnyConfidential")
public external object SecretIdUseOptionJs_UseAnyConfidentialJs : SecretIdUseOptionJs {
	override val ktClass: String
}

@JsName("UseAnySharedWithParent")
public external object SecretIdUseOptionJs_UseAnySharedWithParentJs : SecretIdUseOptionJs {
	override val ktClass: String
}

@JsName("Use")
public external class SecretIdUseOptionJs_UseJs(
	partial: dynamic,
) : SecretIdUseOptionJs {
	public val secretIds: Array<String>

	override val ktClass: String
}