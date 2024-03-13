package com.icure.sdk.model.requests.topic

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RemoveParticipant(
  public val dataOwnerId: String,
)
