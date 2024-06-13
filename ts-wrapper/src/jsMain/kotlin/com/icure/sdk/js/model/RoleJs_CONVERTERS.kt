package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.Role
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun role_toJs(obj: Role): RoleJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val permissions = setToArray(
		obj.permissions,
		{ x1: String ->
			x1
		},
	)
	return RoleJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"permissions:permissions" +
	"}"))
}

public fun role_fromJs(obj: RoleJs): Role {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = undefinedToNull(obj.name)
	val permissions = arrayToSet(
		obj.permissions,
		"obj.permissions",
		{ x1: String ->
			x1
		},
	)
	return Role(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		permissions = permissions,
	)
}
