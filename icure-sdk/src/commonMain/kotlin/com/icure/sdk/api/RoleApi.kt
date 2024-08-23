package com.icure.sdk.api

import com.icure.sdk.model.Role

interface RoleApi {
	suspend fun getAllRoles(): List<Role>
}

