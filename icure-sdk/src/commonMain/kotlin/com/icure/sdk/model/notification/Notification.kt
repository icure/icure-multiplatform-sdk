package com.icure.sdk.model.notification

import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Notification(
  public val eventType: EventType,
  public val entityClass: String,
  public val entity: Identifiable<String>,
) {
	// region Notification-Notification
	// endregion
}