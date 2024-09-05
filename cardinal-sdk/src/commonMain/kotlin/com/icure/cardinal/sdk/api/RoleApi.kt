package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Role

interface RoleApi {
	suspend fun getAllRoles(): List<Role>
}

