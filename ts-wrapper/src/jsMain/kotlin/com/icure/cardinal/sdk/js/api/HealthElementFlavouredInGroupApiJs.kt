// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementFlavouredInGroupApi")
public external interface HealthElementFlavouredInGroupApiJs<E : HealthElementJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		healthElement: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(healthElement: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun createHealthElement(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyHealthElement(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun getHealthElement(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>
}
