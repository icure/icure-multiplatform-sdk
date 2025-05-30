package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Role
import com.icure.utils.InternalIcureApi
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawRoleApi {
	// region cloud endpoints

	suspend fun getAllRoles(): HttpResponse<List<Role>>
	// endregion
}
