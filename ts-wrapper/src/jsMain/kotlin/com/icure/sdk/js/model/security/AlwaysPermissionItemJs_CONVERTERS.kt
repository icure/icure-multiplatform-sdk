package com.icure.sdk.js.model.security

import com.icure.sdk.model.security.AlwaysPermissionItem
import com.icure.sdk.model.security.PermissionType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun alwaysPermissionItem_toJs(obj: AlwaysPermissionItem): AlwaysPermissionItemJs {
	val type = obj.type.name
	return AlwaysPermissionItemJs(js("{" +
		"type:type," +
	"}"))
}

public fun alwaysPermissionItem_fromJs(obj: AlwaysPermissionItemJs): AlwaysPermissionItem {
	val type = PermissionType.valueOf(obj.type)
	return AlwaysPermissionItem(
		type = type,
	)
}
