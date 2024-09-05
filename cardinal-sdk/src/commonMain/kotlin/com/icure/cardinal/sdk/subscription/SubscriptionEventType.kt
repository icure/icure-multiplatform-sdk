package com.icure.cardinal.sdk.subscription

import kotlinx.serialization.Serializable

@Serializable
enum class SubscriptionEventType {
	Create,
	Update
}