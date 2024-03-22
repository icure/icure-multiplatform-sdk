package com.icure.sdk.model.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EventType() {
  @SerialName("CREATE")
  Create,
  @SerialName("UPDATE")
  Update,
  @SerialName("DELETE")
  Delete,
}
