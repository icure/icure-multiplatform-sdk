package com.icure.sdk.api

import com.icure.sdk.api.raw.RawRoleApi
import com.icure.sdk.model.Role
import com.icure.sdk.utils.InternalIcureApi

interface RoleApi {
	suspend fun getAllRoles(): List<Role>
}

@InternalIcureApi
internal class RoleApiImpl(
	private val rawApi: RawRoleApi,
) : RoleApi {
	override suspend fun getAllRoles() = rawApi.getAllRoles().successBody()
}

