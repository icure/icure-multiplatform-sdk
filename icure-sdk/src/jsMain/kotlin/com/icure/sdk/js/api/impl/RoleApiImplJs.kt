// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.RoleApi
import com.icure.sdk.js.api.RoleApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.RoleJs
import com.icure.sdk.js.model.role_toJs
import com.icure.sdk.model.Role
import kotlin.Array
import kotlin.OptIn
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class RoleApiImplJs private constructor(
	private val roleApi: RoleApi,
) : RoleApiJs {
	override fun getAllRoles(): Promise<Array<RoleJs>> = GlobalScope.promise {
		listToArray(
			roleApi.getAllRoles(),
			{ x1: Role ->
				role_toJs(x1)
			},
		)}

}
