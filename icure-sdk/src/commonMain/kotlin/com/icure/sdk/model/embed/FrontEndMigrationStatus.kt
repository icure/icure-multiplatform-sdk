package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class FrontEndMigrationStatus() : IoSerializable {
  @SerialName("STARTED")
  Started,
  @SerialName("PAUSED")
  Paused,
  @SerialName("ERROR")
  Error,
  @SerialName("SUCCESS")
  Success,
}
