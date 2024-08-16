// auto-generated file
package com.icure.sdk.js.model.security

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.security.Permission
import com.icure.sdk.model.security.PermissionItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun permission_toJs(obj: Permission): PermissionJs {
	val grants = setToArray(
		obj.grants,
		{ x1: PermissionItem ->
			permissionItem_toJs(x1)
		},
	)
	val revokes = setToArray(
		obj.revokes,
		{ x1: PermissionItem ->
			permissionItem_toJs(x1)
		},
	)
	return PermissionJs(js("{" +
		"grants:grants," +
		"revokes:revokes" +
	"}"))
}

public fun permission_fromJs(obj: PermissionJs): Permission {
	val grants = arrayToSet(
		obj.grants,
		"obj.grants",
		{ x1: PermissionItemJs ->
			permissionItem_fromJs(x1)
		},
	)
	val revokes = arrayToSet(
		obj.revokes,
		"obj.revokes",
		{ x1: PermissionItemJs ->
			permissionItem_fromJs(x1)
		},
	)
	return Permission(
		grants = grants,
		revokes = revokes,
	)
}
