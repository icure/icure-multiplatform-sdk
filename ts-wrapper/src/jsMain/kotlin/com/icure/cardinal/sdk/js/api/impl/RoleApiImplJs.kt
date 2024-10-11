// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.js.api.RoleApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.RoleJs
import com.icure.cardinal.sdk.js.model.role_toJs
import com.icure.cardinal.sdk.model.Role
import kotlin.Array
import kotlin.OptIn
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class RoleApiImplJs(
	private val roleApi: RoleApi,
) : RoleApiJs {
	override fun getAllRoles(): Promise<Array<RoleJs>> = GlobalScope.promise {
		val result = roleApi.getAllRoles(
		)
		listToArray(
			result,
			{ x1: Role ->
				role_toJs(x1)
			},
		)
	}
}
