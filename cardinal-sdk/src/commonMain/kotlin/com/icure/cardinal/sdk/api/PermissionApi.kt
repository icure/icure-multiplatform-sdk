package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.security.Permission

interface PermissionApi {
	suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	): List<Permission>
}

