package com.icure.sdk.js.model.security

import com.icure.sdk.model.security.AlwaysPermissionItem

public fun alwaysPermissionItem_toJs(obj: AlwaysPermissionItem): AlwaysPermissionItemJs {
	val type = permissionType_toJs(obj.type)
	return AlwaysPermissionItemJs(js("{" +
		"type:type," +
	"}"))
}

public fun alwaysPermissionItem_fromJs(obj: AlwaysPermissionItemJs): AlwaysPermissionItem {
	val type = permissionType_fromJs(obj.type)
	return AlwaysPermissionItem(
		type = type,
	)
}
