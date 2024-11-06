// auto-generated file
@file:JsQualifier("crypto")

package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("EntityAccessInformation")
public external class EntityAccessInformationJs(
	partial: dynamic,
) {
	public val permissionsByDataOwnerId: Record<String, String>

	public val hasUnknownAnonymousDataOwners: Boolean
}
