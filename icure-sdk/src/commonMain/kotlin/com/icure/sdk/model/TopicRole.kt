package com.icure.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TopicRole() {
  @SerialName("PARTICIPANT")
  Participant,
  @SerialName("ADMIN")
  Admin,
  @SerialName("OWNER")
  Owner,
}
