// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementBasicInGroupApi")
public external interface HealthElementBasicInGroupApiJs {
	public fun createHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
			Promise<GroupScopedJs<EncryptedHealthElementJs>>

	public fun modifyHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
			Promise<GroupScopedJs<EncryptedHealthElementJs>>

	public fun getHealthElement(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedHealthElementJs>?>
}
