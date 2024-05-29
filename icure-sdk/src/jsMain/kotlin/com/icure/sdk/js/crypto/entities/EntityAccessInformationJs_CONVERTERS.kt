package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.embed.accessLevel_fromJs
import com.icure.sdk.js.model.embed.accessLevel_toJs
import com.icure.sdk.model.embed.AccessLevel
import kotlin.String

public fun entityAccessInformation_toJs(obj: EntityAccessInformation): EntityAccessInformationJs {
	val permissionsByDataOwnerId = mapToObject<_, _, String>(
		obj.permissionsByDataOwnerId,
		{ x1: String ->
			x1
		},
		{ x1: AccessLevel ->
			accessLevel_toJs(x1)
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
			accessLevel_fromJs(x1)
		},
	)
	val hasUnknownAnonymousDataOwners = obj.hasUnknownAnonymousDataOwners
	return EntityAccessInformation(
		permissionsByDataOwnerId = permissionsByDataOwnerId,
		hasUnknownAnonymousDataOwners = hasUnknownAnonymousDataOwners,
	)
}