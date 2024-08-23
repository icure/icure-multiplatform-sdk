package com.icure.sdk.api.impl

import com.icure.sdk.api.RoleApi
import com.icure.sdk.api.raw.RawRoleApi
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
internal class RoleApiImpl(
	private val rawApi: RawRoleApi,
) : RoleApi {
	override suspend fun getAllRoles() = rawApi.getAllRoles().successBody()
}