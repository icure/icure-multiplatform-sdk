// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entityReferenceInGroup_toJs(obj: EntityReferenceInGroup): EntityReferenceInGroupJs {
	val entityId = obj.entityId
	val groupId = nullToUndefined(
		obj.groupId
	)
	return EntityReferenceInGroupJs(js("{" +
		"entityId:entityId," +
		"groupId:groupId" +
	"}"))
}

public fun entityReferenceInGroup_fromJs(obj: EntityReferenceInGroupJs): EntityReferenceInGroup {
	val entityId = obj.entityId
	val groupId = undefinedToNull(obj.groupId)
	return EntityReferenceInGroup(
		entityId = entityId,
		groupId = groupId,
	)
}
