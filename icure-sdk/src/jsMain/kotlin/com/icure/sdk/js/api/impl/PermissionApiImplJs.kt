// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.PermissionApi
import com.icure.sdk.js.api.PermissionApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.security.PermissionJs
import com.icure.sdk.js.model.security.permission_fromJs
import com.icure.sdk.js.model.security.permission_toJs
import com.icure.sdk.model.security.Permission
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PermissionApiImplJs(
	private val permissionApi: PermissionApi,
) : PermissionApiJs {
	override fun modifyUserPermissions(userId: String, permissions: PermissionJs):
			Promise<Array<PermissionJs>> = GlobalScope.promise {
		listToArray(
			permissionApi.modifyUserPermissions(userId, permission_fromJs(permissions)),
			{ x1: Permission ->
				permission_toJs(x1)
			},
		)}

}