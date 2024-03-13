package com.icure.sdk.model.security

import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.Cloneable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public interface PermissionItem : Cloneable {
  public val itemType: String

  public val type: PermissionType

  public val predicate: Predicate
}
