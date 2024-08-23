package com.icure.sdk.api

import com.icure.sdk.model.security.Permission

interface PermissionApi {
	suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	): List<Permission>
}

