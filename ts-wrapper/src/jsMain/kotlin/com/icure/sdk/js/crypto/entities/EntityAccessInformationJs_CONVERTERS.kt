// auto-generated file
package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.model.embed.AccessLevel
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entityAccessInformation_toJs(obj: EntityAccessInformation): EntityAccessInformationJs {
	val permissionsByDataOwnerId = mapToObject(
		obj.permissionsByDataOwnerId,
		{ x1: String ->
			x1
		},
		{ x1: AccessLevel ->
			x1.name
		},
	)
	val hasUnknownAnonymousDataOwners = obj.hasUnknownAnonymousDataOwners
	return EntityAccessInformationJs(js("{" +
		"permissionsByDataOwnerId:permissionsByDataOwnerId," +
		"hasUnknownAnonymousDataOwners:hasUnknownAnonymousDataOwners" +
	"}"))
}

public fun entityAccessInformation_fromJs(obj: EntityAccessInformationJs): EntityAccessInformation {
	val permissionsByDataOwnerId = objectToMap(
		obj.permissionsByDataOwnerId,
		"obj.permissionsByDataOwnerId",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			AccessLevel.valueOf(x1)
		},
	)
	val hasUnknownAnonymousDataOwners = obj.hasUnknownAnonymousDataOwners
	return EntityAccessInformation(
		permissionsByDataOwnerId = permissionsByDataOwnerId,
		hasUnknownAnonymousDataOwners = hasUnknownAnonymousDataOwners,
	)
}
