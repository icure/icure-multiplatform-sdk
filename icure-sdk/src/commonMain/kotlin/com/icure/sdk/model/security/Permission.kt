package com.icure.sdk.model.security

import kotlin.Cloneable
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Permission(
  public val grants: Set<PermissionItem> = emptySet(),
  public val revokes: Set<PermissionItem> = emptySet(),
) : Cloneable
