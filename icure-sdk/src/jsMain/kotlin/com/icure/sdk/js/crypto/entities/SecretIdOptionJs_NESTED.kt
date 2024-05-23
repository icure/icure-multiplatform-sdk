// auto-generated file
@file:JsQualifier("SecretIdOption")

package com.icure.sdk.js.crypto.entities

import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("UseAnyConfidential")
public external object SecretIdOptionJs_UseAnyConfidentialJs : SecretIdOptionJs {
	override val ktClass: String
}

@JsName("UseAnySharedWithParent")
public external object SecretIdOptionJs_UseAnySharedWithParentJs : SecretIdOptionJs {
	override val ktClass: String
}

@JsName("Use")
public external class SecretIdOptionJs_UseJs(
	partial: dynamic,
) : SecretIdOptionJs {
	public val secretIds: Array<String>

	override val ktClass: String
}
