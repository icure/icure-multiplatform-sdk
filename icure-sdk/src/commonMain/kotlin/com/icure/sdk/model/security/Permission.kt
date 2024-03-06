package com.icure.sdk.model.security

import kotlin.Cloneable
import kotlin.collections.Set
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Permission(
  public val grants: Set<PermissionItem> = emptySet(),
  public val revokes: Set<PermissionItem> = emptySet(),
) : Cloneable, IoSerializable
