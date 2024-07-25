package com.icure.sdk.subscription

import kotlinx.serialization.Serializable

@Serializable
enum class EntitySubscriptionCloseReason {
	/**
	 * A new event was produced but the event channel was at maximum capacity and the
	 * [EntitySubscription.Configuration.onBufferFull] is [EntitySubscription.Configuration.FullBufferBehaviour.Close].
	 */
	ChannelFull,

	/**
	 * The subscription can't connect or lost the connection to the backend (and could not reconnect within the
	 * configured amount of retries).
	 */
	ConnectionLost,

	/**
	 * The subscription was closed by invoking the [close] method.
	 */
	IntentionallyClosed
}