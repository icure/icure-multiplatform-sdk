package com.icure.sdk.model.requests.topic

import com.icure.sdk.model.TopicRole
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AddParticipant(
  public val dataOwnerId: String,
  public val topicRole: TopicRole,
)
