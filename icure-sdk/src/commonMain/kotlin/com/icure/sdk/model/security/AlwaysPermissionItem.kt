package com.icure.sdk.model.security

import kotlinx.serialization.Serializable

@Serializable
public data class AlwaysPermissionItem(
  override val type: PermissionType,
) : PermissionItem
