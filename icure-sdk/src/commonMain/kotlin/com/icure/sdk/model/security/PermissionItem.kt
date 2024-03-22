package com.icure.sdk.model.security

import com.icure.sdk.model.filter.predicate.Predicate
import kotlinx.serialization.Serializable

@Serializable
public sealed interface PermissionItem {
  public val type: PermissionType

  public val predicate: Predicate
}
