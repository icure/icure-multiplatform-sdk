package com.icure.sdk.api

import com.icure.sdk.api.raw.RawPermissionApi
import com.icure.sdk.api.raw.RawRoleApi
import com.icure.sdk.model.Role
import com.icure.sdk.model.security.Permission
import com.icure.sdk.utils.InternalIcureApi

interface PermissionApi {
	suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	): List<Permission>
}

@InternalIcureApi
internal class PermissionApiImpl(
	private val rawApi: RawPermissionApi,
) : PermissionApi {
	override suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	) = rawApi.modifyUserPermissions(
		userId,
		permissions,
	).successBody()
}

