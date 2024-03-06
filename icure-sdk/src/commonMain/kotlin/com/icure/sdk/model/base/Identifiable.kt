package com.icure.sdk.model.base

import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public interface Identifiable<T> : IoSerializable {
  public val id: T
}
