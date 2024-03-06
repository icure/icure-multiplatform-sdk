package com.icure.sdk.model.security

import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.Cloneable
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public interface PermissionItem : Cloneable, IoSerializable {
  public val itemType: String

  public val type: PermissionType

  public val predicate: Predicate
}
