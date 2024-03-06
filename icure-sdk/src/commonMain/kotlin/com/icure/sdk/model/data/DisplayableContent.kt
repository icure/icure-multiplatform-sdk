package com.icure.sdk.model.`data`

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public interface DisplayableContent : IoSerializable {
  public val id: String?

  public val label: String?

  public val entityClass: String?

  public val entityId: String?
}
