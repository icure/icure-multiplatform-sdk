package com.icure.cardinal.sdk.model.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SubscriptionEventType() {
	@SerialName("CREATE")
	Create,

	@SerialName("UPDATE")
	Update,

	@SerialName("DELETE")
	Delete,
}
