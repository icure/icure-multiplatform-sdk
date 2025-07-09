package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.raw.RawRoleApi
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class RoleApiImpl(
	private val rawApi: RawRoleApi,
) : RoleApi {
	override suspend fun getAllRoles() = rawApi.getRoles().successBody()
}