package com.icure.sdk.model.requests.topic

import com.icure.sdk.model.TopicRole
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AddParticipant(
  public val dataOwnerId: String,
  public val topicRole: TopicRole,
) {
	// region AddParticipant-AddParticipant
	// endregion
}