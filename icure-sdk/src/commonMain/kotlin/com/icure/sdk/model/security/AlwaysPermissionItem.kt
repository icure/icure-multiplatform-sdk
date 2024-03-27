package com.icure.sdk.model.security

import com.icure.sdk.model.filter.predicate.AlwaysPredicate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AlwaysPermissionItemDto")
@Serializable
data class AlwaysPermissionItem(
    override val type: PermissionType,
) : PermissionItem {
    override val predicate: AlwaysPredicate = AlwaysPredicate()
}
