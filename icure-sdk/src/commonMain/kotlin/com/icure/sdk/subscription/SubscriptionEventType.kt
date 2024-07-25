package com.icure.sdk.subscription

import kotlinx.serialization.Serializable

@Serializable
enum class SubscriptionEventType {
	Create,
	Update
}