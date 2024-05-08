package com.icure.sdk.api.raw

import com.icure.sdk.model.security.Permission
import com.icure.sdk.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawPermissionApi {
	// region cloud endpoints

	suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	): HttpResponse<List<Permission>>
	// endregion
}
