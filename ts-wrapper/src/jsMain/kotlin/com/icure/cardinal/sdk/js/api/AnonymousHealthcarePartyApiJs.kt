// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.UserAndHealthcarePartyJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AnonymousHealthcarePartyApi")
public external interface AnonymousHealthcarePartyApiJs {
	public fun getPublicHealthcarePartiesInGroup(groupId: String):
			Promise<Array<UserAndHealthcarePartyJs>>
}
