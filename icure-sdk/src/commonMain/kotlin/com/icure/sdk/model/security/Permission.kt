package com.icure.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Permission(
	public val grants: Set<PermissionItem> = emptySet(),
	public val revokes: Set<PermissionItem> = emptySet(),
) {
	// region Permission-Permission

	// endregion
}
