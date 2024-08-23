package com.icure.sdk.api.impl

import com.icure.sdk.api.PermissionApi
import com.icure.sdk.api.raw.RawPermissionApi
import com.icure.sdk.model.security.Permission
import com.icure.sdk.utils.InternalIcureApi

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